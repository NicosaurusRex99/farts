package naturix.farts.utils;

import java.util.Random;

import naturix.farts.init.ModSounds;
import net.minecraft.util.SoundEvent;

/**
 * @author p455w0rd
 *
 */
public class FartUtils {

	public static SoundEvent getRandomFart(Random rand) {
		int num = rand.nextInt(2);
		return ModSounds.getList().get(num);
	}

}
