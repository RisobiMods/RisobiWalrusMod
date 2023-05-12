package risobiwalrus.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import risobiwalrus.RisobiWalrusMain;
import risobiwalrus.entity.custom.WalrusEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, RisobiWalrusMain.MOD_ID);


    public static final RegistryObject<EntityType<WalrusEntity>> WALRUS =
            ENTITY_TYPES.register("walrus",
                    () -> EntityType.Builder.of(WalrusEntity::new, MobCategory.CREATURE)
                            .sized(1.0f, 1.3f)
                            .build(new ResourceLocation(RisobiWalrusMain.MOD_ID, "walrus").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
