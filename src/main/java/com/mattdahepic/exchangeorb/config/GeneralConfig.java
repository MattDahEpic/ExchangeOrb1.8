package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.mdecore.config.sync.Config;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;

public class GeneralConfig extends ConfigSyncable {
    public String getConfigVersion () {return "1";}
    public String getConfigName () {return ExchangeOrb.MODID;}
    public Class getConfigClass () {return getClass();}

    @Config(comment = {"Do orbs have a limited amount of uses?","Set the amount of uses in orbDurability."})
    public static boolean orbHasDurability = false;
    @Config(comment = {"Amount of uses orbs have, if durability is enabled."}, range = @Config.Range(min = 1,max = 9999))
    public static int orbDurability = 200;
    @Config(comment = {"Should the orb require a nether star to create instead of a diamond?"})
    public static boolean orbHardMode = false;
    @Config(comment = {"Should the resource orb be enabled?","This orb can convert resources such as diamond and iron.","More options are available in the exchangeorb-resources.cfg file."},restartReq = Config.RestartReqs.REQUIRES_MC_RESTART)
    public static boolean enableResourceOrb = true;
    @Config(comment = {"Should the mob drop orb be enabled?","This orb can convert mob drops such as rotten flesh and string, as well as convert music disks between each other.","More options are available in the exchangeorb-mobdrops.cfg file"},restartReq = Config.RestartReqs.REQUIRES_MC_RESTART)
    public static boolean enableMobDropOrb = true;
    /* TODO: @Config(comment = {"Should the disenchanting orb be enabled?","This orb can remove enchantments from tools and weapons and place them on books."},restartReq = Config.RestartReqs.REQUIRES_MC_RESTART)
    public static boolean enableDisenchantOrb = true;*/

}
