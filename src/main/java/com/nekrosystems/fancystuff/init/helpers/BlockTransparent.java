package com.nekrosystems.fancystuff.init.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockTransparent extends Block {
	public BlockTransparent(Material material) {
		super(material);
	}
	
	public BlockTransparent(Material material, MapColor mapColor) {
		super(material, mapColor);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}
