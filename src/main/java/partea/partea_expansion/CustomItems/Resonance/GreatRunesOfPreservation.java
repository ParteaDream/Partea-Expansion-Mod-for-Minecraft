package partea.partea_expansion.CustomItems.Resonance;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.potion.EffectPre;
import partea.partea_expansion.sounds.ModSounds;

import java.util.List;

public class GreatRunesOfPreservation extends ClassRunes {

    public GreatRunesOfPreservation(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.great_runes_of_preservation.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            float f = getPullProgress(i);
            if (!((double)f < 0.1) && !user.isSneaking()) {
                if (!world.isClient) {
                    if (f == 1.0F) {
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,1200, 5));
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,120, 4));
                        user.addStatusEffect(new StatusEffectInstance(EffectPre.EffectPre,800, 0));
                        stack.decrement(1);
                        world.playSound(null, user.getBlockPos(), ModSounds.RUNE, SoundCategory.PLAYERS, 1.0f, 1f);
                    }
                }
            }
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
    }
}
