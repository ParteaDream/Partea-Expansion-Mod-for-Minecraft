package partea.partea_expansion.mixin;

import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import partea.partea_expansion.ParteaExpansion;

@Mixin(Mouse.class)
public class MouseMixin {
    @Redirect(method = "updateMouse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingSpyglass()Z"))
    private boolean slowCamera(ClientPlayerEntity clientPlayerEntity) {
        return ParteaExpansion.zoom || clientPlayerEntity.isUsingSpyglass();
    }
}
