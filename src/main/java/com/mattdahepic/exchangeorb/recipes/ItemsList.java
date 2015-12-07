package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemsList {
    public final ItemStack exchange_orb = new ItemStack(ExchangeOrb.itemExchangeOrb,1, OreDictionary.WILDCARD_VALUE);
    public final ItemStack mob_essence = new ItemStack(ExchangeOrb.itemMobEssence,1);
    //resources
    public final ItemStack charcoal = new ItemStack(Items.coal,1,1);
    public final ItemStack coal = new ItemStack(Items.coal,1);
    public final ItemStack iron = new ItemStack(Items.iron_ingot,1);
    public final ItemStack redstone = new ItemStack(Items.redstone,1);
    public final ItemStack lapis = new ItemStack(Items.dye,1,4);
    public final ItemStack gold = new ItemStack(Items.gold_ingot,1);
    public final ItemStack diamond = new ItemStack(Items.diamond,1);
    public final ItemStack emerald = new ItemStack(Items.emerald,1);
    //crafting ingredients
    public final ItemStack nether_star = new ItemStack(Items.nether_star,1);
    public final ItemStack stone = new ItemStack(Blocks.stone,1);
    //mob drops
    public final ItemStack blaze_rod = new ItemStack(Items.blaze_rod,1);
    public final ItemStack string = new ItemStack(Items.string,1);
    public final ItemStack spider_eye = new ItemStack(Items.spider_eye,1);
    public final ItemStack gunpowder = new ItemStack(Items.gunpowder,1);
    public final ItemStack ender_pearl = new ItemStack(Items.ender_pearl,1);
    public final ItemStack ghast_tear = new ItemStack(Items.ghast_tear,1);
    public final ItemStack magma_cream = new ItemStack(Items.magma_cream,1);
    public final ItemStack arrow = new ItemStack(Items.arrow,1);
    public final ItemStack bone = new ItemStack(Items.bone,1);
    public final ItemStack slime_ball = new ItemStack(Items.slime_ball,1);
    public final ItemStack rotten_flesh = new ItemStack(Items.rotten_flesh,1);
    public final ItemStack pris_crystal = new ItemStack(Items.prismarine_crystals,1);
    public final ItemStack pris_shard = new ItemStack(Items.prismarine_shard,1);
    public final ItemStack sponge = new ItemStack(Blocks.sponge,1);
    public final ItemStack wither_skull = new ItemStack(Blocks.skull,1,1);

    public final ItemStack glass_bottle = new ItemStack(Items.glass_bottle,1);
    public final ItemStack glowstone_dust = new ItemStack(Items.glowstone_dust,1);
    public final ItemStack stick = new ItemStack(Items.stick,1);
    public final ItemStack sugar = new ItemStack(Items.sugar,1);
}
