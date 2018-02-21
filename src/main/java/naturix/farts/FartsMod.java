package naturix.farts;

import naturix.farts.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FartsMod.MODID, version = FartsMod.VERSION, name = FartsMod.NAME)
public class FartsMod {
	public static final String MODID = "farts";
	public static final String VERSION = "1.12.2.3";
	public static final String NAME = "Farts";

	@SidedProxy(serverSide = "naturix.farts.proxy.CommonProxy", clientSide = "naturix.farts.proxy.ClientProxy")
	public static CommonProxy PROXY;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PROXY.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		PROXY.init(event);
	}

}
