package nicusha.farts.init;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.SimpleChannel;
import nicusha.farts.*;
import nicusha.farts.networking.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Farts.MODID, value = Dist.CLIENT)
public class ModEvents {

    @SubscribeEvent
    public static void handleEventInput(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || event.phase == TickEvent.Phase.START)
            return;
        if (ModKeyBindings.PLAY_FART.isDown()) {
            ModNetworking.INSTANCE.send(new PacketPlayFart(), mc.player.connection.getConnection());
        }
        if (ModKeyBindings.PLAY_BURP.isDown()) {
            ModNetworking.INSTANCE.send(new PacketPlayBurp(), mc.player.connection.getConnection());
        }
    }

}