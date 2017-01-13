package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.config.MobDropConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfig;
import com.mattdahepic.exchangeorb.recipe.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenders() {}
    public void registerItems() {
        GameRegistry.register(ExchangeOrb.itemOrb);
        if (GeneralConfig.enableMobDropOrb) GameRegistry.register(ExchangeOrb.itemEssence);
    }
    public void registerRecipes () {
        ItemsList i = new ItemsList();
        //Register Recipe Types
        //TODO: RecipeSorter.register("exchangeorb:disenchant",DisenchantRecipe.class, RecipeSorter.Category.SHAPELESS,"after:minecraft:shapeless");
        //orb
        OrbRecipes.remove();
        OrbRecipes.add(GeneralConfig.orbHardMode);
        //resources
        ResourceConversionRecipes.remove();
        if (GeneralConfig.enableResourceOrb) {
            //sanity check, just for you Resonant Rise
            if (ResourceConfig.charcoal_coalHigh == ResourceConfig.coal_ironLow) throw new RuntimeException("INVALID RESOURCE ORB CONFIGURATION: coal");
            if (ResourceConfig.coal_ironHigh == ResourceConfig.iron_redstoneLow) throw new RuntimeException("INVALID RESOURCE ORB CONFIGURATION: iron");
            if (ResourceConfig.iron_redstoneHigh == ResourceConfig.redstone_lapisLow) throw new RuntimeException("INVALID RESOURCE ORB CONFIGURATION: redstone");
            if (ResourceConfig.redstone_lapisHigh == ResourceConfig.lapis_goldLow) throw new RuntimeException("INVALID RESOURCE ORB CONFIGURATION: lapis");
            if (ResourceConfig.lapis_goldHigh == ResourceConfig.gold_diamondLow) throw new RuntimeException("INVALID RESOURCE ORB CONFIGURATION: gold");
            if (ResourceConfig.gold_diamondHigh == ResourceConfig.diamond_emeraldLow) throw new RuntimeException("INVALID RESOURCE ORB CONFIGURATION: diamond");
            //recipes
            ResourceConversionRecipes.add(i.charcoal, i.coal, ResourceConfig.charcoal_coalLow, ResourceConfig.charcoal_coalHigh);
            ResourceConversionRecipes.add(i.coal, i.iron, ResourceConfig.coal_ironLow, ResourceConfig.coal_ironHigh);
            ResourceConversionRecipes.add(i.iron, i.redstone, ResourceConfig.iron_redstoneLow, ResourceConfig.iron_redstoneHigh);
            ResourceConversionRecipes.add(i.redstone, i.lapis, ResourceConfig.redstone_lapisLow, ResourceConfig.redstone_lapisHigh);
            ResourceConversionRecipes.add(i.lapis, i.gold, ResourceConfig.lapis_goldLow, ResourceConfig.lapis_goldHigh);
            ResourceConversionRecipes.add(i.gold, i.diamond, ResourceConfig.gold_diamondLow, ResourceConfig.gold_diamondHigh);
            ResourceConversionRecipes.add(i.diamond, i.emerald, ResourceConfig.diamond_emeraldLow, ResourceConfig.diamond_emeraldHigh);
        }
        //mob drops
        MobDropConversionRecipes.remove();
        MusicDiskConversionRecipes.remove();
        if (GeneralConfig.enableMobDropOrb) {
            MobDropConversionRecipes.add(i.blaze_rod,MobDropConfig.ess_BlazeRod);
            MobDropConversionRecipes.add(i.string,MobDropConfig.ess_String);
            MobDropConversionRecipes.add(i.spider_eye,MobDropConfig.ess_SpiderEye);
            MobDropConversionRecipes.add(i.gunpowder,MobDropConfig.ess_Gunpowder);
            MobDropConversionRecipes.add(i.ender_pearl,MobDropConfig.ess_EnderPearl);
            MobDropConversionRecipes.add(i.ghast_tear,MobDropConfig.ess_GhastTear);
            MobDropConversionRecipes.add(i.magma_cream,MobDropConfig.ess_MagmaCream);
            MobDropConversionRecipes.add(i.arrow,MobDropConfig.ess_Arrow);
            MobDropConversionRecipes.add(i.bone,MobDropConfig.ess_Bone);
            MobDropConversionRecipes.add(i.slime_ball,MobDropConfig.ess_SlimeBall);
            MobDropConversionRecipes.add(i.rotten_flesh,MobDropConfig.ess_RottenFlesh);
            MobDropConversionRecipes.add(i.pris_crystal,MobDropConfig.ess_PrisCrystal);
            MobDropConversionRecipes.add(i.pris_shard, MobDropConfig.ess_PrisShard);
            if (MobDropConfig.convertSponges) MobDropConversionRecipes.add(i.sponge,MobDropConfig.ess_Sponge);
            if (MobDropConfig.convertMusicDisks) MusicDiskConversionRecipes.add();
            if (MobDropConfig.convertWitchDrops) {
                MobDropConversionRecipes.add(i.glass_bottle,MobDropConfig.ess_GlassBottle);
                MobDropConversionRecipes.add(i.glowstone_dust,MobDropConfig.ess_GlowstoneDust);
                MobDropConversionRecipes.add(i.redstone,MobDropConfig.ess_RedstoneDust);
                MobDropConversionRecipes.add(i.stick,MobDropConfig.ess_Stick);
                MobDropConversionRecipes.add(i.sugar,MobDropConfig.ess_Sugar);
            }
        }
        //disenchanting
        //TODO: CraftingManager.getInstance().getRecipeList().remove(new DisenchantRecipe());
        //TODO: GameRegistry.addRecipe(new DisenchantRecipe());
    }
}
