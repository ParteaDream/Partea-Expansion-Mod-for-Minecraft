package partea.partea_expansion.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import partea.partea_expansion.entity.custom.testEntity;

public class testRenderer extends MobEntityRenderer<testEntity,testModel<testEntity>> {
    private static final Identifier TEXTURE = new Identifier("partea_expansion", "textures/entity/test.png");

    public testRenderer(EntityRendererFactory.Context context) {
        super(context, new testModel<>(context.getPart(ModModelLayers.TEST)), 0.5f);
    }

    @Override
    public Identifier getTexture(testEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(testEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        }else{
            matrixStack.scale(1.5f,1.5f,1.5f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
