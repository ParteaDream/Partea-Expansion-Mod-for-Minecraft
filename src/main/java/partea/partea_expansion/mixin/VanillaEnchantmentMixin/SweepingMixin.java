package partea.partea_expansion.mixin.VanillaEnchantmentMixin;

import net.minecraft.enchantment.SweepingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SweepingEnchantment.class)
public class SweepingMixin {
    @Inject(method = "getMaxLevel", at = @At("HEAD"), cancellable = true)
    public void getMaxLevel(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(6);
    }
    @Inject(method = "getMinPower", at = @At("HEAD"), cancellable = true)
    public void getMinPower(int level, CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(7 + (level - 1) * 12);
    }
}
