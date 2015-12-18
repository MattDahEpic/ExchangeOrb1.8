package com.mattdahepic.exchangeorb;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModelLoader.setCustomModelResourceLocation(ExchangeOrb.itemExchangeOrb, 0, new ModelResourceLocation("exchangeorb:exchangeOrb", "inventory")); //TODO: ignore meta
        ModelLoader.setCustomModelResourceLocation(ExchangeOrb.itemMobEssence, 0, new ModelResourceLocation("exchangeorb:mobEssence","inventory"));
    }
}
