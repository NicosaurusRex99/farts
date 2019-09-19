package naturix.networking;

import io.netty.buffer.ByteBuf;
import naturix.utils.FartUtils;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

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
            ServerPlayerEntity player = ctx.get().getSender();
            World world = player.getEntityWorld();
            world.playSound(null, player.getPosition(), FartUtils.getRandomBurp(world.rand), SoundCategory.PLAYERS, 0.8F, 1.0F);
        });
        ctx.get().setPacketHandled(true);
    }
}