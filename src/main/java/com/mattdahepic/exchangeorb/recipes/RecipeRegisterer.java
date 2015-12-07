package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfig;

public class RecipeRegisterer {
    public static void registerRecipes  () {
        //orb
        OrbRecipeHandler.registerRecipes(GeneralConfig.orbHardMode);
        ItemsList i = new ItemsList();
        //resources
        ResourceConversionRecipeHandler.registerRecipes(i.charcoal, i.coal, ResourceConfig.charcoal_coalLow,ResourceConfig.charcoal_coalHigh);
        ResourceConversionRecipeHandler.registerRecipes(i.coal, i.iron, ResourceConfig.coal_ironLow,ResourceConfig.coal_ironHigh);
        ResourceConversionRecipeHandler.registerRecipes(i.iron, i.redstone, ResourceConfig.iron_redstoneLow,ResourceConfig.iron_redstoneHigh);
        ResourceConversionRecipeHandler.registerRecipes(i.redstone, i.lapis, ResourceConfig.redstone_lapisLow,ResourceConfig.redstone_lapisHigh);
        ResourceConversionRecipeHandler.registerRecipes(i.lapis, i.gold, ResourceConfig.lapis_goldLow,ResourceConfig.lapis_goldHigh);
        ResourceConversionRecipeHandler.registerRecipes(i.gold, i.diamond, ResourceConfig.gold_diamondLow,ResourceConfig.gold_diamondHigh);
        ResourceConversionRecipeHandler.registerRecipes(i.diamond, i.emerald, ResourceConfig.diamond_emeraldLow,ResourceConfig.diamond_emeraldHigh);
        //mob drops
    }
}
