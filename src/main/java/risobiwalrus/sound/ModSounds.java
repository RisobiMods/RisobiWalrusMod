package risobiwalrus.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import risobiwalrus.RisobiWalrusMain;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RisobiWalrusMain.MOD_ID);



    public static RegistryObject<SoundEvent> WALRUS_SOUND_1 = registerSoundEvent("walrus_sound_1");
    public static RegistryObject<SoundEvent> WALRUS_HURT_1 = registerSoundEvent("walrus_hurt_1");



    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(RisobiWalrusMain.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
