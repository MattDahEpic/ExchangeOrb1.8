package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.GeneralConfig;
import com.mattdahepic.exchangeorb.config.MobDropConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfig;
import com.mattdahepic.exchangeorb.item.ItemEssence;
import com.mattdahepic.exchangeorb.item.ItemOrb;
import com.mattdahepic.mdecore.config.sync.ConfigSyncable;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExchangeOrb.MODID, name = ExchangeOrb.NAME, version = ExchangeOrb.VERSION, dependencies = ExchangeOrb.DEPENDENCIES,updateJSON = ExchangeOrb.UPDATE_JSON)
public class ExchangeOrb {
    public static final String MODID = "exchangeorb";
    static final String VERSION = "@VERSION@";
    static final String NAME = "Exchange Orb";
    static final String DEPENDENCIES = "required-after:mdecore@[1.10.2-1.3,);";
    static final String UPDATE_JSON = "https://raw.githubusercontent.com/MattDahEpic/Version/master/"+MODID+".json";

    public static final Logger logger = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "com.mattdahepic.exchangeorb.ClientProxy", serverSide = "com.mattdahepic.exchangeorb.CommonProxy")
    public static CommonProxy proxy;

    public static Item itemOrb = new ItemOrb();
    public static Item itemEssence = new ItemEssence();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        new GeneralConfig().initalize(e);
        new ResourceConfig().initalize(e);
        new MobDropConfig().initalize(e);
        proxy.registerItems();
        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerRecipes();
    }
    private int configsSynced = 0;
    @SubscribeEvent
    public void onConfigSync (ConfigSyncable.ConfigSyncEvent e) {
        if (e.configName.equals(MODID) || e.configName.equals(MODID+"-mobdrops") || e.configName.equals(MODID+"-resources")) configsSynced++;
        if (configsSynced == 3) {
            logger.info("Config values synced. Reloading recipes.");
            proxy.registerRecipes();
            configsSynced = 0;
        }
    }
}
