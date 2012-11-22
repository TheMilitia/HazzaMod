package HazzaMod;

import java.util.Random;

import net.minecraft.src.*;

public class BlockDovahFire extends Block
{
    public BlockDovahFire(int par1, int par2)
    {
        super(par1, par2, Material.rock);
  
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {

        if (par1World.getBlockId(par2, par3 - 1, par4) != HazzaMod.MysteriousRock.blockID || !BlockDovahPortal.tryToCreatePortal(par1World, par2, par3, par4))
        {
            if (par3 - 1 != HazzaMod.MysteriousRock.blockID)
            {
                par1World.setBlockWithNotify(par2, par3, par4, 0);

            }
            else
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate() + par1World.rand.nextInt(10));

            }
        }
    }

    
  
}
