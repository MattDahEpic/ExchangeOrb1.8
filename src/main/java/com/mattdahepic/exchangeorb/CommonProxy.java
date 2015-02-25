package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.recipes.RecipeExchangeOrb;
import com.mattdahepic.exchangeorb.recipes.conversions.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenderers() {

    }
    public void registerTiles() {}
    public void registerBlocksItems() {
        //item
        GameRegistry.registerItem(ExchangeOrb.itemExchangeOrb, "exchangeOrb");
    }
    public void registerRecipes() {
        RecipeExchangeOrb.registerRecipe();
        //conversions
        CharcoalCoal.registerRecipe();
        IronGold.registerRecipe();
        GoldDiamond.registerRecipe();
        IronRedstone.registerRecipe();
        GoldLapis.registerRecipes();
        DiamondEmerald.registerRecipes();
    }
}
