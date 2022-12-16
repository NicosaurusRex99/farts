package nicusha.farts.init;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.resources.*;
import net.minecraft.sounds.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nicusha.farts.*;

import static nicusha.farts.Farts.MODID;

/**
 * @author p455w0rd
 *
 */
public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    private static final List<SoundEvent> FARTS_LIST = new LinkedList<>();
    private static final List<SoundEvent> BURP_LIST = new LinkedList<>();

    public static final RegistryObject<SoundEvent>
            FART1 = registerSound("fartsound1"),
            FART2 = registerSound("fartsound2"),
            FART3 = registerSound("fartsound3"),
            FART4 = registerSound("fartsound4"),
            FART5 = registerSound("fartsound5"),
            FART6 = registerSound("fartsound6"),
            FART7 = registerSound("fartsound7"),
            FART8 = registerSound("fartsound8"),
            FART9 = registerSound("fartsound9"),
            FART10 = registerSound("fartsound10"),
            FART11 = registerSound("fartsound11"),
            FART12 = registerSound("fartsound12"),
            FART13 = registerSound("fartsound13"),
            FART14 = registerSound("fartsound14"),
            FART15 = registerSound("fartsound15"),
            FART16 = registerSound("fartsound16"),
            FART17 = registerSound("fartsound17"),
            FART18 = registerSound("fartsound18"),
            FART19 = registerSound("fartsound19"),
            FART20 = registerSound("fartsound20"),
            FART21 = registerSound("fartsound21"),
            FART22 = registerSound("fartsound22"),
            FART23 = registerSound("fartsound23"),
            FART24 = registerSound("fartsound24"),
            FART25 = registerSound("fartsound25"),
            FART26 = registerSound("fartsound26"),
            FART27 = registerSound("fartsound27"),
            FART28 = registerSound("fartsound28"),
            FART29 = registerSound("fartsound29"),
            FART30 = registerSound("fartsound30"),
            FART31 = registerSound("fartsound31"),
            FART32 = registerSound("fartsound32"),
            FART33 = registerSound("fartsound33"),
            FART34 = registerSound("fartsound34"),
            FART35 = registerSound("fartsound35"),
            FART36 = registerSound("fartsound36");

    public static List<SoundEvent> getFartList() {
        if (FARTS_LIST.isEmpty()) {
            FARTS_LIST.add(FART1.get());
            FARTS_LIST.add(FART2.get());
            FARTS_LIST.add(FART3.get());
            FARTS_LIST.add(FART4.get());
            FARTS_LIST.add(FART5.get());
            FARTS_LIST.add(FART6.get());
            FARTS_LIST.add(FART7.get());
            FARTS_LIST.add(FART8.get());
            FARTS_LIST.add(FART9.get());
            FARTS_LIST.add(FART10.get());
            FARTS_LIST.add(FART11.get());
            FARTS_LIST.add(FART12.get());
            FARTS_LIST.add(FART13.get());
            FARTS_LIST.add(FART14.get());
            FARTS_LIST.add(FART15.get());
            FARTS_LIST.add(FART16.get());
            FARTS_LIST.add(FART17.get());
            FARTS_LIST.add(FART18.get());
            FARTS_LIST.add(FART19.get());
            FARTS_LIST.add(FART20.get());
            FARTS_LIST.add(FART21.get());
            FARTS_LIST.add(FART22.get());
            FARTS_LIST.add(FART23.get());
            FARTS_LIST.add(FART24.get());
            FARTS_LIST.add(FART25.get());
            FARTS_LIST.add(FART26.get());
            FARTS_LIST.add(FART27.get());
            FARTS_LIST.add(FART28.get());
            FARTS_LIST.add(FART29.get());
            FARTS_LIST.add(FART30.get());
            FARTS_LIST.add(FART31.get());
            FARTS_LIST.add(FART32.get());
            FARTS_LIST.add(FART33.get());
            FARTS_LIST.add(FART34.get());
            FARTS_LIST.add(FART35.get());
            FARTS_LIST.add(FART36.get());
        }
        return FARTS_LIST;
    }
    public static final RegistryObject<SoundEvent>
            BURP1 = registerSound("burpsound1"),
            BURP2 = registerSound("burpsound2"),
            BURP3 = registerSound("burpsound3"),
            BURP4 = registerSound("burpsound4"),
            BURP5 = registerSound("burpsound5"),
            BURP6 = registerSound("burpsound6"),
            BURP7 = registerSound("burpsound7"),
            BURP8 = registerSound("burpsound8"),
            BURP9 = registerSound("burpsound9"),
            BURP10 = registerSound("burpsound10"),
            BURP11 = registerSound("burpsound11"),
            BURP12 = registerSound("burpsound12");
    public static List<SoundEvent> getBurpList() {
        if (BURP_LIST.isEmpty()) {
            BURP_LIST.add(BURP1.get());
            BURP_LIST.add(BURP2.get());
            BURP_LIST.add(BURP3.get());
            BURP_LIST.add(BURP4.get());
            BURP_LIST.add(BURP5.get());
            BURP_LIST.add(BURP6.get());
            BURP_LIST.add(BURP7.get());
            BURP_LIST.add(BURP8.get());
            BURP_LIST.add(BURP9.get());
            BURP_LIST.add(BURP10.get());
            BURP_LIST.add(BURP11.get());
            BURP_LIST.add(BURP12.get());
        }
        return BURP_LIST;
    }

    private static RegistryObject<SoundEvent> registerSound(String registryName) {
        return SOUNDS.register(registryName, () -> createSoundEvent(registryName));
    }

    private static SoundEvent createSoundEvent(String soundPath) {
        return SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, soundPath));
    }

}