package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.CommonProxy;
import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModelLoader.setCustomModelResourceLocation(ExchangeOrb.itemExchangeOrb, 0, new ModelResourceLocation("exchangeorb:exchangeOrb", "inventory"));
    }
}
