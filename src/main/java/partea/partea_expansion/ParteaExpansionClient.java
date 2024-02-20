package partea.partea_expansion;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Items;
import io.wispforest.owo.config.ui.ConfigScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import partea.partea_expansion.Plugins.interactic.InteracticConfigScreen;
import partea.partea_expansion.Plugins.interactic.ItemFilterScreen;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;

@Environment(EnvType.CLIENT)
public class ParteaExpansionClient implements ClientModInitializer {

    public static final KeyBinding PICKUP_ITEM = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.partea_expansion.pickup_item",
            InputUtil.UNKNOWN_KEY.getCode(), "key.categories.misc"));

    @Override
    public void onInitializeClient() {


        ModelPredicateProviderRegistry.register(new Identifier("enabled"), (stack, world, entity, seed) -> stack.getOrCreateNbt().getBoolean("Enabled") ? 1 : 0);
        HandledScreens.register(ParteaExpansion.ITEM_FILTER_SCREEN_HANDLER, ItemFilterScreen::new);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (PICKUP_ITEM.wasPressed()) {
                ClientPlayNetworking.send(new Identifier("partea_expansion", "pickup"), PacketByteBufs.empty());
                client.player.swingHand(Hand.MAIN_HAND);
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

        //axolotl bucket fix
        FabricModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("variant"), (itemStack, clientWorld, livingEntity, i) -> {
            float axolotlType = 0;
            if (itemStack.getNbt() != null && itemStack.getNbt().contains("Variant"))
                axolotlType = itemStack.getNbt().getInt("Variant");
            return axolotlType * 0.01f + 0.0001f;
        });

        FabricModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("age"), (itemStack, clientWorld, livingEntity, i) -> {
            float age = 1;
            if (itemStack.getNbt() != null && itemStack.getNbt().contains("Age") && itemStack.getNbt().getInt("Age") < 0)
                age = 0;
            return age;
        });
    }
}

