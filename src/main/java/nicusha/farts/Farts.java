package nicusha.farts;

import com.mojang.logging.LogUtils;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nicusha.farts.init.*;
import nicusha.farts.proxy.*;
import org.slf4j.Logger;


@Mod("farts")
public class Farts
{
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "farts";
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public Farts()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::common);
        MinecraftForge.EVENT_BUS.register(this);
        ModSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public void common(FMLCommonSetupEvent event) {
        ModNetworking.init();
        proxy.init();
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        ModNetworking.init();
    }

    @SubscribeEvent
    public void keyBinding(RegisterKeyMappingsEvent event) {
        event.register(ModKeyBindings.PLAY_FART);
        event.register(ModKeyBindings.PLAY_BURP);
    }


}
