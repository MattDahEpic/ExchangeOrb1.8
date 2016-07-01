/*package com.mattdahepic.exchangeorb.recipe;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.item.ItemOrb;
import com.mattdahepic.mdecore.helpers.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.Collections;

public class DisenchantRecipe implements IRecipe {
    public DisenchantRecipe () {}
    @Override
    public ItemStack getCraftingResult (InventoryCrafting inv) {
        ItemStack tool = null;
        int bookCount = 0;
        for (int x = 0; x < inv.getHeight(); x++) {
            for (int y = 0; y < inv.getWidth(); y++) {
                ItemStack item = inv.getStackInRowAndColumn(x,y);
                if (item != null) {
                    if (item.isItemEnchanted()) {
                        tool = item;
                    } else if (item.getItem() == Items.BOOK) {
                        bookCount++;
                    }
                }
            }
        }
        return EnchantmentHelper.getEnchantedBookWithEnchants(Collections.singletonList(getFirstEnchantmentOfMaximumLevel(tool,bookCount)));
    }
    @Override
    public ItemStack[] getRemainingItems (InventoryCrafting inv) {
        ItemStack tool = null;
        int bookCount = 0;
        for (int i = 0; i < inv.getHeight(); i++) {
            for (int j = 0; j < inv.getWidth(); j++) {
                ItemStack item = inv.getStackInRowAndColumn(j, i);
                if (item != null) {
                    if (item.isItemEnchanted()) {
                        tool = item;
                    } else if (item.getItem() == Items.BOOK) {
                        bookCount++;
                    }
                }
            }
        }

        ItemStack[] ret = new ItemStack[inv.getSizeInventory()];
        int index = -1;
        for (int i = 0; i < inv.getHeight(); i++) {
            for (int j = 0; j < inv.getWidth(); j++) {
                ItemStack item = inv.getStackInRowAndColumn(j, i);
                index++;
                if (item != null) {
                    if (item.isItemEnchanted()) {
                        EnchantmentHelper.removeEnchantment(getFirstEnchantmentOfMaximumLevel(tool,bookCount),tool);
                        ret[index] = item;
                        break;
                    } else if (item.getItem() == Items.ENCHANTED_BOOK) {
                        ret[index] = item;
                        break;
                    } else if (item.getItem() instanceof ItemOrb && item.getItemDamage() == 2) {
                        ret[index] = item;
                        break;
                    }
                }
                ret[index] = null;
            }
        }
        return ret;
    }
    @Override
    public boolean matches (InventoryCrafting inv, World world) {
        if (!GeneralConfig.enableDisenchantOrb) return false;
        boolean hasOrb = false;
        boolean hasTool = false;
        int bookCount = 0;
        for (int i = 0; i < inv.getHeight(); i++) {
            for (int j = 0; j < inv.getWidth(); j++) {
                ItemStack item = inv.getStackInRowAndColumn(j,i);
                if (item != null) {
                    if (item.getItem() instanceof ItemOrb && item.getItemDamage() == 2) {
                        hasOrb = true;
                    } else if (item.isItemEnchanted()) {
                        hasTool = true;
                    } else if (item.getItem() == Items.BOOK) {
                        bookCount++;
                        //TODO: maybe check for max enchantment level
                    }
                }
            }
        }
        return hasOrb && hasTool && bookCount > 0;
    }
    @Override
    public int getRecipeSize () {return 9;}
    @Override
    public ItemStack getRecipeOutput () {return null;}
    private EnchantmentData getFirstEnchantmentOfMaximumLevel(ItemStack tool, int max) {
        EnchantmentData data = EnchantmentHelper.getEnchantmentsFromItem(tool).get(0);
        if (data.enchantmentLevel <= max) return data;
        return new EnchantmentData(data.enchantmentobj,max);
    }
}
*/