package com.mattdahepic.exchangeorb;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModelLoader.setCustomModelResourceLocation(ExchangeOrb.itemOrb,0,new ModelResourceLocation("exchangeorb:resource_orb","inventory"));
        ModelLoader.setCustomModelResourceLocation(ExchangeOrb.itemOrb,1,new ModelResourceLocation("exchangeorb:mobdrop_orb","inventory"));
        ModelLoader.setCustomModelResourceLocation(ExchangeOrb.itemOrb,2,new ModelResourceLocation("exchangeorb:disenchant_orb","inventory"));
        ModelLoader.setCustomModelResourceLocation(ExchangeOrb.itemEssence,0,new ModelResourceLocation("exchangeorb:mob_essence","inventory"));
    }
}
