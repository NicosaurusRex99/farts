package nicusha.farts.init;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.network.PacketDistributor;
import nicusha.farts.*;
import nicusha.farts.networking.*;

@EventBusSubscriber(modid = Farts.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void handleEventInput(ClientTickEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null)
            return;
        if (ModKeyBindings.PLAY_FART.isDown()) {
            ModNetworking.sendToServer(new FartPayload(0.8F, 1.0F));
        }
        if (ModKeyBindings.PLAY_BURP.isDown()) {
            ModNetworking.sendToServer(new BurpPayload(0.8F, 1.0F));
        }
    }
}
