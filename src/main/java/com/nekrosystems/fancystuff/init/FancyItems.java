package com.nekrosystems.fancystuff.init;

import com.nekrosystems.fancystuff.Config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FancyItems {

	public static void init() {
	}

	public static void register() {
	}

	public static void registerRenders() {
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Config.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
