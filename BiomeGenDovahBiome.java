package HazzaMod;

import java.util.List;
import java.util.Random;

import net.minecraft.src.*;

public class BiomeGenDovahBiome extends BiomeGenBase 
{
    protected WorldGenDelphiTree Delphi;

	public BiomeGenDovahBiome(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        topBlock = (byte)HazzaMod.PrometheusGrass.blockID;
        fillerBlock = (byte)HazzaMod.AresDirt.blockID;
        this.minHeight = 0.3F;
        this.maxHeight = 1.5F;
        this.biomeName = "Dovah Biome";
       this.theBiomeDecorator.generateLakes = true;
       this.theBiomeDecorator.grassPerChunk = -999;
       this.theBiomeDecorator.flowersPerChunk = -999;
       this.theBiomeDecorator.DelphiTreePerChunk = 10;
       this.spawnableMonsterList.clear();
       this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 15, 1, 2));
       this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 15, 1, 2));
    }
}

