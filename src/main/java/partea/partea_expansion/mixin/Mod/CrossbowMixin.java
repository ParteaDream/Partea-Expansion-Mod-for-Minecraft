package partea.partea_expansion.mixin.Mod;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import partea.partea_expansion.Enchantments.EnchantAccurateShooting;

@Mixin(CrossbowItem.class)
public class CrossbowMixin{
    @ModifyVariable(method = "shootAll", at = @At("HEAD"), index = 5, argsOnly = true)
    private static float shootAll(float value, World world, LivingEntity entity, Hand hand, ItemStack stack, float speed, float divergence) {
        int level = EnchantmentHelper.getLevel(EnchantAccurateShooting.Accurate_Shoot, stack);
        return value * (1f - 0.9f * level);
    }
}
