// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package HazzaMod;

import java.util.Random;

import net.minecraft.src.*;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, World, WorldGenTaiga2, WorldGenForest, 
//            WorldGenTrees, WorldGenBigTree, WorldGenerator

public class BlockDelphiSapling extends BlockFlower
{

    protected BlockDelphiSapling(int i, int j)
    {
        super(i, j);
        float f = 0.4F;

        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }
    
    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == HazzaMod.PrometheusGrass.blockID;
    }
    
    
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        
        
        super.updateTick(world, i, j, k, random);
        
        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
        {
            int l = world.getBlockMetadata(i, j, k);
            if((l & 8) == 0)
            {
                world.setBlockMetadataWithNotify(i, j, k, l | 8);
            } else
            {
                growTree(world, i, j, k, random);
            }
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        j &= 3;
        if(j == 1)
        {
            return blockIndexInTexture;  //63
        }
        if(j == 2)
        {
            return blockIndexInTexture; //79
        } else
        {
            //return super.getBlockTextureFromSideAndMetadata(i, j);
        	return blockIndexInTexture;
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k) & 3;
        world.setBlock(i, j, k, 0);
        Object obj = null;
        obj = new WorldGenDelphiTree();
  
        
        if(!((WorldGenerator) (obj)).generate(world, random, i, j, k))
        {
            world.setBlockAndMetadata(i, j, k, blockID, l);
        }
    }


    public String getTextureFile()
    {
            return "/Hazza/Blocks/HazzaBlocks.png";
    }
}
