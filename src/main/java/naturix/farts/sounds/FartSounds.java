package naturix.farts.sounds;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FartSounds extends MovingSound
{
    private World world;

	public FartSounds()
    {
        super(SoundEvents.ENTITY_GUARDIAN_ATTACK, SoundCategory.PLAYERS);

    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update()
    {
        if (!world.isRemote)
        {
            this.volume = 0.0F + 1.0F;
            this.pitch = 0.7F + 0.5F;
        }
        else
        {
            this.donePlaying = true;
        }
    }
}