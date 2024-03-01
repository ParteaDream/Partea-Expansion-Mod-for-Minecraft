package partea.partea_expansion.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModTreeGeneration.registerTrees();
    }
}
