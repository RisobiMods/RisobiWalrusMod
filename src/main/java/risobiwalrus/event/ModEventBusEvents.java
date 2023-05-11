package risobiwalrus.event;


import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import risobiwalrus.RisobiWalrusMain;
import risobiwalrus.entity.ModEntityTypes;
import risobiwalrus.entity.custom.WalrusEntity;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = RisobiWalrusMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

//    @SubscribeEvent
//    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
//                                                           event) {
//        event.getRegistry().registerAll(
//                new CucumberSeedsFromGrassAdditionModifier.Serializer().setRegistryName
//                        (new ResourceLocation(TutorialMod.MOD_ID,"cucumber_seeds_from_grass")),
//                new DowsingRodInIglooAdditionModifier.Serializer().setRegistryName
//                        (new ResourceLocation(TutorialMod.MOD_ID,"dowsing_rod_in_igloo")),
//                new CoalCokeFromCreeperAdditionModifier.Serializer().setRegistryName
//                        (new ResourceLocation(TutorialMod.MOD_ID,"coal_coke_from_creeper"))
//        );
//    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.WALRUS.get(), WalrusEntity.setAttributes());
    }
}
