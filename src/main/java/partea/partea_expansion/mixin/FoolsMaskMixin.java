package partea.partea_expansion.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class FoolsMaskMixin {
    @Unique
    private static int strengthLevel = 0;
    @Inject(at = @At("HEAD"), method = "onDeath")
    public void foolsMaskKill(DamageSource source, CallbackInfo callbackInfo) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        if (user != null && Objects.equals(user.getEquippedStack(EquipmentSlot.HEAD).getItem().getName(), Text.translatable("item.partea_expansion.fools_mask"))) {
            if (strengthLevel == 0){
                strengthLevel = 1;
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,114514,0,false,false,false));
            }else if(strengthLevel == 1){
                strengthLevel = 2;
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,114514,1,false,false,false));
            }else if(strengthLevel == 2){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,114514,2,false,false,false));
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "onAttacking")
    public void foolsMaskOnAttacking(Entity target, CallbackInfo ci){
        LivingEntity user = (LivingEntity) target;
        if (user != null && Objects.equals(user.getEquippedStack(EquipmentSlot.HEAD).getItem().getName(), Text.translatable("item.partea_expansion.fools_mask"))) {
            user.removeStatusEffect(StatusEffects.SPEED);
            user.removeStatusEffect(StatusEffects.STRENGTH);
            strengthLevel = 0;
        }
    }
}
