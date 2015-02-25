package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeExchangeOrb {
    public RecipeExchangeOrb () {}
    public static void registerRecipe () {
        GameRegistry.addShapedRecipe(new ItemStack(ExchangeOrb.itemExchangeOrb, 1), getRecipe());
    }
    private static Object[] getRecipe () {
        ItemStack charcoal = new ItemStack(Items.coal,1,1); //a
        ItemStack coal = new ItemStack(Items.coal,1); //b
        ItemStack iron = new ItemStack(Items.iron_ingot,1); //c
        ItemStack gold = new ItemStack(Items.gold_ingot,1); //d
        ItemStack redstone = new ItemStack(Items.redstone,1); //e
        ItemStack lapis = new ItemStack(Items.dye,1,4); //f
        ItemStack stone = new ItemStack(Blocks.stone,1); //g
        ItemStack diamond = new ItemStack(Items.diamond,1); //h
        ItemStack emerald = new ItemStack(Items.emerald,1); //i
        String row1 = "abc";
        String row2 = "hgi";
        String row3 = "def";
        Object[] recipe = new Object[21];
        recipe[0] = row1;
        recipe[1] = row2;
        recipe[2] = row3;
        recipe[3] = 'a';
        recipe[4] = charcoal;
        recipe[5] = 'b';
        recipe[6] = coal;
        recipe[7] = 'c';
        recipe[8] = iron;
        recipe[9] = 'd';
        recipe[10] = gold;
        recipe[11] = 'e';
        recipe[12] = redstone;
        recipe[13] = 'f';
        recipe[14] = lapis;
        recipe[15] = 'g';
        recipe[16] = stone;
        recipe[17] = 'h';
        recipe[18] = diamond;
        recipe[19] = 'i';
        recipe[20] = emerald;
        return recipe;
    }
}
