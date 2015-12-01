package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.recipes.RecipeRegisterer;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenderers() {

    }
    public void registerTiles() {}
    public void registerBlocksItems() {
        //item
        GameRegistry.registerItem(ExchangeOrb.itemExchangeOrb, "exchangeOrb");
    }
    public void registerRecipes() {
        RecipeRegisterer.registerRecipes();
    }
}
