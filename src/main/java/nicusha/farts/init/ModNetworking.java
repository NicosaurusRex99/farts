package nicusha.farts.init;

import net.minecraftforge.network.*;
import net.minecraftforge.network.simple.*;
import nicusha.farts.*;
import nicusha.farts.networking.PacketPlayBurp;
import nicusha.farts.networking.PacketPlayFart;
import net.minecraft.resources.*;

public class ModNetworking {

    private static int packetId = 0;
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Farts.MODID, "fart_packet"), () -> "1.0", s -> true, s -> true);

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