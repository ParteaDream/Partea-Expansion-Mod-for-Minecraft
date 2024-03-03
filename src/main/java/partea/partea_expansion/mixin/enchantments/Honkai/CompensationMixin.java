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
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.EnchantCompensation;
import partea.partea_expansion.util.FEUtil;

import java.util.Random;

@Mixin(LivingEntity.class)
public class CompensationMixin {

    @Inject(at = @At("HEAD"), method = "onDeath")
    public void CompensationKill(DamageSource source, CallbackInfo callbackInfo) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        Random random = new Random();
        int i = FEUtil.getLevelArmor(user, EnchantCompensation.CONSTRUSTION_COMPENSATION);
        if (i == 1 && random.nextFloat() < 0.8) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 0));
        } else if (i == 2) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 1));
        }
    }
}