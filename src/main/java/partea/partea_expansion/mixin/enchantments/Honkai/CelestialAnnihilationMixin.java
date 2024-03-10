package partea.partea_expansion.mixin.enchantments.Honkai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantCelestialAnnihilation;
import partea.partea_expansion.util.FEUtil;

import java.util.Random;

@Mixin(LivingEntity.class)
public class CelestialAnnihilationMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    public void CelestialAnnihilationKill(DamageSource source, CallbackInfo callbackInfo) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        LivingEntity target = (LivingEntity)(Object)this;
        int level  = FEUtil.getLevelArmor(user, EnchantCelestialAnnihilation.Celestial_Annihilation);
        Random random = new Random();
        float chance = level * 0.3f + 0.2f;
        if(random.nextFloat() < chance && level > 0){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, level));
        }
    }
}
