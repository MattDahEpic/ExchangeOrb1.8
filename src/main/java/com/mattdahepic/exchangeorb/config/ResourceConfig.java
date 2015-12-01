package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.mdecore.config.Config;
import net.minecraftforge.common.config.Configuration;


public class ResourceConfig extends Config {
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
    public static ResourceConfigSection charcoal_coal = new ResourceConfigSection("charcoal","coal",4,1);
    public static ResourceConfigSection coal_iron = new ResourceConfigSection("coal","iron",4,1);
    public static ResourceConfigSection iron_redstone = new ResourceConfigSection("iron","redstone",1,8);
    public static ResourceConfigSection redstone_lapis = new ResourceConfigSection("redstone","lapis",4,2);
    public static ResourceConfigSection lapis_gold = new ResourceConfigSection("lapis","gold",4,1);
    public static ResourceConfigSection gold_diamond = new ResourceConfigSection("gold","diamond",3,1);
    public static ResourceConfigSection diamond_emerald = new ResourceConfigSection("diamond","emerald",2,1);

    @Override
    public void processConfig(Configuration c) {
        charcoal_coal.load(c);
        coal_iron.load(c);
        iron_redstone.load(c);
        redstone_lapis.load(c);
        lapis_gold.load(c);
        gold_diamond.load(c);
        diamond_emerald.load(c);
    }
}
