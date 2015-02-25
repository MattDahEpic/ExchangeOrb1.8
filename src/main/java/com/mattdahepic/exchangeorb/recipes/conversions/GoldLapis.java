package com.mattdahepic.exchangeorb.recipes.conversions;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GoldLapis {
    public static final int xLapis = Config.xLapis;
    public static final int goldPerXLapis = Config.goldPerXLapis;
    public GoldLapis () {}
    public static void registerRecipes () {
        //gold to lapis
        GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, xLapis, 4), getRecipeTo());
        //lapis to gold
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot,goldPerXLapis), getRecipeFrom());
    }

    private static Object[] getRecipeTo() {
        ItemStack gold = new ItemStack(Items.gold_ingot,1);
        Object[] recipe = new Object[goldPerXLapis+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= goldPerXLapis; i++) {
            recipe[i] = gold;
        }
        return recipe;
    }

    private static Object[] getRecipeFrom() {
        ItemStack lapis = new ItemStack(Items.dye,1,4);
        Object[] recipe = new Object[xLapis+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= xLapis; i++) {
            recipe[i] = lapis;
        }
        return recipe;
    }
}
