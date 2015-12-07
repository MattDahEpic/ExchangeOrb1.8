package com.mattdahepic.exchangeorb.recipes.handler;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.recipes.ItemsList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class MobDropConversionRecipeHandler {
    private static List<IRecipe> recipes = new ArrayList<IRecipe>();
    private static ItemsList i = new ItemsList();
    public static void registerRecipes (ItemStack mobDrop, int dropWorth) {
        GameRegistry.addRecipe(decompose(mobDrop,dropWorth));
        GameRegistry.addRecipe(create(mobDrop,dropWorth));
    }
    public static void removeAllMobDropRecipes () {
        for (IRecipe recipe : recipes) {
            CraftingManager.getInstance().getRecipeList().remove(recipe);
        }
    }
    private static IRecipe decompose (ItemStack mobDrop,int dropWorth) {
        ItemStack output = new ItemStack(ExchangeOrb.itemMobEssence,dropWorth);
        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(i.exchange_orb);
        input.add(mobDrop);
        recipes.add(new ShapelessRecipes(output,input));
        return new ShapelessRecipes(output,input);
    }
    private static IRecipe create (ItemStack mobDrop,int dropWorth) {
        ItemStack output = new ItemStack(mobDrop.getItem(),2,mobDrop.getMetadata());
        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(mobDrop);
        for (int j = 0; j < dropWorth; j++) {
            input.add(i.mob_essence);
        }
        recipes.add(new ShapelessRecipes(output,input));
        return new ShapelessRecipes(output,input);
    }
}
