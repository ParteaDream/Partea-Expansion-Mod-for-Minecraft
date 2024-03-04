package partea.partea_expansion.mixin.VanillaEnchantmentMixin;

import net.minecraft.enchantment.DamageEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageEnchantment.class)
public class SharpnessMixin {

    @Inject(method = "getMaxLevel", at = @At(value = "HEAD"), cancellable = true)
    public void getMaxLevel(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(5);
    }

    @Inject(method = "getMinPower", at = @At("HEAD"), cancellable = true)
    public void getMinPower(int level, CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(5 + (level - 1) * 8);
    }
}
