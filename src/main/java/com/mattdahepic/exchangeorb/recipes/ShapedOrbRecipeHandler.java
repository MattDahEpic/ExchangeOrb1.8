package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;

public class ShapedOrbRecipeHandler {
    public static void registerRecipes (boolean hardMode) {
        GameRegistry.addRecipe(orbRecipe(hardMode));
    }
    private static IRecipe orbRecipe (boolean hardMode) {
        ItemStack output = new ItemStack(ExchangeOrb.itemExchangeOrb);
        ItemStack[] input = new ItemStack[9];
        //row 1
        input[0] = new ItemStack(Items.coal,1,1); //charcoal
        input[1] = new ItemStack(Items.coal,1); //coal
        input[2] = new ItemStack(Items.iron_ingot,1); //iron
        //row 2
        input[3] = new ItemStack(Items.diamond,1); //diamond
        if (hardMode) {
            input[4] = new ItemStack(Items.nether_star,1); //nether star, if hard
        } else {
            input[4] = new ItemStack(Blocks.stone,1); //stone, if easy
        }
        input[5] = new ItemStack(Items.emerald,1);
        //row 3
        input[6] = new ItemStack(Items.gold_ingot,1); //gold
        input[7] = new ItemStack(Items.redstone,1); //redstone
        input[8] = new ItemStack(Items.dye,1,4); //lapis
        return new ShapedRecipes(3,3,input,output);
    }
}
