// package
package com.github.armouredheart.eons_core;

// Minecraft imports
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

// Forge imports
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.config.ModConfig.Reloading;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.config.EonsConfig;
import com.github.armouredheart.eons_core.init.EonsItemGroups;
import com.github.armouredheart.eons_core.init.EonsBlocks;
import com.github.armouredheart.eons_core.init.EonsEntityTypes;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.paleozoic.*;
import com.github.armouredheart.eons_core.init.EonsBiomes;
import com.github.armouredheart.eons_core.common.world.gen.surfacebuilders.EonsSurfaceBuilders;

// misc imports
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** */
@EventBusSubscriber(modid = EonsCore.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class EonsEventSubscriber {

	//
	private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsEventSubcriber");

	/** */
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
			setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "example_ore")
		);
	}

	/** */
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		// Automatically register BlockItems for all our Blocks
		EonsBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)
				// You can do extra filtering here if you don't want some blocks to have an
				// BlockItem automatically registered for them
				// .filter(block -> needsItemBlock(block))
				// Register the BlockItem for the block
				.forEach(block -> {
					// Make the properties, and make it so that the item will be on our ItemGroup
					// (CreativeTab)
					final Item.Properties properties = new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP);
					// Create the new BlockItem with the block and it's properties
					final BlockItem blockItem = new BlockItem(block, properties);
					// Set the new BlockItem's registry name to the block's registry name
					blockItem.setRegistryName(block.getRegistryName());
					// Register the BlockItem
					registry.register(blockItem);
				});
		LOGGER.debug("Registered BlockItems!");

		/** Cadiboo code */
		//event.getRegistry().registerAll(setup(new Item(new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP)), "example_ingot"));

		// Register Spawn eggs
	}

	/** */
	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {

	}

	/** */
	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		EonsBiomes.registerBiomesToBiomeDictionary();
	}

	@SubscribeEvent
	public static void onRegisterSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
		EonsSurfaceBuilders.registerEonsSurfaceBuilders(event);
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading event) {
		// call method defined in config
		EonsConfig.onLoad(event);
	}

	@SubscribeEvent
	public static void onFileChange(final Reloading event) {
		// call method defined in config
		EonsConfig.onFileChange(event);
	}

	/** Cadiboo method */
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(EonsCore.MOD_ID, name));
	}
	
	/** Cadiboo method */
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}

	/**
	 * We need to register our renderers on the client because rendering code does not exist on the server
	 * and trying to use it on a dedicated server will crash the game.
	 * <p>
	 * This method will be called by Forge when it is time for the mod to do its client-side setup
	 * This method will always be called after the Registry events.
	 * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
	 */
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
		LOGGER.debug("Registering Entity renderers...");
		// Register Entity Renderers
		RenderingRegistry.registerEntityRenderingHandler(EonsEntityTypes.DIMETRODON.get(), EonsDimetrodonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EonsEntityTypes.ANOMALOCARIS.get(), EonsAnomalocarisRenderer::new);
	}
}