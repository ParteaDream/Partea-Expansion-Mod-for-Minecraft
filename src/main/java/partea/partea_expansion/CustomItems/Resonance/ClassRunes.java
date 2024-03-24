package partea.partea_expansion.CustomItems.Resonance;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import partea.partea_expansion.sounds.ModSounds;

public class ClassRunes extends Item {
    public ClassRunes(Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.RUNEPRE, SoundCategory.PLAYERS, 5.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F * 0.5F);
        return TypedActionResult.consume(itemStack);
    }
    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.00F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
    public int getMaxUseTime(ItemStack stack) {
        return 2000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
}
