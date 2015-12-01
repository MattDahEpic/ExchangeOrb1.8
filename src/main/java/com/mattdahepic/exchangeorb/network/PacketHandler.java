package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
    public static SimpleNetworkWrapper net;
    public static void initPackets () {
        net = NetworkRegistry.INSTANCE.newSimpleChannel(ExchangeOrb.MODID.toUpperCase());
        registerMessage(SyncPacket.class, SyncPacket.SyncMessage.class);
    }
    private static int nextPacketId = 0;
    public static void registerMessage (Class packet,Class message) {
        net.registerMessage(packet,message,nextPacketId,Side.CLIENT);
        nextPacketId++;
    }
}
