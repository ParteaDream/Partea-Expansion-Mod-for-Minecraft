package partea.partea_expansion.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER
                , new Identifier("partea_expansion", QuatitativeAnalyzerRecipe.Serializer.ID),
                QuatitativeAnalyzerRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE
                ,new Identifier("partea_expansion", QuatitativeAnalyzerRecipe.Type.ID),
                QuatitativeAnalyzerRecipe.Type.INSTANCE);
    }
}
