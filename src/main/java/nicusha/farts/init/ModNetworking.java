package nicusha.farts.init;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import nicusha.farts.Farts;
import nicusha.farts.networking.*;
import nicusha.farts.networking.packets.*;

@EventBusSubscriber(modid = Farts.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModNetworking {

    @SubscribeEvent
    public static void registerNetworking(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar payloadRegistrar = event.registrar(Farts.MODID);

        payloadRegistrar.playToServer(BurpPayload.TYPE, BurpPayload.STREAM_BURP, BurpPacket.get()::handle);
        payloadRegistrar.playToServer(FartPayload.TYPE, FartPayload.STREAM_FART, FartPacket.get()::handle);
    }

    public static void sendToServer(CustomPacketPayload message) {
        PacketDistributor.sendToServer(message);
    }

}
