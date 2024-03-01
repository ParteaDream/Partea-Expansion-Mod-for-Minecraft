package partea.partea_expansion.world;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import partea.partea_expansion.ModItems;

public class ModPortals {

    public static void registerPortals(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                .lightWithItem(ModItems.ANCIENT_PEARL)
                .destDimID(new Identifier("partea_expansion", "innerworld"))
                .tintColor(13, 26, 31)
                .registerPortal();
    }
}
