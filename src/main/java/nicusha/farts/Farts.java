package nicusha.farts;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nicusha.farts.init.*;
import nicusha.farts.networking.*;
import org.slf4j.Logger;


@Mod("farts")
public class Farts
{
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "farts";

    public Farts()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::common);
        MinecraftForge.EVENT_BUS.register(this);
        ModSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public void common(FMLCommonSetupEvent event) {
        ModNetworking.registerMessage(ModNetworking.INSTANCE, 0, PacketPlayFart.class);
        ModNetworking.registerMessage(ModNetworking.INSTANCE, 1, PacketPlayBurp.class);
    }


}
