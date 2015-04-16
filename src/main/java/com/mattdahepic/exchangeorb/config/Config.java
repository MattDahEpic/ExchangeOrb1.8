package com.mattdahepic.exchangeorb.config;

//based on EnderIO

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;


public class Config {
    /*
    charcoal
    coal
    iron
    redstone
    lapis
    gold
    diamond
    emerald
     */

    //defaults
    public static final int MIN = 1;
    public static final int MAX = 8;

    public static final String CATEGORY_CHARCOAL_COAL = "charcoal_coal";
    public static int charcoalCoal_Charcoal = 4;
    public static int charcoalCoal_Coal = 1;

    public static final String CATEGORY_COAL_IRON = "coal_iron";
    public static int coalIron_Coal = 4;
    public static int coalIron_Iron = 1;

    public static final String CATEGORY_IRON_REDSTONE = "iron_redstone";
    public static int ironRedstone_Iron = 1;
    public static int ironRedstone_Redstone = 8;

    public static final String CATEGORY_REDSTONE_LAPIS = "redstone_lapis";
    public static int redstoneLapis_Redstone = 4;
    public static int redstoneLapis_Lapis = 2;

    public static final String CATEGORY_LAPIS_GOLD = "lapis_gold";
    public static int lapisGold_Lapis = 4;
    public static int lapisGold_Gold = 1;

    public static final String CATEGORY_GOLD_DIAMOND = "gold_diamond";
    public static int goldDiamond_Gold = 3;
    public static int goldDiamond_Diamond = 1;

    public static final String CATEGORY_DIAMOND_EMERALD = "diamond_emerald";
    public static int diamondEmerald_Diamond = 2;
    public static int diamondEmerald_Emerald = 1;

    public static String CATEGORY_ORB = "orb";
    public static boolean orbHasDurability = false;
    public static int orbDurability = 200;
    public static boolean orbHardMode = false;

    public static void load(FMLPreInitializationEvent event) {
        ExchangeOrb.configFile = new Configuration(event.getSuggestedConfigurationFile());
        syncConfig();
    }
    public static void syncConfig() {
        try {
            Config.processConfig(ExchangeOrb.configFile);
        } catch (Exception e) {
            System.out.println("[ExchangeOrb] Error loading config!");
        } finally {
            if (ExchangeOrb.configFile.hasChanged()) {
                ExchangeOrb.configFile.save();
            }
        }
    }
    @SubscribeEvent
    public void onConfigChanged (ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(ExchangeOrb.MODID)) {
            System.out.println("Updating config...");
            syncConfig();
        }
    }
    public static void processConfig(Configuration c) {
        charcoalCoal_Charcoal = c.getInt("charcoalCoal_Charcoal",CATEGORY_CHARCOAL_COAL,charcoalCoal_Charcoal, MIN, MAX,"Amount of coal involved in the charcoal/coal conversion.");
        charcoalCoal_Coal = c.getInt("charcoalCoal_Coal",CATEGORY_CHARCOAL_COAL,charcoalCoal_Coal, MIN, MAX,"Amount of coal involved in the charcoal/coal conversion.");
        coalIron_Coal = c.getInt("coalIron_Coal",CATEGORY_COAL_IRON,coalIron_Coal, MIN, MAX,"Amount of coal involved in the coal/iron conversion.");
        coalIron_Iron = c.getInt("coalIron_Iron",CATEGORY_COAL_IRON,coalIron_Iron, MIN, MAX,"Amount of iron involved in the coal/iron conversion.");
        ironRedstone_Iron = c.getInt("ironRedstone_Iron",CATEGORY_IRON_REDSTONE,ironRedstone_Iron, MIN, MAX,"Amount of iron involved in the iron/redstone conversion.");
        ironRedstone_Redstone = c.getInt("ironRedstone_Redstone",CATEGORY_IRON_REDSTONE,ironRedstone_Redstone, MIN, MAX,"Amount of redstone involved in the iron/redstone conversion.");
        redstoneLapis_Redstone = c.getInt("redstoneLapis_Redstone",CATEGORY_REDSTONE_LAPIS,redstoneLapis_Redstone, MIN, MAX,"Amount of redstone involved in the redstone/lapis conversion.");
        redstoneLapis_Lapis = c.getInt("redstoneLapis_Lapis",CATEGORY_REDSTONE_LAPIS,redstoneLapis_Lapis, MIN, MAX,"Amount of lapis involved in the redstone/lapis conversion.");
        lapisGold_Lapis = c.getInt("lapisGold_Lapis",CATEGORY_LAPIS_GOLD,lapisGold_Lapis, MIN, MAX,"Amount of lapis involved in the lapis/gold conversion.");
        lapisGold_Gold = c.getInt("lapisGold_Gold",CATEGORY_LAPIS_GOLD,lapisGold_Gold, MIN, MAX,"Amount of gold involved in the lapis/gold conversion.");
        goldDiamond_Gold = c.getInt("goldDiamond_Gold",CATEGORY_GOLD_DIAMOND,goldDiamond_Gold, MIN, MAX,"Amount of gold involved in the gold/diamond conversion.");
        goldDiamond_Diamond = c.getInt("goldDiamond_Diamond",CATEGORY_GOLD_DIAMOND,goldDiamond_Diamond, MIN, MAX,"Amount of diamonds involved in the gold/diamond conversion.");
        diamondEmerald_Diamond = c.getInt("diamondEmerald_Diamond",CATEGORY_DIAMOND_EMERALD,diamondEmerald_Diamond, MIN, MAX,"Amount of diamonds involved in the diamond/emerald conversion.");
        diamondEmerald_Emerald = c.getInt("diamondEmerald_Emerald",CATEGORY_DIAMOND_EMERALD,diamondEmerald_Emerald, MIN, MAX,"Amount of emeralds involved in the diamond/emerald conversion.");
        orbHasDurability = c.getBoolean("orbHasDurability", CATEGORY_ORB,orbHasDurability,"Does the Exchange Orb have a limited amount of uses? Set the amount of uses in orbDurability.");
        orbDurability = c.getInt("orbDurability", CATEGORY_ORB,orbDurability,1,999,"Amount of uses the exchange orb has, if durability is enabled.");
        orbHardMode = c.getBoolean("orbHardMode",CATEGORY_ORB,orbHardMode,"Should the orb require a nether star to create instead of a stone block?");
    }
    private Config() {}
}
