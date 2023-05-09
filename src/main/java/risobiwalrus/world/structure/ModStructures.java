package risobiwalrus.world.structure;

import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import risobiwalrus.RisobiWalrusMain;

public class ModStructures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, RisobiWalrusMain.MOD_ID);


    public static final RegistryObject<StructureFeature<?>> SKY_STRUCTURES = DEFERRED_REGISTRY_STRUCTURE.register("sky_structures", SkyStructures::new);

    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }
}