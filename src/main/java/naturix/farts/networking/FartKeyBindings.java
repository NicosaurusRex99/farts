package naturix.farts.networking;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import naturix.farts.FartsMod;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FartKeyBindings {

    public static KeyBinding Fart;
    
    public static void init() {
        final String category = "key.categories." + FartsMod.MODID;

        Fart = new KeyBinding("key.fart", Keyboard.KEY_G, category);
        ClientRegistry.registerKeyBinding(Fart);
    }
}