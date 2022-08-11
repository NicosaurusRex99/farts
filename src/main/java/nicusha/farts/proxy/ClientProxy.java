package nicusha.farts.proxy;

import nicusha.farts.init.ModKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.*;
import net.minecraft.world.level.*;

public class ClientProxy implements IProxy {

    @Override
    public void init() {

    }

    @Override
    public Level getClientWorld() {
        return Minecraft.getInstance().player.clientLevel;
    }

    @Override
    public LocalPlayer getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}