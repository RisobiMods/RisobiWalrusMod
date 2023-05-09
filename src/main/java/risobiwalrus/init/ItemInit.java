package risobiwalrus.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import risobiwalrus.RisobiWalrusMain;
import risobiwalrus.item.WalkingCaneItem;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RisobiWalrusMain.MOD_ID);

    public static final RegistryObject<WalkingCaneItem> WALKING_CANE = ITEMS.register("walking_cane",
            () -> new WalkingCaneItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
