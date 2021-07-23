package naturix;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static boolean fartFertilize;

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig configEvent) {
        if (configEvent.getSpec() == Config.CLIENT_SPEC) {
            bakeConfig();
        }
    }

    public static void bakeConfig() {
        fartFertilize = CLIENT.fartFertilize.get();
    }

    public static class ClientConfig {

        public final ForgeConfigSpec.BooleanValue fartFertilize;

        public ClientConfig(ForgeConfigSpec.Builder builder) {
            fartFertilize = builder
                    .comment("if false farts wont fertilize crops")
                    .translation(Main.MODID + ".config." + "fartFertilize")
                    .define("fartFertilize", true);

            builder.push("category");
            builder.pop();
        }

    }

}