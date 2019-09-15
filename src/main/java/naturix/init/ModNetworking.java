package naturix.init;

import javafx.geometry.Side;
import naturix.Main;
import naturix.networking.PacketPlayFart;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModNetworking {

    private static int packetId = 0;
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Main.MODID, "fart_packet"), () -> "1.0", s -> true, s -> true);

    private static int nextID() {
        return packetId++;
    }

    public static void init() {
        INSTANCE.registerMessage(nextID(),
                PacketPlayFart.class,
                PacketPlayFart::toBytes,
                PacketPlayFart::new,
                PacketPlayFart::handle);
    }

}