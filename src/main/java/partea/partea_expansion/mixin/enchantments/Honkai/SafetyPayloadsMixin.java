package partea.partea_expansion.mixin.enchantments.Honkai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.EnchantCrystallyClear;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.EnchantFayu;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.EnchantSafetyPayloads;
import partea.partea_expansion.potion.EffectAbu;
import partea.partea_expansion.potion.EffectPre;
import partea.partea_expansion.util.FEUtil;

@Mixin(LivingEntity.class)
public class SafetyPayloadsMixin {
    @Inject(at = @At("HEAD"), method = "baseTick")
    public void subeutecticTrigger(CallbackInfo ci) {
        LivingEntity user = (LivingEntity) (Object) this;
        int level = FEUtil.getLevelArmor(user, EnchantSafetyPayloads.SafetyPayloads);
        if (user.hasStatusEffect(EffectPre.EffectPre)){
            level++;
        }
        if (level > 0) {
            if (user.hasStatusEffect(StatusEffects.ABSORPTION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,5,level - 1,false,false,false));
            }
        }


        //Fayu
        int level2 = FEUtil.getLevelArmor(user, EnchantFayu.Fayu);
        if (user.hasStatusEffect(EffectAbu.EffectAbu)){
            level2++;
        }
        if (level2 > 0){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20, level2,false,false,false));
        }

        //Crystally Clear
        int CrystallyClear = FEUtil.getLevelArmor(user, EnchantCrystallyClear.CrystallyClear);
        if (user.hasStatusEffect(EffectAbu.EffectAbu)){
            CrystallyClear++;
        }
        if (CrystallyClear > 0 && user.getHealth() >= user.getMaxHealth() * 0.98){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20, CrystallyClear,false,false,false));
        }
    }
}
