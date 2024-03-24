package partea.partea_expansion.CustomItems.CurioItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TotemOfVoidItem extends ClassCurioItem {

    public TotemOfVoidItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.totem_of_void.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.getDimensionKey() == DimensionTypes.THE_END && user.getVelocity().getY() < -1.6){
            user.teleport(0.5,80,0.5);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,400,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,100,0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,400,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,1200,0));
            itemStack.decrement(1);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack);
        } else if (world.getDimensionKey() == DimensionTypes.OVERWORLD && user.getPos().getY() < -64) {
            user.teleport(user.getX(),320,user.getZ());
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,400,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,800,0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,400,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,1200,0));
            itemStack.decrement(1);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack);
        }else if (world.getDimensionKey() == DimensionTypes.THE_NETHER && user.getPos().getY() < 0) {
            user.teleport(user.getX(),64,user.getZ());
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,400,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,800,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,400,1));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,1200,0));
            itemStack.decrement(1);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack);
        }
        return TypedActionResult.consume(itemStack);
    }
}
