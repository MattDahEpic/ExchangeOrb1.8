package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;

public class OrbRecipeHandler {
    public static void registerRecipes (boolean hardMode) {
        GameRegistry.addRecipe(orbRecipe(hardMode));
    }
    private static IRecipe orbRecipe (boolean hardMode) {
        ItemStack output = new ItemStack(ExchangeOrb.itemExchangeOrb);
        ItemsList i = new ItemsList();
        ItemStack[] input = new ItemStack[9];
        //row 1
        input[0] = i.charcoal;
        input[1] = i.coal;
        input[2] = i.iron;
        //row 2
        input[3] = i.diamond;
        input[4] = hardMode ? i.nether_star : i.stone; //nether star if hard, stone if easy
        input[5] = i.emerald;
        //row 3
        input[6] = i.gold;
        input[7] = i.redstone;
        input[8] = i.lapis;
        return new ShapedRecipes(3,3,input,output);
    }
}
