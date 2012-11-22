package HazzaMod;
import java.util.Random;

import net.minecraft.src.*;

public class BlockDelphiPlanks extends Block
{
	
	protected BlockDelphiPlanks(int i, int j)
	{
		super(i,j,Material.iron);
		this.setCreativeTab(CreativeTabs.tabMisc);
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