package HazzaMod;
import java.util.Random;

import net.minecraft.src.*;

public class BlockCoroniumOre extends Block
{
	
	public BlockCoroniumOre(int i, int j)
	{
		super(i,j,Material.iron);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public int idDropped(int i, Random random, int par3)
	{
		return HazzaMod.CoroniumDust.shiftedIndex;
		
		
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