package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.mdecore.config.annot.Comment;
import com.mattdahepic.mdecore.config.annot.Config;
import com.mattdahepic.mdecore.config.annot.Range;
import com.mattdahepic.mdecore.config.sync.ConfigProcessor;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;

public class MobDropConfig extends ConfigSyncable {
    public static final String CAT_ESSENCE = "essence";
    public static final String CAT_WITCH = "witch";

    @Config @Comment({"Should players be allowed to convert essence to sponges?"}) public static boolean convertSponges = true;
    @Config @Comment({"Should wither skulls be convertable?"}) public static boolean convertWitherSkulls = true;
    @Config @Comment({"Should music disks be converted between the types?"}) public static boolean convertMusicDisks = true;
    @Config @Comment({"Should witch drops be convertable?"}) public static boolean convertWitchDrops = true;

    @Config(CAT_ESSENCE) @Comment({"Worth of a blaze rod in essence."}) @Range(min = 1,max = 8) public static int ess_BlazeRod = 2;
    @Config(CAT_ESSENCE) @Comment({"Worth of a string in essence."}) @Range(min = 1,max = 8) public static int ess_String = 1;
    @Config(CAT_ESSENCE) @Comment({"Worth of a spider eye in essence."}) @Range(min = 1,max = 8) public static int ess_SpiderEye = 2;
    @Config(CAT_ESSENCE) @Comment({"Worth of a gunpowder in essence."}) @Range(min = 1,max = 8) public static int ess_Gunpowder = 1;
    @Config(CAT_ESSENCE) @Comment({"Worth of an ender pearl in essence."}) @Range(min = 1,max = 8) public static int ess_EnderPearl = 4;
    @Config(CAT_ESSENCE) @Comment({"Worth of a ghast tear in essence."}) @Range(min = 1,max = 8) public static int ess_GhastTear = 3;
    @Config(CAT_ESSENCE) @Comment({"Worth of a magma cream in essence."}) @Range(min = 1,max = 8) public static int ess_MagmaCream = 2;
    @Config(CAT_ESSENCE) @Comment({"Worth of an arrow in essence."}) @Range(min = 1,max = 8) public static int ess_Arrow = 1;
    @Config(CAT_ESSENCE) @Comment({"Worth of a bone in essence."}) @Range(min = 1,max = 8) public static int ess_Bone = 1;
    @Config(CAT_ESSENCE) @Comment({"Worth of a slime ball in essence."}) @Range(min = 1,max = 8) public static int ess_SlimeBall = 1;
    @Config(CAT_ESSENCE) @Comment({"Worth of a rotten flesh in essence."}) @Range(min = 1,max = 8) public static int ess_RottenFlesh = 1;
    @Config(CAT_ESSENCE) @Comment({"Worth of a prismarine crystal in essence."}) @Range(min = 1,max = 8) public static int ess_PrisCrystal = 2;
    @Config(CAT_ESSENCE) @Comment({"Worth of a prismarine shard in essence."}) @Range(min = 1,max = 8) public static int ess_PrisShard = 2;
    @Config(CAT_ESSENCE) @Comment({"Worth of a sponge in essence."}) @Range(min = 1,max = 8) public static int ess_Sponge = 3;
    @Config(CAT_ESSENCE) @Comment({"Worth of a wither skull in essence."}) @Range(min = 1,max = 8) public static int ess_WitherSkull = 8;

    @Config(CAT_WITCH) @Comment({"Worth of a glass bottle in essence."}) @Range(min = 1,max = 8) public static int ess_GlassBottle = 1;
    @Config(CAT_WITCH) @Comment({"Worth of a glowstone dust in essence."}) @Range(min = 1,max = 8) public static int ess_GlowstoneDust = 2;
    @Config(CAT_WITCH) @Comment({"Worth of a redstone dust in essence."}) @Range(min = 1,max = 8) public static int ess_RedstoneDust = 1;
    @Config(CAT_WITCH) @Comment({"Worth of a measly stick in essence."}) @Range(min = 1,max = 8) public static int ess_Stick = 1;
    @Config(CAT_WITCH) @Comment({"Worth of a sugar in essence."}) @Range(min = 1,max = 8) public static int ess_Sugar = 1;

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
        addSection(CAT_ESSENCE);
        addSection(CAT_WITCH);
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
