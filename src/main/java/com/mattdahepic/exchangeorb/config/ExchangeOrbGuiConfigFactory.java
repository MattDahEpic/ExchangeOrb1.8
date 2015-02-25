package com.mattdahepic.exchangeorb.config;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;


public class ExchangeOrbGuiConfigFactory extends GuiConfig {
    public ExchangeOrbGuiConfigFactory(GuiScreen parentScreen) {
        super(parentScreen, new ConfigElement(ExchangeOrb.configFile.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), ExchangeOrb.MODID,true,true,"Exchange Orb Configuration");
    }
}