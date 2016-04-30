package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.mdecore.config.sync.Config;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;

public class MobDropConfig extends ConfigSyncable {
    public String getConfigVersion () {return "1";}
    public String getConfigName () {return ExchangeOrb.MODID+"-mobdrops";}
    public Class getConfigClass () {return getClass();}

    private static final String CAT_ESS = "essence";
    private static final String CAT_WITCH = "witch";

    @Config(comment = "Should players be allowed to convert essence to sponges?") public static boolean convertSponges = true;
    @Config(comment = "Should music disks be converted between the types?") public static boolean convertMusicDisks = true;
    @Config(comment = "Should witch drops be convertable?") public static boolean convertWitchDrops = true;

    @Config(cat = CAT_ESS,comment = "Worth of a blaze rod in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_BlazeRod = 2;
    @Config(cat = CAT_ESS,comment = "Worth of a string in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_String = 1;
    @Config(cat = CAT_ESS,comment = "Worth of a spider eye in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_SpiderEye = 2;
    @Config(cat = CAT_ESS,comment = "Worth of a gunpowder in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_Gunpowder = 1;
    @Config(cat = CAT_ESS,comment = "Worth of an ender pearl in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_EnderPearl = 4;
    @Config(cat = CAT_ESS,comment = "Worth of a ghast tear in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_GhastTear = 3;
    @Config(cat = CAT_ESS,comment = "Worth of a magma cream in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_MagmaCream = 2;
    @Config(cat = CAT_ESS,comment = "Worth of an arrow in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_Arrow = 1;
    @Config(cat = CAT_ESS,comment = "Worth of a bone in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_Bone = 1;
    @Config(cat = CAT_ESS,comment = "Worth of a slime ball in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_SlimeBall = 1;
    @Config(cat = CAT_ESS,comment = "Worth of a rotten flesh in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_RottenFlesh = 1;
    @Config(cat = CAT_ESS,comment = "Worth of a prismarine crystal in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_PrisCrystal = 2;
    @Config(cat = CAT_ESS,comment = "Worth of a prismarine shard in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_PrisShard = 2;
    @Config(cat = CAT_ESS,comment = "Worth of a sponge in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_Sponge = 3;

    @Config(cat = CAT_WITCH,comment = "Worth of a glass bottle in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_GlassBottle = 1;
    @Config(cat = CAT_WITCH,comment = "Worth of a glowstone dust in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_GlowstoneDust = 2;
    @Config(cat = CAT_WITCH,comment = "Worth of a redstone dust in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_RedstoneDust = 1;
    @Config(cat = CAT_WITCH,comment = "Worth of a measly stick in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_Stick = 1;
    @Config(cat = CAT_WITCH,comment = "Worth of a sugar in essence.",range = @Config.Range(min = 1,max = 8)) public static int ess_Sugar = 1;
}
