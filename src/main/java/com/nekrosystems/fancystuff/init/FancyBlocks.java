package com.nekrosystems.fancystuff.init;

import java.util.ArrayList;
import java.util.List;

import com.nekrosystems.fancystuff.Config;
import com.nekrosystems.fancystuff.FancyMaterial;
import com.nekrosystems.fancystuff.FancyStuff;
import com.nekrosystems.fancystuff.blocks.BlockColored;
import com.nekrosystems.fancystuff.blocks.Chain;
import com.nekrosystems.fancystuff.blocks.Rope;
import com.nekrosystems.fancystuff.init.helpers.StringHelper;
import com.nekrosystems.fancystuff.items.ItemColored;
import com.nekrosystems.fancystuff.sounds.ChainSound;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FancyBlocks {
	public static Block chain;
	public static Block rope;
	
	public static BlockColored colored_stone;
	public static BlockColored colored_stone_bricks;

	public static void init() {
		chain = new Chain("chain")
				.setCreativeTab(FancyStuff.creativeTab);
		
		rope = new Rope("rope")
				.setCreativeTab(FancyStuff.creativeTab);

		colored_stone = (BlockColored) new BlockColored("colored_stone")
				.setCreativeTab(FancyStuff.creativeTab);

		colored_stone_bricks = (BlockColored) new BlockColored("colored_stone_bricks")
				.setCreativeTab(FancyStuff.creativeTab);
	}

	public static void register() {
		GameRegistry.registerBlock(chain, StringHelper.getUnlocalizedName(chain));
		GameRegistry.registerBlock(rope, StringHelper.getUnlocalizedName(rope));

		/** Colored blocks **/
		GameRegistry.registerBlock(colored_stone, ItemColored.class, StringHelper.getUnlocalizedName(colored_stone));
		GameRegistry.registerBlock(colored_stone_bricks, ItemColored.class, StringHelper.getUnlocalizedName(colored_stone_bricks));
	}

	public static void registerRenders() {
		registerRender(chain);
		registerRender(rope);
		
		/** Colored items **/
		registerRenderColoredBlock(colored_stone);
		registerRenderColoredBlock(colored_stone_bricks);
	}

	public static void registerRender(Block block) {
		registerRender(block, true);
	}

	public static void registerRender(Block block, Boolean includeInventory) {
		Item item = Item.getItemFromBlock(block);
		
		/** Register inventory items **/
		if (includeInventory)
			FancyItems.registerRender(item);
	}

	public static void registerRenderColoredBlock(BlockColored block) {
		Item item = Item.getItemFromBlock(block);

		List<String> names = new ArrayList<String>();
		for (int i = 0; i < 16; i++) {
			names.add(Config.MOD_ID + ":" + StringHelper.getUnlocalizedName(block) + "/" + block.getVariantName(new ItemStack(block, 1, i)).toString());
			FancyItems.registerColoredItemRender(item, i);
		}
		
		ModelBakery.addVariantName(item, names.toArray(new String[names.size()]));
	}
}
