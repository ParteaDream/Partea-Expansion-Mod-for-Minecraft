package partea.partea_expansion.mixin.interacic;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import partea.partea_expansion.ParteaExpansion;
import partea.partea_expansion.Plugins.interactic.util.InteracticItemExtensions;
import partea.partea_expansion.Plugins.interactic.util.InteracticPlayerExtension;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements InteracticPlayerExtension {

    @Unique
    private float dropPower = 1;

    @Override
    public void setDropPower(float power) {
        this.dropPower = power;
    }

    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;setVelocity(DDD)V", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD)
    private void applyDropPower(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir, double d, ItemEntity item) {
        if (!ParteaExpansion.getConfig().itemThrowing()) return;

        if (this.dropPower > 1) {
            var velocity = ((PlayerEntity)(Object)this).getRotationVec(0f).multiply(this.dropPower * .35f);
            item.setVelocity(velocity);
            item.velocityDirty = true;

            item.updatePosition(item.getX(), ((PlayerEntity) (Object) this).getEyeY(), item.getZ());

            if (retainOwnership) {
                ((InteracticItemExtensions) item).markThrown();
                if (this.dropPower >= 5) ((InteracticItemExtensions) item).markFullPower();
            }

            this.dropPower = 1;
        }
    }
}
