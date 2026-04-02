package nicusha.farts.init;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import nicusha.farts.Farts;
import nicusha.farts.networking.BurpPayload;
import nicusha.farts.networking.FartPayload;

@EventBusSubscriber(modid = Farts.MODID, value = Dist.CLIENT)
public class ModEvents {
    @SubscribeEvent
    public static void handleEventInput(ClientTickEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        while (ModKeyBindings.PLAY_FART.consumeClick()) {
            ModNetworking.sendToServer(new FartPayload(0.8F, 1.0F));
        }
        while (ModKeyBindings.PLAY_BURP.consumeClick()) {
            ModNetworking.sendToServer(new BurpPayload(0.8F, 1.0F));
        }
    }
}