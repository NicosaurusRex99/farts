package naturix.networking;

import io.netty.buffer.ByteBuf;
import naturix.Config;
import naturix.utils.FartUtils;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.fmllegacy.network.*;

import java.util.Iterator;
import java.util.function.Supplier;

public class PacketPlayFart {

    public PacketPlayFart(ByteBuf buf) {

    }

    public void toBytes(ByteBuf buf) {

    }

    public PacketPlayFart() {
    }


    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            ServerLevel world = player.getLevel();
                world.playSound(null, new BlockPos(player.xo, player.yo, player.zo), FartUtils.getRandomFart(world.random), SoundSource.PLAYERS, 0.8F, 1.0F);
                Iterator<BlockPos> iterator = BlockPos.betweenClosed(new BlockPos(player.xo, player.yo, player.zo), new BlockPos(player.xo, player.yo, player.zo).offset(3, 2, 3)).iterator();
                while (iterator.hasNext()) {
                    BlockPos p = iterator.next();
                    if(player.mayUseItemAt(p.below(2), Direction.DOWN, null) && Config.fartFertilize != false){
                    growCrop(player.getItemInHand(player.getUsedItemHand()), world, p.below(2));
                }
                }
        });
        ctx.get().setPacketHandled(true);
    }

    @Deprecated //Forge: Use Player/Hand version
    public static boolean growCrop(ItemStack p_40628_, Level p_40629_, BlockPos p_40630_) {
        if (p_40629_ instanceof net.minecraft.server.level.ServerLevel)
            return applyBonemeal(p_40628_, p_40629_, p_40630_, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.server.level.ServerLevel)p_40629_));
        return false;
    }

    public static boolean applyBonemeal(ItemStack p_40628_, Level p_40629_, BlockPos p_40630_, net.minecraft.world.entity.player.Player player) {
        BlockState blockstate = p_40629_.getBlockState(p_40630_);
        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, p_40629_, p_40630_, blockstate, p_40628_);
        if (hook != 0) return hook > 0;
        if (blockstate.getBlock() instanceof BonemealableBlock) {
            BonemealableBlock bonemealableblock = (BonemealableBlock)blockstate.getBlock();
            if (bonemealableblock.isValidBonemealTarget(p_40629_, p_40630_, blockstate, p_40629_.isClientSide)) {
                if (p_40629_ instanceof ServerLevel) {
                    if (bonemealableblock.isBonemealSuccess(p_40629_, p_40629_.random, p_40630_, blockstate)) {
                        bonemealableblock.performBonemeal((ServerLevel)p_40629_, p_40629_.random, p_40630_, blockstate);
                    }

                    p_40628_.shrink(1);
                }

                return true;
            }
        }

        return false;
    }
}