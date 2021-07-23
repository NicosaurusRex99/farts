package naturix.proxy;

import naturix.init.ModNetworking;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

public class ServerProxy implements IProxy {

    @Override
    public void init() {
        ModNetworking.init();
    }

    @Override
    public Level getClientWorld() {
        throw new IllegalStateException("Only run this on the client!");
    }

    @Override
    public Player getClientPlayer() {
        throw new IllegalStateException("Only run this on the client!");
    }
}