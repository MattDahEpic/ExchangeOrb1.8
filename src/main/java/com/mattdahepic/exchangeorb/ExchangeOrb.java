package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.config.MobDropConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfig;
import com.mattdahepic.exchangeorb.network.DummyPacket;
import com.mattdahepic.exchangeorb.network.ExchangeOrbPacketHandler;
import com.mattdahepic.mdecore.update.UpdateChecker;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExchangeOrb.MODID, name = ExchangeOrb.NAME, version = ExchangeOrb.VERSION, dependencies = ExchangeOrb.DEPENDENCIES)
public class ExchangeOrb {
    @Mod.Instance("exchangeorb")
    public static ExchangeOrb instance;

    public static final String MODID = "exchangeorb";
    public static final String VERSION = "@VERSION@";
    public static final String NAME = "Exchange Orb";
    public static final String DEPENDENCIES = "required-after:mdecore@[1.8.8-1.6,);";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/MattDahEpic/Version/master/"+ MinecraftForge.MC_VERSION+"/"+MODID+".txt";
    public static final String CLIENT_PROXY = "com.mattdahepic.exchangeorb.ClientProxy";
    public static final String COMMON_PROXY = "com.mattdahepic.exchangeorb.CommonProxy";

    public static final Logger logger = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy;

    public static Configuration configFile;

    public static Item itemExchangeOrb;
    public static Item itemMobEssence;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        FMLCommonHandler.instance().bus().register(instance);
        GeneralConfig.instance(MODID).initialize(e);
        ResourceConfig.instance(MODID+"-resources").initialize(e);
        MobDropConfig.instance(MODID+"-mobdrops").initialize(e);
        proxy.registerItems();
        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        UpdateChecker.checkRemote(MODID, UPDATE_URL);
        proxy.registerRecipes();
        ExchangeOrbPacketHandler.initPackets();
    }
    @SubscribeEvent
    public void onPlayerJoinServer (PlayerEvent.PlayerLoggedInEvent e) {
        UpdateChecker.printMessageToPlayer(MODID,e.player);
        ExchangeOrbPacketHandler.net.sendTo(new DummyPacket.Message(),(EntityPlayerMP)e.player);
    }
}
