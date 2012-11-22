package HazzaMod;

import static net.minecraftforge.common.ForgeDirection.UP;

import java.util.Random;

import net.minecraft.src.*;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockPrometheusGrass extends Block
{
    protected BlockPrometheusGrass(int par1, int par2)
    {
        super(par1, par2, Material.ground);
        this.setTickRandomly(true);
      
    }
    
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
    	return true;
    }
    
	public int getBlockTextureFromSide(int i)
	   {
     switch(i)
{
     case 0: return 6;
     case 1: return 4;
     default: return 5;
}
	   }
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return HazzaMod.AresDirt.idDropped(0, par2Random, par3);
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && Block.lightOpacity[par1World.getBlockId(par2, par3 + 1, par4)] > 2)
            {
                par1World.setBlockWithNotify(par2, par3, par4, HazzaMod.AresDirt.blockID);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int var6 = 0; var6 < 4; ++var6)
                {
                    int var7 = par2 + par5Random.nextInt(3) - 1;
                    int var8 = par3 + par5Random.nextInt(5) - 3;
                    int var9 = par4 + par5Random.nextInt(3) - 1;
                    int var10 = par1World.getBlockId(var7, var8 + 1, var9);

                    if (par1World.getBlockId(var7, var8, var9) == HazzaMod.AresDirt.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && Block.lightOpacity[var10] <= 2)
                    {
                        par1World.setBlockWithNotify(var7, var8, var9, HazzaMod.PrometheusGrass.blockID);
                    }
                }
            }
        }
        
        
    }
	   public String getTextureFile()
	    {
	            return "/Hazza/Blocks/HazzaBlocks.png";
	    }
}

