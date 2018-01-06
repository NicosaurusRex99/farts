package naturix.farts.proxy;

import java.util.Random;

import naturix.farts.FartsMod;
import naturix.farts.network.PacketHandler;
import naturix.farts.network.PacketSendKey;
import naturix.farts.utils.SoundHandlerFart;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class CommonProxy {
	PacketHandler packetHandler;
	
    private static Random rand;
	public void preInit(FMLPreInitializationEvent e) {
		int messageId = 0;
    	 packetHandler.registerMessages(FartsMod.MODID);
    }

    public void init(FMLInitializationEvent e) {
    	SoundHandlerFart.register();

    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}