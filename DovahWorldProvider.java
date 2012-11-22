package HazzaMod;

import net.minecraft.src.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class DovahWorldProvider extends WorldProvider
{
    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new DovahWorldChunkManager(HazzaMod.DovahBiome, 1.0F, 0.0F);
        this.isHellWorld = false;
        this.hasNoSky = false;
        this.dimensionId = 2 ;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Return Vec3D with biome specific fog color
     */
    public Vec3 getFogColor(float par1, float par2)
    {
        float var3 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }

        if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        float var4 = 0.7529412F;
        float var5 = 0.84705883F;
        float var6 = 1.0F;
        var4 *= var3 * 0.94F + 0.06F;
        var5 *= var3 * 0.94F + 0.06F;
        var6 *= var3 * 0.91F + 0.09F;
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double)var4, (double)var5, (double)var6);
    }

    /**
     * Creates the light to brightness table
     */
    protected void generateLightBrightnessTable()
    {
    	 float var1 = 0.0F;

         for (int var2 = 0; var2 <= 15; ++var2)
         {
             float var3 = 1.0F - (float)var2 / 15.0F;
             this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
         }
    }

    /**
     * Returns the chunk provider back for the world provider
     */
    public IChunkProvider getChunkProvider()
    {
        return new DovahChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return true;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        return false;
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long par1, float par3)
    {
    	 int var4 = (int)(par1 % 24000L);
         float var5 = ((float)var4 + par3) / 24000.0F - 0.25F;

         if (var5 < 0.0F)
         {
             ++var5;
         }

         if (var5 > 1.0F)
         {
             --var5;
         }

         float var6 = var5;
         var5 = 1.0F - (float)((Math.cos((double)var5 * Math.PI) + 1.0D) / 2.0D);
         var5 = var6 + (var5 - var6) / 3.0F;
         return var5;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    public boolean doesXZShowFog(int par1, int par2)
    {
        return true;
    }

    /**
     * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
     */
    public String getDimensionName()
    {
        return "Dovah";
    }
    
    /**
     * the y level at which clouds are rendered.
     */
    public float getCloudHeight()
    {
        return -100F;
    }
}
