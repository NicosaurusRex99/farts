package nicusha.farts.networking.packets;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import nicusha.farts.FartUtils;
import nicusha.farts.networking.*;
import net.minecraft.sounds.SoundSource;
import javax.annotation.Nullable;

public class FartPacket {
    public static final FartPacket INSTANCE = new FartPacket();

    public static FartPacket get() {
        return INSTANCE;
    }

    public void handle(final FartPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level world = player.level();
            world.playSound(null, player.getX(), player.getY(), player.getZ(), FartUtils.getRandomFart(world.getRandom()), SoundSource.PLAYERS, payload.volume(), payload.pitch());

            if (world instanceof ServerLevel serverLevel) {
                BlockPos center = player.blockPosition();

                if (growCrop(player, serverLevel, center)) {
                    return;
                }
                BlockPos.betweenClosedStream(center.offset(-2, -2, -2), center.offset(2, 2, 2)).filter(pos -> !pos.equals(center)).filter(pos -> growCrop(player, serverLevel, pos)).findFirst();
            }
        });
    }

    public static boolean growCrop(Player player, Level level, BlockPos pos) {
        ItemStack stack = player.getItemInHand(player.getUsedItemHand());
        return applyBonemeal(stack, level, pos, player);
    }

    public static boolean applyBonemeal(ItemStack stack, Level level, BlockPos pos, @Nullable Player player) {
        BlockState state = level.getBlockState(pos);
        var event = net.neoforged.neoforge.event.EventHooks.fireBonemealEvent(player, level, pos, state, stack);
        if (event.isCanceled()) return event.isSuccessful();
        if (state.getBlock() instanceof BonemealableBlock block && block.isValidBonemealTarget(level, pos, state)) {
            if (level instanceof ServerLevel serverLevel) {
                if (block.isBonemealSuccess(level, level.getRandom(), pos, state)) {
                    block.performBonemeal(serverLevel, level.getRandom(), pos, state);
                }
                level.levelEvent(1505, pos, 15);
            }
            return true;
        }
        return false;
    }
}