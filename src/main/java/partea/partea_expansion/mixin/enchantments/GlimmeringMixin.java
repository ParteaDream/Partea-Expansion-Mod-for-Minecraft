package partea.partea_expansion.mixin.enchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import partea.partea_expansion.Enchantments.EnchantmentGlimmering;

@Mixin(PiglinBrain.class)
public class GlimmeringMixin {

    @Inject(method = "wearsGoldArmor", at = @At("HEAD"), cancellable = true)
    private static void hasGlimmering(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (EnchantmentHelper.getLevel(EnchantmentGlimmering.GLIMMERING, entity.getEquippedStack(EquipmentSlot.FEET)) >= 1) {
            cir.setReturnValue(true);
        }
    }
}
