package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.mdecore.config.sync.Config;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;


public class ResourceConfig extends ConfigSyncable {
    public String getConfigVersion () {return "1";}
    public String getConfigName () {return ExchangeOrb.MODID+"-resources";}
    public Class getConfigClass () {return getClass();}

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

    @Config(cat = "charcoal_coal",comment = "The amount of charcoal involved in the charcoal/coal conversion.", range = @Config.Range(min = 1,max = 8)) public static int charcoal_coalLow = 4;
    @Config(cat = "charcoal_coal",comment = "The amount of coal involved in the charcoal/coal conversion.",range = @Config.Range(min = 1,max = 8)) public static int charcoal_coalHigh = 1;

    @Config(cat = "coal_iron",comment = "The amount of coal involved in the coal/iron conversion.",range = @Config.Range(min = 1,max = 8)) public static int coal_ironLow = 8;
    @Config(cat = "coal_iron",comment = "The amount of iron involved in the coal/iron conversion.",range = @Config.Range(min = 1,max = 8)) public static int coal_ironHigh = 2;

    @Config(cat = "iron_redstone",comment = "The amount of iron involved in the iron/redstone conversion.",range = @Config.Range(min = 1,max = 8)) public static int iron_redstoneLow = 1;
    @Config(cat = "iron_redstone",comment = "The amount of redstone involved in the iron/redstone conversion.",range = @Config.Range(min = 1,max = 8)) public static int iron_redstoneHigh = 8;

    @Config(cat = "redstone_lapis",comment = "The amount of redstone involved in the redstone/lapis conversion.",range = @Config.Range(min = 1,max = 8)) public static int redstone_lapisLow = 4;
    @Config(cat = "redstone_lapis",comment = "The amount of lapis involved in the redstone/lapis conversion.",range = @Config.Range(min = 1,max = 8)) public static int redstone_lapisHigh = 2;

    @Config(cat = "lapis_gold",comment = "The amount of lapis involved in the lapis/gold conversion.",range = @Config.Range(min = 1,max = 8)) public static int lapis_goldLow = 4;
    @Config(cat = "lapis_gold",comment = "The amount of gold involved in the lapis/gold conversion.",range = @Config.Range(min = 1,max = 8)) public static int lapis_goldHigh = 1;

    @Config(cat = "gold_diamond",comment = "The amount of gold involved in the gold/diamond conversion.",range = @Config.Range(min = 1,max = 8)) public static int gold_diamondLow = 3;
    @Config(cat = "gold_diamond",comment = "The amount of diamond involved in the gold/diamond conversion.",range = @Config.Range(min = 1,max = 8)) public static int gold_diamondHigh = 1;

    @Config(cat = "diamond_emerald",comment = "The amount of diamond involved in the diamond/emerald conversion.",range = @Config.Range(min = 1,max = 8)) public static int diamond_emeraldLow = 2;
    @Config(cat = "diamond_emerald",comment = "The amount of emerald involved in the diamond/emerald conversion.",range = @Config.Range(min = 1,max = 8)) public static int diamond_emeraldHigh = 1;
}
