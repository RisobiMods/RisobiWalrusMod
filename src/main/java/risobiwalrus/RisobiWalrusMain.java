package risobiwalrus;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import risobiwalrus.init.ItemInit;
import risobiwalrus.world.structure.ModStructures;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;


@Mod(RisobiWalrusMain.MOD_ID)
public class RisobiWalrusMain {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "risobiwalrus";

    public RisobiWalrusMain() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
         modEventBus.addListener(this::setup);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        ItemInit.register(eventBus);

        ModStructures.register(eventBus);

        //GeckoLib.initialize();

        eventBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
}
