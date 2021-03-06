package com.nekrosystems.fancystuff.blocks;

import com.nekrosystems.fancystuff.FancyMaterial;
import com.nekrosystems.fancystuff.init.helpers.BlockTransparent;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Rope extends BlockTransparent {
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");

	public Rope(String name) {
		super(FancyMaterial.rope);
		
		this.setUnlocalizedName("rope");
		this.setHardness(.2f);
		this.setResistance(10f);
		this.setLightOpacity(0);
		
		this.setBlockBounds(0.325f, 0f, 0.325f, 0.675f, 1f, 0.675f);
	}
	
	public Rope(Material material, MapColor mapColor) {
		super(material, mapColor);

		this.setDefaultState(this.blockState.getBaseState().withProperty(DOWN, false).withProperty(UP, false));
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean isFullCube() {
		return false;
	}
	
	@Override
	public boolean isLadder(IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
		return true;
	}

	/**
	 * Check if rope can connect with a knot to a block
	 * @param worldIn
	 * @param pos
	 * @return
	 */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos).getBlock();
		return block == Blocks.barrier ? false : !(block instanceof Rope);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state
				.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()))
				.withProperty(UP, this.canConnectTo(worldIn, pos.up()));
	}
	
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {DOWN, UP});
    }
}
