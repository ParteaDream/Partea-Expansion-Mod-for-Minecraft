package partea.partea_expansion.mixin.enchantments.ExtraEnchant;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import partea.partea_expansion.Enchantments.EnchantAutoSmelt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(Block.class)
public class AutoSmeltMixin {
    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> items = new ArrayList<>();
        List<ItemStack> returnValue = cir.getReturnValue();
        if (EnchantmentHelper.getLevel(EnchantAutoSmelt.Auto_Smelt, stack) > 0) {
            for (ItemStack itemStack : returnValue) {
                Optional<RecipeEntry<SmeltingRecipe>> recipe = world.getRecipeManager().listAllOfType(RecipeType.SMELTING).stream().filter((smeltingRecipe -> {
                    return smeltingRecipe.value().getIngredients().get(0).test(itemStack);
                })).findFirst();
                if (recipe.isPresent()) {
                    ItemStack smelted = recipe.get().value().getResult(null).copy();
                    smelted.setCount(itemStack.getCount());
                    items.add(smelted);
                } else {
                    items.add(itemStack);
                }
            }
            cir.setReturnValue(items);
        }
    }
}
