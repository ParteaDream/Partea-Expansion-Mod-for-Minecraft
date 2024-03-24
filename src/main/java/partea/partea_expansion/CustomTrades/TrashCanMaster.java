package partea.partea_expansion.CustomTrades;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import partea.partea_expansion.Modblocks;
import partea.partea_expansion.sounds.ModSounds;

public class TrashCanMaster {
    public static final RegistryKey<PointOfInterestType> Trash_Can_SITE_KEY = point("trash_work_site");
    public static final PointOfInterestType Trash_WORK_SITE = registerPointOfInterestType("trash_work_site", Modblocks.TRASH_CAN);
    public static final VillagerProfession Trash_Can_Master = registerVillagerProfession("trash_can_master",Trash_Can_SITE_KEY);
    private static VillagerProfession registerVillagerProfession(String name,RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION,new Identifier("partea_expansion", name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(),ImmutableSet.of(), ModSounds.TRASH));

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
