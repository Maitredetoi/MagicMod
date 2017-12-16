package com.systemsbysparky.magicmod.block;

import com.systemsbysparky.magicmod.MagicMod;
import com.systemsbysparky.magicmod.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class BlockBase extends Block {
	public BlockBase(final Material material, final MapColor mapColor, final String blockName) {
		super(material, mapColor);
		setBlockName(this, blockName);
		setCreativeTab(MagicMod.creativeTab);
	}

	public BlockBase(final Material materialIn, final String blockName) {
		this(materialIn, materialIn.getMaterialMapColor(), blockName);
	}

	/**
	 * Set the registry name of {@code block} to {@code blockName} and the unlocalised name to the full registry name.
	 *
	 * @param block     The block
	 * @param blockName The block's name
	 */
	public static void setBlockName(final Block block, final String blockName) {
		block.setRegistryName(Reference.MOD_ID, blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}