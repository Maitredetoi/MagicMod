package com.systemsbysparky.magicmod.block;

import net.minecraft.block.material.Material;

public class BlockRubyBlock extends BlockBase{

    public BlockRubyBlock(){
        super(Material.ROCK, "blockrubyblock");
        setHarvestLevel("pickaxe", 2);
        setHardness(3);
    }



}
