package naturix.farts.network;

import io.netty.buffer.ByteBuf;
import naturix.farts.utils.FartUtils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
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
			world.playSound(null, player.getPosition(), FartUtils.getRandomFart(world.rand), SoundCategory.PLAYERS, 0.2F, 1.0F);
			return null;
		}

	}
}
