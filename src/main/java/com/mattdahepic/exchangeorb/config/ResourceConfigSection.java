package com.mattdahepic.exchangeorb.config;

import net.minecraftforge.common.config.Configuration;

import java.io.Serializable;

public class ResourceConfigSection {
    private final String resourceLow,resourceHigh,sectionName;
    private static final int MIN = 1;
    private static final int MAX = 8;

    public int amountLow;
    public int amountHigh;

    public ResourceConfigSection (String lowResource,String highResource,int lowDefault,int highDefault) {
        resourceLow = lowResource;
        resourceHigh = highResource;
        sectionName = lowResource+"_"+highResource;
        amountLow = lowDefault;
        amountHigh = highDefault;
    }

    public void load (Configuration c) {
        amountLow = c.getInt(resourceLow+"Amount",sectionName,amountLow,MIN,MAX,"The amount of "+resourceLow+" involved in the "+resourceLow+"/"+resourceHigh+" conversion.");
        amountHigh = c.getInt(resourceHigh+"Amount",sectionName,amountHigh,MIN,MAX,"The amount of "+resourceHigh+" involved in the "+resourceLow+"/"+resourceHigh+" conversion.");
    }
}
