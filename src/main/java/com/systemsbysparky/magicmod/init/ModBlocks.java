package com.systemsbysparky.magicmod.init;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.systemsbysparky.magicmod.Reference;
import com.systemsbysparky.magicmod.block.BlockRubyBlock;
import com.systemsbysparky.magicmod.block.BlockRubyOre;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	
	//Static Final Instance of each Block
	public static final BlockRubyOre BLOCKRUBYORE = new BlockRubyOre();
	public static final BlockRubyBlock BLOCKRUBYBLOCK = new BlockRubyBlock();
	
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();
		
		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		
			@SubscribeEvent
			public static void registerBlocks(final RegistryEvent.Register<Block> event) {	
				final IForgeRegistry<Block> registry = event.getRegistry();
				
				
				final Block[] blocks = {
						//Reference Static Instance of Block to be Registered Here
						BLOCKRUBYORE,
						BLOCKRUBYBLOCK,
				};
			registry.registerAll(blocks);
			
			}

	// Register ItemBlocks
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
		final ItemBlock[] items = {
				//call new Itemblock(%BLOCK%) for each new block
				new ItemBlock(BLOCKRUBYORE),
				new ItemBlock(BLOCKRUBYBLOCK)
		};
		final IForgeRegistry<Item> iregistry = event.getRegistry();
		
		for (final ItemBlock item : items) {
			final Block block = item.getBlock();
			final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(),"Block %s has null registry name", block);
			iregistry.register(item.setRegistryName(registryName));
			ITEM_BLOCKS.add(item);
					
			}

		}	
	}

}
