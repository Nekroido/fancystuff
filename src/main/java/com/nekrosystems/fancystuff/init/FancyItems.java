package com.nekrosystems.fancystuff.init;

import com.nekrosystems.fancystuff.Config;
import com.nekrosystems.fancystuff.init.helpers.StringHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class FancyItems {

	public static void init() {
	}

	public static void register() {
	}

	public static void registerRenders() {
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
				Config.MOD_ID + ":" + StringHelper.getUnlocalizedName(item), "inventory"));
	}

	public static void registerColoredItemRender(Item item, int index) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, index,
				new ModelResourceLocation(Config.MOD_ID + ":" + StringHelper.getUnlocalizedName(item) + "/"
						+ EnumDyeColor.byMetadata(index).toString(), "inventory"));
	}
}
