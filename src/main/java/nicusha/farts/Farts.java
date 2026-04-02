package nicusha.farts;

import nicusha.farts.registry.SoundRegistry;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Farts.MODID)
public class Farts {
    public static final String MODID = "farts";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Farts(IEventBus bus, ModContainer container) {
        bus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        SoundRegistry.SOUNDS.register(bus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
