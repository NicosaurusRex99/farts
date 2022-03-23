package nicusha.farts.init;

import nicusha.farts.*;
import nicusha.farts.networking.PacketPlayBurp;
import nicusha.farts.networking.PacketPlayFart;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Farts.MODID, value = Dist.CLIENT)
public class ModEvents {

    @SubscribeEvent
    public static void handleEventInput(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || event.phase == TickEvent.Phase.START)
            return;
        if (ModKeyBindings.PLAY_FART.isDown()) {
            ModNetworking.INSTANCE.sendToServer(new PacketPlayFart());
        }
        if (ModKeyBindings.PLAY_BURP.isDown()) {
            ModNetworking.INSTANCE.sendToServer(new PacketPlayBurp());
        }
    }
}