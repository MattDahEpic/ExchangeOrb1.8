package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfig;

public class RecipeRegisterer {
    public void registerRecipes  () {
        //orb
        OrbRecipeHandler.registerRecipes(GeneralConfig.orbHardMode);
        ItemsList i = new ItemsList();
        //resources
        ResourceConversionRecipeHandler.registerRecipes(i.charcoal, i.coal, ResourceConfig.charcoal_coal);
        ResourceConversionRecipeHandler.registerRecipes(i.coal, i.iron, ResourceConfig.coal_iron);
        ResourceConversionRecipeHandler.registerRecipes(i.iron, i.redstone, ResourceConfig.iron_redstone);
        ResourceConversionRecipeHandler.registerRecipes(i.redstone, i.lapis, ResourceConfig.redstone_lapis);
        ResourceConversionRecipeHandler.registerRecipes(i.lapis, i.gold, ResourceConfig.lapis_gold);
        ResourceConversionRecipeHandler.registerRecipes(i.gold, i.diamond, ResourceConfig.gold_diamond);
        ResourceConversionRecipeHandler.registerRecipes(i.diamond, i.emerald, ResourceConfig.diamond_emerald);
        //mob drops

    }
}
