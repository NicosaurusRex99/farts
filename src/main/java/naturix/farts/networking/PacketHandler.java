package naturix.farts.networking;
import naturix.farts.FartsMod;
import naturix.farts.networking.message.MessageFart;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(FartsMod.MODID);

	public static void init()
	{
		System.out.print("Farts networking initiailized");
		INSTANCE.registerMessage(MessageFart.class, MessageFart.class, 3, Side.CLIENT);
    }
}