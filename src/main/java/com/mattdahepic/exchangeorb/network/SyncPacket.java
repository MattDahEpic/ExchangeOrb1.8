package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import com.mattdahepic.mdecore.helpers.LogHelper;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class SyncPacket implements IMessageHandler<SyncPacket.SyncMessage,IMessage> {
    @Override
    public IMessage onMessage (SyncMessage message,MessageContext ctx) {
        if (ctx.side.isClient()) {
            LogHelper.info(ExchangeOrb.MODID,"Recieved a configuration syncronization packet from the server. Changing config values accordingly...");
            Config.charcoalCoal_Charcoal = message.charcoalCoal_Charcoal;
            Config.charcoalCoal_Coal = message.charcoalCoal_Coal;
            Config.coalIron_Coal = message.coalIron_Coal;
            Config.coalIron_Iron = message.coalIron_Iron;
            Config.ironRedstone_Iron = message.ironRedstone_Iron;
            Config.ironRedstone_Redstone = message.ironRedstone_Redstone;
            Config.redstoneLapis_Redstone = message.redstoneLapis_Redstone;
            Config.redstoneLapis_Lapis = message.redstoneLapis_Lapis;
            Config.lapisGold_Lapis = message.lapisGold_Lapis;
            Config.lapisGold_Gold = message.lapisGold_Gold;
            Config.goldDiamond_Gold = message.goldDiamond_Gold;
            Config.goldDiamond_Diamond = message.goldDiamond_Diamond;
            Config.diamondEmerald_Diamond = message.diamondEmerald_Diamond;
            Config.diamondEmerald_Emerald = message.diamondEmerald_Emerald;
            Config.orbHasDurability = message.orbHasDurability;
            Config.orbDurability = message.orbDurability;
            Config.orbHardMode = message.orbHardMode;
        }
        return null;
    }
    public static class SyncMessage implements IMessage {
        private int charcoalCoal_Charcoal;
        private int charcoalCoal_Coal;
        private int coalIron_Coal;
        private int coalIron_Iron;
        private int ironRedstone_Iron;
        private int ironRedstone_Redstone;
        private int redstoneLapis_Redstone;
        private int redstoneLapis_Lapis;
        private int lapisGold_Lapis;
        private int lapisGold_Gold;
        private int goldDiamond_Gold;
        private int goldDiamond_Diamond;
        private int diamondEmerald_Diamond;
        private int diamondEmerald_Emerald;
        private boolean orbHasDurability;
        private int orbDurability;
        private boolean orbHardMode;
        public SyncMessage() {}
        public SyncMessage(int charcoalCoal_Charcoal,int charcoalCoal_Coal,int coalIron_Coal,int coalIron_Iron,int ironRedstone_Iron,int ironRedstone_Redstone,int redstoneLapis_Redstone,int redstoneLapis_Lapis, int lapisGold_Lapis,int lapisGold_Gold,int goldDiamond_Gold,int goldDiamond_Diamond,int diamondEmerald_Diamond,int diamondEmerald_Emerald,boolean orbHasDurability,int orbDurability,boolean orbHardMode) {
            this.charcoalCoal_Charcoal = charcoalCoal_Charcoal;
            this.charcoalCoal_Coal = charcoalCoal_Coal;
            this.coalIron_Coal = coalIron_Coal;
            this.coalIron_Iron = coalIron_Iron;
            this.ironRedstone_Iron = ironRedstone_Iron;
            this.ironRedstone_Redstone = ironRedstone_Redstone;
            this.redstoneLapis_Redstone = redstoneLapis_Redstone;
            this.redstoneLapis_Lapis = redstoneLapis_Lapis;
            this.lapisGold_Lapis = lapisGold_Lapis;
            this.lapisGold_Gold = lapisGold_Gold;
            this.goldDiamond_Gold = goldDiamond_Gold;
            this.goldDiamond_Diamond = goldDiamond_Diamond;
            this.diamondEmerald_Diamond = diamondEmerald_Diamond;
            this.diamondEmerald_Emerald = diamondEmerald_Emerald;
            this.orbHasDurability = orbHasDurability;
            this.orbDurability = orbDurability;
            this.orbHardMode = orbHardMode;
        }
        @Override
        public void fromBytes (ByteBuf buf) {
            this.charcoalCoal_Charcoal = buf.readInt();
            this.charcoalCoal_Coal = buf.readInt();
            this.coalIron_Coal = buf.readInt();
            this.coalIron_Iron = buf.readInt();
            this.ironRedstone_Iron = buf.readInt();
            this.ironRedstone_Redstone = buf.readInt();
            this.redstoneLapis_Redstone = buf.readInt();
            this.redstoneLapis_Lapis = buf.readInt();
            this.lapisGold_Lapis = buf.readInt();
            this.lapisGold_Gold = buf.readInt();
            this.goldDiamond_Gold = buf.readInt();
            this.goldDiamond_Diamond = buf.readInt();
            this.diamondEmerald_Diamond = buf.readInt();
            this.diamondEmerald_Emerald = buf.readInt();
            this.orbHasDurability = buf.readBoolean();
            this.orbDurability = buf.readInt();
            this.orbHardMode = buf.readBoolean();
        }
        @Override
        public void toBytes (ByteBuf buf) {
            buf.writeInt(charcoalCoal_Charcoal);
            buf.writeInt(charcoalCoal_Coal);
            buf.writeInt(coalIron_Coal);
            buf.writeInt(coalIron_Iron);
            buf.writeInt(ironRedstone_Iron);
            buf.writeInt(ironRedstone_Redstone);
            buf.writeInt(redstoneLapis_Redstone);
            buf.writeInt(redstoneLapis_Lapis);
            buf.writeInt(lapisGold_Lapis);
            buf.writeInt(lapisGold_Gold);
            buf.writeInt(goldDiamond_Gold);
            buf.writeInt(goldDiamond_Diamond);
            buf.writeInt(diamondEmerald_Diamond);
            buf.writeInt(diamondEmerald_Emerald);
            buf.writeBoolean(orbHasDurability);
            buf.writeInt(orbDurability);
            buf.writeBoolean(orbHardMode);
        }
    }
}
