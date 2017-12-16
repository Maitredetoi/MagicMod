package com.systemsbysparky.magicmod.block;

import com.systemsbysparky.magicmod.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockRubyOre extends BlockBase{

	public BlockRubyOre() {
		super(Material.ROCK, "BlockRubyOre");
		setHarvestLevel("pickaxe", 2);
		setHardness(3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.ITEM_RUBY;
	}



}
