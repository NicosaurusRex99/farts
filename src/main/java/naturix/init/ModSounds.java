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
    private static final List<SoundEvent> BURP_LIST = new LinkedList<>();

    public static List<SoundEvent> getFartList() {
        if (FARTS_LIST.isEmpty()) {
            registerFartSound("fartsound1");
            registerFartSound("fartsound2");
            registerFartSound("fartsound3");
            registerFartSound("fartsound4");
            registerFartSound("fartsound5");
            registerFartSound("fartsound6");
            registerFartSound("fartsound7");
            registerFartSound("fartsound8");
            registerFartSound("fartsound9");
            registerFartSound("fartsound10");
            registerFartSound("fartsound11");
            registerFartSound("fartsound12");
            registerFartSound("fartsound13");
            registerFartSound("fartsound14");
            registerFartSound("fartsound15");
            registerFartSound("fartsound16");
            registerFartSound("fartsound17");
            registerFartSound("fartsound18");
            registerFartSound("fartsound19");
            registerFartSound("fartsound20");
            registerFartSound("fartsound21");
            registerFartSound("fartsound22");
            registerFartSound("fartsound23");
            registerFartSound("fartsound24");
            registerFartSound("fartsound25");
            registerFartSound("fartsound26");
            registerFartSound("fartsound27");
            registerFartSound("fartsound28");
            registerFartSound("fartsound29");
            registerFartSound("fartsound30");
            registerFartSound("fartsound31");
            registerFartSound("fartsound32");
            registerFartSound("fartsound33");
            registerFartSound("fartsound34");
            registerFartSound("fartsound35");
            registerFartSound("fartsound36");
        }
        return FARTS_LIST;
    }

    public static List<SoundEvent> getBurpList() {
        if (BURP_LIST.isEmpty()) {
            registerBurpSound("burpsound1");
            registerBurpSound("burpsound2");
            registerBurpSound("burpsound3");
            registerBurpSound("burpsound4");
            registerBurpSound("burpsound5");
            registerBurpSound("burpsound6");
            registerBurpSound("burpsound7");
            registerBurpSound("burpsound8");
            registerBurpSound("burpsound9");
            registerBurpSound("burpsound10");
            registerBurpSound("burpsound11");
            registerBurpSound("burpsound12");
        }
        return BURP_LIST;
    }

    public static SoundEvent registerFartSound(String soundNameIn) {
        SoundEvent sound = new SoundEvent(new ResourceLocation(Main.MODID, soundNameIn)).setRegistryName(new ResourceLocation(Main.MODID, soundNameIn));
        if (!FARTS_LIST.contains(sound)) {
            FARTS_LIST.add(sound);
        }
        return sound;
    }
    public static SoundEvent registerBurpSound(String soundNameIn) {
        SoundEvent sound = new SoundEvent(new ResourceLocation(Main.MODID, soundNameIn)).setRegistryName(new ResourceLocation(Main.MODID, soundNameIn));
        if (!BURP_LIST.contains(sound)) {
            BURP_LIST.add(sound);
        }
        return sound;
    }

}