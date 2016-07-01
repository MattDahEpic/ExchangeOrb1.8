package com.mattdahepic.exchangeorb.recipe;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class MobDropConversionRecipes {
    private static List<IRecipe> recipes = new ArrayList<IRecipe>();
    private static ItemsList i = new ItemsList();

    public static void add (ItemStack item, int worth) {
        GameRegistry.addRecipe(decompose(item,worth));
        GameRegistry.addRecipe(create(item,worth));
    }
    public static void remove () {
        for (IRecipe r : recipes) {
            CraftingManager.getInstance().getRecipeList().remove(r);
        }
    }
    private static IRecipe decompose (ItemStack item, int worth) {
        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(item);
        input.add(new ItemStack(ExchangeOrb.itemOrb,1,1));
        IRecipe ret = new ShapelessRecipes(new ItemStack(ExchangeOrb.itemEssence,worth,0),input);
        recipes.add(ret);
        return ret;
    }
    private static IRecipe create (ItemStack item ,int worth) {
        ItemStack output = item.copy();
        output.stackSize = 2;
        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(new ItemStack(ExchangeOrb.itemOrb,1,1));
        input.add(item.copy());
        for (int j = 0; j < worth; j++) {
            input.add(new ItemStack(ExchangeOrb.itemEssence,1,0));
        }
        IRecipe ret = new ShapelessRecipes(output,input);
        recipes.add(ret);
        return ret;
    }
}
