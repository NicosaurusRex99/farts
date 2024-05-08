package nicusha.farts.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.*;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import nicusha.farts.Farts;

public record FartPayload(float pitch, float volume) implements CustomPacketPayload {
    public static final Type<FartPayload> TYPE = new Type<>(new ResourceLocation(Farts.MODID, "fart_packet"));

    @Override
    public Type<FartPayload> type() {
        return TYPE;
    }
    public static final StreamCodec<FriendlyByteBuf, FartPayload> STREAM_FART = StreamCodec.composite(ByteBufCodecs.FLOAT, FartPayload::pitch, ByteBufCodecs.FLOAT, FartPayload::volume, FartPayload::new);
}