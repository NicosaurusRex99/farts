package nicusha.farts.init;

import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import nicusha.farts.Farts;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = Farts.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ModKeyBindings {
    public static final KeyMapping PLAY_FART = new KeyMapping("key.fart", GLFW.GLFW_KEY_G, "keys.categories.farts");
    public static final KeyMapping PLAY_BURP = new KeyMapping("key.burp", GLFW.GLFW_KEY_H, "keys.categories.farts");

    @SubscribeEvent
    public static void init(RegisterKeyMappingsEvent event) {
        event.register(PLAY_FART);
        event.register(PLAY_BURP);
    }
}
