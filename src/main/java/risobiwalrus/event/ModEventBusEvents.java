package risobiwalrus.event;


import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import risobiwalrus.RisobiWalrusMain;
import risobiwalrus.entity.ModEntityTypes;
import risobiwalrus.entity.custom.WalrusEntity;

import javax.annotation.Nonnull;

//this isnt really needed
@Mod.EventBusSubscriber(modid = RisobiWalrusMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.WALRUS.get(), WalrusEntity.setAttributes());
    }
}
