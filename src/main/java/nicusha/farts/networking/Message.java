package nicusha.farts.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.network.CustomPayloadEvent;

public interface Message<T extends Message> {
    Dist getExecutingSide();
    default void server(CustomPayloadEvent.Context context) {}
    default void client(CustomPayloadEvent.Context context) {}
    T fromBytes(FriendlyByteBuf buf);
    void toBytes(FriendlyByteBuf buf);
}