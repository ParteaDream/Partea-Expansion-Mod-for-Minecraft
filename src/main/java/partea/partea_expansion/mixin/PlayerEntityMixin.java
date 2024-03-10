package partea.partea_expansion.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import partea.partea_expansion.ModItems;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends Entity {
    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);
    public PlayerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    protected void bounceFall(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir){
        if(this.getEquippedStack(EquipmentSlot.LEGS).getItem() == ModItems.KNEE_PADS){
            cir.setReturnValue(false);
        }
    }
}
