package naturix.farts;

import naturix.farts.networking.FartKeyBindings;
import naturix.farts.proxy.CommonProxy;
import naturix.farts.utils.ModSounds;
import naturix.farts.utils.SoundHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FartsMod.MODID, version = FartsMod.VERSION, name = FartsMod.NAME)
public class FartsMod
{
    public static final String MODID = "farts";
    public static final String VERSION = "1.12.2.0";
    public static final String NAME = "Farts";
    
    @SidedProxy(serverSide = "naturix.farts.proxy.CommonProxy", clientSide = "naturix.farts.proxy.ClientProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	FartKeyBindings.init();
    }
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
    	
	}
}
