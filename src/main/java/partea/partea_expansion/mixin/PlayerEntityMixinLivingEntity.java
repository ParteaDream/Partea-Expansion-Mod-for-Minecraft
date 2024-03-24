package partea.partea_expansion.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance.EnchantSensitivity;
import partea.partea_expansion.util.FEUtil;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixinLivingEntity extends LivingEntity {
    protected PlayerEntityMixinLivingEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Override
    public void onAttacking(Entity target) {
        PlayerEntity player = (PlayerEntity) (Object)this;
        int level = FEUtil.getLevelArmor(this,EnchantSensitivity.Sensitivity);
        if (target instanceof LivingEntity T && level > 0){
            T.setHealth(T.getHealth() - Math.min(player.experienceLevel, 40) * 0.3f);
        }
    }
}
