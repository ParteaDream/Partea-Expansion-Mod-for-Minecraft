package partea.partea_expansion.CustomBlocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import partea.partea_expansion.Modblocks;

public class ModBlockEntities {
    public static final BlockEntityType<QualitativeAnalyzerBlockEntity> QUALITATIVE_ANALYZER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier("partea_expansion","qualitative_analyzer_block_entity"),
                    FabricBlockEntityTypeBuilder.create(QualitativeAnalyzerBlockEntity::new,
                            Modblocks.QUALITATIVE_ANALYZER).build());
    public static void registerBlockEntities(){

    }
}
