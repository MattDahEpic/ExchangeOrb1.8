package com.mattdahepic.exchangeorb.recipe.jei_handler;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.item.ItemOrb;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

import javax.annotation.Nonnull;

@JEIPlugin
public class ExchangeOrbJEIPlugin extends BlankModPlugin {
    @Override
    public void register (@Nonnull IModRegistry registry) {
        IJeiHelpers helpers = registry.getJeiHelpers();

        registry.addRecipeHandlers(new DisenchantRecipeHandler());

        helpers.getNbtIgnoreList().ignoreNbtTagNames(ExchangeOrb.itemOrb,ItemOrb.USES_REMAINING_KEY);
    }
}
