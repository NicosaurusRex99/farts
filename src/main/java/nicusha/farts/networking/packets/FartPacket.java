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
import net.minecraft.core.Direction;

import java.util.Iterator;

public class FartPacket {
    public static final FartPacket INSTANCE = new FartPacket();

    public static FartPacket get() {
        return INSTANCE;
    }

    public void handle(final FartPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level world = player.level();
            world.playSound(null, player.blockPosition(), FartUtils.getRandomFart(world.random), SoundSource.PLAYERS, payload.pitch(), payload.volume());

            Iterator<BlockPos> iterator = BlockPos.betweenClosed(player.blockPosition().offset(-3, -2, -3), player.blockPosition().offset(3, 2, 3)).iterator();
            while (iterator.hasNext()) {
                BlockPos p = iterator.next();
                if(player.mayUseItemAt(p.below(2), Direction.DOWN, null)){
                    growCrop(player, world, p.below(2));
                }
            }
        });
    }

    public static boolean growCrop(Player player, Level level, BlockPos pos) {
        return applyBonemeal(player.getItemInHand(player.getUsedItemHand()), level, pos, player);
    }

    public static boolean applyBonemeal(ItemStack stack, Level level, BlockPos pos, Player player) {
        BlockState blockstate = level.getBlockState(pos);
        int hook = net.neoforged.neoforge.event.EventHooks.onApplyBonemeal(player, level, pos, blockstate, stack);
        if (hook != 0) return hook > 0;
        Block block = blockstate.getBlock();
        if (block instanceof BonemealableBlock bonemealableblock) {
            if (bonemealableblock.isValidBonemealTarget(level, pos, blockstate)) {
                BlockPos abovePos = pos.above();
                BlockState aboveBlockState = level.getBlockState(abovePos);
                if (aboveBlockState.isAir() && level instanceof ServerLevel) {
                    if (bonemealableblock.isBonemealSuccess(level, level.random, pos, blockstate)) {
                        bonemealableblock.performBonemeal((ServerLevel)level, level.random, pos, blockstate);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
