package partea.partea_expansion.mixin;

import com.google.common.collect.Maps;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import partea.partea_expansion.Enchantments.EnchantBlazeWalker;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.EnchantAfterglowEffect;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.potion.AfterglowEffectCD;
import partea.partea_expansion.potion.EvilLizardEffect;
import partea.partea_expansion.util.randomCurioTools;
import partea.partea_expansion.util.randomEnchantmentTools;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow public abstract float getMaxHealth();

    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    protected LivingEntityMixin(EntityType entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "baseTick")
    public void TickTok(CallbackInfo ci) {
        LivingEntity user = (LivingEntity) (Object) this;
        if ((Object)this instanceof  PlayerEntity player){
            //分裂银币触发
            boolean hasSilverCoin = false;
            ItemStack sc = null;
            int countCoins = 0;
            for(int i = 0; i < 36; i ++){
                if (player.getInventory().getStack(i).getItem() == ModItems.SILVER_COIN_OF_DISCORD){
                    hasSilverCoin = true;
                    sc = player.getInventory().getStack(i);
                } else if (player.getInventory().getStack(i).getItem() == ModItems.COIN) {
                    countCoins += player.getInventory().getStack(i).getCount();
                }
            }
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.SILVER_COIN_OF_DISCORD){
                hasSilverCoin = true;
                sc = player.getEquippedStack(EquipmentSlot.OFFHAND);
            }
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.COIN){
                hasSilverCoin = true;
                countCoins += player.getEquippedStack(EquipmentSlot.OFFHAND).getCount();
            }
            if (hasSilverCoin){
                sc.decrement(1);
                ItemEntity dropCoins = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(ModItems.COIN, countCoins/2));
                user.getWorld().spawnEntity(dropCoins);
            }
        }
    }
    @Inject(method = "onAttacking", at = @At("TAIL"))
    protected void livingAttacking(Entity target, CallbackInfo ci){
        if (target instanceof LivingEntity) {
            if(this.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.BLAZE_ROD || this.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.TORCH){
                target.setOnFireFor(5);
                ((LivingEntity) target).setHealth(((LivingEntity) target).getHealth() - 2);
            }
            if(this.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.SOUL_TORCH){
                target.setOnFireFor(8);
                ((LivingEntity) target).setHealth(((LivingEntity) target).getHealth() - 3);
            }
            if(this.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.THRILLER_MASK){
                target.setOnFireFor(8);
            }
            if (this.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == ModItems.Totem_Of_Equilibrium){
                float result = Math.min(Objects.requireNonNull(((LivingEntity) target).getAttacker()).getHealth(), ((LivingEntity) target).getHealth());
                result = Math.max(2, result);
                ((LivingEntity) target).setHealth(result);
                this.setHealth(result);
                this.getEquippedStack(EquipmentSlot.MAINHAND).decrement(1);
                ItemEntity dropTotems = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), new ItemStack(ModItems.Damaged_Totem_Of_Equilibrium, 1));
                this.getWorld().spawnEntity(dropTotems);
            }
        } else {
        }
    }
    @Inject(at = @At("HEAD"), method = "onDeath")
    public void livingDeath(DamageSource source, CallbackInfo callbackInfo) {
        LivingEntity target = (LivingEntity) (Object) this;
        Random random1 = new Random();
        if (random1.nextFloat() < 0.008){
            ItemEntity dropCurioBag = new ItemEntity(target.getWorld(), target.getX(), target.getY(), target.getZ(), new ItemStack(ModItems.Curio_Treasure_Bag, 1));
            target.getWorld().spawnEntity(dropCurioBag);
        }
        if (random1.nextFloat() < 0.08){
            ItemEntity dropCoin = new ItemEntity(target.getWorld(), target.getX(), target.getY(), target.getZ()
                    , new ItemStack(ModItems.COIN, random1.nextInt(1,3)));
            target.getWorld().spawnEntity(dropCoin);
        }

        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        //星际大乐透
        if (user != null){
            ItemStack sc = null;
            PlayerEntity player = (PlayerEntity) user;
            for (int i = 0; i < 36; i++){
                if (player.getInventory().getStack(i).getItem() == ModItems.Interastra_Big_Lotto){
                    sc = player.getInventory().getStack(i);
                    break;
                }
            }
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.Interastra_Big_Lotto){
                sc = player.getEquippedStack(EquipmentSlot.OFFHAND);
            }
            if (sc != null){
                int r = user.getRandom().nextInt(100);
                if (r <= 30){
                    ItemStack randomEnchantBook = new ItemStack(Items.ENCHANTED_BOOK,1);
                    randomEnchantBook.addEnchantment(randomEnchantmentTools.randomHonkaiEnchant_All(),1);
                    ItemEntity drop = new ItemEntity(target.getWorld(), target.getX(), target.getY(), target.getZ(), randomEnchantBook);
                    user.getWorld().spawnEntity(drop);
                } else if(r > 90){
                    user.clearStatusEffects();
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 400, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 400, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 400, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 400, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 400, 1));
                    sc.decrement(1);
                    ItemEntity dropDamagedIGL = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(ModItems.Damaged_Interastra_Big_Lotto, 1));
                    user.getWorld().spawnEntity(dropDamagedIGL);
                }
            }
        }

        //银河大乐透
        if (user != null){
            ItemStack sc = null;
            PlayerEntity player = (PlayerEntity) user;
            for (int i = 0; i < 36; i++){
                if (player.getInventory().getStack(i).getItem() == ModItems.Galaxy_Lotto){
                    sc = player.getInventory().getStack(i);
                    break;
                }
            }
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.Galaxy_Lotto){
                sc = player.getEquippedStack(EquipmentSlot.OFFHAND);
            }
            if (sc != null){
                int r = user.getRandom().nextInt(100);
                if (r <= 30){
                    ItemEntity drop = new ItemEntity(target.getWorld(), target.getX(), target.getY(), target.getZ(), new ItemStack(randomCurioTools.randomCurioButLotto(), 1));
                    user.getWorld().spawnEntity(drop);
                } else if(r > 90){
                    user.setHealth(1);
                    sc.decrement(1);
                    ItemEntity dropDamagedGL = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(ModItems.Damaged_Galaxy_Lotto, 1));
                    user.getWorld().spawnEntity(dropDamagedGL);
                }
            }
        }
        //俱乐部券
        if (user != null){
            ItemStack sc = null;
            PlayerEntity player = (PlayerEntity) user;
            for (int i = 0; i < 36; i++){
                if (player.getInventory().getStack(i).getItem() == ModItems.SOCIETY_TICKET){
                    sc = player.getInventory().getStack(i);
                    break;
                }
            }
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.SOCIETY_TICKET){
                sc = player.getEquippedStack(EquipmentSlot.OFFHAND);
            }
            if (sc != null){
                if (random1.nextFloat() < 0.1){
                    ItemEntity dropCoin = new ItemEntity(target.getWorld(), target.getX(), target.getY(), target.getZ()
                            , new ItemStack(ModItems.COIN, random1.nextInt(0,4)));
                    target.getWorld().spawnEntity(dropCoin);
                }
            }
        }
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
        int level = EnchantmentHelper.getEquipmentLevel(EnchantAfterglowEffect.Afterglow_Effect,user);
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY) && user instanceof ServerPlayerEntity) {
            cir.setReturnValue(false);
        } else if (user instanceof ServerPlayerEntity serverPlayerEntity && (user.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == ModItems.TOTEM_OF_VOID
                || user.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.TOTEM_OF_VOID)) {
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(Items.TOTEM_OF_UNDYING));
            user.setHealth(4.0F);
            user.clearStatusEffects();
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
            user.getWorld().sendEntityStatus(user, (byte)35);
            if (user.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == ModItems.TOTEM_OF_VOID){
                user.getEquippedStack(EquipmentSlot.MAINHAND).decrement(1);
            } else if (user.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.TOTEM_OF_VOID) {
                user.getEquippedStack(EquipmentSlot.OFFHAND).decrement(1);
            }
            cir.setReturnValue(true);
        } else if(level > 0 && user instanceof ServerPlayerEntity serverPlayerEntity && !user.hasStatusEffect(AfterglowEffectCD.AfterglowEffectCDEffect)){
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(Items.TOTEM_OF_UNDYING));
            if (level == 1){
                user.setHealth(1.0F);
                user.clearStatusEffects();
                user.addStatusEffect(new StatusEffectInstance(AfterglowEffectCD.AfterglowEffectCDEffect, 6000, 0,false,false,false));
                user.getWorld().sendEntityStatus(user, (byte) 35);
            }else if(level == 2){
                user.setHealth(1.0F);
                user.clearStatusEffects();
                user.addStatusEffect(new StatusEffectInstance(AfterglowEffectCD.AfterglowEffectCDEffect,3600,0,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0,false,false,false));
                user.getWorld().sendEntityStatus(user, (byte)35);
            }
            cir.setReturnValue(true);
        }   else if(user instanceof ServerPlayerEntity serverPlayerEntity && user.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.Laurel_Crown_Of_Planar_Shifts){
            if(user.getAttacker() != null){
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(Items.TOTEM_OF_UNDYING));
                user.setHealth(user.getMaxHealth());
                user.clearStatusEffects();
                user.getWorld().sendEntityStatus(user, (byte)35);
                user.getAttacker().setHealth(0);
                user.getEquippedStack(EquipmentSlot.HEAD).decrement(1);
            } else {
                user.setHealth(2.0F);
                user.clearStatusEffects();
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 2,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 2,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0,false,false,false));
                user.getEquippedStack(EquipmentSlot.HEAD).decrement(1);
                ItemEntity drop = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(ModItems.Damaged_Laurel_Crown_Of_Planar_Shifts, 1));
                user.getWorld().spawnEntity(drop);
                user.getWorld().sendEntityStatus(user, (byte)35);
            }
            cir.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "drop", cancellable = true)
    public void dropModify(DamageSource source, CallbackInfo ci){
        Entity attacker = source.getAttacker();
        if (attacker instanceof PlayerEntity player){
            boolean hasGossip = false;
            for (int i = 0; i < 36; i++){
                if (player.getInventory().getStack(i).getItem() == ModItems.Typical_Genius_Society_Gossip){
                    hasGossip = true;
                }
                if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ModItems.Typical_Genius_Society_Gossip){
                    hasGossip = true;
                }

            }
            if (hasGossip){
                Random random = new Random();
                if (random.nextFloat() < 0.8){
                    ItemEntity dropCoins = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), new ItemStack(ModItems.COIN, random.nextInt(0,3)));
                    this.getWorld().spawnEntity(dropCoins);
                }
                ci.cancel();
            }
        }
    }
    @Inject(method = "jump", at = @At("HEAD"))
    public void jump(CallbackInfo ci){
        if (this.hasStatusEffect(EvilLizardEffect.EvilLizardEffect)){
            Vec3d vec3d = this.getVelocity();
            this.setVelocity(vec3d.x * 2, (double)this.getJumpVelocity(), vec3d.z);
            if (this.isSprinting()) {
                float f = this.getYaw() * 0.017453292F;
                this.setVelocity(this.getVelocity().add((double)(-MathHelper.sin(f) * 0.2F), 0.0, (double)(MathHelper.cos(f) * 0.2F)));
            }

            this.velocityDirty = true;
        }
    }
    @Unique
    protected float getJumpVelocity() {
        return 0.42F * this.getJumpVelocityMultiplier() + this.getJumpBoostVelocityModifier();
    }
    @Unique
    public float getJumpBoostVelocityModifier() {
        return this.hasStatusEffect(StatusEffects.JUMP_BOOST) ? 0.1F * ((float) Objects.requireNonNull(this.getStatusEffect(StatusEffects.JUMP_BOOST)).getAmplifier() + 1.0F) : 0.0F;
    }
    @Unique
    @Nullable
    public StatusEffectInstance getStatusEffect(StatusEffect effect) {
        return (StatusEffectInstance)this.activeStatusEffects.get(effect);
    }
    @Unique
    private final Map<StatusEffect, StatusEffectInstance> activeStatusEffects = Maps.newHashMap();
}