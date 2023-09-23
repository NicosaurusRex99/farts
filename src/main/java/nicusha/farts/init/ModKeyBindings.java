package nicusha.farts.init;

import net.minecraft.client.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nicusha.farts.Farts;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Farts.MODID, value = Dist.CLIENT)
public class ModKeyBindings {

    public static final KeyMapping PLAY_FART = new KeyMapping("key.fart", GLFW.GLFW_KEY_G, "keys.categories.farts");
    public static final KeyMapping PLAY_BURP = new KeyMapping("key.burp", GLFW.GLFW_KEY_H, "keys.categories.farts");

    @SubscribeEvent
    public static void init(RegisterKeyMappingsEvent event) {
        event.register(PLAY_FART);
        event.register(PLAY_BURP);
    }
}