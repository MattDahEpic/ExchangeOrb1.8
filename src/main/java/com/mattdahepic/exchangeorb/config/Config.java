package com.mattdahepic.exchangeorb.config;

//based on EnderIO

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;


public class Config {
    //defaults
    public static int charcoalPerXCoal = 4;
    public static int xCoal = 1;
    public static int diamondsPerXEmeralds = 2;
    public static int xEmeralds = 1;
    public static int goldPerXDiamonds = 4;
    public static int xDiamonds = 1;
    public static int goldPerXLapis = 2;
    public static int xLapis = 8;
    public static int ironPerXGold = 8;
    public static int xGold = 1;
    public static int ironPerXRedstone = 1;
    public static int xRedstone = 8;
    public static boolean orbHasDurability = false;
    public static int orbDurability = 200;

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
    public static void processConfig(Configuration config) {
        charcoalPerXCoal = config.get(Configuration.CATEGORY_GENERAL,"charcoalPerXCoal",charcoalPerXCoal,"Amount of charcoals to be the amount of coal defined in xCoal",1,8).getInt(charcoalPerXCoal);
        xCoal = config.get(Configuration.CATEGORY_GENERAL,"xCoal",xCoal,"Amount of coal to be per the amount of charcoal defined in charcoalPerXCoal",1,8).getInt(xCoal);
        diamondsPerXEmeralds = config.get(Configuration.CATEGORY_GENERAL,"diamondsPerEmerald",diamondsPerXEmeralds,"Amount of diamonds to be the amount of emeralds defined in xEmeralds",1,8).getInt(diamondsPerXEmeralds);
        xEmeralds = config.get(Configuration.CATEGORY_GENERAL,"xEmeralds",xEmeralds,"Amount of emeralds to be per the amount of diamonds defined in diamondsPerXEmeralds",1,8).getInt(xEmeralds);
        goldPerXDiamonds = config.get(Configuration.CATEGORY_GENERAL,"goldPerDiamond",goldPerXDiamonds,"Amount of golds to be the amount of diamonds specified in xDiamonds",1,8).getInt(goldPerXDiamonds);
        xDiamonds  = config.get(Configuration.CATEGORY_GENERAL,"xDiamonds",xDiamonds,"Amount of diamonds per amount of golds specified in goldPerXDiamonds",1,8).getInt(xDiamonds);
        goldPerXLapis = config.get(Configuration.CATEGORY_GENERAL,"goldperXLapis",goldPerXLapis,"Amount of golds to be the amount of lapis defined in xLapis",1,8).getInt(goldPerXLapis);
        xLapis = config.get(Configuration.CATEGORY_GENERAL,"xLapis",xLapis,"Amount of lapis to be for the amount of gold defined in goldPerXLapis",1,8).getInt(xLapis);
        ironPerXGold = config.get(Configuration.CATEGORY_GENERAL,"ironPerXGold",ironPerXGold,"Iron to be the amount of gold specified in xGold",1,8).getInt(ironPerXGold);
        xGold = config.get(Configuration.CATEGORY_GENERAL,"xGold",xGold,"Amount of gold to be the amount of iron specified in ironPerXGold",1,8).getInt(xGold);
        ironPerXRedstone = config.get(Configuration.CATEGORY_GENERAL,"ironPerXRedstone",ironPerXRedstone,"Iron to be the amount of redstone specified in xRedstone",1,8).getInt(ironPerXRedstone);
        xRedstone = config.get(Configuration.CATEGORY_GENERAL,"xRedstone",xRedstone,"Redstone per the amount of iron specified in ironPerXRedstone",1,8).getInt(xRedstone);
        orbHasDurability = config.getBoolean("orbHasDurability",Configuration.CATEGORY_GENERAL,orbHasDurability,"If this value is true, the Exchange Orb will have limited uses. You must set a number or uses in orbDurability");
        orbDurability = config.getInt("orbDurability",Configuration.CATEGORY_GENERAL,orbDurability,1,999,"The number of uses an Exchange Orb has. orbHasDurability must be true for this to do anything");
    }
    private Config() {}
}
