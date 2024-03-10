package partea.partea_expansion.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.ParteaExpansion;

public class Potions {
    public static final Potion DOOMED_DEATH = register("doomed_death", new Potion(new StatusEffectInstance(CustomPotionDoomedDeath.PotionDoomedDeath, 160)));
    public static final Potion STRONG_DOOMED_DEATH = register("strong_doomed_death", new Potion(new StatusEffectInstance(CustomPotionDoomedDeath.PotionDoomedDeath, 240, 1)));
    public static final Potion EVIL_LIZARD = register("evil_lizard", new Potion(new StatusEffectInstance(EvilLizardEffect.EvilLizardEffect, 3600)));

    private static Potion register(String id, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier("partea_expansion", id), potion);
    }
    public static void init(){
        ParteaExpansion.LOGGER.debug("Registering potions");
        FabricBrewingRecipeRegistry.registerPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Ingredient.ofItems(Items.ECHO_SHARD),DOOMED_DEATH);
        FabricBrewingRecipeRegistry.registerPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Ingredient.ofItems(ModItems.SUSPICIOUS_SQUAMA),EVIL_LIZARD);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.DOOMED_DEATH, Ingredient.ofItems(Items.GLOWSTONE_DUST),STRONG_DOOMED_DEATH);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.DOOMED_DEATH, Ingredient.ofItems(Items.REDSTONE),STRONG_DOOMED_DEATH);
    }
}
