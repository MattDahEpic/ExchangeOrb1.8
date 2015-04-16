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
    }
    @Override
    public int getMaxDamage () {
        if(isDamageable() && Config.orbDurability > 1) { //if durability enabled and not one use
             return (Config.orbDurability-1);
        } else {
            return 0;
        }
    }
    @Override
    public boolean isDamageable () {
        this.setMaxDamage(0);
        return Config.orbHasDurability;
    }
    @Override
    public boolean hasContainerItem (ItemStack item) {
        return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        if(isDamageable() && Config.orbDurability > 1) { //if more than one use, but not infinite
            return new ItemStack(stack.getItem(),1,stack.getItemDamage()+1);
        } else if (Config.orbDurability == 1) { //if one use
            return null;
        } else { //if infinite
            return new ItemStack(this);
        }
    }
}
