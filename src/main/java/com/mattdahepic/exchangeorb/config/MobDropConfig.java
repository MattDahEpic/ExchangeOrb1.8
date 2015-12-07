package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.mdecore.config.sync.ConfigProcessor;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;

public class MobDropConfig extends ConfigSyncable {
    //fields

    private static ConfigSyncable INSTANCE;
    public static ConfigSyncable instance(String configName) {
        if (INSTANCE == null) {
            INSTANCE = new MobDropConfig(configName);
        }
        return INSTANCE;
    }

    public static ConfigProcessor processor;

    protected MobDropConfig(String configName) {
        super(configName);
    }
    @Override
    public void init() {
        addSection(CATEGORY_TWEAKS);
        addSection(CATEGORY_DEBUG);
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
