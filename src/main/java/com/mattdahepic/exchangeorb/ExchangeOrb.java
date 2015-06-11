package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.Config;
import com.mattdahepic.exchangeorb.item.ItemExchangeOrb;
import com.mattdahepic.exchangeorb.network.PacketHandler;
import com.mattdahepic.exchangeorb.network.SyncPacket;
import com.mattdahepic.mdecore.helpers.LogHelper;
import com.mattdahepic.mdecore.update.UpdateChecker;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = ExchangeOrb.MODID, name = ExchangeOrb.NAME, version = ExchangeOrb.VERSION, dependencies = "required-after:mdecore@[1.8-1.1.1,);")
public class ExchangeOrb {
    @Mod.Instance("exchangeorb")
    public static ExchangeOrb instance;

    public static final String MODID = "exchangeorb";
    public static final String VERSION = "1.8-1.8";
    public static final String NAME = "Exchange Orb";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/MattDahEpic/ExchangeOrb1.8/master/version.txt";

    @SidedProxy(clientSide = "com.mattdahepic.exchangeorb.client.ClientProxy", serverSide = "com.mattdahepic.exchangeorb.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration configFile;

    //item
    public static Item itemExchangeOrb;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(instance);
        Config.load(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        PacketHandler.initPackets();
        itemExchangeOrb = new ItemExchangeOrb();
        proxy.registerBlocksItems();
        proxy.registerRecipes();
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info(MODID,"Ready to transmute!");
    }
    @Mod.EventHandler
    public void loadComplete (FMLLoadCompleteEvent event) {
        UpdateChecker.updateCheck(MODID, NAME, UPDATE_URL, VERSION, false, null);
    }
    @SubscribeEvent
    public void onPlayerJoinServer (PlayerEvent.PlayerLoggedInEvent event) {
        UpdateChecker.updateCheck(MODID,NAME,UPDATE_URL,VERSION,true,event.player);
        if (!event.player.worldObj.isRemote) {
            if (event.player instanceof EntityPlayerMP) {
                LogHelper.info(MODID,"Sending configuration settings packet from the server to the connecting client "+event.player.getDisplayName()+".");
                IMessage sync = new SyncPacket.SyncMessage(Config.charcoalCoal_Charcoal,Config.charcoalCoal_Coal,Config.coalIron_Coal,Config.coalIron_Iron,Config.ironRedstone_Iron,Config.ironRedstone_Redstone,Config.redstoneLapis_Redstone,Config.redstoneLapis_Lapis,Config.lapisGold_Lapis,Config.lapisGold_Gold,Config.goldDiamond_Gold,Config.goldDiamond_Diamond,Config.diamondEmerald_Diamond,Config.diamondEmerald_Emerald,Config.orbHasDurability,Config.orbDurability,Config.orbHardMode);
                PacketHandler.net.sendTo(sync, (EntityPlayerMP) event.player);
            }
        }
    }
}
