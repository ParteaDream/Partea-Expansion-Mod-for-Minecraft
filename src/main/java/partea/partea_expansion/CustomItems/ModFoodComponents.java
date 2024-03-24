package partea.partea_expansion.CustomItems;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent HORSE_MEAT = new FoodComponent.Builder().hunger(3).saturationModifier(1.8f).build();
    public static final FoodComponent COOKED_HORSE_MEAT = new FoodComponent.Builder().hunger(8).saturationModifier(12.8f).build();
    public static final FoodComponent TEA = new FoodComponent.Builder().hunger(20).saturationModifier(40f).build();
}
