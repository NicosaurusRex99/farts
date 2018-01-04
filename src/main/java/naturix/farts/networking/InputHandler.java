package naturix.farts.networking;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import naturix.farts.networking.message.MessageFart;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class InputHandler
{
	public static KeyBinding key_fart;
	public static boolean keyPressed = false;
	public static boolean keyHasBeenPressed = false;
	private Random rand = new Random();

	public InputHandler()
	{
		key_fart = new KeyBinding("key.fart", Keyboard.KEY_G, "keys.category.farts");
		ClientRegistry.registerKeyBinding(key_fart);

	}

	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event)
	{
		if (key_fart.isPressed())
		{
			keyPressed = true;
			PacketHandler.INSTANCE.sendToServer(new MessageFart());
					}
	}

	@SubscribeEvent
	public void playerTick(PlayerTickEvent event)
	{
			if (keyPressed)
			{
				keyPressed = false;
				PacketHandler.INSTANCE.sendToServer(new MessageFart());
			}
		}
	

	public KeyBinding getFartKey()
	{
		return key_fart;
	}
}