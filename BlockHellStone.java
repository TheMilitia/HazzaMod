package HazzaMod;

import java.util.Random;

import net.minecraft.src.*;

public class BlockHellStone extends Block
{
    public BlockHellStone(int par1, int par2)
    {
        super(par1, par2, Material.rock);
  
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return HazzaMod.HellStoneBlock.blockID;
    }
    
    public String getTextureFile()
    {
            return "/Hazza/Blocks/HazzaBlocks.png";
    }
}
