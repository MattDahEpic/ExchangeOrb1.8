package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.item.ItemExchangeOrb;
import com.mattdahepic.exchangeorb.item.ItemMobEssence;
import com.mattdahepic.exchangeorb.recipes.RecipeRegisterer;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenders() {}
    public void registerItems() {
        ExchangeOrb.itemExchangeOrb = new ItemExchangeOrb();
        GameRegistry.registerItem(ExchangeOrb.itemExchangeOrb, "exchangeOrb");
        ExchangeOrb.itemMobEssence = new ItemMobEssence();
        GameRegistry.registerItem(ExchangeOrb.itemMobEssence,"mobEssence");
    }
    public void registerRecipes() {
        RecipeRegisterer.registerRecipes();
    }
}
