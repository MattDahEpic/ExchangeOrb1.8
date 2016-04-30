package com.mattdahepic.exchangeorb.recipe.jei_handler;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.recipe.DisenchantRecipe;
import com.mattdahepic.mdecore.helpers.EnchantmentHelper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisenchantRecipeHandler implements IRecipeHandler<DisenchantRecipe> {
    @Override public Class<DisenchantRecipe> getRecipeClass() {
        return DisenchantRecipe.class;
    }
    @Override public String getRecipeCategoryUid() {
        return VanillaRecipeCategoryUid.CRAFTING;
    }
    @Override public IRecipeWrapper getRecipeWrapper(@Nonnull DisenchantRecipe recipe) {
        return new DisenchantRecipeWrapper();
    }
    @Override public boolean isRecipeValid(@Nonnull DisenchantRecipe recipe) {
        return true;
    }

    public static class DisenchantRecipeWrapper implements ICraftingRecipeWrapper {
        private final List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
        private final List<ItemStack> output = new ArrayList<ItemStack>();

        public DisenchantRecipeWrapper() {
            inputs.add(0, new ArrayList<ItemStack>()); //orbs
            inputs.add(1, new ArrayList<ItemStack>()); //enchanted item
            inputs.add(2, new ArrayList<ItemStack>()); //books
            inputs.add(3, new ArrayList<ItemStack>()); //books
            inputs.add(4, new ArrayList<ItemStack>()); //books
            inputs.add(5, new ArrayList<ItemStack>()); //books
            inputs.add(6, new ArrayList<ItemStack>()); //books
            inputs.add(7, new ArrayList<ItemStack>()); //books
            inputs.add(8, new ArrayList<ItemStack>()); //books

            for (Enchantment ench : ForgeRegistries.ENCHANTMENTS.getValues()) {
                setupRecipe(ench);
            }
        }

        @Override public List getInputs() {return inputs;}
        @Override public List<ItemStack> getOutputs() {return output;}

        @Override public void drawInfo(@Nonnull Minecraft mc, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {}
        @Override public List<FluidStack> getFluidInputs() {return null;}
        @Override public List<FluidStack> getFluidOutputs() {return null;}
        @Override public void drawAnimations(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight) {}
        @Override public List<String> getTooltipStrings(int mouseX, int mouseY) {return null;}
        @Override public boolean handleClick(@Nonnull Minecraft mc, int mouseX, int mouseY, int mouseButton) {return false;}

        private void setupRecipe(Enchantment ench) {
            for (int lvl = 1; lvl <= ench.getMaxLevel(); lvl++) {
                if (lvl >= 7) continue; //dont have recipes for more levels than slots we have
                inputs.get(0).add(new ItemStack(ExchangeOrb.itemOrb, 1, 2)); //add orb
                ItemStack enchItem;
                switch (ench.type) {
                    case ARMOR_HEAD:
                        enchItem = new ItemStack(Items.DIAMOND_HELMET, 1, 0);
                        break;
                    case ARMOR_CHEST:
                    case ARMOR:
                        enchItem = new ItemStack(Items.DIAMOND_CHESTPLATE, 1, 0);
                        break;
                    case ARMOR_LEGS:
                        enchItem = new ItemStack(Items.DIAMOND_LEGGINGS, 1, 0);
                        break;
                    case ARMOR_FEET:
                        enchItem = new ItemStack(Items.DIAMOND_BOOTS, 1, 0);
                        break;
                    case WEAPON:
                        enchItem = new ItemStack(Items.DIAMOND_SWORD, 1, 0);
                        break;
                    case DIGGER:
                        enchItem = new ItemStack(Items.DIAMOND_SHOVEL, 1, 0);
                        break;
                    case FISHING_ROD:
                        enchItem = new ItemStack(Items.FISHING_ROD, 1, 0);
                        break;
                    case BOW:
                        enchItem = new ItemStack(Items.BOW, 1, 0);
                        break;
                    default:
                        enchItem = new ItemStack(Items.DIAMOND_HOE, 1, 0);
                        break;
                }
                enchItem.addEnchantment(ench, lvl);
                inputs.get(1).add(enchItem);
                //books
                int bookCount = 0;
                for (int slot = 2; slot < 8; slot++) {
                    if (bookCount < lvl) {
                        inputs.get(slot).add(new ItemStack(Items.BOOK, 1, 0));
                        bookCount++;
                    } else {
                        inputs.get(slot).add(null);
                    }
                }
                output.add(EnchantmentHelper.getEnchantedBookWithEnchants(Collections.singletonList(new EnchantmentData(ench, lvl))));
            }
        }
    }
}
