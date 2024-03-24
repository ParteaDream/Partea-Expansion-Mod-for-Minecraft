package partea.partea_expansion.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import partea.partea_expansion.ParteaExpansion;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingSpyglass()Z"))
    private boolean spyglassOverlay(ClientPlayerEntity clientPlayerEntity) {
        return ParteaExpansion.zoom || clientPlayerEntity.isUsingSpyglass();
    }
}
