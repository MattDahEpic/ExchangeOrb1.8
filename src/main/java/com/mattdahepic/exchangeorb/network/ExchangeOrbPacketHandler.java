package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ExchangeOrbPacketHandler {
    public static SimpleNetworkWrapper net;
    public static void initPackets () {
        net = NetworkRegistry.INSTANCE.newSimpleChannel(ExchangeOrb.MODID.toUpperCase());
        net.registerMessage(DummyPacket.class,DummyPacket.Message.class,0, Side.CLIENT);
    }
}
