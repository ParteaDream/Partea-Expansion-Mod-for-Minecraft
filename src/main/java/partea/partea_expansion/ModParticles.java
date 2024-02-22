package partea.partea_expansion;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    //public static final DefaultParticleType DOOMED_DEATH_FLAME = FabricParticleTypes.simple();

    // Register our custom particle type in the mod initializer.

    public static void registerParticles(){
        //Registry.register(Registries.PARTICLE_TYPE, new Identifier("partea_expansion", "doomed_death_flame"), DOOMED_DEATH_FLAME);
    }
}
