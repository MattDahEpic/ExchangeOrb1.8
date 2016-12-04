package com.mattdahepic.exchangeorb.recipe;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class ResourceConversionRecipes {
    private static List<IRecipe> recipes = new ArrayList<IRecipe>();
    private static ItemsList i = new ItemsList();

    public static void add (ItemStack lowItem, ItemStack highItem, int amountLow, int amountHigh) {
        GameRegistry.addRecipe(convert(lowItem,highItem,amountLow,amountHigh)); //low to high
        GameRegistry.addRecipe(convert(highItem,lowItem,amountHigh,amountLow)); //high to low
    }
    public static void remove () {
        for (IRecipe r : recipes) {
            CraftingManager.getInstance().getRecipeList().remove(r);
        }
    }
    private static IRecipe convert (ItemStack inputItem, ItemStack outputItem, int aInput, int aOutput) {
        ItemStack output = outputItem.copy();
        output.setCount(aOutput);

        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(new ItemStack(ExchangeOrb.itemOrb,1,0));
        for (int j = 0; j < aInput; j++) {
            input.add(inputItem);
        }
        IRecipe ret = new ShapelessRecipes(output,input);
        recipes.add(ret);
        return ret;
    }
}
