package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.mdecore.config.Config;
import net.minecraftforge.common.config.Configuration;

public class GeneralConfig extends Config {
    public static boolean orbHasDurability = false;
    public static int orbDurability = 200;
    public static boolean orbHardMode = false;
    //public static boolean enableResources = true;
    //public static boolean enableMobDrops = true;
    @Override
    public void processConfig (Configuration c) {
        orbHasDurability = c.getBoolean("orbHasDurability",Configuration.CATEGORY_GENERAL,orbHasDurability,"Does the Exchange Orb have a limited amount of uses? Set the amount of uses in orbDurability.");
        orbDurability = c.getInt("orbDurability", Configuration.CATEGORY_GENERAL, orbDurability, 1, 9999, "Amount of uses the exchange orb has, if durability is enabled.");
        orbHardMode = c.getBoolean("orbHardMode", Configuration.CATEGORY_GENERAL, orbHardMode, "Should the orb require a nether star to create instead of a stone block?");
        //enableResources = c.getBoolean("enableResources",Configuration.CATEGORY_GENERAL,enableResources,"Should the orb be able to convert resources such as redstone and diamond?");
        //enableMobDrops = c.getBoolean("enableMobDrops",Configuration.CATEGORY_GENERAL,enableMobDrops,"Should the orb be able to convert mob drops such as rotten flesh and string?");
    }
}
