package com.mattdahepic.exchangeorb.recipe;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.GeneralConfig;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class OrbRecipes {
    private static List<IRecipe> recipes = new ArrayList<IRecipe>();
    private static ItemsList i = new ItemsList();

    public static void add (boolean hard) {
        if (GeneralConfig.enableResourceOrb) GameRegistry.addRecipe(resource(hard));
        if (GeneralConfig.enableMobDropOrb) GameRegistry.addRecipe(mobdrop(hard));
        if (GeneralConfig.enableDisenchantOrb) GameRegistry.addRecipe(disenchant());
    }
    public static void remove () {
        for (IRecipe r : recipes) {
            CraftingManager.getInstance().getRecipeList().remove(r);
        }
    }

    private static IRecipe resource (boolean hard) {
        ItemStack[] r = new ItemStack[9];
        r[0] = i.charcoal;
        r[1] = i.coal;
        r[2] = i.iron;
        r[3] = i.redstone;
        r[4] = hard ? i.nether_star : i.stone;
        r[5] = i.lapis;
        r[6] = i.gold;
        r[7] = i.diamond;
        r[8] = i.emerald;
        IRecipe ret = new ShapedRecipes(3,3,r,new ItemStack(ExchangeOrb.itemOrb,1,0));
        recipes.add(ret);
        return ret;
    }
    private static IRecipe mobdrop (boolean hard) {
        ItemStack[] r = new ItemStack[9];
        r[0] = i.string;
        r[1] = i.bone;
        r[2] = i.blaze_rod;
        r[3] = i.gunpowder;
        r[4] = hard ? i.nether_star : i.stone;
        r[5] = i.arrow;
        r[6] = i.rotten_flesh;
        r[7] = i.slime_ball;
        r[8] = i.sugar;
        IRecipe ret = new ShapedRecipes(3,3,r,new ItemStack(ExchangeOrb.itemOrb,1,1));
        recipes.add(ret);
        return ret;
    }
    private static IRecipe disenchant () {
        List<ItemStack> r = new ArrayList<ItemStack>();
        r.add(new ItemStack(ExchangeOrb.itemOrb,1,0));
        r.add(new ItemStack(ExchangeOrb.itemOrb,1,1));
        r.add(new ItemStack(Items.ENCHANTED_BOOK,1,0));
        IRecipe ret = new ShapelessRecipes(new ItemStack(ExchangeOrb.itemOrb,1,2),r);
        recipes.add(ret);
        return ret;
    }
}
