package HazzaMod;
import java.util.Random;

import net.minecraft.src.*;

public class BlockTazniteOre extends Block
{
	
	public BlockTazniteOre(int i, int j)
	{
		super(i,j,Material.iron);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public int idDropped(int i, Random random, int par3)
	{
		return HazzaMod.TazniteGem.shiftedIndex;
		
		
	}
	
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	 public String getTextureFile()
	    {
	            return "/Hazza/Blocks/HazzaBlocks.png";
	    }
	 
}