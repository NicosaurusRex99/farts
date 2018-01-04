package naturix.farts.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import naturix.farts.FartsMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoundHandlerFart {
	
	public static SoundEvent fart_1;
	public static SoundEvent fart_2;

	
	public static void register()
	{
		fart_1 = registerSound("farts:fartsound1");
		fart_2 = registerSound("farts:fartsound2");

	}
	
	public static SoundEvent getRandomFart(Random rand) 
	{
		int num = rand.nextInt(3);
		switch(num)
		{
		case 1:
			return fart_2;
		default:
			return fart_1;
		}
	}
	
	private static SoundEvent registerSound(String soundNameIn)
    {
		ResourceLocation resource = new ResourceLocation(soundNameIn);
		SoundEvent sound = new SoundEvent(resource).setRegistryName(soundNameIn);
		RegistrationHandler.SOUNDS.add(sound);
        return sound;
    }

	@Mod.EventBusSubscriber(modid = FartsMod.MODID)
	public static class RegistrationHandler
	{
		public static final List<SoundEvent> SOUNDS = new LinkedList<>();

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<SoundEvent> event)
		{
			register();
			SOUNDS.stream().forEach(sound -> event.getRegistry().register(sound));
		}
	}
}