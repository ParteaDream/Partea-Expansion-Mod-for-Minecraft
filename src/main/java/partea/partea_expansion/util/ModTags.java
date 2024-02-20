package partea.partea_expansion.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> DIAMOND_PROSPECTOR_LIST = createTag("diamond_prospector_list");
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("partea_expansion", name));
        }
    }
    public static class Items{

    }
}
