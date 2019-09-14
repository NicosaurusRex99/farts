package naturix.networking;

import naturix.utils.FartUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketPlayFart {

    public static void encode(PacketPlayFart msg, PacketBuffer buffer) {}
    public static PacketPlayFart decode(PacketBuffer buffer) { return new PacketPlayFart(); }

    public PacketPlayFart() {
    }

    public static class Handler {
            public static void handle(final PacketPlayFart msg, Supplier<NetworkEvent.Context> ctx) {
                ctx.get().enqueueWork(() -> {
                    PlayerEntity player = ctx.get().getSender();
                    if (player == null)
                        return;
                    World world = player.getEntityWorld();
                    world.playSound(player, player.getPosition(), FartUtils.getRandomFart(world.rand), SoundCategory.PLAYERS, 0.8F, 1.0F);

                });
                ctx.get().setPacketHandled(true);
            }
    }
}