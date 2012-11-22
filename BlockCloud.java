package HazzaMod;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCloud extends Block
{
    public BlockCloud(int par1, int par2, Material par3Material, boolean par4)
    {
        super(par1, par2, par3Material);


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
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }
    
 /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	if (par5Entity.fallDistance >= 3){
        	par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
        par5Entity.motionY *= 0.5D;
        par5Entity.fallDistance = 0;

    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    

    
    public String getTextureFile()
    {
            return "/Hazza/Blocks/HazzaBlocks.png";
    }
    
 
}
