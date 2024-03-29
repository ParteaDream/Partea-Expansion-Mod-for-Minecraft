package partea.partea_expansion.CustomItems.ArmorItems;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
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
    DIAMOND_NETHERITE("diamond_netherite", 54, new int[]{4,10,7,4}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0f, 0.2f
            ,() -> Ingredient.ofItems(ModItems.DIAMOND_NETHERITE_INGOT)),
    NIGHT_VISION_GLASSES("night_vision_glasses", 25, new int[]{1,2,2,2}, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(Items.COPPER_INGOT)),
    FOOLS_MASK("fools_mask", 7, new int[]{1,3,2,1}, 0,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(ModItems.FABRIC)),
    THRILLER_MASK("thriller_mask", 7, new int[]{1,3,2,1}, 0,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(ModItems.FABRIC)),
    SNEAKER("sneaker", 9, new int[]{1,3,2,1}, 5,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(ModItems.FABRIC)),
    KNEE_PADS("knee_pads", 9, new int[]{1,3,2,1}, 5,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(ModItems.FABRIC)),
    Laurel_Crown_Of_Planar_Shifts("laurel_crown_of_planar_shifts", 9, new int[]{1,3,2,1}, 5,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f
            ,() -> Ingredient.ofItems(ModItems.FABRIC)),
    AZURE("azure", 49, new int[]{4,9,7,4}, 24,
    SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.14f
            ,() -> Ingredient.ofItems(ModItems.AZURE_INGOT)),
    AZURITE("azurite", 108, new int[]{5,12,8,5}, 28,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5.0f, 0.25f
            ,() -> Ingredient.ofItems(ModItems.AZURE_INGOT)),
    ROBE_OF_THE_BEAUTY("robe_of_the_beauty", 9, new int[]{1,3,2,1}, 5,
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
