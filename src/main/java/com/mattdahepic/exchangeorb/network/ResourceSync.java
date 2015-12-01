package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.ResourceConfig;
import com.mattdahepic.exchangeorb.config.ResourceConfigSection;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ResourceSync implements IMessageHandler<ResourceSync.Message,IMessage> {
    @Override
    public IMessage onMessage (Message msg, MessageContext ctx) {
        if (ctx.side.isClient()) {
            ExchangeOrb.logger.info("Received resource config settings packet from server. Setting values accordingly...");
            ResourceConfig.charcoal_coal.amountLow = msg.charcoal_coalLow;
            ResourceConfig.charcoal_coal.amountHigh = msg.charcoal_coalHigh;
            ResourceConfig.coal_iron.amountLow = msg.coal_ironLow;
            ResourceConfig.coal_iron.amountHigh = msg.coal_ironHigh;
            ResourceConfig.iron_redstone.amountLow = msg.iron_redstoneLow;
            ResourceConfig.iron_redstone.amountHigh = msg.iron_redstoneHigh;
            ResourceConfig.redstone_lapis.amountLow = msg.redstone_lapisLow;
            ResourceConfig.redstone_lapis.amountHigh = msg.redstone_lapisHigh;
            ResourceConfig.lapis_gold.amountLow = msg.lapis_goldLow;
            ResourceConfig.lapis_gold.amountHigh = msg.lapis_goldHigh;
            ResourceConfig.gold_diamond.amountLow = msg.gold_diamondLow;
            ResourceConfig.gold_diamond.amountHigh = msg.gold_diamondHigh;
            ResourceConfig.diamond_emerald.amountLow = msg.diamond_emeraldLow;
            ResourceConfig.diamond_emerald.amountHigh = msg.diamond_emeraldHigh;
        }
        return null;
    }
    public static class Message implements IMessage {
        private int charcoal_coalLow,charcoal_coalHigh;
        private int coal_ironLow,coal_ironHigh;
        private int iron_redstoneLow,iron_redstoneHigh;
        private int redstone_lapisLow,redstone_lapisHigh;
        private int lapis_goldLow, lapis_goldHigh;
        private int gold_diamondLow, gold_diamondHigh;
        private int diamond_emeraldLow, diamond_emeraldHigh;
        public Message (ResourceConfigSection charcoal_coal,ResourceConfigSection coal_iron,ResourceConfigSection iron_redstone,ResourceConfigSection redstone_lapis,ResourceConfigSection lapis_gold,ResourceConfigSection gold_diamond,ResourceConfigSection diamond_emerald) {
            charcoal_coalLow = charcoal_coal.amountLow;
            charcoal_coalHigh = charcoal_coal.amountHigh;
            coal_ironLow = coal_iron.amountLow;
            coal_ironHigh = coal_iron.amountHigh;
            iron_redstoneLow = iron_redstone.amountLow;
            iron_redstoneHigh = iron_redstone.amountHigh;
            redstone_lapisLow = redstone_lapis.amountLow;
            redstone_lapisHigh = redstone_lapis.amountHigh;
            lapis_goldLow = lapis_gold.amountLow;
            lapis_goldHigh = lapis_gold.amountHigh;
            gold_diamondLow = gold_diamond.amountLow;
            gold_diamondHigh = gold_diamond.amountHigh;
            diamond_emeraldLow = diamond_emerald.amountLow;
            diamond_emeraldHigh = diamond_emerald.amountHigh;
        }
        @Override
        public void fromBytes (ByteBuf b) {
            charcoal_coalLow = b.readInt();
            charcoal_coalHigh = b.readInt();
            coal_ironLow = b.readInt();
            coal_ironHigh = b.readInt();
            iron_redstoneLow = b.readInt();
            iron_redstoneHigh = b.readInt();
            redstone_lapisLow = b.readInt();
            redstone_lapisHigh = b.readInt();
            lapis_goldLow = b.readInt();
            lapis_goldHigh = b.readInt();
            gold_diamondLow = b.readInt();
            gold_diamondHigh = b.readInt();
            diamond_emeraldLow = b.readInt();
            diamond_emeraldHigh = b.readInt();
        }
        @Override
        public void toBytes (ByteBuf b) {
            b.writeInt(charcoal_coalLow);
            b.writeInt(charcoal_coalHigh);
            b.writeInt(coal_ironLow);
            b.writeInt(coal_ironHigh);
            b.writeInt(iron_redstoneLow);
            b.writeInt(iron_redstoneHigh);
            b.writeInt(redstone_lapisLow);
            b.writeInt(redstone_lapisHigh);
            b.writeInt(lapis_goldLow);
            b.writeInt(lapis_goldHigh);
            b.writeInt(gold_diamondLow);
            b.writeInt(gold_diamondHigh);
            b.writeInt(diamond_emeraldLow);
            b.writeInt(diamond_emeraldHigh);
        }
    }
}
