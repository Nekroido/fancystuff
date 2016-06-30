package com.nekrosystems.fancystuff.items;

import com.nekrosystems.fancystuff.Config;
import com.nekrosystems.fancystuff.blocks.BlockColored;
import com.nekrosystems.fancystuff.init.helpers.StringHelper;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemColored extends ItemBlock {
	public ItemColored(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "tile." + StringHelper.getUnlocalizedName(stack.getItem()) + "." + ((BlockColored)this.block).getVariantName(stack);
	}
}