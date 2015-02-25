package com.mattdahepic.exchangeorb.recipes.conversions;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DiamondEmerald {
    public static final int xEmeralds = Config.xEmeralds;
    public static final int diamondsPerXEmeralds = Config.diamondsPerXEmeralds;
    public DiamondEmerald () {}
    public static void registerRecipes () {
        //diamond to emerald
        GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, xEmeralds), getRecipeTo());
        //1 emerald for 2 diamonds
        GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond,diamondsPerXEmeralds),getRecipeFrom());
    }
    private static Object[] getRecipeTo () {
        ItemStack diamond = new ItemStack(Items.diamond,1);
        Object[] recipe = new Object[diamondsPerXEmeralds+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= diamondsPerXEmeralds; i++) {
            recipe[i] = diamond;
        }
        return recipe;
    }
    private static Object[] getRecipeFrom () {
        ItemStack emerald = new ItemStack(Items.emerald,1);
        Object[] recipe = new Object[xEmeralds+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= xEmeralds; i++) {
            recipe[i] = emerald;
        }
        return recipe;
    }
}
