package nicusha.farts.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nicusha.farts.Farts;

import java.util.ArrayList;
import java.util.List;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, Farts.MODID);

    private static final List<DeferredHolder<SoundEvent, SoundEvent>> FARTS_HOLDERS = new ArrayList<>();
    private static final List<DeferredHolder<SoundEvent, SoundEvent>> BURP_HOLDERS = new ArrayList<>();

    static {
        for (int i = 1; i <= 36; i++) {
            FARTS_HOLDERS.add(register("fartsound" + i));
        }
        for (int i = 1; i <= 12; i++) {
            BURP_HOLDERS.add(register("burpsound" + i));
        }
    }

    public static List<SoundEvent> getFartList() {
        return FARTS_HOLDERS.stream().map(DeferredHolder::get).toList();
    }

    public static List<SoundEvent> getBurpList() {
        return BURP_HOLDERS.stream().map(DeferredHolder::get).toList();
    }

    private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(Farts.MODID, name)));
    }
}