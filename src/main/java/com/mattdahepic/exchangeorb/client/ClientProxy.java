package com.mattdahepic.exchangeorb.client;

import com.mattdahepic.exchangeorb.CommonProxy;
import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        // This is for rendering entities and so forth later on
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ExchangeOrb.itemExchangeOrb, 0, new ModelResourceLocation("exchangeorb:exchangeOrb", "inventory"));
        }
}
