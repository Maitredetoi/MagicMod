package com.systemsbysparky.magicmod;

import com.systemsbysparky.magicmod.block.BlockRubyOre;
import com.systemsbysparky.magicmod.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabSMM extends CreativeTabs {


    public CreativeTabSMM(){
        super(Reference.MOD_ID);

    }
    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.BLOCKRUBYORE);
    }
}
