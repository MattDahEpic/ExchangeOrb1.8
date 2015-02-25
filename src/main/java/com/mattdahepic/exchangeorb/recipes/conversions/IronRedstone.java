package com.mattdahepic.exchangeorb.recipes.conversions;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class IronRedstone {
    public static final int xRedstone = Config.xRedstone;
    public static final int ironPerXRedstone = Config.ironPerXRedstone;
    public IronRedstone() {}
    public static void registerRecipe () {
        //iron to redstone
        GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone, xRedstone), getRecipeTo());
        //redstone to iron
        GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot,ironPerXRedstone),getRecipeFrom());
    }
    private static Object[] getRecipeTo () {
        ItemStack iron = new ItemStack(Items.iron_ingot,1);
        Object[] recipe = new Object[ironPerXRedstone+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= ironPerXRedstone; i++) {
            recipe[i] = iron;
        }
        return recipe;
    }

    private static Object[] getRecipeFrom () {
        ItemStack redstone = new ItemStack(Items.redstone,1);
        Object[] recipe = new Object[xRedstone+1];
        recipe[0] = new ItemStack(ExchangeOrb.itemExchangeOrb.setContainerItem(ExchangeOrb.itemExchangeOrb),1,32767);
        for (int i = 1; i <= xRedstone; i++) {
            recipe[i] = redstone;
        }
        return recipe;
    }
}
