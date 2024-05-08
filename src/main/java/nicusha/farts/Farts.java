package nicusha.farts;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import nicusha.farts.registry.SoundRegistry;
import org.slf4j.Logger;

@Mod(Farts.MODID)
public class Farts
{
    public static final String MODID = "farts";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Farts(IEventBus bus, ModContainer mod)
    {
        SoundRegistry.SOUNDS.register(bus);
    }

}
