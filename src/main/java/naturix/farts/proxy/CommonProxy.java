package naturix.farts.proxy;

import java.util.Random;

import naturix.farts.network.PacketHandler;
import naturix.farts.utils.SoundHandlerFart;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
	
    private static Random rand;
	public void preInit(FMLPreInitializationEvent e) {
		PacketHandler.registerMessages("farts");
    }

    public void init(FMLInitializationEvent e) {
    	PacketHandler.registerMessages();
    	SoundHandlerFart.register();

    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}