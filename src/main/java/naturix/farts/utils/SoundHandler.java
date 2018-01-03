package naturix.farts.utils;


import java.util.Random;

import naturix.farts.FartsMod;
import net.minecraft.init.Bootstrap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.RegistryNamespaced;

public class SoundHandler {

public static SoundEvent fartsound;
public static SoundEvent fartsound2;
public static final RegistryNamespaced<ResourceLocation, SoundEvent> REGISTRY = net.minecraftforge.registries.GameData.getWrapper(SoundEvent.class);
private static int soundEventId;
private static int size = 0;

public static void init() {
	size = SoundEvent.REGISTRY.getKeys().size();

	fartsound = register("Fart", "sounds.fartsound");
	fartsound2 = register("farts", "sounds.fartsound2");
	
}

private static SoundEvent register(String string, String string2) {

	return null;
}

private static SoundEvent getRegisteredSoundEvent(String id)
{
    SoundEvent soundevent = SoundEvent.REGISTRY.getObject(new ResourceLocation(id));

    if (soundevent == null)
    {
        throw new IllegalStateException("Invalid Sound requested: " + id);
    }
    else
    {
        return soundevent;
    }
}

static
{
    if (!Bootstrap.isRegistered())
    {
        throw new RuntimeException("Accessed Sounds before Bootstrap!");
    }
    else
    {
        fartsound = getRegisteredSoundEvent("sounds.fartsounds");
    }}}