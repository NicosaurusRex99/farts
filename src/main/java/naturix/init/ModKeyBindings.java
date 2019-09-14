package naturix.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class ModKeyBindings {

    public static final KeyBinding PLAY_FART = new KeyBinding("key.fart", GLFW.GLFW_KEY_G, "keys.categories.farts");

    public static void init() {
        ClientRegistry.registerKeyBinding(PLAY_FART);
    }
}