package naturix.networking;

import io.netty.buffer.ByteBuf;
import naturix.Config;
import naturix.utils.FartUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

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
            ServerPlayerEntity player = ctx.get().getSender();
            World world = player.getEntityWorld();
                world.playSound(null, new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ()), FartUtils.getRandomFart(world.rand), SoundCategory.PLAYERS, 0.8F, 1.0F);
                Iterator<BlockPos> iterator = BlockPos.getAllInBox(new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ()), new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ()).add(3, 2, 3)).iterator();
                while (iterator.hasNext()) {
                    BlockPos p = iterator.next();
                    if(player.canPlayerEdit(p.down(2), Direction.DOWN, null) && Config.fartFertilize != false){
                    applyBonemeal(player.getHeldItem(player.getActiveHand()), world, p.down(2));
                }
                }
        });
        ctx.get().setPacketHandled(true);
    }

    @Deprecated //Forge: Use Player/Hand version
    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos) {
        if (worldIn instanceof net.minecraft.world.server.ServerWorld)
            return applyBonemeal(stack, worldIn, pos, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.world.server.ServerWorld)worldIn));
        return false;
    }

    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, net.minecraft.entity.player.PlayerEntity player) {
        BlockState blockstate = worldIn.getBlockState(pos);
        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, blockstate, stack);
        if (hook != 0) return hook > 0;
        if (blockstate.getBlock() instanceof IGrowable) {
            IGrowable igrowable = (IGrowable)blockstate.getBlock();
            if (igrowable.canGrow(worldIn, pos, blockstate, worldIn.isRemote)) {
                if (!worldIn.isRemote) {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, blockstate)) {
                        igrowable.grow((ServerWorld)worldIn, worldIn.rand, pos, blockstate);
                    }
                }

                return true;
            }
        }

        return false;
    }
}