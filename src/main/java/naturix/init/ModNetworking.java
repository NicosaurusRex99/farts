package naturix.init;

import naturix.Main;
import naturix.networking.PacketPlayBurp;
import naturix.networking.PacketPlayFart;
import net.minecraft.resources.*;
import net.minecraftforge.fmllegacy.network.*;
import net.minecraftforge.fmllegacy.network.simple.*;

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
        INSTANCE.registerMessage(nextID(),
                PacketPlayBurp.class,
                PacketPlayBurp::toBytes,
                PacketPlayBurp::new,
                PacketPlayBurp::handle);
    }

}