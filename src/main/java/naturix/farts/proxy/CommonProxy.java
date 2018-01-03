package naturix.farts.proxy;

import java.util.Random;

import naturix.farts.networking.FartKeyBindings;
import naturix.farts.networking.InputHandler;
import naturix.farts.utils.ModSounds;
import naturix.farts.utils.SoundHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
	
    private static Random rand;
	public void preInit(FMLPreInitializationEvent e) {
		FMLCommonHandler.instance().bus().register(new InputHandler());
    }

    public void init(FMLInitializationEvent e) {
    	SoundHandler.init();
    	FartKeyBindings.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}