package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.config.MobDropConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfig;
import com.mattdahepic.exchangeorb.network.GeneralSync;
import com.mattdahepic.exchangeorb.network.PacketHandler;
import com.mattdahepic.exchangeorb.network.ResourceSync;
import com.mattdahepic.mdecore.update.UpdateChecker;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExchangeOrb.MODID, name = ExchangeOrb.NAME, version = ExchangeOrb.VERSION, dependencies = ExchangeOrb.DEPENDENCIES)
public class ExchangeOrb {
    @Mod.Instance(MODID)
    public static ExchangeOrb instance;

    public static final String MODID = "exchangeorb";
    public static final String VERSION = "@VERSION@";
    public static final String NAME = "Exchange Orb";
    public static final String DEPENDENCIES = "required-after:mdecore@[1.8.8-1.5,);";
    public static final String UPDATE_URL = "https://raw.githubusercontent.com/MattDahEpic/Version/master/"+ MinecraftForge.MC_VERSION+"/"+MODID+".txt";
    public static final String CLIENT_PROXY = "com.mattdahepic.exchangeorb.ClientProxy";
    public static final String COMMON_PROXY = "com.mattdahepic.exchangeorb.CommonProxy";

    public static final Logger logger = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy;

    public static Configuration configFile;

    public static Item itemExchangeOrb;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        FMLCommonHandler.instance().bus().register(instance);
        GeneralConfig.load(MODID,e,new GeneralConfig());
        ResourceConfig.load(MODID+"-resources", e, new ResourceConfig());
        MobDropConfig.load(MODID+"-mobdrops",e,new MobDropConfig());
        proxy.registerItems();
        proxy.registerRenders();
        PacketHandler.initPackets();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        UpdateChecker.checkRemote(MODID, UPDATE_URL);
        proxy.registerRecipes();
    }
    @SubscribeEvent
    public void onPlayerJoinServer (PlayerEvent.PlayerLoggedInEvent e) {
        UpdateChecker.printMessageToPlayer(MODID,e.player);
        if (!e.player.worldObj.isRemote) {
            logger.info("Sending configuration settings packet(s) from the server to the connecting client " + e.player.getDisplayName() + ".");
            IMessage general = new GeneralSync.Message(GeneralConfig.orbDurability,GeneralConfig.orbHardMode,GeneralConfig.orbHasDurability);
            PacketHandler.net.sendTo(general,(EntityPlayerMP)e.player);
            IMessage resources = new ResourceSync.Message(ResourceConfig.charcoal_coal,ResourceConfig.coal_iron,ResourceConfig.iron_redstone,ResourceConfig.redstone_lapis,ResourceConfig.lapis_gold,ResourceConfig.gold_diamond,ResourceConfig.diamond_emerald);
            PacketHandler.net.sendTo(resources,(EntityPlayerMP)e.player);
            //IMessage drops = ;
            //PacketHandler.net.sendTo(drops,(EntityPlayerMP)e.player);
        }
    }
}
