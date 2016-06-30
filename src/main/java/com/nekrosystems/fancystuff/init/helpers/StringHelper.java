package com.nekrosystems.fancystuff.init.helpers;

import java.util.regex.Pattern;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class StringHelper {
	public static String getUnlocalizedName(Block item) {
		String name = item.getUnlocalizedName();

		return getUnlocalizedName(name);
	}

	public static String getUnlocalizedName(Item item) {
		String name = item.getUnlocalizedName();

		return getUnlocalizedName(name);
	}

	public static String getUnlocalizedName(String name) {
		Pattern p = Pattern.compile("^tile\\.(\\w+)\\W{0,1}(.*?)", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
	    return p.matcher(name).replaceAll("$1");
	}
}
