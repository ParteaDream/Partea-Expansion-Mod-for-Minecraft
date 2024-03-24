package partea.partea_expansion.mixin.client;

import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import partea.partea_expansion.CustomItems.ToolItems.SniperCrossbowSeries;
import partea.partea_expansion.Enchantments.EnchantDualLeap;
import partea.partea_expansion.ParteaExpansion;
import partea.partea_expansion.potion.EvilLizardEffect;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Shadow public Input input;
    @Unique
    private int jumpCount = 0;
    @Unique
    private boolean jumpedLastTick = false;

    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void tickMovement(CallbackInfo info) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        // Dual Leap
        if (player.isOnGround() || player.isClimbing()) {
            jumpCount = EnchantmentHelper.getEquipmentLevel(EnchantDualLeap.DUAL_LEAP, player);
            if(player.hasStatusEffect(EvilLizardEffect.EvilLizardEffect)){
                jumpCount = 8;
            }
        } else if (!jumpedLastTick && jumpCount > 0 && player.getVelocity().y < 0) {
            if (player.input.jumping && canJump(player)) {
                jumpCount--;
                player.jump();
            }
        }
        jumpedLastTick = player.input.jumping;
    }

    @Unique
    private boolean canJump(ClientPlayerEntity player) {
        ItemStack chestItemStack = player.getEquippedStack(EquipmentSlot.CHEST);
        boolean wearingUsableElytra = chestItemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(chestItemStack);

        return !wearingUsableElytra && !player.isFallFlying() && !player.hasVehicle()
                && !player.isTouchingWater() && !player.hasStatusEffect(StatusEffects.LEVITATION)
                && !player.getAbilities().creativeMode && !player.getAbilities().flying;
    }
    @Inject(method = "isSneaking", at = @At("HEAD"))
    private void checkSneakZoom(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (!player.getWorld().isClient()) return;
        ItemStack stack = player.getEquippedStack(EquipmentSlot.MAINHAND);
        if (stack.getItem() instanceof SniperCrossbowSeries) {
            boolean sneaking = player.isInSneakingPose();
            if (sneaking && !ParteaExpansion.zoom) {
                player.playSound(SoundEvents.ITEM_SPYGLASS_USE, 1.0F, 1.0F);
                ParteaExpansion.zoom = true;
            } else if (!sneaking && ParteaExpansion.zoom) {
                player.playSound(SoundEvents.ITEM_SPYGLASS_STOP_USING, 1.0F, 1.0F);
                ParteaExpansion.zoom = false;
            }
        } else {
            ParteaExpansion.zoom = false;
        }
    }
}
