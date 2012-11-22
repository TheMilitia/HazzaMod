package HazzaMod;
import java.util.Random;

import net.minecraft.src.*;

public class BlockDelphiLog extends Block
{

    protected BlockDelphiLog(int i)
    {
        super(i, Material.wood);
      
        //blockIndexInTexture = 20;   - Not needed
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return HazzaMod.DelphiLog.blockID;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        byte byte0 = 4;
        int l = byte0 + 1;
        if(world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l))
        {
            for(int i1 = -byte0; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0; j1 <= byte0; j1++)
                {
                    for(int k1 = -byte0; k1 <= byte0; k1++)
                    {
                        int l1 = world.getBlockId(i + i1, j + j1, k + k1);
                        if(l1 != HazzaMod.DelphiLeaves.blockID)  ///Leaf//////////////
                        {
                            continue;
                        }
                        int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
                        if((i2 & 8) == 0)
                        {
                            world.setBlockMetadata(i + i1, j + j1, k + k1, i2 | 8);
                        }
                    }

                }

            }

        }
    }
    
	public int getBlockTextureFromSide(int i)
	   {
        switch(i)
{
        case 0: return 8;
        case 1: return 8;
        default: return 1;
}
	   }





//    protected int damageDropped(int i)
  //  {
    //    return i;
   // }
    public String getTextureFile()
    {
            return "/Hazza/Blocks/HazzaBlocks.png";
    }
    
    
}

