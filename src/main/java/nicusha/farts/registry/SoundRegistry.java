package nicusha.farts.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.neoforged.neoforge.registries.*;

import java.util.*;

import static nicusha.farts.Farts.MODID;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, MODID);


    private static final List<SoundEvent> FARTS_LIST = new LinkedList<>(), BURP_LIST = new LinkedList<>();
    public static final DeferredHolder<SoundEvent, SoundEvent>
            FART1 = register("fartsound1"),
            FART2 = register("fartsound2"),
            FART3 = register("fartsound3"),
            FART4 = register("fartsound4"),
            FART5 = register("fartsound5"),
            FART6 = register("fartsound6"),
            FART7 = register("fartsound7"),
            FART8 = register("fartsound8"),
            FART9 = register("fartsound9"),
            FART10 = register("fartsound10"),
            FART11 = register("fartsound11"),
            FART12 = register("fartsound12"),
            FART13 = register("fartsound13"),
            FART14 = register("fartsound14"),
            FART15 = register("fartsound15"),
            FART16 = register("fartsound16"),
            FART17 = register("fartsound17"),
            FART18 = register("fartsound18"),
            FART19 = register("fartsound19"),
            FART20 = register("fartsound20"),
            FART21 = register("fartsound21"),
            FART22 = register("fartsound22"),
            FART23 = register("fartsound23"),
            FART24 = register("fartsound24"),
            FART25 = register("fartsound25"),
            FART26 = register("fartsound26"),
            FART27 = register("fartsound27"),
            FART28 = register("fartsound28"),
            FART29 = register("fartsound29"),
            FART30 = register("fartsound30"),
            FART31 = register("fartsound31"),
            FART32 = register("fartsound32"),
            FART33 = register("fartsound33"),
            FART34 = register("fartsound34"),
            FART35 = register("fartsound35"),
            FART36 = register("fartsound36");

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
    public static final DeferredHolder<SoundEvent, SoundEvent>
            BURP1 = register("burpsound1"),
            BURP2 = register("burpsound2"),
            BURP3 = register("burpsound3"),
            BURP4 = register("burpsound4"),
            BURP5 = register("burpsound5"),
            BURP6 = register("burpsound6"),
            BURP7 = register("burpsound7"),
            BURP8 = register("burpsound8"),
            BURP9 = register("burpsound9"),
            BURP10 = register("burpsound10"),
            BURP11 = register("burpsound11"),
            BURP12 = register("burpsound12");

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
    private static <T extends SoundEvent> DeferredHolder<SoundEvent, SoundEvent> register(String registryName) {
        DeferredHolder<SoundEvent, SoundEvent> sounds = SOUNDS.register(registryName, () -> createSoundEvent(registryName));
        return sounds;
    }

    private static SoundEvent createSoundEvent(String soundPath) {
        return SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, soundPath));
    }
}
