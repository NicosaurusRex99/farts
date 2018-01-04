package naturix.farts.networking.message;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import naturix.farts.networking.InputHandler;
import naturix.farts.utils.SoundHandlerFart;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

//Server Packet
public class MessageFart implements IMessage, IMessageHandler<MessageFart, IMessage>
{
	private Random rand = new Random();

	public MessageFart()
	{
	}


	@Override
	public void fromBytes(ByteBuf buf)
	{

	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		
	}

	@Override
	public IMessage onMessage(MessageFart message, MessageContext ctx)
	{
		EntityPlayerMP player = ctx.getServerHandler().player;
		if (InputHandler.key_fart.isPressed())
		{
			System.out.print("a player farted");
			player.world.playSound(null, player.getPosition(), SoundHandlerFart.getRandomFart(rand), SoundCategory.BLOCKS, 0.75F, rand.nextFloat());
		}
		return null;
	}
}