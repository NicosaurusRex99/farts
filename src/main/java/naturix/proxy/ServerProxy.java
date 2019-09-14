package naturix.proxy;

import naturix.init.ModNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ServerProxy implements IProxy {

    @Override
    public void init() {
        ModNetworking.register();
    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Only run this on the client!");
    }

    @Override
    public PlayerEntity getClientPlayer() {
        throw new IllegalStateException("Only run this on the client!");
    }
}