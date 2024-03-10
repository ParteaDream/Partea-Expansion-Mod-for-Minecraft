package partea.partea_expansion.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import partea.partea_expansion.entity.custom.testEntity;

public class ModEntities {
    public static final EntityType<testEntity> TEST_Entity = Registry.register(Registries.ENTITY_TYPE,
            new Identifier("partea_expansion","test"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, testEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());
}
