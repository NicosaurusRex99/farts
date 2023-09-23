package nicusha.farts.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.network.*;
import nicusha.farts.Farts;
import nicusha.farts.utils.FartUtils;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;

import java.util.function.*;

public class PacketPlayBurp implements Message<PacketPlayBurp> {
    public PacketPlayBurp() {}

    @Override
    public Dist getExecutingSide() {
        return Dist.DEDICATED_SERVER;
    }
    @Override
    public void server(CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            Level world = player.level();
            world.playSound(null, player.blockPosition(), FartUtils.getRandomBurp(world.random), SoundSource.PLAYERS, 0.8F, 1.0F);
        });
        context.setPacketHandled(true);
    }

    @Override
    public PacketPlayBurp fromBytes(FriendlyByteBuf packetBuffer) {
        return this;
    }

    @Override
    public void toBytes(FriendlyByteBuf packetBuffer) {
    }
}