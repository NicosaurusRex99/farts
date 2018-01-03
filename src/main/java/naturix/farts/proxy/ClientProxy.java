package naturix.farts.proxy;

import naturix.farts.networking.FartKeyBindings;
import naturix.farts.utils.ModSounds;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        FartKeyBindings.init();
    }

    public void registerSounds(RegistryEvent.Register<SoundEvent> evt) {
    	ModSounds.registerSounds(evt);
    }
}
