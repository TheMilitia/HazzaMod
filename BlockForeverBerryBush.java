package HazzaMod;


//NEEDS REDOING (Deadline - Version Beta 2.0)
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.*;
import net.minecraftforge.common.ForgeDirection;

public class BlockForeverBerryBush extends BlockFlower
{
    protected BlockForeverBerryBush(int par1, int par2)
    {
        super(par1, par2);
        this.blockIndexInTexture = par2;
        this.setTickRandomly(true);
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
        this.setCreativeTab((CreativeTabs)null);
        this.setRequiresSelfNotify();
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
           if (par5 == 7)
            {
            	par1World.setBlockWithNotify(par2, par3, par4, HazzaMod.ForeverBerryBush.blockID);
            }
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }
    
    
    
    public String getTextureFile(){
    	return "/Hazza/Blocks/HazzaBlocks.png";
    }
    
    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */

    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == HazzaMod.AresDirt.blockID || par1 == HazzaMod.PrometheusGrass.blockID || !(par1 == Block.grass.blockID);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);

            if (var6 < 7)
            {
                float var7 = this.getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(0.0F / var7) + 1) == 0)
                {
                    ++var6;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6);
                }
            }
        }
    }

    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
    }

    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float var5 = 1.0F;
        int var6 = par1World.getBlockId(par2, par3, par4 - 1);
        int var7 = par1World.getBlockId(par2, par3, par4 + 1);
        int var8 = par1World.getBlockId(par2 - 1, par3, par4);
        int var9 = par1World.getBlockId(par2 + 1, par3, par4);
        int var10 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int var11 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int var12 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int var13 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean var14 = var8 == this.blockID || var9 == this.blockID;
        boolean var15 = var6 == this.blockID || var7 == this.blockID;
        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

        for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17)
        {
            for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18)
            {
                int var19 = par1World.getBlockId(var17, par3 - 1, var18);
                float var20 = 0.0F;

                if (var19 == HazzaMod.AresDirt.blockID)
                {
                    var20 = 1.0F;

                    if (par1World.getBlockMetadata(var17, par3 - 1, var18) > 0)
                    {
                        var20 = 3.0F;
                    }
                }

                if (var17 != par2 || var18 != par4)
                {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15)
        {
            var5 /= 2.0F;
        }

        return var5;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par2 == 0)
        {
            return HazzaMod.ForeverBerryBush.blockIndexInTexture - 1;
        }
        if (par2 == 1)
        {
        	return HazzaMod.ForeverBerryBush.blockIndexInTexture - 1;
        }
        if (par2 == 2)
        {
        	return HazzaMod.ForeverBerryBush.blockIndexInTexture - 1;
        }
        if (par2 == 3)
        {
        	return HazzaMod.ForeverBerryBush.blockIndexInTexture - 1;
        }
        if (par2 == 4)
        {
        	return HazzaMod.ForeverBerryBush.blockIndexInTexture - 1 ;
        }
        if (par2 == 5)
        {
        	return HazzaMod.ForeverBerryBush.blockIndexInTexture - 1;
        }
        if (par2 == 6)
        {
        	return HazzaMod.ForeverBerryBush.blockIndexInTexture - 1;
        }
        if (par2 == 7)
        {
        	return HazzaMod.ForeverBerryBush.blockIndexInTexture;
        }
        
		return -1;
    
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }
    
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }
    
    
    //Returns ForeverBerry and ForeverBerry Bush    
    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        if (metadata == 7)
        {
            ret.add(new ItemStack(HazzaMod.ForeverBerry));
        }
        return ret;
    }
    

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3,int par2)
    {
        return par1 == 7 ? HazzaMod.ForeverBerry.shiftedIndex : -1;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return HazzaMod.ForeverBerryBush.blockID;
    }
}
