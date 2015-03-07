package com.mattdahepic.exchangeorb.utils;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class LogHelper {
    public static void info (String message) {
        FMLLog.log(ExchangeOrb.MODID,Level.INFO,message);
    }
    public static void warn (String message) {
        FMLLog.log(ExchangeOrb.MODID,Level.WARN,message);
    }
    public static void error (String message) {
        FMLLog.log(ExchangeOrb.MODID,Level.ERROR,message);
    }
}
