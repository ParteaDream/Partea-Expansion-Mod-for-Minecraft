package partea.partea_expansion.Enchantments.HonkaiStarRail;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
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
import net.minecraft.world.GameRules;
import net.minecraft.world.event.GameEvent;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantLifeSteal;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.potion.AfterglowEffectCD;
import partea.partea_expansion.util.ModTags;

public class EnchantAfterglowEffect extends Enchantment {
    public static Enchantment Afterglow_Effect = new EnchantAfterglowEffect();

    protected EnchantAfterglowEffect() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }
    public int getMaxLevel() {
        return 2;
    }
    public boolean isTreasure(){
        return true;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
