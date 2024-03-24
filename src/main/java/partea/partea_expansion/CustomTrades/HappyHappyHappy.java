package partea.partea_expansion.CustomTrades;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import partea.partea_expansion.sounds.ModSounds;

public class HappyHappyHappy {
    public static final RegistryKey<PointOfInterestType> HAPPY_WORK_SITE_KEY = point("happy_work_site");
    public static final PointOfInterestType HAPPY_WORK_SITE = registerPointOfInterestType("happy_work_site", Blocks.COMMAND_BLOCK);
    public static final VillagerProfession Happy = registerVillagerProfession("designer",HAPPY_WORK_SITE_KEY);
    private static VillagerProfession registerVillagerProfession(String name,RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION,new Identifier("partea_expansion", name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(),ImmutableSet.of(), ModSounds.ELATION));

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
