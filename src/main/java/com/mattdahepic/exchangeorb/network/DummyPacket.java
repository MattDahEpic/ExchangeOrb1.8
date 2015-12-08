package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DummyPacket implements IMessageHandler<DummyPacket.Message,IMessage> {
    public IMessage onMessage (DummyPacket.Message msg, MessageContext ctx) {
        ExchangeOrb.proxy.registerRecipes();
        return null;
    }
    public static class Message implements IMessage {
        public Message () {}
        public void fromBytes (ByteBuf buf) {}
        public void toBytes (ByteBuf buf) {}
    }
}
