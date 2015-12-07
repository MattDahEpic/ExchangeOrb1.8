package com.mattdahepic.exchangeorb.recipes.handler;

import com.mattdahepic.exchangeorb.recipes.ItemsList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class MusicDiskConversionRecipeHandler {
    private static ItemStack disk1 = new ItemStack(Items.record_13);
    private static ItemStack disk2 = new ItemStack(Items.record_cat);
    private static ItemStack disk3 = new ItemStack(Items.record_blocks);
    private static ItemStack disk4 = new ItemStack(Items.record_chirp);
    private static ItemStack disk5 = new ItemStack(Items.record_far);
    private static ItemStack disk6 = new ItemStack(Items.record_mall);
    private static ItemStack disk7 = new ItemStack(Items.record_mellohi);
    private static ItemStack disk8 = new ItemStack(Items.record_stal);
    private static ItemStack disk9 = new ItemStack(Items.record_strad);
    private static ItemStack disk10 = new ItemStack(Items.record_ward);
    private static ItemStack disk11 = new ItemStack(Items.record_11);
    private static ItemStack disk12 = new ItemStack(Items.record_wait);

    private static List<IRecipe> recipes = new ArrayList<IRecipe>();
    private static ItemsList i = new ItemsList();
    public static void registerRecipes () {
        GameRegistry.addRecipe(getDiskConvert(disk1,disk2));
        GameRegistry.addRecipe(getDiskConvert(disk2,disk3));
        GameRegistry.addRecipe(getDiskConvert(disk3,disk4));
        GameRegistry.addRecipe(getDiskConvert(disk4,disk5));
        GameRegistry.addRecipe(getDiskConvert(disk5,disk6));
        GameRegistry.addRecipe(getDiskConvert(disk6,disk7));
        GameRegistry.addRecipe(getDiskConvert(disk7,disk8));
        GameRegistry.addRecipe(getDiskConvert(disk8,disk9));
        GameRegistry.addRecipe(getDiskConvert(disk9,disk10));
        GameRegistry.addRecipe(getDiskConvert(disk10,disk11));
        GameRegistry.addRecipe(getDiskConvert(disk11, disk12));
        GameRegistry.addRecipe(getDiskConvert(disk12,disk1));
    }
    public static void removeRecipes () {
        for (IRecipe recipe : recipes) {
            CraftingManager.getInstance().getRecipeList().remove(recipe);
        }
    }
    private static IRecipe getDiskConvert (ItemStack oldDisk, ItemStack newDisk) {
        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(i.exchange_orb);
        input.add(oldDisk);
        recipes.add(new ShapelessRecipes(newDisk,input));
        return new ShapelessRecipes(newDisk,input);
    }
}
