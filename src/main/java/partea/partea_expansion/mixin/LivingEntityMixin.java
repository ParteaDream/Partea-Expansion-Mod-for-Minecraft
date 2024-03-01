package partea.partea_expansion.mixin;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import partea.partea_expansion.Enchantments.EnchantBlazeWalker;
import partea.partea_expansion.Enchantments.HonkaiStarRail.EnchantAfterglowEffect;
import partea.partea_expansion.potion.AfterglowEffectCD;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    protected LivingEntityMixin(EntityType entityType, World world) {
        super(entityType, world);
    }
    @Inject(method = "applyMovementEffects", at = @At("HEAD"))
    protected void applyMovementEffects(BlockPos pos, CallbackInfo ci) {
        LivingEntity currentEntity = (LivingEntity) (Object) this;

        // Blaze Walker
        int blazeWalkerLevel = EnchantmentHelper.getEquipmentLevel(EnchantBlazeWalker.BLAZE_WALKER, currentEntity);
        if (blazeWalkerLevel > 0) {
            EnchantBlazeWalker.freezeLava(currentEntity, this.getWorld(), pos, blazeWalkerLevel);
        }
    }

    @Inject(method = "tryUseTotem", at = @At("HEAD"), cancellable = true)
    protected void tryAfterglowEffect(DamageSource source, CallbackInfoReturnable<Boolean> cir){
        LivingEntity user = (LivingEntity) (Object)this;
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && user instanceof ServerPlayerEntity) {
            cir.setReturnValue(false);
        } else {
            if (user instanceof ServerPlayerEntity serverPlayerEntity && !user.hasStatusEffect(AfterglowEffectCD.AfterglowEffectCDEffect)) {
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(Items.TOTEM_OF_UNDYING));
                int level = EnchantmentHelper.getEquipmentLevel(EnchantAfterglowEffect.Afterglow_Effect,user);
                if (level == 1){
                    user.setHealth(1.0F);
                    user.clearStatusEffects();
                    user.addStatusEffect(new StatusEffectInstance(AfterglowEffectCD.AfterglowEffectCDEffect, 6000, 0));
                    user.getWorld().sendEntityStatus(user, (byte) 35);
                }else if(level == 2){
                    user.setHealth(1.0F);
                    user.clearStatusEffects();
                    user.addStatusEffect(new StatusEffectInstance(AfterglowEffectCD.AfterglowEffectCDEffect,3600,0));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0));
                    user.getWorld().sendEntityStatus(user, (byte)35);
                }
                cir.setReturnValue(true);
            }
        }
    }
}