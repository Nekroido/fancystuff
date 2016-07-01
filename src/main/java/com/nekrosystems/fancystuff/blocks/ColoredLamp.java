package com.nekrosystems.fancystuff.blocks;

import net.minecraft.util.EnumWorldBlockLayer;

public class ColoredLamp extends BlockColored {

	public ColoredLamp(String name) {
		super(name);

		this.setLightOpacity(0);
		this.setLightLevel(1f);
		this.translucent = true;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.SOLID;
	}
}
