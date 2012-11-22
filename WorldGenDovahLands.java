package HazzaMod;



import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.src.WorldGenerator;

public class WorldGenDovahLands implements IWorldGenerator {
    /** The world the BiomeDecorator is currently decorating */
    protected World currentWorld;
    protected WorldGenerator generateDelphiTree = new WorldGenDelphiTree();

public void generate(Random random, int chunkX, int chunkZ, World world,
IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

switch (world.provider.dimensionId)
{
case -1: generateNether(world, random, chunkX*16, chunkZ*16);
break;
case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
break;
case 1: generateEnd(world, random, chunkX*16, chunkZ*16);
break;
case 2: generateDovah(world,random, chunkX*16, chunkZ*16);
break;
}
}

private void generateSurface(World world, Random random, int blockX, int blockZ)
{

}

private void generateNether(World world, Random random, int blockX, int blockZ)
{

}

private void generateEnd(World world, Random random, int blockX, int blockZ)
{

}

private void generateDovah(World world, Random random, int blockX, int blockZ)
{
	WorldGenDelphiTree tree = new WorldGenDelphiTree(); 
	  WorldGenerator generateDelphiTree;
	  this.generateDelphiTree = new WorldGenDelphiTree();
	  
	for (int i = 0;  i < 1;  i++)
	{
		int randPosX = blockX + random.nextInt(16);
		int randPosY = random.nextInt(60);
		int randPosZ = blockZ + random.nextInt(16);
		(new WorldGenDovahMinable(HazzaMod.TazmiteOre.blockID, 6)).generate(world, random, randPosX, randPosY , randPosZ);
	}
	
	for (int i = 0;  i < 20;  i++)
	{
		int randPosX = blockX + random.nextInt(16);
		int randPosY = random.nextInt(150);
		int randPosZ = blockZ + random.nextInt(16);
		(new WorldGenDovahMinable(HazzaMod.CoroniumOre.blockID, 12)).generate(world, random, randPosX, randPosY , randPosZ);
	}
	
	for (int j = 0;  j < 50;  j++)
	{
		int randPosX = blockX + random.nextInt(16);
		int randPosY = random.nextInt(150);
		int randPosZ = blockZ + random.nextInt(16);
		(new WorldGenDovahFlowers()).generate(world, random, randPosX, randPosY, randPosZ);
	}
	

	
	
	for (int i = 0; i < 10; ++i)
	{
	int randPosX = blockX + random.nextInt(16) + 8;
	int randPosZ = blockZ + random.nextInt(16) + 8;
	int RandY = world.getHeightValue(blockX, blockZ);
	this.generateDelphiTree.generate(world, random, randPosX, RandY, randPosZ);
	}
	
	if (random.nextInt(2) == 0){
	for (int i = 0;  i < 20;  i++)
	{
		int randPosX = blockX + random.nextInt(16);
		int randPosY = random.nextInt(60);
		int randPosZ = blockZ + random.nextInt(16);
		(new WorldGenClouds(HazzaMod.Cloud.blockID, 15)).generate(world, random, randPosX, 130, randPosZ);
	}
	}
	
	if (random.nextInt(499) == 0){
	for (int i = 0; i < 1; ++i)
	{
	int randPosX = blockX + random.nextInt(16) + 8;
	int randPosZ = blockZ + random.nextInt(16) + 8;

	(new WorldGenAncientRuins()).generate(world, random, randPosX, 130, randPosZ);
	}
	}

	
	
}

}