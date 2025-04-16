package nicusha.farts;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import nicusha.farts.registry.SoundRegistry;

import java.util.logging.Logger;

@Mod(Farts.MODID)
public class Farts
{
    public static final String MODID = "farts";
    public static final Logger LOGGER = Logger.getLogger(MODID);

    public Farts(IEventBus bus, ModContainer mod)
    {
        SoundRegistry.SOUNDS.register(bus);
    }

}
