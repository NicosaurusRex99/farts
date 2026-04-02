package nicusha.farts.networking.packets;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import nicusha.farts.FartUtils;
import nicusha.farts.networking.BurpPayload;

public class BurpPacket {
    public static final BurpPacket INSTANCE = new BurpPacket();

    public static BurpPacket get() {
        return INSTANCE;
    }

    public void handle(final BurpPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level world = player.level();
            world.playSound(null, player.blockPosition(), FartUtils.getRandomBurp(world.getRandom()), SoundSource.PLAYERS, payload.pitch(), payload.volume());
        });
    }
}
