package nicusha.farts.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.network.*;
import nicusha.farts.Farts;
import nicusha.farts.utils.FartUtils;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

import java.util.Iterator;
import java.util.function.*;

public class PacketPlayFart implements Message<PacketPlayFart> {

    public PacketPlayFart() {}
    @Override
    public Dist getExecutingSide() {
        return Dist.DEDICATED_SERVER;
    }
    @Override
    public void server(CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            Level level = player.level();
            level.playSound(null, player.blockPosition(), FartUtils.getRandomFart(level.random), SoundSource.PLAYERS, 0.8F, 1.0F);
            Iterator<BlockPos> iterator = BlockPos.betweenClosed(player.blockPosition().offset(-3, -2, -3), player.blockPosition().offset(3, 2, 3)).iterator();
            while (iterator.hasNext()) {
                BlockPos p = iterator.next();
                if(player.mayUseItemAt(p.below(2), Direction.DOWN, null)){
                    growCrop(player, level, p.below(2));
                }
            }
        });
        context.setPacketHandled(true);
    }
    @Override
    public PacketPlayFart fromBytes(FriendlyByteBuf packetBuffer) {
        return this;
    }

    @Override
    public void toBytes(FriendlyByteBuf packetBuffer) {
    }

    public static boolean growCrop(Player player, Level level, BlockPos pos) {
        return applyBonemeal(player.getItemInHand(player.getUsedItemHand()), level, pos, player);
    }

    public static boolean applyBonemeal(ItemStack stack, Level level, BlockPos pos, Player player) {
        BlockState blockstate = level.getBlockState(pos);
        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, level, pos, blockstate, stack);
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