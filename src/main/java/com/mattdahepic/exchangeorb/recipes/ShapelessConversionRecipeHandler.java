package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class ShapelessConversionRecipeHandler {
    public static void registerRecipes (ItemStack lowItem,ItemStack highItem,int lowCount,int highCount) {
        GameRegistry.addRecipe(recipeHighToLow(lowItem,highItem,lowCount,highCount));
        GameRegistry.addRecipe(recipeLowToHigh(lowItem,highItem,lowCount,highCount));
    }
    private static IRecipe recipeHighToLow (ItemStack lowItem,ItemStack highItem,int lowCount,int highCount) {
        ItemStack output = new ItemStack(lowItem.getItem(),lowCount,lowItem.getItemDamage());

        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(new ItemStack(ExchangeOrb.itemExchangeOrb,1,OreDictionary.WILDCARD_VALUE));
        for (int i = 0; i < highCount; i++) {
            input.add(highItem);
        }

        return new ShapelessRecipes(output,input);
    }
    private static IRecipe recipeLowToHigh (ItemStack lowItem,ItemStack highItem,int lowCount,int highCount) {
        ItemStack output = new ItemStack(highItem.getItem(),highCount,highItem.getItemDamage());

        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(new ItemStack(ExchangeOrb.itemExchangeOrb,1,OreDictionary.WILDCARD_VALUE));
        for (int i = 0; i < lowCount; i++) {
            input.add(lowItem);
        }

        return new ShapelessRecipes(output,input);
    }
}
