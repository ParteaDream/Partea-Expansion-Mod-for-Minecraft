package partea.partea_expansion.mixin.enchantments;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.EnchantSafetyPayloads;
import partea.partea_expansion.util.FEUtil;

@Mixin(LivingEntity.class)
public class SafetyPayloadsMixin {
    @Inject(at = @At("HEAD"), method = "baseTick")
    public void subeutecticTrigger(CallbackInfo ci) {
        LivingEntity user = (LivingEntity) (Object) this;
        int level = FEUtil.getLevelArmor(user, EnchantSafetyPayloads.SafetyPayloads);
        if (level > 0) {
            if (user.hasStatusEffect(StatusEffects.ABSORPTION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,5,level - 1));
            }
        }
    }
}
