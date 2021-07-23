package naturix.networking;

import io.netty.buffer.ByteBuf;
import naturix.utils.FartUtils;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraftforge.fmllegacy.network.*;

import java.util.function.Supplier;

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
            world.playSound(null, new BlockPos(player.xo, player.yo, player.zo), FartUtils.getRandomBurp(world.random), SoundSource.PLAYERS, 0.8F, 1.0F);
        });
        ctx.get().setPacketHandled(true);
    }
}