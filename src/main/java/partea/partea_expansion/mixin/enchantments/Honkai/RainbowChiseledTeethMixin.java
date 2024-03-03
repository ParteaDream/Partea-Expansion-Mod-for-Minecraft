package partea.partea_expansion.mixin.enchantments.Honkai;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantRainbowChiseledTeeth;
import partea.partea_expansion.util.FEUtil;

import java.util.Map;
import java.util.Random;

@Mixin(LivingEntity.class)
public class RainbowChiseledTeethMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    public void CompensationKill(DamageSource source, CallbackInfo callbackInfo) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        Random random = new Random();
        int i = FEUtil.getLevel(user, EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth);
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth, user);
        if (i == 1 && random.nextFloat() < 0.4) {
            if (entry != null) {
                entry.getValue().setDamage(entry.getValue().getDamage() - 1);
            }
        } else if (i == 2 && random.nextFloat() < 0.6) {
            if (entry != null) {
                entry.getValue().setDamage(entry.getValue().getDamage() - 2);
            }
        }
    }
}
