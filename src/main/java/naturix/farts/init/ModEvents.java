package naturix.farts.init;

import naturix.farts.network.PacketPlayFart;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author p455w0rd
 *
 */
public class ModEvents {

	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ModEvents());
	}

	@SubscribeEvent
	public void onSoundRegistryReady(final RegistryEvent.Register<SoundEvent> event) {
		ModSounds.getList().stream().forEach(sound -> event.getRegistry().register(sound));
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (ModKeyBindings.PLAY_FART.isPressed()) {
			ModNetworking.getInstance().sendToServer(new PacketPlayFart());
		}
	}

}
