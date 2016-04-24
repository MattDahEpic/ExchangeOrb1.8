package com.mattdahepic.exchangeorb.item;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemOrb extends Item {
    private static Map<Integer,String> nameMap = new HashMap<Integer, String>();
    static {
        nameMap.put(0,"resource");
        nameMap.put(1,"mobdrop");
        nameMap.put(2,"disenchant");
    }

    private static final String USES_REMAINING_KEY = "uses_remaining";
    public ItemOrb () {
        super();
        setUnlocalizedName("exchange_orb");
        setRegistryName("exchange_orb");
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.SEARCH);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item."+nameMap.get(stack.getItemDamage())+"_orb";
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> items) {
        for (int i : nameMap.keySet()) {
            items.add(new ItemStack(item, 1, i));
        }
    }

    /* DURABILITY */
    private int getUsesRemaining (ItemStack stack) {
        if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey(USES_REMAINING_KEY)) setUsesRemaining(stack,GeneralConfig.orbDurability);
        return stack.getTagCompound().getInteger(USES_REMAINING_KEY);
    }
    private void setUsesRemaining (ItemStack stack, int usesRemaining) {
        if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setInteger(USES_REMAINING_KEY,usesRemaining);
    }
    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return GeneralConfig.orbHasDurability;
    }
    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return Math.pow(getUsesRemaining(stack) / GeneralConfig.orbDurability,-1);
    }

    /* CRAFTING */
    @Override
    public boolean hasContainerItem (ItemStack item) {
        return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        switch (getUsesRemaining(stack)) {
            case -1: //infinite uses
                return new ItemStack(this);
            case 1: //last use
                return null;
            default: //damageable, but not last use
                setUsesRemaining(stack,getUsesRemaining(stack)-1);
                return stack;
        }
    }
}
