package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.config.MobDropConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfig;
import com.mattdahepic.exchangeorb.recipes.handler.MobDropConversionRecipeHandler;
import com.mattdahepic.exchangeorb.recipes.handler.MusicDiskConversionRecipeHandler;
import com.mattdahepic.exchangeorb.recipes.handler.OrbRecipeHandler;
import com.mattdahepic.exchangeorb.recipes.handler.ResourceConversionRecipeHandler;

public class RecipeRegisterer {
    public static void registerRecipes  () {
        ItemsList i = new ItemsList();
        //clear current recipes
        removeAllRecipes();
        //orb
        OrbRecipeHandler.registerRecipes(GeneralConfig.orbHardMode);
        //add resources
        if (GeneralConfig.enableResources) {
            ResourceConversionRecipeHandler.registerRecipes(i.charcoal, i.coal, ResourceConfig.charcoal_coalLow, ResourceConfig.charcoal_coalHigh);
            ResourceConversionRecipeHandler.registerRecipes(i.coal, i.iron, ResourceConfig.coal_ironLow, ResourceConfig.coal_ironHigh);
            ResourceConversionRecipeHandler.registerRecipes(i.iron, i.redstone, ResourceConfig.iron_redstoneLow, ResourceConfig.iron_redstoneHigh);
            ResourceConversionRecipeHandler.registerRecipes(i.redstone, i.lapis, ResourceConfig.redstone_lapisLow, ResourceConfig.redstone_lapisHigh);
            ResourceConversionRecipeHandler.registerRecipes(i.lapis, i.gold, ResourceConfig.lapis_goldLow, ResourceConfig.lapis_goldHigh);
            ResourceConversionRecipeHandler.registerRecipes(i.gold, i.diamond, ResourceConfig.gold_diamondLow, ResourceConfig.gold_diamondHigh);
            ResourceConversionRecipeHandler.registerRecipes(i.diamond, i.emerald, ResourceConfig.diamond_emeraldLow, ResourceConfig.diamond_emeraldHigh);
        }
        //add mob drops
        if (GeneralConfig.enableMobDrops) {
            MobDropConversionRecipeHandler.registerRecipes(i.blaze_rod,MobDropConfig.ess_BlazeRod);
            MobDropConversionRecipeHandler.registerRecipes(i.string,MobDropConfig.ess_String);
            MobDropConversionRecipeHandler.registerRecipes(i.spider_eye,MobDropConfig.ess_SpiderEye);
            MobDropConversionRecipeHandler.registerRecipes(i.gunpowder,MobDropConfig.ess_Gunpowder);
            MobDropConversionRecipeHandler.registerRecipes(i.ender_pearl,MobDropConfig.ess_EnderPearl);
            MobDropConversionRecipeHandler.registerRecipes(i.ghast_tear,MobDropConfig.ess_GhastTear);
            MobDropConversionRecipeHandler.registerRecipes(i.magma_cream,MobDropConfig.ess_MagmaCream);
            MobDropConversionRecipeHandler.registerRecipes(i.arrow,MobDropConfig.ess_Arrow);
            MobDropConversionRecipeHandler.registerRecipes(i.bone,MobDropConfig.ess_Bone);
            MobDropConversionRecipeHandler.registerRecipes(i.slime_ball,MobDropConfig.ess_SlimeBall);
            MobDropConversionRecipeHandler.registerRecipes(i.rotten_flesh,MobDropConfig.ess_RottenFlesh);
            MobDropConversionRecipeHandler.registerRecipes(i.pris_crystal,MobDropConfig.ess_PrisCrystal);
            MobDropConversionRecipeHandler.registerRecipes(i.pris_shard,MobDropConfig.ess_PrisShard);
            if (MobDropConfig.convertSponges) MobDropConversionRecipeHandler.registerRecipes(i.sponge,MobDropConfig.ess_Sponge);
            if (MobDropConfig.convertWitherSkulls) MobDropConversionRecipeHandler.registerRecipes(i.wither_skull,MobDropConfig.ess_WitherSkull);
            if (MobDropConfig.convertMusicDisks) MusicDiskConversionRecipeHandler.registerRecipes();
            if (MobDropConfig.convertWitchDrops) {
                MobDropConversionRecipeHandler.registerRecipes(i.glass_bottle,MobDropConfig.ess_GlassBottle);
                MobDropConversionRecipeHandler.registerRecipes(i.glowstone_dust,MobDropConfig.ess_GlowstoneDust);
                MobDropConversionRecipeHandler.registerRecipes(i.redstone,MobDropConfig.ess_RedstoneDust);
                MobDropConversionRecipeHandler.registerRecipes(i.stick,MobDropConfig.ess_Stick);
                MobDropConversionRecipeHandler.registerRecipes(i.sugar,MobDropConfig.ess_Sugar);
            }
        }
    }
    public static void removeAllRecipes () {
        OrbRecipeHandler.removeRecipe();
        ResourceConversionRecipeHandler.removeAllResoruceRecipes();
        MobDropConversionRecipeHandler.removeAllMobDropRecipes();
        MusicDiskConversionRecipeHandler.removeRecipes();
    }
}
