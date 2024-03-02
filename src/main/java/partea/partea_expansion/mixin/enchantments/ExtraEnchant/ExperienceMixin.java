package partea.partea_expansion.mixin.enchantments.ExtraEnchant;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantExperience;
import partea.partea_expansion.util.FEUtil;

@Mixin(LivingEntity.class)
public abstract class ExperienceMixin extends Entity {

    @Shadow
    public abstract int getXpToDrop();

    protected ExperienceMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "onDeath")
    private void experienceKill(DamageSource source, CallbackInfo ci) {
        if (source.getAttacker() instanceof PlayerEntity player && this.getXpToDrop() > 0) {
            if (FEUtil.hasEnchantment(player, EnchantExperience.EXPERIENCE)) {
                int level = FEUtil.getLevel(player, EnchantExperience.EXPERIENCE);
                player.addExperience(level * 8);
            }
        }
    }
}
