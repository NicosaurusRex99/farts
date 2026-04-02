package nicusha.farts.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.*;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import nicusha.farts.Farts;

public record BurpPayload(float pitch, float volume) implements CustomPacketPayload {
    public static final Type<BurpPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(Farts.MODID, "burp_packet"));

    @Override
    public Type<BurpPayload> type() {
        return TYPE;
    }
    public static final StreamCodec<FriendlyByteBuf, BurpPayload> STREAM_BURP = StreamCodec.composite(ByteBufCodecs.FLOAT, BurpPayload::pitch, ByteBufCodecs.FLOAT, BurpPayload::volume, BurpPayload::new);
}