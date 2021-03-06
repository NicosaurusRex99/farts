package naturix.utils;

import java.util.Random;

import naturix.init.ModSounds;
import net.minecraft.util.SoundEvent;

/**
 * @author p455w0rd
 *
 */
public class FartUtils {

    public static SoundEvent getRandomFart(Random rand) {
        int num = rand.nextInt(ModSounds.getFartList().size());
        return ModSounds.getFartList().get(num);
    }
    public static SoundEvent getRandomBurp(Random rand) {
        int num = rand.nextInt(ModSounds.getBurpList().size());
        return ModSounds.getBurpList().get(num);
    }

}