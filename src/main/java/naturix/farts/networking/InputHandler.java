package naturix.farts.networking;

import java.util.Random;

import naturix.farts.utils.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class InputHandler {
    private EntityPlayer player;
	private Random rand;
	private World world;
	private EntityPlayer posX, posY, posZ;
	private BlockPos blockpos;
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(FartKeyBindings.Fart.isPressed()) {float var4 = 1.0F;
        System.out.println("loading fart");
        world.playSound(null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), ModSounds.fartsound, SoundCategory.BLOCKS, 0.2F, 1F);
	}
}}