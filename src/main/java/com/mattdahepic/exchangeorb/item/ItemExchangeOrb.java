package com.mattdahepic.exchangeorb.item;

import com.mattdahepic.exchangeorb.config.Config;
import com.mattdahepic.exchangeorb.utils.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemExchangeOrb extends Item {
    public ItemExchangeOrb () {
        super();
        this.setUnlocalizedName("exchangeOrb");
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        if(Config.orbHasDurability && Config.orbDurability > 1 ) { //if durability enabled and not one use
            this.setMaxDamage(Config.orbDurability-1);
            LogHelper.info("Exchange Orb has a maximum durability of " + (this.getMaxDamage()+1));
        }
    }
    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        if(isDamageable()) { //if more than one use, but not infinite
            LogHelper.info("Exchange Orb durability decreased by 1, leaving you with an orb that has " + ((this.getMaxDamage()-stack.getItemDamage())-1) + " uses left!");
            return new ItemStack(stack.getItem(),1,stack.getItemDamage()+1);
        } else if (Config.orbDurability == 1) { //if one use
            LogHelper.info("Exchange Orb set to be 1 use! Removing orb.");
            return null;
        } else { //if infinite
            LogHelper.info("Exchange Orb set to be infinite! Returning new orb.");
            return new ItemStack(this);
        }
    }
}
