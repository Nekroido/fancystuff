package com.nekrosystems.fancystuff;

import com.nekrosystems.fancystuff.events.MobDropsHandler;
import com.nekrosystems.fancystuff.init.Crafting;
import com.nekrosystems.fancystuff.init.FancyBlocks;
import com.nekrosystems.fancystuff.init.FancyEntities;
import com.nekrosystems.fancystuff.init.FancyItems;
import com.nekrosystems.fancystuff.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Config.MOD_ID, name = Config.MOD_NAME, version = Config.MOD_VERSION)
public class FancyStuff {

	@SidedProxy(clientSide = Config.CLIENT_PROXY_CLASS, serverSide = Config.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final FancyStuffTab creativeTab = new FancyStuffTab("creativeTab");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		FancyItems.init();
		FancyItems.register();
		FancyBlocks.init();
		FancyBlocks.register();
		FancyEntities.register();
		Crafting.registeCrafting();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new MobDropsHandler());
	}
}
