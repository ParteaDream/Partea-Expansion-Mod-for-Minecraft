package partea.partea_expansion.mixin.enchantments;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantSoulSeeker;
import partea.partea_expansion.util.FEUtil;
import partea.partea_expansion.util.ModTags;

@Mixin(PersistentProjectileEntity.class)
public class SoulSeekerMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void tickSoulSeeker(CallbackInfo ci) {
        PersistentProjectileEntity projectile = (PersistentProjectileEntity) (Object) this;
    if (projectile.getOwner() instanceof LivingEntity owner && FEUtil.hasEnchantment(owner, EnchantSoulSeeker.SOUL_SEEKER)
            && (owner.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.CROSSBOW || owner.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == Items.CROSSBOW)) {
            if (projectile.isAlive() && !projectile.isOnGround() && !(projectile instanceof TridentEntity)) {
                Box box = projectile.getBoundingBox().expand(15);
                LivingEntity target = projectile.getWorld().getClosestEntity(LivingEntity.class, TargetPredicate.DEFAULT, null, projectile.getX(), projectile.getY(), projectile.getZ(), box);
                if (target != null && target.isAlive() && !target.isSpectator() && !(target == owner)) {
                    if (projectile.age >= 5) {
                        double x = target.getX() - projectile.getX();
                        double y = target.getEyeY() - projectile.getY();
                        double z = target.getZ() - projectile.getZ();
                        projectile.setVelocity(x, y, z, (float) projectile.getVelocity().length(), 0);
                    }
                }
            }
        }
    }
}
