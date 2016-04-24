package com.mattdahepic.exchangeorb.recipe;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class MusicDiskConversionRecipes {
    private static ItemStack disk1 = new ItemStack(Items.RECORD_13);
    private static ItemStack disk2 = new ItemStack(Items.RECORD_CAT);
    private static ItemStack disk3 = new ItemStack(Items.RECORD_BLOCKS);
    private static ItemStack disk4 = new ItemStack(Items.RECORD_CHIRP);
    private static ItemStack disk5 = new ItemStack(Items.RECORD_FAR);
    private static ItemStack disk6 = new ItemStack(Items.RECORD_MALL);
    private static ItemStack disk7 = new ItemStack(Items.RECORD_MELLOHI);
    private static ItemStack disk8 = new ItemStack(Items.RECORD_STAL);
    private static ItemStack disk9 = new ItemStack(Items.RECORD_STRAD);
    private static ItemStack disk10 = new ItemStack(Items.RECORD_WARD);
    private static ItemStack disk11 = new ItemStack(Items.RECORD_11);
    private static ItemStack disk12 = new ItemStack(Items.RECORD_WAIT);

    private static List<IRecipe> recipes = new ArrayList<IRecipe>();
    public static void add () {
        GameRegistry.addRecipe(convert(disk1,disk2));
        GameRegistry.addRecipe(convert(disk2,disk3));
        GameRegistry.addRecipe(convert(disk3,disk4));
        GameRegistry.addRecipe(convert(disk4,disk5));
        GameRegistry.addRecipe(convert(disk5,disk6));
        GameRegistry.addRecipe(convert(disk6,disk7));
        GameRegistry.addRecipe(convert(disk7,disk8));
        GameRegistry.addRecipe(convert(disk8,disk9));
        GameRegistry.addRecipe(convert(disk9,disk10));
        GameRegistry.addRecipe(convert(disk10,disk11));
        GameRegistry.addRecipe(convert(disk11, disk12));
        GameRegistry.addRecipe(convert(disk12,disk1));
    }
    public static void remove () {
        for (IRecipe r : recipes) {
            CraftingManager.getInstance().getRecipeList().remove(r);
        }
    }
    private static IRecipe convert (ItemStack oldDisk, ItemStack newDisk) {
        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(new ItemStack(ExchangeOrb.itemOrb,1,1));
        input.add(oldDisk);
        IRecipe ret = new ShapelessRecipes(newDisk,input);
        recipes.add(ret);
        return ret;
    }
}
