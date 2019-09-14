package naturix.init;

import java.util.LinkedList;
import java.util.List;

import naturix.Main;
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
            registerSound("fartsound3");
            registerSound("fartsound4");
            registerSound("fartsound5");
            registerSound("fartsound6");
            registerSound("fartsound7");
            registerSound("fartsound8");
            registerSound("fartsound9");
            registerSound("fartsound10");
            registerSound("fartsound11");
            registerSound("fartsound12");
            registerSound("fartsound13");
            registerSound("fartsound14");
            registerSound("fartsound15");
            registerSound("fartsound16");
            registerSound("fartsound17");
            registerSound("fartsound18");
            registerSound("fartsound19");
            registerSound("fartsound20");
            registerSound("fartsound21");
            registerSound("fartsound22");
            registerSound("fartsound23");
            registerSound("fartsound24");
            registerSound("fartsound25");
            registerSound("fartsound26");
            registerSound("fartsound27");
            registerSound("fartsound28");
            registerSound("fartsound29");
            registerSound("fartsound30");
            registerSound("fartsound31");
            registerSound("fartsound32");
            registerSound("fartsound33");
            registerSound("fartsound34");
            registerSound("fartsound35");
            registerSound("fartsound36");
        }
        return FARTS_LIST;
    }

    public static SoundEvent registerSound(String soundNameIn) {
        SoundEvent sound = new SoundEvent(new ResourceLocation(Main.MODID, soundNameIn)).setRegistryName(new ResourceLocation(Main.MODID, soundNameIn));
        if (!FARTS_LIST.contains(sound)) {
            FARTS_LIST.add(sound);
        }
        return sound;
    }

}