package com.nekrosystems.fancystuff.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafting {
	public static void registeCrafting() {
		addCrafting();
		addSmelting();

	}

	public static void addCrafting() {
		GameRegistry.addRecipe(new ItemStack(FancyBlocks.chain, 5),
				new Object[] { "X X", " X ", "X X", 'X', Items.iron_ingot });
		GameRegistry.addRecipe(new ItemStack(FancyBlocks.rope, 5),
				new Object[] { "X X", " X ", "X X", 'X', Items.string });

		/** Colored items **/
		for (int i = 0; i < 16; i++) {
			GameRegistry.addRecipe(new ItemStack(FancyBlocks.colored_stone, 8, i),
					new Object[] { "XXX", "XYX", "XXX", 'X', Blocks.stone, 'Y', new ItemStack(Items.dye, 1, EnumDyeColor.byDyeDamage(i).getMetadata()) });
			
			GameRegistry.addRecipe(new ItemStack(FancyBlocks.colored_stone_bricks, 4, i),
					new Object[] { "XX", "XX", 'X', new ItemStack(FancyBlocks.colored_stone, 4, i) });
		}
	}

	public static void addSmelting() {
	}
}
