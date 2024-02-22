package partea.partea_expansion.CustomItems;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.util.ModTags;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    GOLDEN_NETHERITE(4, 3072, 12.0F, 5.0F, 22, () -> {
        return Ingredient.ofItems(ModItems.GOLDEN_NETHERITE_INGOT);
    }),
    DIAMOND_NETHERITE(5, 4096, 15.0F, 6.0F, 25, () -> {
        return Ingredient.ofItems(ModItems.DIAMOND_NETHERITE_INGOT);
    }),
    CREATIVE_MATERIAL(100, 999999, 30.0F, 999999999.0F, 50, () -> {
        return Ingredient.ofItems(Blocks.GRASS_BLOCK);
    }),
    AMETHYST(3, 20, 12.0F, 4.0F, 0, () -> {
        return Ingredient.ofItems(ModItems.AMETHYST);
    }),
    AMETHYST2(3, 1, 12.0F, 21.0F, 0, () -> {
        return Ingredient.ofItems(ModItems.AMETHYST);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

}
