package com.mattdahepic.exchangeorb.recipes.conversions;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CharcoalCoal {
    private static final int xCoal = Config.xCoal;
    private static final int charcoalPerXCoal = Config.charcoalPerXCoal;
    public CharcoalCoal() {}
    public static void registerRecipe () {
        //charcoal to coal
        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal, xCoal), getRecipeTo());
        //coal to charcoal
        GameRegistry.addShapelessRecipe(new ItemStack(Items.coal,charcoalPerXCoal,1),getRecipeFrom());
    }
    private static Object[] getRecipeTo () {
        ItemStack charcoal = new ItemStack(Items.coal,1,1);
        Object[] recipe = new Object[charcoalPerXCoal+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= charcoalPerXCoal; i++) {
            recipe[i] = charcoal;
        }
        return recipe;
    }

    private static Object[] getRecipeFrom () {
        ItemStack coal = new ItemStack(Items.coal,1,0);
        Object[] recipe = new Object[xCoal+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= xCoal; i++) {
            recipe[i] = coal;
        }
        return recipe;
    }
}
