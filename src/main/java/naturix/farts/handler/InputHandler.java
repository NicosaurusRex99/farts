package naturix.farts.handler;

import naturix.farts.network.PacketHandler;
import naturix.farts.network.PacketSendKey;
import naturix.farts.utils.KeyBindings;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class InputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBindings.fartsKey.isPressed()) {

            PacketHandler.INSTANCE.sendToServer(new PacketSendKey());
        }
    }
}