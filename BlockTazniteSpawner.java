package HazzaMod;

import java.util.Random;

import net.minecraft.src.*;

public class BlockTazniteSpawner extends Block
{
    protected BlockTazniteSpawner(int par1, int par2)
    {
        super(par1, par2, Material.ground);

      
    }
    
    public String getTextureFile()
    {
            return "/Hazza/Blocks/HazzaBlocks.png";
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return HazzaMod.TazniteBlock.blockID;
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            EntityDarkDragon var6 = new EntityDarkDragon(par1World);
            EntityHostileVillager var7 = new EntityHostileVillager(par1World);
            EntityHostileVillager var8 = new EntityHostileVillager(par1World);
            EntityHostileVillager var9 = new EntityHostileVillager(par1World);
            var6.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            var7.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            var8.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            var9.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(var6);
            par1World.spawnEntityInWorld(var7);
            par1World.spawnEntityInWorld(var8);
            par1World.spawnEntityInWorld(var9);
            var6.spawnExplosionParticle();
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }
    


}

