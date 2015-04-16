package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeRegisterer {
    public static void registerRecipes  () {
        //orb
        ShapedOrbRecipeHandler.registerRecipes(Config.orbHardMode);
        //converions
        ItemStack charcoal = new ItemStack(Items.coal,1,1);
        ItemStack coal = new ItemStack(Items.coal,1,0);
        ItemStack iron = new ItemStack(Items.iron_ingot,1,0);
        ItemStack redstone = new ItemStack(Items.redstone,1,0);
        ItemStack lapis = new ItemStack(Items.dye,1,4);
        ItemStack gold = new ItemStack(Items.gold_ingot,1,0);
        ItemStack diamond = new ItemStack(Items.diamond,1,0);
        ItemStack emerald = new ItemStack(Items.emerald,1,0);
        ShapelessConversionRecipeHandler.registerRecipes(charcoal, coal, Config.charcoalCoal_Charcoal, Config.charcoalCoal_Coal);
        ShapelessConversionRecipeHandler.registerRecipes(coal,iron,Config.coalIron_Coal,Config.coalIron_Iron);
        ShapelessConversionRecipeHandler.registerRecipes(iron,redstone,Config.ironRedstone_Iron,Config.ironRedstone_Redstone);
        ShapelessConversionRecipeHandler.registerRecipes(redstone,lapis,Config.redstoneLapis_Redstone,Config.redstoneLapis_Lapis);
        ShapelessConversionRecipeHandler.registerRecipes(lapis,gold,Config.lapisGold_Lapis,Config.lapisGold_Gold);
        ShapelessConversionRecipeHandler.registerRecipes(gold,diamond,Config.goldDiamond_Gold,Config.goldDiamond_Diamond);
        ShapelessConversionRecipeHandler.registerRecipes(diamond,emerald,Config.diamondEmerald_Diamond,Config.diamondEmerald_Emerald);
    }
}
