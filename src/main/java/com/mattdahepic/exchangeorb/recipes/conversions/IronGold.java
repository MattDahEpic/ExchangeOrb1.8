package com.mattdahepic.exchangeorb.recipes.conversions;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class IronGold {
    public static final int xGold = Config.xGold;
    public static final int ironPerXGold = Config.ironPerXGold;
    public IronGold() {}
    public static void registerRecipe () {
        //iron to gold
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, xGold), getRecipeTo());
        //gold to iron
        GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot,ironPerXGold),getRecipeFrom());
    }
    private static Object[] getRecipeTo () {
        ItemStack iron = new ItemStack(Items.iron_ingot,1);
        Object[] recipe = new Object[ironPerXGold+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= ironPerXGold; i++) {
            recipe[i] = iron;
        }
        return recipe;
    }

    private static Object[] getRecipeFrom () {
        ItemStack gold = new ItemStack(Items.gold_ingot,1);
        Object[] recipe = new Object[xGold+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= xGold; i++) {
            recipe[i] = gold;
        }
        return recipe;
    }
}
