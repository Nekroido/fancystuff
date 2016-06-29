package com.nekrosystems.fancystuff.init.helpers;

import com.nekrosystems.fancystuff.Config;

import net.minecraft.block.Block.SoundType;

public class FancySoundType extends SoundType {
	
    public FancySoundType(String name, float volume, float frequency)
    {
        super(name, 1.0f, 1.0f);
    }

    public float getVolume()
    {
        return this.volume;
    }

    public float getFrequency()
    {
        return this.frequency;
    }

    /**
     * Get the breaking sound for the Block
     */
    public String getBreakSound()
    {
        return Config.MOD_ID + ":dig." + this.soundName;
    }

    public String getStepSound()
    {
        return Config.MOD_ID + ":step." + this.soundName;
    }

    public String getPlaceSound()
    {
        return this.getBreakSound();
    }
}
