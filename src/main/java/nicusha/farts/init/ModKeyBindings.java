package nicusha.farts.init;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import nicusha.farts.Farts;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber
public class ModKeyBindings {

    public static final KeyMapping.Category FARTS_CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath(Farts.MODID, "farts"));

    public static final KeyMapping PLAY_FART = new KeyMapping("key.fart", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, FARTS_CATEGORY);

    public static final KeyMapping PLAY_BURP = new KeyMapping("key.burp", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, FARTS_CATEGORY);

    @SubscribeEvent
    public static void init(RegisterKeyMappingsEvent event) {
        event.register(PLAY_FART);
        event.register(PLAY_BURP);
    }
}