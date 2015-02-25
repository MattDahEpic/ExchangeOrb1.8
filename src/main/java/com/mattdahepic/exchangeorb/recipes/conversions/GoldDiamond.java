package com.mattdahepic.exchangeorb.recipes.conversions;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GoldDiamond {
    public static final int xDiamonds = Config.xDiamonds;
    public static final int goldPerXDiamonds = Config.goldPerXDiamonds;
    public GoldDiamond() {}
    public static void registerRecipe () {
        //gold to diamond
        GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, xDiamonds), getRecipeTo());
        //diamond to gold
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot,goldPerXDiamonds),getRecipeFrom());
    }
    private static Object[] getRecipeTo () {
        ItemStack gold = new ItemStack(Items.gold_ingot,1);
        Object[] recipe = new Object[goldPerXDiamonds+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= goldPerXDiamonds; i++) {
            recipe[i] = gold;
        }
        return recipe;
    }

    private static Object[] getRecipeFrom () {
        ItemStack diamond = new ItemStack(Items.diamond,1);
        Object[] recipe = new Object[xDiamonds+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= xDiamonds; i++) {
            recipe[i] = diamond;
        }
        return recipe;
    }
}
