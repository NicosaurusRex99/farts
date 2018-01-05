package naturix.farts;

import naturix.farts.network.PacketHandler;
import naturix.farts.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FartsMod.MODID, version = FartsMod.VERSION, name = FartsMod.NAME)
public class FartsMod
{
    public static final String MODID = "farts";
    public static final String VERSION = "1.12.2.1";
    public static final String NAME = "Farts";
    
    @SidedProxy(serverSide = "naturix.farts.proxy.CommonProxy", clientSide = "naturix.farts.proxy.ClientProxy")
    public static CommonProxy proxy;
    public static PacketHandler packetHandler;

    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
 
	}
}
