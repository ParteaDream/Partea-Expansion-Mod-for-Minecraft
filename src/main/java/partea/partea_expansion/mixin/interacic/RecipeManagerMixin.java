package partea.partea_expansion.mixin.interacic;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import partea.partea_expansion.ParteaExpansion;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    private static final String FILTER_RECIPE = """
            {
                "type": "minecraft:crafting_shaped",
                "pattern": [
                    " c ",
                    "cEc",
                    " c "
                ],
                "key": {
                    "c": {
                        "item": "minecraft:copper_ingot"
                    },
                    "E": {
                        "item": "minecraft:ender_pearl"
                    }
                },
                "result": {
                    "item": "partea_expansion:item_filter",
                    "count": 1
                }
            }
            """;

    @Inject(method = "apply", at = @At("HEAD"))
    public void injectFilterRecipe(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
        if (ParteaExpansion.getConfig().itemFilterEnabled()) {
            map.put(new Identifier("partea_expansion", "item_filter"), new Gson().fromJson(FILTER_RECIPE, JsonObject.class));
        }
    }
}
