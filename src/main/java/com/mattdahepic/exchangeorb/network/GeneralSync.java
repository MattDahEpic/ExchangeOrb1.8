package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.GeneralConfig;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class GeneralSync implements IMessageHandler<GeneralSync.Message,IMessage> {
    @Override
    public IMessage onMessage (Message msg,MessageContext ctx) {
        if (ctx.side.isClient()) {
            ExchangeOrb.logger.info("Received general config settings packet from server. Setting values accordingly...");
            GeneralConfig.orbDurability = msg.orbDurability;
            GeneralConfig.orbHardMode = msg.orbHardMode;
            GeneralConfig.orbHasDurability = msg.orbHasDurability;
            //GeneralConfig.enableResources = msg.enableResources;
            //GeneralConfig.enableMobDrops = msg.enableMobDrops;
        }
        return null;
    }
    public static class Message implements IMessage {
        private int orbDurability;
        private boolean orbHardMode;
        private boolean orbHasDurability;
        //private boolean enableResources;
        //private boolean enableMobDrops;
        public Message (int orbDurability, boolean orbHardMode,boolean orbHasDurability) {
            this.orbDurability = orbDurability;
            this.orbHardMode = orbHardMode;
            this.orbHasDurability = orbHasDurability;
            //this.enableResources = enableResources;
            //this.enableMobDrops = enableMobDrops;
        }
        @Override
        public void fromBytes (ByteBuf b) {
            this.orbDurability = b.readInt();
            this.orbHardMode = b.readBoolean();
            this.orbHasDurability = b.readBoolean();
            //this.enableResources = b.readBoolean();
            //this.enableMobDrops = b.readBoolean();
        }
        @Override
        public void toBytes (ByteBuf b) {
            b.writeInt(orbDurability);
            b.writeBoolean(orbHardMode);
            b.writeBoolean(orbHasDurability);
            //b.writeBoolean(enableResources);
            //b.writeBoolean(enableMobDrops);
        }
    }
}
