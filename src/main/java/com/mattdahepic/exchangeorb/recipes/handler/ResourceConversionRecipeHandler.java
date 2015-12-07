package com.mattdahepic.exchangeorb.recipes.handler;

import com.mattdahepic.exchangeorb.recipes.ItemsList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class ResourceConversionRecipeHandler {
    private static List<IRecipe> recipes = new ArrayList<IRecipe>();
    private static ItemsList i = new ItemsList();
    public static  void registerRecipes (ItemStack lowItem,ItemStack highItem,int amountLow,int amountHigh) {
        GameRegistry.addRecipe(recipeHighToLow(lowItem,highItem,amountLow,amountHigh));
        GameRegistry.addRecipe(recipeLowToHigh(lowItem,highItem,amountLow,amountHigh));
    }
    public static void removeAllResoruceRecipes () {
        for (IRecipe recipe : recipes) {
            CraftingManager.getInstance().getRecipeList().remove(recipe);
        }
    }
    private static IRecipe recipeHighToLow (ItemStack lowItem,ItemStack highItem,int lowCount,int highCount) {
        ItemStack output = new ItemStack(lowItem.getItem(),lowCount,lowItem.getItemDamage());

        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(i.exchange_orb);
        for (int i = 0; i < highCount; i++) {
            input.add(highItem);
        }
        recipes.add(new ShapelessRecipes(output,input));
        return new ShapelessRecipes(output,input);
    }
    private static IRecipe recipeLowToHigh (ItemStack lowItem,ItemStack highItem,int lowCount,int highCount) {
        ItemStack output = new ItemStack(highItem.getItem(),highCount,highItem.getItemDamage());

        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(i.exchange_orb);
        for (int i = 0; i < lowCount; i++) {
            input.add(lowItem);
        }
        recipes.add(new ShapelessRecipes(output,input));
        return new ShapelessRecipes(output,input);
    }
}
