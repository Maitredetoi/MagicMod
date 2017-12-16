package com.systemsbysparky.magicmod.item;

import com.systemsbysparky.magicmod.MagicMod;
import com.systemsbysparky.magicmod.Reference;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(final String itemName) {
        setItemName(this, itemName);
        setCreativeTab(MagicMod.creativeTab);
    }

    public static void setItemName(final Item item, final String itemName) {
        item.setRegistryName(Reference.MOD_ID,itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }
}

