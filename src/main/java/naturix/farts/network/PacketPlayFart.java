package naturix.farts.network;

import java.util.Iterator;

import io.netty.buffer.ByteBuf;
import naturix.farts.utils.FartUtils;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketPlayFart implements IMessage {

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}

	public PacketPlayFart() {
	}

	public static class Handler implements IMessageHandler<PacketPlayFart, IMessage> {

		@Override
		public IMessage onMessage(PacketPlayFart message, MessageContext ctx) {
			EntityPlayerMP player = ctx.getServerHandler().player;
			World world = player.getEntityWorld();
			world.playSound(null, player.getPosition(), FartUtils.getRandomFart(world.rand), SoundCategory.PLAYERS, 0.8F, 1.0F);
			

	        	Iterable<BlockPos> positions = BlockPos.getAllInBox(player.getPosition().add(-4,-2,-4), player.getPosition().add(4,2,4));
	            for(Iterator<BlockPos> i = positions.iterator(); i.hasNext(); ) {
	            	BlockPos pos = i.next();
	        	applyBonemeal(player.getHeldItem(player.getActiveHand()), world, pos);
	            }	        	
	        return null;
		}

	}
	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos iterable)
    {
        if (worldIn instanceof net.minecraft.world.WorldServer)
            return applyBonemeal(stack, worldIn, iterable, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.world.WorldServer)worldIn), null);
        return false;
    }

    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos iterable, EntityPlayer player, @javax.annotation.Nullable EnumHand hand)
    {
        IBlockState iblockstate = worldIn.getBlockState(iterable);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, iterable, iblockstate, stack, hand);
        if (hook != 0) return hook > 0;

        if (iblockstate.getBlock() instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)iblockstate.getBlock();

            if (igrowable.canGrow(worldIn, iterable, iblockstate, worldIn.isRemote))
            {
                if (!worldIn.isRemote)
                {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, iterable, iblockstate))
                    {
                        igrowable.grow(worldIn, worldIn.rand, iterable, iblockstate);
                    }
                }

                return true;
            }
        }

        return false;
    }
}
