package com.nekrosystems.fancystuff.blocks;

import java.util.List;

import com.nekrosystems.fancystuff.Config;
import com.nekrosystems.fancystuff.init.helpers.StringHelper;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockColored extends Block {
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);

    public BlockColored(String name)
    {
    	super(Material.rock);

		this.setUnlocalizedName(name);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setStepSound(new SoundType("stone", 1f, 1f));

        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.BLACK));        
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
	public int damageDropped(IBlockState state)
	{
		return ((EnumDyeColor) state.getValue(COLOR)).getMetadata();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
        for (EnumDyeColor enumdyecolor : EnumDyeColor.values())
        {
            list.add(new ItemStack(itemIn, 1, enumdyecolor.getMetadata()));
        }
	}
	
	@Override
	public MapColor getMapColor(IBlockState state)
    {
        return ((EnumDyeColor)state.getValue(COLOR)).getMapColor();
    }

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumDyeColor) state.getValue(COLOR)).getMetadata();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { COLOR });
	}
	
	public String getVariantName(ItemStack stack) {
		EnumDyeColor color = EnumDyeColor.byMetadata(stack.getMetadata());
		return /*Config.MOD_ID + ":" + StringHelper.getUnlocalizedNameFromItem(stack.getItem()) + "." +*/ color.toString();
	}
}
