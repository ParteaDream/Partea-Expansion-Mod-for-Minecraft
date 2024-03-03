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
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.EnchantFayu;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.EnchantYuanyin;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantBloodTherapy;
import partea.partea_expansion.util.FEUtil;

@Mixin(LivingEntity.class)
public class BloodTherapyMixin {

    @Inject(at = @At("HEAD"), method = "onDeath")
    public void bloodTherapyKill(DamageSource source, CallbackInfo callbackInfo) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        if (user != null && FEUtil.getLevel(user, EnchantBloodTherapy.BLOOD_THERAPY) > 0) {
            user.heal(FEUtil.getLevel(user, EnchantBloodTherapy.BLOOD_THERAPY) * 2f);
        }
        if (user != null && FEUtil.getLevel(user, EnchantBloodTherapy.BLOOD_THERAPY) > 0){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,100
                    , FEUtil.getLevel(user, EnchantBloodTherapy.BLOOD_THERAPY) - 1));
        }
        if (user != null && FEUtil.getLevelArmor(user, EnchantYuanyin.Yuanyin) > 0){
            user.heal(FEUtil.getLevelArmor(user, EnchantYuanyin.Yuanyin) * 2);
            if(FEUtil.getLevelArmor(user, EnchantYuanyin.Yuanyin) > 1){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,100,1));
            }
        }
    }
}
