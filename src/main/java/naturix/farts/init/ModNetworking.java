package naturix.farts.init;

import naturix.farts.FartsMod;
import naturix.farts.network.PacketPlayFart;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author p455w0rd
 *
 */
public class ModNetworking {

	private static int packetId = 0;
	private static SimpleNetworkWrapper INSTANCE = null;

	private static int nextID() {
		return packetId++;
	}

	public static SimpleNetworkWrapper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(FartsMod.MODID);
		}
		return INSTANCE;
	}

	public static void init() {
		getInstance().registerMessage(PacketPlayFart.Handler.class, PacketPlayFart.class, nextID(), Side.SERVER);
	}

}
