package partea.partea_expansion.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent SHED_A_LIGHT = registerSoundEvents("shed_a_light");
    public static final SoundEvent SILENT_TIME = registerSoundEvents("silent_time");
    public static final SoundEvent BLURP = registerSoundEvents("blurp");
    public static final SoundEvent ELATION = registerSoundEvents("elation");

    public static SoundEvent registerSoundEvents(String name){
        Identifier identifier = new Identifier("partea_expansion", name);
        return Registry.register(Registries.SOUND_EVENT,identifier,SoundEvent.of(identifier));
    }
    public static void registerSounds(){

    }
}
