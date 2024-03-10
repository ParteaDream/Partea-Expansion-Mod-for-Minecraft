package partea.partea_expansion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import partea.partea_expansion.CustomBlocks.entity.ModBlockEntities;
import partea.partea_expansion.CustomTrades.NetherExplorer;
import partea.partea_expansion.Enchantments.EnchantRegister;
import partea.partea_expansion.Plugins.interactic.ItemFilterItem;
import partea.partea_expansion.Plugins.interactic.ItemFilterScreenHandler;
import partea.partea_expansion.Plugins.interactic.util.Helpers;
import partea.partea_expansion.Plugins.interactic.util.InteracticPlayerExtension;
import partea.partea_expansion.entity.ModEntities;
import partea.partea_expansion.entity.custom.testEntity;
import partea.partea_expansion.mixin.interacic.ItemEntityAccessor;
import partea.partea_expansion.potion.EffectRegister;
import partea.partea_expansion.potion.Potions;
import partea.partea_expansion.screen.ModScreenHandlers;
import partea.partea_expansion.sounds.ModSounds;
import partea.partea_expansion.util.InteracticConfig;
import partea.partea_expansion.util.ModLootTableModifiers;
import partea.partea_expansion.util.ModTraders;
import partea.partea_expansion.world.gen.ModWorldGeneration;

import java.util.function.Consumer;

public class ParteaExpansion implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("partea_expansion");
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	//interactic
	public static Item ITEM_FILTER = null;
	private static final InteracticConfig CONFIG = InteracticConfig.createAndLoad();
	private static float itemRotationSpeedMultiplier = 1f;
	public static final ScreenHandlerType<ItemFilterScreenHandler> ITEM_FILTER_SCREEN_HANDLER =
			Registry.register(Registries.SCREEN_HANDLER, new Identifier("partea_expansion", "item_filter")
					, new ScreenHandlerType<>(ItemFilterScreenHandler::new, FeatureFlags.DEFAULT_ENABLED_FEATURES));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerItems();
		Modblocks.registerBlocks();
		ModTab.registerTab();
		ModTraders.registerTraders();
		NetherExplorer.registerVillagers();
		ModSounds.registerSounds();
		ModLootTableModifiers.modifierLootTables();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModParticles.registerParticles();
		EnchantRegister.registerEnchantment();
		EffectRegister.registerEffect();
		ModWorldGeneration.generateModWorldGen();
		Potions.init();
		//ModPortals.registerPortals();

		FabricDefaultAttributeRegistry.register(ModEntities.TEST_Entity, testEntity.createTestAttributes());

		FlammableBlockRegistry.getDefaultInstance().add(Modblocks.PALM_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(Modblocks.PALM_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(Modblocks.STRIPPED_PALM_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(Modblocks.STRIPPED_PALM_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(Modblocks.PALM_PLANKS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(Modblocks.PALM_LEAVES,5,60);

		StrippableBlockRegistry.register(Modblocks.PALM_LOG,Modblocks.STRIPPED_PALM_LOG);
		StrippableBlockRegistry.register(Modblocks.PALM_WOOD,Modblocks.STRIPPED_PALM_WOOD);

		LOGGER.info("Hello Fabric world!");

		//interactic
		CONFIG.subscribeToClientOnlyMode(clientOnlyMode -> {
			if (!clientOnlyMode) return;
			CONFIG.itemsActAsProjectiles(false);
			CONFIG.itemThrowing(false);
			CONFIG.itemFilterEnabled(false);
			CONFIG.autoPickup(true);
			CONFIG.rightClickPickup(false);
		});
		enforceInClientOnlyMode(CONFIG::subscribeToItemsActAsProjectiles, CONFIG::itemsActAsProjectiles, false);
		enforceInClientOnlyMode(CONFIG::subscribeToItemThrowing, CONFIG::itemThrowing, false);
		enforceInClientOnlyMode(CONFIG::subscribeToItemFilterEnabled, CONFIG::itemFilterEnabled, false);
		enforceInClientOnlyMode(CONFIG::subscribeToAutoPickup, CONFIG::autoPickup, true);
		enforceInClientOnlyMode(CONFIG::subscribeToRightClickPickup, CONFIG::rightClickPickup, false);
		if (FabricLoader.getInstance().isModLoaded("iris")) itemRotationSpeedMultiplier = 0.5f;
		if (CONFIG.itemFilterEnabled()) {
			ITEM_FILTER = Registry.register(Registries.ITEM, new Identifier("partea_expansion", "item_filter"), new ItemFilterItem());

			ServerPlayNetworking.registerGlobalReceiver(new Identifier("partea_expansion", "filter_mode_request"), (server, player, handler, buf, responseSender) -> {
				final boolean newMode = buf.readBoolean();
				server.execute(() -> {
					if (!(player.currentScreenHandler instanceof ItemFilterScreenHandler filterHandler)) return;
					filterHandler.setFilterMode(newMode);
				});
			});
		}
		if (CONFIG.rightClickPickup()) {
			ServerPlayNetworking.registerGlobalReceiver(new Identifier("partea_expansion", "pickup"), (server, player, handler, buf, responseSender) -> {
				server.execute(() -> {
					final var item = Helpers.raycastItem(player.getCameraEntity(), 6);
					if (item == null || ((ItemEntityAccessor) item).interactic$getPickupDelay() == Short.MAX_VALUE) {
						return;
					}

					if (player.getInventory().insertStack(item.getStack().copy())) {
						player.sendPickup(item, item.getStack().getCount());
						item.discard();
					}
				});
			});
		}
		if (CONFIG.itemThrowing()) {
			ServerPlayNetworking.registerGlobalReceiver(new Identifier("partea_expansion", "drop_with_power"), (server, player, handler, buf, responseSender) -> {
				final float power = buf.readFloat();
				final boolean dropAll = buf.readBoolean();
				server.execute(() -> {
					((InteracticPlayerExtension) player).setDropPower(power);
					dropSelected(player, dropAll);
				});
			});
		}


	}

	//interactic
	public static Item getItemFilter() {
		return ITEM_FILTER;
	}
	private static void enforceInClientOnlyMode(Consumer<Consumer<Boolean>> eventSource, Consumer<Boolean> setter, boolean defaultValue) {
		eventSource.accept(value -> {
			if (!CONFIG.clientOnlyMode()) return;
			if (value != defaultValue) setter.accept(defaultValue);
		});
	}
	private void dropSelected(PlayerEntity player, boolean dropAll) {
		player.dropItem(player.getInventory().removeStack(player.getInventory().selectedSlot, dropAll && !player.getInventory().getMainHandStack().isEmpty() ? player.getInventory().getMainHandStack().getCount() : 1), false, true);
	}
	public static float getItemRotationSpeedMultiplier() {
		return itemRotationSpeedMultiplier;
	}
	public static InteracticConfig getConfig() {
		return CONFIG;
	}
}