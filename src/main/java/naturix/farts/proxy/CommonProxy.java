package naturix.farts.proxy;

import java.util.Random;

import naturix.farts.networking.InputHandler;
import naturix.farts.networking.PacketHandler;
import naturix.farts.utils.SoundHandlerFart;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
	
    private static Random rand;
	public void preInit(FMLPreInitializationEvent e) {
		
    }

    public void init(FMLInitializationEvent e) {
    	
    	SoundHandlerFart.register();
       	PacketHandler.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}