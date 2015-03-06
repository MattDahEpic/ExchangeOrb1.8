package com.mattdahepic.exchangeorb.client;

import com.mattdahepic.exchangeorb.CommonProxy;
import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        // This is for rendering entities and so forth later on
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ExchangeOrb.itemExchangeOrb, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack p_178113_1_) {
                return new ModelResourceLocation("exchangeorb:exchangeOrb", "inventory");
            }
        });
        }
}
