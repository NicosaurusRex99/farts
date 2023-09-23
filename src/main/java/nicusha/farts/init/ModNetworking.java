package nicusha.farts.init;

import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.*;
import nicusha.farts.*;
import nicusha.farts.networking.*;
import net.minecraft.resources.*;

public class ModNetworking {
    public static SimpleChannel INSTANCE = ChannelBuilder.named(new ResourceLocation(Farts.MODID, "farts"))
            .networkProtocolVersion(2)
            .acceptedVersions((status, version) -> version == 2)
            .simpleChannel();

    public static <T extends Message<T>> void registerMessage(SimpleChannel channel, int id, Class<T> message) {
        channel.messageBuilder(message, id)
                .encoder(Message::toBytes)
                .decoder(byteBuf -> {
                    try {
                        T msg = message.getDeclaredConstructor().newInstance();
                        return msg.fromBytes(byteBuf);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .consumerMainThread((msg, ctx) -> {
                    LogicalSide side = ctx.getDirection().getReceptionSide();
                    if (side.equals(LogicalSide.CLIENT)) {
                        msg.client(ctx);
                    } else if (side.equals(LogicalSide.SERVER)) {
                        msg.server(ctx);
                    }
                })
                .add();
    }

}