package partea.partea_expansion.mixin.VanillaEnchantmentMixin;

import net.minecraft.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProtectionEnchantment.class)
public class ProtectionMixin {

    @Inject(method = "getMaxLevel", at = @At("HEAD"), cancellable = true)
    public void getMaxLevel(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(2);
    }
    @Inject(method = "getMinPower", at = @At("HEAD"), cancellable = true)
    public void getMinPower(int level, CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(10 + 20 * (level - 1));
    }
}
