package risobiwalrus;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import risobiwalrus.entity.ModEntityTypes;
import risobiwalrus.entity.client.WalrusRenderer;
import risobiwalrus.entity.custom.WalrusEntity;
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

        ModEntityTypes.register(eventBus);

        ModStructures.register(eventBus);

        GeckoLib.initialize();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            SpawnPlacements.register(ModEntityTypes.WALRUS.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    WalrusEntity::checkWalrusSpawnRules);
        });

    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    private void clientSetup(final FMLClientSetupEvent event) {

        EntityRenderers.register(ModEntityTypes.WALRUS.get(), WalrusRenderer::new);
    }
}
