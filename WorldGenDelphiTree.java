package HazzaMod;
import java.util.Random;

import net.minecraft.src.*;

public class WorldGenDelphiTree extends WorldGenerator
{
	public WorldGenDelphiTree()
	{		
	}
	
	public boolean generate(World world, Random random, int x, int y, int z)
    {
		if(world.getBlockId(x, y - 1, z) == HazzaMod.PrometheusGrass.blockID && world.getBlockId(x, y + 1, z) == 0){
		world.setBlockWithNotify(x, y, z, HazzaMod.DelphiLog.blockID);
		world.setBlockWithNotify(x, y + 1, z, HazzaMod.DelphiLog.blockID);
		world.setBlockWithNotify(x, y + 2, z, HazzaMod.DelphiLog.blockID);
		world.setBlockWithNotify(x, y + 3, z, HazzaMod.DelphiLog.blockID);
		world.setBlockWithNotify(x, y + 4, z, HazzaMod.DelphiLog.blockID);
		world.setBlockWithNotify(x, y + 5, z, HazzaMod.DelphiLeaves.blockID);


		world.setBlockWithNotify(x, y + 2, z + 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x, y + 3, z + 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x, y + 4, z + 1, HazzaMod.DelphiLeaves.blockID);

		world.setBlockWithNotify(x, y + 2, z - 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x, y + 3, z - 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x, y + 4, z - 1, HazzaMod.DelphiLeaves.blockID);

		world.setBlockWithNotify(x - 1 , y + 2, z , HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x - 1 , y + 3, z , HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x - 1 , y + 4, z , HazzaMod.DelphiLeaves.blockID);
	
		world.setBlockWithNotify(x + 1, y + 2, z, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x + 1, y + 3, z, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x + 1, y + 4, z, HazzaMod.DelphiLeaves.blockID);

		world.setBlockWithNotify(x + 1, y + 2, z + 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x + 1, y + 3, z + 1, HazzaMod.DelphiLeaves.blockID);

		world.setBlockWithNotify(x - 1, y + 2, z - 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x - 1, y + 3, z - 1, HazzaMod.DelphiLeaves.blockID);


		world.setBlockWithNotify(x + 1, y + 2, z - 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x + 1, y + 3, z - 1, HazzaMod.DelphiLeaves.blockID);


		world.setBlockWithNotify(x - 1, y + 2, z + 1, HazzaMod.DelphiLeaves.blockID);
		world.setBlockWithNotify(x - 1, y + 3, z + 1, HazzaMod.DelphiLeaves.blockID);
		return true;
    }
		return false;
	
}
	}
