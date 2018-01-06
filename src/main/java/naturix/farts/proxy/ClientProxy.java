package naturix.farts.proxy;

import naturix.farts.init.ModKeyBindings;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		ModKeyBindings.init();
	}

}
