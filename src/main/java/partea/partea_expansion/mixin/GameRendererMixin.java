package partea.partea_expansion.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import partea.partea_expansion.ParteaExpansion;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final private MinecraftClient client;
    @Unique
    @Final private MinecraftClient minecraft;
    private double multiplier = 1.0F;
    private double lastMultiplier = 1.0F;
    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        double zoomMultiplier = ParteaExpansion.zoom ? 0.1F : 1.0F;
        if (!this.client.options.getPerspective().isFirstPerson()) zoomMultiplier = 1.0F;
        lastMultiplier = multiplier;
        multiplier += (zoomMultiplier - multiplier) * 0.66F;
    }
    @Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
    private void getFov(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir) {
        double fov = cir.getReturnValue();
        double fovMultiplier = MathHelper.lerp(tickDelta, lastMultiplier, multiplier);
        double zoomedFov = fov * fovMultiplier;
        if (Math.abs(fov-zoomedFov) > 0.5)
            cir.setReturnValue(zoomedFov);
    }
}
