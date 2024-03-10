package partea.partea_expansion;

import io.wispforest.owo.config.ui.ConfigScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import partea.partea_expansion.CustomItems.ToolItems.AzuriteBowItem;
import partea.partea_expansion.Plugins.interactic.InteracticConfigScreen;
import partea.partea_expansion.Plugins.interactic.ItemFilterScreen;
import partea.partea_expansion.entity.ModEntities;
import partea.partea_expansion.entity.client.ModModelLayers;
import partea.partea_expansion.entity.client.testModel;
import partea.partea_expansion.entity.client.testRenderer;
import partea.partea_expansion.screen.ModScreenHandlers;
import partea.partea_expansion.screen.QualitativeAnalyzerScreen;

@Environment(EnvType.CLIENT)
public class ParteaExpansionClient implements ClientModInitializer {

    public static final KeyBinding PICKUP_ITEM = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.partea_expansion.pickup_item",
            InputUtil.UNKNOWN_KEY.getCode(), "key.categories.misc"));

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.QUALITATIVE_ANALYZER_SCREEN_HANDLER, QualitativeAnalyzerScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(Modblocks.PALM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Modblocks.PALM_SAPLING, RenderLayer.getCutout());

        //Entities
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TEST, testModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TEST_Entity, testRenderer::new);


        //ParticleFactoryRegistry.getInstance().register(ModParticles.DOOMED_DEATH_FLAME, EndRodParticle.Factory::new);


        ModelPredicateProviderRegistry.register(new Identifier("enabled"), (stack, world, entity, seed) -> stack.getOrCreateNbt().getBoolean("Enabled") ? 1 : 0);
        HandledScreens.register(ParteaExpansion.ITEM_FILTER_SCREEN_HANDLER, ItemFilterScreen::new);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (PICKUP_ITEM.wasPressed()) {
                ClientPlayNetworking.send(new Identifier("partea_expansion", "pickup"), PacketByteBufs.empty());
                if (client.player != null) {
                    client.player.swingHand(Hand.MAIN_HAND);
                }
            }
        });
        ConfigScreen.registerProvider("partea_expansion", InteracticConfigScreen::new);
        if (ParteaExpansion.getConfig().itemFilterEnabled()) {
            ClientPlayNetworking.registerGlobalReceiver(new Identifier("partea_expansion", "set_filter_mode"), (client, handler, buf, responseSender) -> {
                final boolean newMode = buf.readBoolean();
                client.execute(() -> {
                    if (!(client.currentScreen instanceof ItemFilterScreen screen)) return;
                    screen.blockMode = newMode;
                });
            });
        }
        //Azurite Bow
        ModelPredicateProviderRegistry.register(ModItems.AZURITE_BOW, new Identifier("pull"), (itemStack, world, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 5.0F;
        });
        ModelPredicateProviderRegistry.register(ModItems.AZURITE_BOW, new Identifier("pulling"), (itemStack, world, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });

        //axolotl bucket fix
        ModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("variant"), (itemStack, clientWorld, livingEntity, i) -> {
            float axolotlType = 0;
            if (itemStack.getNbt() != null && itemStack.getNbt().contains("Variant"))
                axolotlType = itemStack.getNbt().getInt("Variant");
            return axolotlType * 0.01f + 0.0001f;
        });

        ModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("age"), (itemStack, clientWorld, livingEntity, i) -> {
            float age = 1;
            if (itemStack.getNbt() != null && itemStack.getNbt().contains("Age") && itemStack.getNbt().getInt("Age") < 0)
                age = 0;
            return age;
        });
    }
}

