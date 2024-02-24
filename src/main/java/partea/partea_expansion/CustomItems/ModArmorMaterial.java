package partea.partea_expansion.CustomItems;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import partea.partea_expansion.ModItems;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    GOLDEN_NETHERITE("golden_netherite", 42, new int[]{4,8,6,4}, 22,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.15f
            ,() -> Ingredient.ofItems(ModItems.GOLDEN_NETHERITE_INGOT)),
    DIAMOND_NETHERITE("diamond_netherite", 54, new int[]{4,10,8,4}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0f, 0.2f
            ,() -> Ingredient.ofItems(ModItems.DIAMOND_NETHERITE_INGOT)),
    NIGHT_VISION_GLASSES("night_vision_glasses", 25, new int[]{2,2,2,2}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(Items.COPPER_INGOT)),
    FOOLS_MASK("fools_mask", 7, new int[]{1,3,2,1}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(ModItems.FABRIC));
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;
    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts
            , int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance
            , Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()]*this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return "partea_expansion:" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
