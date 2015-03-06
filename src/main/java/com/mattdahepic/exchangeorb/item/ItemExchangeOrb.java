package com.mattdahepic.exchangeorb.item;

import com.mattdahepic.exchangeorb.config.Config;
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
            System.out.println("orb has a durability of " + this.getMaxDamage(new ItemStack(this)));
        }
        //TODO: creative tabs
    }
    /*@Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return false;
    }*/
    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        if(isDamageable()) { //if more than one use, but not infinite
            //System.out.println("input stack damage is: " + stack.getItemDamage() + " and output damage is: " + stack.getItemDamage()+1);
            //System.out.println("returning damaged stack");
            return new ItemStack(stack.getItem(),1,stack.getItemDamage()+1);
        } else if (Config.orbDurability == 1) { //if one use
            //System.out.println("one use, removing item");
            return null;
        } else { //if infinite
            //System.out.println("infinite, returning input");
            return new ItemStack(this);
        }
    }
}
