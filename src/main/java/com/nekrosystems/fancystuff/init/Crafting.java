package com.nekrosystems.fancystuff.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafting {
    public static void registeCrafting() {
        addCrafting();
        addSmelting();
       
    }
   
    public static void addCrafting() {
        GameRegistry.addRecipe(new ItemStack(FancyBlocks.chain, 5), new Object[]{"X X", " X ", "X X", 'X', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(FancyBlocks.rope, 5), new Object[]{"X X", " X ", "X X", 'X', Items.string});
    }
   
    public static void addSmelting() {
    }
}
