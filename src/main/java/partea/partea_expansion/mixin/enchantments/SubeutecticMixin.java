package partea.partea_expansion.mixin.enchantments;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.EnchantSubeutectic;
import partea.partea_expansion.util.FEUtil;

@Mixin(LivingEntity.class)
public class SubeutecticMixin {
    @Inject(at = @At("HEAD"), method = "baseTick")
    public void subeutecticTrigger(CallbackInfo ci) {
        LivingEntity user = (LivingEntity) (Object) this;
        int level = FEUtil.getLevelArmor(user,EnchantSubeutectic.Subeutectic);
        if (level > 0) {
            if (user.hasStatusEffect(StatusEffects.ABSORPTION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,5,0));
                if (level == 2){
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,5,0));
                }
            }
        }
    }
}
