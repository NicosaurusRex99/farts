package naturix.init;

import naturix.Main;
import naturix.networking.PacketPlayBurp;
import naturix.networking.PacketPlayFart;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Main.MODID, value = Dist.CLIENT)
public class ModEvents {

    @SubscribeEvent
    public static void handleEventInput(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || event.phase == TickEvent.Phase.START)
            return;
        if (ModKeyBindings.PLAY_FART.isPressed()) {
            ModNetworking.INSTANCE.sendToServer(new PacketPlayFart());
        }
        if (ModKeyBindings.PLAY_BURP.isPressed()) {
            ModNetworking.INSTANCE.sendToServer(new PacketPlayBurp());
        }
    }
}