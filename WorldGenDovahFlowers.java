package HazzaMod;

import java.util.Random;

import net.minecraft.src.*;

public class WorldGenDovahFlowers extends WorldGenerator
{

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		
		if(world.getBlockId(x, y - 1, z) == HazzaMod.PrometheusGrass.blockID && world.getBlockId(x, y + 1, z) == 0){
			world.setBlockWithNotify(x, y, z, HazzaMod.ForeverBerryBush.blockID);
			
		return true;
		}
		
		return false;
	}
}