package naturix.farts.network;

import io.netty.buffer.ByteBuf;
import naturix.farts.utils.KeyBindings;
import naturix.farts.utils.SoundHandlerFart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSendKey implements IMessage {
	 private int toSend;
	private String player;
	  public PacketSendKey(int toSend) {
	    this.toSend = toSend;}



    @Override
    public void fromBytes(ByteBuf buf) {
		this.toSend = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeLong(toSend);
    }

    public PacketSendKey() {
    	
    }

    public static class Handler implements IMessageHandler<PacketSendKey, IMessage> {
        private ByteBuf buf;
		
		@Override
        public IMessage onMessage(PacketSendKey message, MessageContext ctx) {
			EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
			int amount = message.toSend;
			serverPlayer.getServerWorld().addScheduledTask(() -> {
				if(KeyBindings.fartsKey.isPressed()) {
			      serverPlayer.playSound(SoundHandlerFart.fart_1, 5f, 1f);
			      System.out.print("farting");
			    }});
			return message;
		}
        private void handle(PacketSendKey message, MessageContext ctx) {
        	EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
        	if(KeyBindings.fartsKey.isPressed()) {
        		System.out.println("fart key works");
        		serverPlayer.playSound(SoundHandlerFart.fart_2, 5f, 1f);
        	}
        }
        }
    }
