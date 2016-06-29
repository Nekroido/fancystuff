package com.nekrosystems.fancystuff;

import com.nekrosystems.fancystuff.init.FancyBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FancyStuffTab extends CreativeTabs {

	public FancyStuffTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(FancyBlocks.chain);
	}

}
