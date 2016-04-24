package com.mattdahepic.exchangeorb.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEssence extends Item {
    public ItemEssence () {
        super();
        setUnlocalizedName("mob_essence");
        setRegistryName("mob_essence");
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.SEARCH);
        setHasSubtypes(false);
    }
}
