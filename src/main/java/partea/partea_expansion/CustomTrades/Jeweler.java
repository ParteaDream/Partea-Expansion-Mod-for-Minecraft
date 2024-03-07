package partea.partea_expansion.CustomTrades;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class Jeweler {
    public static final RegistryKey<PointOfInterestType> JEWEL_WORK_SITE_KEY = point("jewel_work_site");
    public static final PointOfInterestType JEWEL_WORK_SITE = registerPointOfInterestType("jewel_work_site", Blocks.ANVIL);
    public static final VillagerProfession Jeweler = registerVillagerProfession("jeweler",JEWEL_WORK_SITE_KEY);
    private static VillagerProfession registerVillagerProfession(String name,RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION,new Identifier("partea_expansion", name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(),ImmutableSet.of(), SoundEvents.BLOCK_ANVIL_USE));

    }
    private static PointOfInterestType registerPointOfInterestType(String name, Block block){
        return PointOfInterestHelper.register(new Identifier("partea_expansion", name),1,1,block);
    }
    private static RegistryKey<PointOfInterestType> point(String name){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE,new Identifier("partea_expansion", name));
    }
    public static void registerVillagers(){

    }
}
