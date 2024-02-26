package partea.partea_expansion.recipe;

import com.mojang.serialization.Codec;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class QuatitativeAnalyzerRecipe implements Recipe<SimpleInventory> {

    private final Identifier id;
    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public QuatitativeAnalyzerRecipe(Identifier id, ItemStack output, List<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()){
            return false;
        }
        return recipeItems.get(0).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    public Identifier getId(){
        return id;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    public static class Type implements RecipeType<QuatitativeAnalyzerRecipe>{
        public static final Type INSTANCE = new Type();
        public static final String ID = "quanlitative_analyzer";
    }

    public static class Serializer implements RecipeSerializer<QuatitativeAnalyzerRecipe>{

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "quanlitative_analyzer";
        @Override
        public Codec<QuatitativeAnalyzerRecipe> codec() {
            return null;
        }

        @Override
        public QuatitativeAnalyzerRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1,Ingredient.EMPTY);

            for(int i = 0; i < inputs.size();i++){
                inputs.set(i,Ingredient.fromPacket(buf));
            }
            ItemStack output = buf.readItemStack();
            return null;
        }

        @Override
        public void write(PacketByteBuf buf, QuatitativeAnalyzerRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for(Ingredient ingredient:recipe.getIngredients()){
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getResult(null));
        }
    }
}
