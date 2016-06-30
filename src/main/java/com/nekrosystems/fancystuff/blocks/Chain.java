package com.nekrosystems.fancystuff.blocks;

import com.nekrosystems.fancystuff.FancyMaterial;
import com.nekrosystems.fancystuff.init.helpers.BlockTransparent;
import com.nekrosystems.fancystuff.sounds.ChainSound;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.ISound.AttenuationType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Chain extends BlockTransparent {

	public Chain(String name) {
		super(FancyMaterial.chain);

		this.setUnlocalizedName(name);
		this.setHardness(.5f);
		this.setResistance(30f);
		this.setStepSound(new ChainSound());
		this.setLightOpacity(0);
		
		this.setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 1f, 0.75f);
	}

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
}
