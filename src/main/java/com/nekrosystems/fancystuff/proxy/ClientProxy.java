package com.nekrosystems.fancystuff.proxy;

import com.nekrosystems.fancystuff.init.FancyBlocks;
import com.nekrosystems.fancystuff.init.FancyItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders(){
		FancyItems.registerRenders();
		FancyBlocks.registerRenders();
	}
}
