package HazzaMod;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.*;

public class BlockChestOfAlexander extends Block
{

	Random rand = new Random();
    protected BlockChestOfAlexander(int i)
    {
        super(i, Material.wood);
      
        //blockIndexInTexture = 20;   - Not needed
    }

    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
    	int a = rand.nextInt(3);

        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        if (a == 0)
        {
            ret.add(new ItemStack(HazzaMod.TazniteHelmet));
            ret.add(new ItemStack(HazzaMod.TazniteLeggings));
        }else
        	if (a == 2){
        		ret.add(new ItemStack(HazzaMod.TazniteAxe));
        		ret.add(new ItemStack(HazzaMod.TaznitePickAxe));
        	}else
        		if(a == 1){
        			ret.add(new ItemStack(HazzaMod.DragonScaleChestplate));
            		ret.add(new ItemStack(HazzaMod.ForeverSeeds));
        		}
        return ret;
    }


	public int getBlockTextureFromSide(int i)
	   {
        switch(i)
{
        case 0: return 15;
        case 1: return 15;
        case 2: return 16;
        case 3: return 17;
        case 4: return 16;
        case 5: return 16;
}
		return i;
	   }


    public String getTextureFile()
    {
            return "/Hazza/Blocks/HazzaBlocks.png";
    }
    
    
}

