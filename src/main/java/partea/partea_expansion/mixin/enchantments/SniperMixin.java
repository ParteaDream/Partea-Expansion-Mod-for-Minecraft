package partea.partea_expansion.mixin.enchantments;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.EnchantSniper;
import partea.partea_expansion.util.FEUtil;

@Mixin(PersistentProjectileEntity.class)
public class SniperMixin {

    @Inject(method = "onEntityHit", at = @At("TAIL"))
    private void sniperHit(EntityHitResult entityHitResult, CallbackInfo ci){
        if (!(entityHitResult.getEntity() instanceof LivingEntity)) {
            return;
        }
        PersistentProjectileEntity persistentProjectileEntity = (PersistentProjectileEntity) (Object) this;
        Entity target = entityHitResult.getEntity();
        LivingEntity attacker = (LivingEntity) persistentProjectileEntity.getOwner();

        if (attacker != null && FEUtil.hasEnchantment(attacker, EnchantSniper.SNIPER)) {
            int level = FEUtil.getLevel(attacker, EnchantSniper.SNIPER);
            double startDamage = persistentProjectileEntity.getDamage();
            double modifier = 1;
            if (level == 1) {
                modifier = 1.3D;
            } else if (level == 2) {
                modifier = 1.6D;
            } else if (level > 2) {
                // In case you have a mod that makes the enchantment levels higher
                modifier = 1.8D;
            }
            double distance = attacker.squaredDistanceTo(target);
            if (distance >= 40 && distance <= 60) {
                persistentProjectileEntity.setDamage(startDamage * modifier);
            } else if (distance > 60) {
                persistentProjectileEntity.setDamage(startDamage * modifier + 0.5D);
            }
        }
    }
}
