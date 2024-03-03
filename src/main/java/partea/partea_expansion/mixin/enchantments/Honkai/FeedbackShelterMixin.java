package partea.partea_expansion.mixin.enchantments.Honkai;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantRainbowChiseledTeeth;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.EnchantFeedbackShelter;
import partea.partea_expansion.util.FEUtil;

import java.util.Map;
import java.util.Random;

@Mixin(LivingEntity.class)
public class FeedbackShelterMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    public void FeedbackShelterKill(DamageSource source, CallbackInfo callbackInfo) {
        if(!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        LivingEntity target = (LivingEntity)(Object)this;
        int level  = FEUtil.getLevel(user, EnchantFeedbackShelter.Feedback_Shelter);
        Random random = new Random();
        float chance = level * 0.03f;
        if (random.nextFloat() < chance && level > 0){
            ItemEntity goldingotdrop = new ItemEntity(target.getWorld(), target.getX(), target.getY(), target.getZ(), new ItemStack(Items.GOLD_INGOT, random.nextInt(1,level)));
            user.getWorld().spawnEntity(goldingotdrop);
        }
    }
}
