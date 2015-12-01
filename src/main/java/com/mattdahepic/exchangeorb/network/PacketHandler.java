package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static SimpleNetworkWrapper net;
    public static void initPackets () {
        net = NetworkRegistry.INSTANCE.newSimpleChannel(ExchangeOrb.MODID.toUpperCase());
        registerMessage(GeneralSync.class,GeneralSync.Message.class);
        registerMessage(ResourceSync.class,ResourceSync.Message.class);
        //registerMessage(MobDropSync.class,MobDropSync.Message.class);
    }
    private static int nextPacketId = 0;
    public static void registerMessage (Class packet,Class message) {
        net.registerMessage(packet,message,nextPacketId,Side.CLIENT);
        nextPacketId++;
    }
}
