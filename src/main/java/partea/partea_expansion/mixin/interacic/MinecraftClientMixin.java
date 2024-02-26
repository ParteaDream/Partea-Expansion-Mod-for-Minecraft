package partea.partea_expansion.mixin.interacic;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.ParteaExpansion;
import partea.partea_expansion.ParteaExpansionClient;
import partea.partea_expansion.Plugins.interactic.util.Helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Unique
    private float dropPower = 0.9f;

    @Shadow
    @Nullable
    public Entity cameraEntity;

    @Shadow
    @Nullable
    public ClientPlayerInteractionManager interactionManager;

    @Shadow
    @Nullable
    public ClientPlayerEntity player;

    @Shadow
    @Final
    public GameOptions options;

    @Inject(method = "doItemUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isRiding()Z", shift = At.Shift.AFTER), cancellable = true)
    private void tryPickupItem(CallbackInfo ci) {
        if (!ParteaExpansion.getConfig().rightClickPickup()) return;
        if (KeyBindingHelper.getBoundKeyOf(ParteaExpansionClient.PICKUP_ITEM) != InputUtil.UNKNOWN_KEY) return;

        if (Helpers.raycastItem(cameraEntity, interactionManager.getReachDistance()) == null) return;
        ClientPlayNetworking.send(new Identifier("partea_expansion", "pickup"), PacketByteBufs.empty());
        this.player.swingHand(Hand.MAIN_HAND);
        ci.cancel();
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;dropSelectedItem(Z)Z"))
    private boolean handleDropPower(ClientPlayerEntity clientPlayerEntity, boolean dropEntireStack) {
        if (!ParteaExpansion.getConfig().itemThrowing()) return clientPlayerEntity.dropSelectedItem(dropEntireStack);

        if (!Screen.hasShiftDown()) {
            dropPower += 0.075f;
            if (dropPower > 5) dropPower = 5;
            if (dropPower >= 1.5)
                clientPlayerEntity.sendMessage(Text.of("Power: " + BigDecimal.valueOf(Math.max(dropPower, 1)).setScale(1, RoundingMode.HALF_UP)), true);
            return false;
        } else {
            return clientPlayerEntity.dropSelectedItem(dropEntireStack);
        }
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;swingHand(Lnet/minecraft/util/Hand;)V"))
    private void dontSwingArms(ClientPlayerEntity player, Hand hand) {
        if (!ParteaExpansion.getConfig().swingArm()) return;
        player.swingHand(hand);
    }

    @Inject(method = "handleInputEvents", at = @At("RETURN"))
    private void afterDrop(CallbackInfo ci) {
        if (!ParteaExpansion.getConfig().itemThrowing()) return;

        if (dropPower > 0.9f && !options.dropKey.isPressed()) {
            final var dropAll = Screen.hasControlDown();

            if (dropPower >= 1.5) {
                final var buffer = PacketByteBufs.create();
                buffer.writeFloat(dropPower);
                buffer.writeBoolean(dropAll);

                ClientPlayNetworking.send(new Identifier("partea_expansion", "drop_with_power"), buffer);

                if (!this.player.getInventory().removeStack(this.player.getInventory().selectedSlot, dropAll && !this.player.getInventory().getMainHandStack().isEmpty() ? this.player.getInventory().getMainHandStack().getCount() : 1).isEmpty()) {
                    if (ParteaExpansion.getConfig().swingArm()) this.player.swingHand(Hand.MAIN_HAND);
                }
            } else if (this.player.dropSelectedItem(dropAll)) {
                if (ParteaExpansion.getConfig().swingArm()) this.player.swingHand(Hand.MAIN_HAND);
            }

            dropPower = 0.9f;
        }
    }

}
