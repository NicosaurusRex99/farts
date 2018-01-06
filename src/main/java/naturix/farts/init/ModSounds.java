package naturix.farts.init;

import java.util.LinkedList;
import java.util.List;

import naturix.farts.FartsMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * @author p455w0rd
 *
 */
public class ModSounds {

	private static final List<SoundEvent> FARTS_LIST = new LinkedList<>();

	public static List<SoundEvent> getList() {
		if (FARTS_LIST.isEmpty()) {
			registerSound("fartsound1");
			registerSound("fartsound2");
		}
		return FARTS_LIST;
	}

	public static SoundEvent registerSound(String soundNameIn) {
		SoundEvent sound = new SoundEvent(new ResourceLocation(FartsMod.MODID, soundNameIn)).setRegistryName(new ResourceLocation(FartsMod.MODID, soundNameIn));
		if (!FARTS_LIST.contains(sound)) {
			FARTS_LIST.add(sound);
		}
		return sound;
	}

}
