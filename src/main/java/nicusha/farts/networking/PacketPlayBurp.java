package nicusha.farts.networking;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.network.*;
import nicusha.farts.utils.FartUtils;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;

import java.util.function.*;

public class PacketPlayBurp {

    public PacketPlayBurp(ByteBuf buf) {

    }

    public void toBytes(ByteBuf buf) {

    }

    public PacketPlayBurp() {
    }


    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            ServerLevel world = player.getLevel();
            world.playSound(null, player.blockPosition(), FartUtils.getRandomBurp(world.random), SoundSource.PLAYERS, 0.8F, 1.0F);
        });
        ctx.get().setPacketHandled(true);
    }
}