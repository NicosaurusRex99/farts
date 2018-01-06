package naturix.farts.init;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModKeyBindings {

	public static final KeyBinding PLAY_FART = new KeyBinding("key.fart", Keyboard.KEY_G, "keys.categories.farts");;

	public static void init() {
		ClientRegistry.registerKeyBinding(PLAY_FART);
	}
}