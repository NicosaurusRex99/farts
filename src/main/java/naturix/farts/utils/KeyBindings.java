package naturix.farts.utils;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindings {

    public static KeyBinding fartsKey;

    public static void init() {
        fartsKey = new KeyBinding("key.fart", Keyboard.KEY_G, "keys.categories.farts");
        ClientRegistry.registerKeyBinding(fartsKey);
    }
}