package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.mdecore.config.annot.Comment;
import com.mattdahepic.mdecore.config.annot.Config;
import com.mattdahepic.mdecore.config.annot.Range;
import com.mattdahepic.mdecore.config.sync.ConfigProcessor;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;


public class ResourceConfig extends ConfigSyncable {
    @Config("charcoal_coal") @Comment({"The amount of charcoal involved in the charcoal/coal conversion."}) @Range(min = 1,max = 8) public static int charcoal_coalLow = 4;
    @Config("charcoal_coal") @Comment({"The amount of coal involved in the charcoal/coal conversion."}) @Range(min = 1,max = 8) public static int charcoal_coalHigh = 1;

    @Config("coal_iron") @Comment({"The amount of coal involved in the coal/iron conversion."}) @Range(min = 1,max = 8) public static int coal_ironLow = 4;
    @Config("coal_iron") @Comment({"The amount of iron involved in the coal/iron conversion."}) @Range(min = 1,max = 8) public static int coal_ironHigh = 1;

    @Config("iron_redstone") @Comment({"The amount of iron involved in the iron/redstone conversion."}) @Range(min = 1,max = 8) public static int iron_redstoneLow = 1;
    @Config("iron_redstone") @Comment({"The amount of redstone involved in the iron/redstone conversion."}) @Range(min = 1,max = 8) public static int iron_redstoneHigh = 8;

    @Config("redstone_lapis") @Comment({"The amount of redstone involved in the redstone/lapis conversion."}) @Range(min = 1,max = 8) public static int redstone_lapisLow = 4;
    @Config("redstone_lapis") @Comment({"The amount of lapis involved in the redstone/lapis conversion."}) @Range(min = 1,max = 8) public static int redstone_lapisHigh = 2;

    @Config("lapis_gold") @Comment({"The amount of lapis involved in the lapis/gold conversion."}) @Range(min = 1,max = 8) public static int lapis_goldLow = 4;
    @Config("lapis_gold") @Comment({"The amount of gold involved in the lapis/gold conversion."}) @Range(min = 1,max = 8) public static int lapis_goldHigh = 1;

    @Config("gold_diamond") @Comment({"The amount of gold involved in the gold/diamond conversion."}) @Range(min = 1,max = 8) public static int gold_diamondLow = 3;
    @Config("gold_diamond") @Comment({"The amount of diamond involved in the gold/diamond conversion."}) @Range(min = 1,max = 8) public static int gold_diamondHigh = 1;

    @Config("diamond_emerald") @Comment({"The amount of diamond involved in the diamond/emerald conversion."}) @Range(min = 1,max = 8) public static int diamond_emeraldLow = 2;
    @Config("diamond_emerald") @Comment({"The amount of emerald involved in the diamond/emerald conversion."}) @Range(min = 1,max = 8) public static int diamond_emeraldHigh = 1;
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
    private static ConfigSyncable INSTANCE;
    public static ConfigSyncable instance(String configName) {
        if (INSTANCE == null) {
            INSTANCE = new ResourceConfig(configName);
        }
        return INSTANCE;
    }

    public static ConfigProcessor processor;

    protected ResourceConfig(String configName) {
        super(configName);
    }
    @Override
    public void init() {
        addSection("charcoal_coal");
        addSection("coal_iron");
        addSection("iron_redstone");
        addSection("redstone_lapis");
        addSection("lapis_gold");
        addSection("gold_diamond");
        addSection("diamond_emerald");
        processor = new ConfigProcessor(getClass(), this.config, this.configFileName);
        processor.process(true);
    }
    @Override
    protected void reloadIngameConfigs() {}
    @Override
    protected void reloadNonIngameConfigs() {}
    @Override
    public String getConfigName() {
        return this.configFileName;
    }
}
