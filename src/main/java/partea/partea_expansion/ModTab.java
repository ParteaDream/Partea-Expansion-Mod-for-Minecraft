package partea.partea_expansion;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import partea.partea_expansion.CustomItems.SafeminingDetectorItem;
import partea.partea_expansion.Plugins.interactic.ItemFilterItem;

import static partea.partea_expansion.ModItems.*;
import static partea.partea_expansion.Modblocks.*;
import static partea.partea_expansion.ParteaExpansion.*;

public class ModTab {
    public static final ItemGroup PARTEA_EXPANSION = FabricItemGroup.builder()
            .icon(() -> new ItemStack(GOLDEN_NETHERITE_INGOT))
            .displayName(Text.translatable("itemgroup.partea_expansion.partea_expansion"))
            .entries((context, entries) -> {
                entries.add(CREATIVE_MODE_SWORD);
                entries.add(GOLDEN_NETHERITE_INGOT);
                entries.add(GOLDEN_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(GOLDEN_NETHERITE_SWORD);
                entries.add(GOLDEN_NETHERITE_AXE);
                entries.add(GOLDEN_NETHERITE_PICKAXE);
                entries.add(GOLDEN_NETHERITE_SHOVEL);
                entries.add(GOLDEN_NETHERITE_HOE);
                entries.add(GOLDEN_NETHERITE_HELMET);
                entries.add(GOLDEN_NETHERITE_CHESTPLATE);
                entries.add(GOLDEN_NETHERITE_LEGGINGS);
                entries.add(GOLDEN_NETHERITE_BOOTS);
                entries.add(GOLDEN_NETHERITE_BLOCK);

                entries.add(DIAMOND_NETHERITE_INGOT);
                entries.add(DIAMOND_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(DIAMOND_NETHERITE_SWORD);
                entries.add(DIAMOND_NETHERITE_AXE);
                entries.add(DIAMOND_NETHERITE_PICKAXE);
                entries.add(DIAMOND_NETHERITE_SHOVEL);
                entries.add(DIAMOND_NETHERITE_HOE);
                entries.add(DIAMOND_NETHERITE_HELMET);
                entries.add(DIAMOND_NETHERITE_CHESTPLATE);
                entries.add(DIAMOND_NETHERITE_LEGGINGS);
                entries.add(DIAMOND_NETHERITE_BOOTS);
                entries.add(DIAMOND_NETHERITE_BLOCK);

                entries.add(CRUDE_AMETHYST);
                entries.add(AMETHYST);
                entries.add(AMETHYST_SWORD);
                entries.add(AMETHYST_STILLETO);

                entries.add(AZURE_ORE);
                entries.add(RAE_AZURE);
                entries.add(AZURE_INGOT);
                entries.add(AZURE_BLOCK);

                entries.add(NIGHT_VISION_GLASSES);
                entries.add(EMPTY_TERMINAL);
                entries.add(DIAMOND_PROSPECTOR);
                entries.add(SAFEMINING_DETECTOR);

                entries.add(SHED_A_LIGHT_MUSIC_DISC);
                entries.add(SILENT_TIME_MUSIC_DISC);

                entries.add(ITEM_FILTER);

                entries.add(QUALITATIVE_ANALYZER);
            })
            .build();

    public static void registerTab(){
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "partea_expansion"), PARTEA_EXPANSION);
    }

}
