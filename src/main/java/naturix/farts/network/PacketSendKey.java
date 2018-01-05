package naturix.farts.network;

import java.util.Random;

import io.netty.buffer.ByteBuf;
import naturix.farts.utils.KeyBindings;
import naturix.farts.utils.SoundHandlerFart;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSendKey implements IMessage {

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public PacketSendKey() {
    }

    public static class Handler implements IMessageHandler<PacketSendKey, IMessage> {
        private ByteBuf buf;
		private Random rand;

		@Override
        public IMessage onMessage(PacketSendKey message, MessageContext ctx) {
        	EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
        		serverPlayer.playSound(SoundHandlerFart.fart_1, 1, 1);
            return null;
        }

        private void handle(PacketSendKey message, MessageContext ctx) {
        	if(KeyBindings.fartsKey.isPressed()) {
        		this.onMessage(message, ctx);
        	}
        }
        }
    }
