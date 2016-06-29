package com.nekrosystems.fancystuff.init;

import com.nekrosystems.fancystuff.FancyMaterial;
import com.nekrosystems.fancystuff.FancyStuff;
import com.nekrosystems.fancystuff.blocks.Chain;
import com.nekrosystems.fancystuff.blocks.Rope;
import com.nekrosystems.fancystuff.sounds.ChainSound;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FancyBlocks {
	public static Block chain;
	public static Block rope;

	public static void init() {
		chain = new Chain(FancyMaterial.chain)
				.setUnlocalizedName("chain")
				.setHardness(.5f)
				.setResistance(30f)
				.setStepSound(new ChainSound())
				.setLightOpacity(0)
				.setCreativeTab(FancyStuff.creativeTab);

		chain.setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 1f, 0.75f);
		
		rope = new Rope(FancyMaterial.rope)
				.setUnlocalizedName("rope")
				.setHardness(.2f)
				.setResistance(10f)
				.setLightOpacity(0)
				.setCreativeTab(FancyStuff.creativeTab);

		rope.setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 1f, 0.75f);
	}

	public static void register() {
		GameRegistry.registerBlock(chain, chain.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(rope, rope.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(chain);
		registerRender(rope);
	}

	public static void registerRender(Block block) {
		registerRender(block, true);
	}

	public static void registerRender(Block block, Boolean skipInventory) {
		Item item = Item.getItemFromBlock(block);
		
		/** Register inventory items **/
		if (skipInventory)
			FancyItems.registerRender(item);
	}
}
