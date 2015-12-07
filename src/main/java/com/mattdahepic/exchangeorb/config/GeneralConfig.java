package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.mdecore.config.annot.Comment;
import com.mattdahepic.mdecore.config.annot.Config;
import com.mattdahepic.mdecore.config.annot.Range;
import com.mattdahepic.mdecore.config.sync.ConfigProcessor;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;

public class GeneralConfig extends ConfigSyncable {
    @Config
    @Comment({"Does the Exchange Orb have a limited amount of uses?","Set the amount of uses in orbDurability."})
    public static boolean orbHasDurability = false;
    @Config
    @Comment({"Amount of uses the exchange orb has, if durability is enabled."})
    @Range(min = 1,max = 9999)
    public static int orbDurability = 200;
    @Config
    @Comment({"Should the orb require a nether star to create instead of a stone block?"})
    public static boolean orbHardMode = false;
    //public static boolean enableResources = true; //TODO: make these work
    //public static boolean enableMobDrops = true; //TODO: make these work

    private static ConfigSyncable INSTANCE;
    public static ConfigSyncable instance(String configName) {
        if (INSTANCE == null) {
            INSTANCE = new GeneralConfig(configName);
        }
        return INSTANCE;
    }

    public static ConfigProcessor processor;

    protected GeneralConfig(String configName) {
        super(configName);
    }
    @Override
    public void init() {
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
