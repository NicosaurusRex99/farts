package naturix.farts.network;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import naturix.farts.utils.KeyBindings;
import naturix.farts.utils.SoundHandlerFart;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSendKey implements IMessage {
	 private int toSend;
	  public PacketSendKey(int toSend) {
	    this.toSend = toSend;}


    @Override
    public void fromBytes(ByteBuf buf) {
    	
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeLong(toSend);
    }

    public PacketSendKey() {
    	
    }

    public static class Handler implements IMessageHandler<PacketSendKey, IMessage> {
        private ByteBuf buf;
		private Random rand;
		private Runnable Runnable;
		
		@Override
        public IMessage onMessage(PacketSendKey message, MessageContext ctx) {
			EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
			int volume = message.toSend;
			serverPlayer.getServerWorld().addScheduledTask(() -> {
				if(KeyBindings.fartsKey.isPressed()) {
			      serverPlayer.playSound(SoundHandlerFart.fart_1, 5f, 1f);
			    }});
			return message;
		}
        private void handle(PacketSendKey message, MessageContext ctx) {
        	if(KeyBindings.fartsKey.isPressed()) {
        		this.onMessage(message, ctx);
        		System.out.println("fart key works");
        	}
        }
        }
    }
