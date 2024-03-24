package partea.partea_expansion.mixin.Mod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.ModItems;

@Mixin(LivingEntity.class)
public abstract class FoolsMaskMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    public void foolsMaskKill(DamageSource source, CallbackInfo callbackInfo) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();


        if (user != null && user.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.FOOLS_MASK) {
            ItemStack stack = user.getEquippedStack(EquipmentSlot.HEAD);
            NbtCompound nbtCompound = stack.getNbt();
            int strengthLevel = 0;
            if (nbtCompound != null) {
                strengthLevel = nbtCompound.getInt("strengthLevel");
            }else {
                nbtCompound = stack.getOrCreateNbt();
            }
            if(strengthLevel < 3){
                strengthLevel ++;
            }
            nbtCompound.putInt("strengthLevel", strengthLevel);
        }
    }
    @Inject(at = @At("HEAD"), method = "onAttacking")
    public void foolsMaskOnAttacking(Entity target, CallbackInfo ci){
        if(!(target instanceof PlayerEntity user)){
            return;
        }
        if (user.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.FOOLS_MASK) {
            user.removeStatusEffect(StatusEffects.STRENGTH);
            ItemStack stack = user.getEquippedStack(EquipmentSlot.HEAD);
            NbtCompound nbtCompound = stack.getOrCreateNbt();
            nbtCompound.putInt("strengthLevel", 0);
            stack.writeNbt(nbtCompound);
        }
    }
}
