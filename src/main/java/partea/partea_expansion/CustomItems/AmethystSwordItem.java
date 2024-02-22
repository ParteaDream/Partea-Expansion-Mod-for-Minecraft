package partea.partea_expansion.CustomItems;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmethystSwordItem extends SwordItem {

    public AmethystSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity player = (PlayerEntity)attacker;
        World world = attacker.getWorld();
        DamageSource damageSource = world.getDamageSources().create(DamageTypes.MOB_ATTACK);
        int MaxLeft = stack.getDamage();
        System.out.println(MaxLeft);
        target.damage(damageSource, 5 + MaxLeft);
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.amethyst_sword.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
