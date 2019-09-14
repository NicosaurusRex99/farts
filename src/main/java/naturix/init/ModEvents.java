package naturix.init;

import naturix.Main;
import naturix.networking.PacketPlayFart;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Main.MODID, value = Dist.CLIENT)
public class ModEvents {

    @SubscribeEvent
    public static void handleEventInput(ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || event.phase == Phase.START)
            return;
        PlayerEntity player = mc.player;
       if (ModKeyBindings.PLAY_FART.isPressed()) {
            ModNetworking.sendTo(new PacketPlayFart(), (ServerPlayerEntity)player);
        }
    }
}