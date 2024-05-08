package nicusha.farts;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import nicusha.farts.registry.SoundRegistry;

/**
 * @author p455w0rd
 *
 */
public class FartUtils {
    public static SoundEvent getRandomFart(RandomSource rand) {
        int num = rand.nextInt(SoundRegistry.getFartList().size());
        return SoundRegistry.getFartList().get(num);
    }
    public static SoundEvent getRandomBurp(RandomSource rand) {
        int num = rand.nextInt(SoundRegistry.getBurpList().size());
        return SoundRegistry.getBurpList().get(num);
    }
}
