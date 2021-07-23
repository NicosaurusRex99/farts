package naturix.proxy;

import net.minecraft.server.level.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

public interface IProxy {

    void init();

    Level getClientWorld();

    Player getClientPlayer();
}