package com.mattdahepic.exchangeorb.recipes.handler;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.recipes.ItemsList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OrbRecipeHandler {
    private static IRecipe recipe = null;
    public static void registerRecipes (boolean hardMode) {
        GameRegistry.addRecipe(orbRecipe(hardMode));
    }
    public static void removeRecipe () {
        if (recipe != null) {
            CraftingManager.getInstance().getRecipeList().remove(recipe);
        }
    }
    private static IRecipe orbRecipe (boolean hardMode) {
        ItemStack output = new ItemStack(ExchangeOrb.itemExchangeOrb);
        ItemsList i = new ItemsList();
        ItemStack[] input = new ItemStack[9];
        //row 1
        input[0] = i.rotten_flesh;
        input[1] = i.iron;
        input[2] = i.spider_eye;
        //row 2
        input[3] = i.gold;
        input[4] = hardMode ? i.nether_star : i.diamond; //nether star if hard, diamond if easy
        input[5] = i.lapis;
        //row 3
        input[6] = i.string;
        input[7] = i.gold;
        input[8] = i.gunpowder;
        recipe = new ShapedRecipes(3,3,input,output);
        return new ShapedRecipes(3,3,input,output);
    }
}
