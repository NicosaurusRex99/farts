package naturix.init;

import net.minecraft.client.*;
import net.minecraftforge.fmlclient.registry.*;
import org.lwjgl.glfw.GLFW;

public class ModKeyBindings {

    public static final KeyMapping PLAY_FART = new KeyMapping("key.fart", GLFW.GLFW_KEY_G, "keys.categories.farts");
    public static final KeyMapping PLAY_BURP = new KeyMapping("key.burp", GLFW.GLFW_KEY_H, "keys.categories.farts");

    public static void init() {
        ClientRegistry.registerKeyBinding(PLAY_FART);
        ClientRegistry.registerKeyBinding(PLAY_BURP);
    }
}