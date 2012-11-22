package HazzaMod;

import net.minecraft.src.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.src.Achievement;
import net.minecraft.src.AchievementList;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemSeeds;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.WorldGenerator;
import net.minecraftforge.common.*;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.liquids.LiquidDictionary;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
//Intended For 1.4.4
//Pre-Unrelease for Beta 1.9.2

/*
 * Bugs
 * NEEDS A CONFIG FILE!!!!!
 * Needs Higher Block And Item ID's 
 * Achievements Don't Work (Something to do with the first achievement on the custom page)
 * Mobs Slow Down When You Hit Them
 * Tools And Swords Need Some Work
 * Forever Berry Bush Needs Some Work
 * 
 */

@Mod(modid = "xDesert122_HazzaMod", name = "Hazza! Mod", version = "Beta")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class HazzaMod {
	
	static EnumArmorMaterial SCALEARMOR = EnumHelper.addArmorMaterial("SCALEARMOR", 40, new int[] { 3, 8, 6, 3 }, 10);
	static EnumArmorMaterial TAZNITE = EnumHelper.addArmorMaterial("TAZNITE",35, new int[] {3,8,6,3}, 10);
	static EnumToolMaterial Coal = EnumHelper.addToolMaterial("Coal", 0, 10, 1F, 1, 5);
	static EnumToolMaterial HellStone = EnumHelper.addToolMaterial("HellStone", 1, 225, 5F, 2, 0);
	static EnumToolMaterial Taznite = EnumHelper.addToolMaterial("Taznite", 3, 2000, 8.1F, 15, 15);
	static EnumToolMaterial Delphi = EnumHelper.addToolMaterial("Delphi", 0, 75, 3F, 1, 5);
	public static final Item DragonScale = new HazzaItems(12222);
	public static final Item DragonScaleBar = new HazzaItems(12223);
	public static final Item DragonScaleHelmet = (new ItemTypeArmor(12224, SCALEARMOR, 5, 0));
	public static final Item DragonScaleChestplate = (new ItemTypeArmor(12225,SCALEARMOR, 5, 1));
	public static final Item DragonScaleLeggings = (new ItemTypeArmor(12226, SCALEARMOR, 5, 2));
	public static final Item DragonScaleBoots = (new ItemTypeArmor(12227, SCALEARMOR, 5, 3));
	public static final Item DragonFlesh = (new ItemTypeFood(12228, 20, 0.3F, false)).setPotionEffect(Potion.heal.id, 30,1, 1F);
	public static final Item CoalSword = new ItemTypeSword (12229, Coal);
	public static final Item SwordOfZeus = new ItemTypeSpecialSword(12230,Coal);
	public static final Item MythicalBottle = new ItemMysticalBottle(12231);
	public static final Item WaterBottle = new HazzaItems(12232);
	public static final Item GodlyPotion = new HazzaItems(12233);
	public static final Item HellStoneSword = (new ItemTypeSword(12234,HellStone));
	public static final Item HellStonePickaxe = (new ItemTypePickaxe(12235,HellStone));
	public static final Item HellStoneAxe = (new ItemTypeAxe(12236, HellStone));
	public static final Item HellStoneShovel = (new ItemTypeShovel(12237,HellStone));
	public static final Item HellStoneHoe = (new ItemTypeHoe(12238,HellStone));
	public static final Item TazniteGem = new HazzaItems (12239);
	public static final Item TaznitePickAxe = new ItemTypePickaxe (12240, Taznite);
	public static final Item TazniteAxe = new ItemTypeAxe (12241, Taznite);
	public static final Item TazniteSword = new ItemTypeSword (12242, Taznite);
	public static final Item TazniteHoe = new ItemTypeHoe (12243, Taznite);
	public static final Item TazniteShovel = new ItemTypeShovel (12244, Taznite);
	public static final Item DelphiStick = new HazzaItems(12245);
	public static final Item TazniteHelmet = (new ItemTypeArmor(12246, TAZNITE, 6, 0));
	public static final Item TazniteChestplate = (new ItemTypeArmor(12247, TAZNITE, 6, 1));
	public static final Item TazniteLeggings = (new ItemTypeArmor(12248, TAZNITE, 6, 2));
	public static final Item TazniteBoots = (new ItemTypeArmor(12249,  TAZNITE, 6, 3));
	public static final Item DelphiSword = (new ItemTypeSword(12250,Delphi));
	public static final Item DelphiPickaxe = (new ItemTypePickaxe(12251,Delphi));
	public static final Item DelphiAxe = (new ItemTypeAxe(12252, Delphi));
	public static final Item DelphiShovel = (new ItemTypeShovel(12253,Delphi));
	public static final Item DelphiHoe = (new ItemTypeHoe(12254,Delphi));
	public static final Item ForeverBerry =  (new ItemTypeFood(12255, 2, 0.3F, false));
	public static final Item CookedRatMeat = (new ItemTypeFood(12256, 2, 1F, false));
	public static final Item MysticalKey = new ItemKey(12257);
	//Slot 12259 ForeverSeeds                             (12258)
	public static final Item CoroniumDust = new HazzaItems(12259);

	public static final Block HellStoneBlock =  new BlockHellStone (150,0).setHardness(2.0F).setResistance(10F);
	public static final Block DelphiLog =  new BlockDelphiLog (151).setHardness(1.5F).setResistance(8F).setBlockName("Delphi Log");
	public static final Block DelphiSapling =  new BlockDelphiSapling (152,2).setHardness(0.0F).setBlockName("Delphi Sapling").setRequiresSelfNotify();
	public static final Block DelphiLeaves =  new BlockDelphiLeaves (153, 3).setHardness(0.2F).setLightOpacity(1).setBlockName("Delphi Leaves").setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify();
	public static final Block PrometheusGrass = new BlockPrometheusGrass(154, 4).setHardness(0.5F).setBlockName("PrometheusGrass");
	public static final Block AresDirt = new BlockAresDirt(155, 6).setHardness(0.5F).setBlockName("AresDirt");
	public static final Block TazmiteOre = new BlockTazniteOre (156, 7).setHardness(4F).setResistance(15F).setBlockName("Taznite Ore");
	public static final Block DelphiPlanks = new BlockDelphiPlanks(157,10).setHardness(2.0F).setResistance(5F).setRequiresSelfNotify();
	public static final Block MysteriousRock = new BlockMysteriousRock(158, 9).setHardness(0.5F).setStepSound(Block.soundMetalFootstep);
	public static final Block ForeverBerryBush = new BlockForeverBerryBush(159,12).setHardness(0.1F);
	public static final Block HazzaPortal = new BlockDovahPortal(160, 14).setResistance(6000000.0F).setBlockUnbreakable();
	public static final Block HazzaFire = new BlockDovahFire(161,31).setHardness(0F);
	public static final Block Cloud = new BlockCloud(162, 13, Material.glass, false).setHardness(0F);
	public static final Block AncientBricks = new BlockAncientBricks(163,14).setHardness(2.0F).setResistance(10F);
	public static final Block ChestOfAlexander = new BlockChestOfAlexander(164).setHardness(2.0F).setResistance(10F);
	public static final Block TazniteBlock = new BlockTaznite(165,18).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep);
	public static final Block TazniteSpawner = new BlockTazniteSpawner(166,18).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep);
	public static final Block CoroniumOre = new BlockCoroniumOre (167, 19).setHardness(4F).setResistance(15F).setBlockName("Coronium Ore");
	public static final Block CoroniumTorch = new BlockCoroniumTorch (168, 20).setLightValue(1F).setBlockName("Coronium Torch");
	public static final Item ForeverSeeds = new ItemForeverSeeds(12258, HazzaMod.ForeverBerryBush.blockID, HazzaMod.PrometheusGrass.blockID);
	public static final BiomeGenBase DovahBiome = (new BiomeGenDovahBiome(25));
	public static final Achievement WhatInThe = (new Achievement (2006, "What In The World...", 0,0, HazzaMod.MysticalKey, null)).setIndependent().registerAchievement();
	public static final Achievement TheScaleOfLife = (new Achievement (2000, "The Scale Of Life", 5, 6, HazzaMod.DragonScale, WhatInThe)).setSpecial().registerAchievement();
	public static final Achievement FoodOfTheGods = (new Achievement (2001, "Food Of The Gods", 5, 4, HazzaMod.DragonFlesh, WhatInThe)).setIndependent().registerAchievement();
	public static final Achievement GemOfGreed = (new Achievement (2002, "The Gem Of Greed", 6, 5, HazzaMod.TazniteGem, FoodOfTheGods)).registerAchievement();
	public static final Achievement FireDirt = (new Achievement (2003, "The Fire Dirt", 7, 4, HazzaMod.AresDirt, FoodOfTheGods)).registerAchievement();
	public static final Achievement Interesting = (new Achievement (2004, "Very Interesting...", 7, 6, HazzaMod.MysteriousRock, WhatInThe)).registerAchievement();
	public static final Achievement rat = (new Achievement (2005, "Willard.", 7,8, HazzaMod.CookedRatMeat, FoodOfTheGods)).registerAchievement();
	public static AchievementPage HazzaAcheivementPage = new AchievementPage("The Hazza! Mod", WhatInThe, FoodOfTheGods, TheScaleOfLife, Interesting,FireDirt,GemOfGreed,rat);

	@Init
	public void init(FMLInitializationEvent event) {
		
	//Registers Achievement Page	
	AchievementPage.registerAchievementPage(HazzaAcheivementPage);
		
	//Pre-loads Textures
	MinecraftForgeClient.preloadTexture("/Hazza/Items/HazzaItems.png");
    MinecraftForgeClient.preloadTexture("/Hazza/Blocks/HazzaBlocks.png");
		
    //Registers Pickup And Crafting Handlers (Includes Smelting)
	GameRegistry.registerPickupHandler( new HazzaPickupHandler());
	GameRegistry.registerCraftingHandler(new HazzaCraftingHandler());

		
	//Registers Dimension
	DimensionManager.registerProviderType(2, DovahWorldProvider.class, false);
    DimensionManager.registerDimension(2, 2);
		 
	//Registers WorldGenerator NEEDED FOR TAZNITE GENERATION!
	GameRegistry.registerWorldGenerator(new WorldGenDovahLands());

	//Add Name
	DragonScale.setItemName("Dragon Scale");
	DragonScaleBar.setItemName("Dragon Scale Bar");
	DragonScaleHelmet.setItemName("Dragon Scale Helmet");
	DragonScaleChestplate.setItemName("Dragon Scale Chestplate");
	DragonScaleLeggings.setItemName("Dragon Scale Leggings");
	DragonScaleBoots.setItemName("Dragon Scale Boots");
	DragonFlesh.setItemName("DragonFlesh");
	CoalSword.setItemName("CoalSword");
	SwordOfZeus.setItemName("SwordOfZeus");
	MythicalBottle.setItemName("MyhticalBottle");
	WaterBottle.setItemName("WaterBottle");
	GodlyPotion.setItemName("GodlyPotion");
	HellStoneSword.setItemName("HellStoneSword");
	HellStonePickaxe.setItemName("HellStonePickaxe");
	HellStoneAxe.setItemName("HellStoneAxe");
	HellStoneShovel.setItemName("HellStoneShovel");
	HellStoneHoe.setItemName("HellStoneHoe");
	HellStoneBlock.setBlockName("Hellstone");
	DelphiLog.setBlockName("Delphi Log");
	DelphiSapling.setBlockName("Delphi Sapling");
	DelphiLeaves.setBlockName("Delphi Leaves");
	PrometheusGrass.setBlockName("Prometheus Grass");
	AresDirt.setBlockName("Ares Dirt");
	TazniteGem.setItemName("TazniteGem");
	TazniteSword.setItemName("TazniteSword");
	TaznitePickAxe.setItemName("TaznitePickAxe");
	TazniteAxe.setItemName("TazniteAxe");
	TazniteShovel.setItemName("TazniteShovel");
	TazniteHoe.setItemName("TazniteHoe");
	TazmiteOre.setBlockName("Taznite");
	DelphiPlanks.setBlockName("Delphi Planks");
	MysteriousRock.setBlockName("Mysterious Rock");
	DelphiStick.setItemName("Delphi Stick");
	TazniteHelmet.setItemName("Taznite Helmet");
	TazniteChestplate.setItemName("Taznite Chestplate");
	TazniteLeggings.setItemName("Taznite Leggings");
	TazniteBoots.setItemName("Taznite Boots");
	DelphiSword.setItemName("Delphi Wood Sword");
	DelphiPickaxe.setItemName("Delphi Wood Pickaxe");
	DelphiAxe.setItemName("Delphi Wood Axe");
	DelphiShovel.setItemName("Delphi Shovel");
	DelphiHoe.setItemName("Delphi Wood Hoe");
	ForeverBerryBush.setBlockName("Forever Berry Bush");
	ForeverBerry.setItemName("Forever Berry Bush");
	HazzaPortal.setBlockName("Hazza Portal");
	CookedRatMeat.setItemName("Cooked Rat Meat");
	MysticalKey.setItemName("Mystical Key");
	HazzaFire.setBlockName("Hazza Fire");
	ForeverSeeds.setItemName("Forever Seeds");
	Cloud.setBlockName("Cloud");
	AncientBricks.setBlockName("Ancient Bricks");
	ChestOfAlexander.setBlockName("Chest Of Alexander");
	TazniteBlock.setBlockName("Taznite");
	TazniteSpawner.setBlockName("Taznite Spawner");
	CoroniumOre.setBlockName("Coronium Ore");
	CoroniumTorch.setBlockName("Coronium Torch");
	CoroniumDust.setItemName("Coronium Dust");
	
	//ModLoader Add Name
	LanguageRegistry.addName(DragonScale, "Dragon Scale");
	LanguageRegistry.addName(DragonScaleBar, "Dragon Scale Bar");
	LanguageRegistry.addName(DragonScaleHelmet, "Dragon Scale Helmet");
	LanguageRegistry.addName(DragonScaleChestplate, "Dragon Scale Chestplate");
	LanguageRegistry.addName(DragonScaleLeggings, "Dragon Scale Leggins");
	LanguageRegistry.addName(DragonScaleBoots, "Dragon Scale Boots");
	LanguageRegistry.addName(DragonFlesh, "Dragon Flesh");
	LanguageRegistry.addName(CoalSword, "Coal Sword");
	LanguageRegistry.addName(SwordOfZeus, "Sword Of Zues");
	LanguageRegistry.addName(MythicalBottle, "Mythical Bottle");
	LanguageRegistry.addName(WaterBottle, "Water Bottle");
	LanguageRegistry.addName(GodlyPotion, "Godly Potion");
	LanguageRegistry.addName(HellStoneSword, "HellStone Sword");
	LanguageRegistry.addName(HellStonePickaxe, "HellStone Pickaxe");
	LanguageRegistry.addName(HellStoneAxe, "HellStone Axe");
	LanguageRegistry.addName(HellStoneShovel, "HellStoneShovel");
	LanguageRegistry.addName(HellStoneHoe, "HellStone Hoe");
	LanguageRegistry.addName(HellStoneBlock, "HellStone");
	LanguageRegistry.addName(TazniteGem, "Taznite Gem");
	LanguageRegistry.addName(TazniteSword, "Taznite Sword");
	LanguageRegistry.addName(TaznitePickAxe, "Taznite Pickaxe");
	LanguageRegistry.addName(TazniteAxe, "Taznite Axe");
	LanguageRegistry.addName(TazniteShovel, "Taznite Shovel");
	LanguageRegistry.addName(TazniteHoe, "Taznite Hoe");
	LanguageRegistry.addName(DelphiLog, "Delphi Log");
	LanguageRegistry.addName(DelphiSapling, "Delphi Sapling");
	LanguageRegistry.addName(DelphiLeaves, "Delphi Leaves");
	LanguageRegistry.addName(PrometheusGrass, "Prometheus Grass");
	LanguageRegistry.addName(AresDirt, "Ares Dirt");
	LanguageRegistry.addName(TazmiteOre, "Taznite Ore");
	LanguageRegistry.addName(DelphiPlanks, "Delphi Planks");
	LanguageRegistry.addName(MysteriousRock, "Mysterious Rock");
	LanguageRegistry.addName(DelphiStick, "Delphi Stick");
	LanguageRegistry.addName(TazniteHelmet, "Taznite Helmet");
	LanguageRegistry.addName(TazniteChestplate, "Taznite Chestplate");
	LanguageRegistry.addName(TazniteLeggings, "Taznite Leggings");
	LanguageRegistry.addName(TazniteBoots, "Taznite Boots");
	LanguageRegistry.addName(DelphiSword, "Delphi Wood Sword");
	LanguageRegistry.addName(DelphiPickaxe, "Delphi Wood Pickaxe");
	LanguageRegistry.addName(DelphiAxe, "Delphi Wood Axe");
	LanguageRegistry.addName(DelphiShovel, "Delphi Wood Shovel");
	LanguageRegistry.addName(DelphiHoe, "Delphi Wood Hoe");
	LanguageRegistry.addName(ForeverBerryBush, "Forever Berry Bush");
	LanguageRegistry.addName(ForeverBerry, "Forever Berry");
	LanguageRegistry.addName(HazzaPortal, "Hazza Portal");
	LanguageRegistry.addName(CookedRatMeat, "Cooked Rat Meat");
	LanguageRegistry.addName(MysticalKey, "Mystical Key");
	LanguageRegistry.addName(HazzaFire, "Fire");
	LanguageRegistry.addName(ForeverSeeds, "Foreverberry Bush");
	LanguageRegistry.addName(Cloud, "Cloud");
	LanguageRegistry.addName(AncientBricks, "Ancient Bricks");
	LanguageRegistry.addName(ChestOfAlexander, "Chest Of Alexander");
	LanguageRegistry.addName(TazniteBlock, "Taznite");
	LanguageRegistry.addName(TazniteSpawner, "Taznite Spawner");
	LanguageRegistry.addName(CoroniumOre, "Coronium Ore");
	LanguageRegistry.addName(CoroniumTorch, "Coronium Torch");
	LanguageRegistry.addName(CoroniumDust, "Coronium Dust");
	
	//Icon Index
	DragonScale.setIconIndex(0);
	DragonScaleBar.setIconIndex(1);
	DragonScaleHelmet.setIconIndex(2);
	DragonScaleChestplate.setIconIndex(3);
	DragonScaleLeggings.setIconIndex(4);
	DragonScaleBoots.setIconIndex(5);
	DragonFlesh.setIconIndex(6);
	CoalSword.setIconIndex(7);
	SwordOfZeus.setIconIndex(8);
	MythicalBottle.setIconIndex(9);
	WaterBottle.setIconIndex(10);
	GodlyPotion.setIconIndex(11);
	HellStoneSword.setIconIndex(12);
	HellStonePickaxe.setIconIndex(13);
	HellStoneAxe.setIconIndex(14);
	HellStoneShovel.setIconIndex(15);
	HellStoneHoe.setIconIndex(16);
	TazniteGem.setIconIndex(17);
	TazniteSword.setIconIndex(18);
	TaznitePickAxe.setIconIndex(19);
	TazniteAxe.setIconIndex(20);
	TazniteShovel.setIconIndex(21);
	TazniteHoe.setIconIndex(22);
	DelphiStick.setIconIndex(23);
	TazniteHelmet.setIconIndex(24);
	TazniteChestplate.setIconIndex(25);
	TazniteLeggings.setIconIndex(26);
	TazniteBoots.setIconIndex(27);
	DelphiSword.setIconIndex(28);
	DelphiPickaxe.setIconIndex(29);
	DelphiAxe.setIconIndex(30);
	DelphiShovel.setIconIndex(31);
	DelphiHoe.setIconIndex(32);
	ForeverBerry.setIconIndex(33);
	CookedRatMeat.setIconIndex(34);
	MysticalKey.setIconIndex(35);
	ForeverSeeds.setIconIndex(12);
	CoroniumDust.setIconIndex(36);
	
	
	//Tab Displays
	DragonScale.setCreativeTab(CreativeTabs.tabMaterials);
	DragonScale.setCreativeTab(CreativeTabs.tabMaterials);
	DragonScaleBar.setCreativeTab(CreativeTabs.tabMaterials);
	DragonScaleHelmet.setCreativeTab(CreativeTabs.tabCombat);
	DragonScaleChestplate.setCreativeTab(CreativeTabs.tabCombat);
	DragonScaleLeggings.setCreativeTab(CreativeTabs.tabCombat);
	DragonScaleBoots.setCreativeTab(CreativeTabs.tabCombat);
	DragonFlesh.setCreativeTab(CreativeTabs.tabFood);
	CoalSword.setCreativeTab(CreativeTabs.tabCombat);
	SwordOfZeus.setCreativeTab(CreativeTabs.tabCombat);
	MythicalBottle.setCreativeTab(CreativeTabs.tabBrewing);
	WaterBottle.setCreativeTab(CreativeTabs.tabBrewing);
	GodlyPotion.setCreativeTab(CreativeTabs.tabBrewing);
	HellStoneSword.setCreativeTab(CreativeTabs.tabCombat);
	HellStonePickaxe.setCreativeTab(CreativeTabs.tabTools);
	HellStoneAxe.setCreativeTab(CreativeTabs.tabTools);
	HellStoneShovel.setCreativeTab(CreativeTabs.tabTools);
	HellStoneHoe.setCreativeTab(CreativeTabs.tabTools);
	TazniteGem.setCreativeTab(CreativeTabs.tabMaterials);
	TazniteSword.setCreativeTab(CreativeTabs.tabCombat);
	TaznitePickAxe.setCreativeTab(CreativeTabs.tabTools);
	TazniteAxe.setCreativeTab(CreativeTabs.tabTools);
	TazniteShovel.setCreativeTab(CreativeTabs.tabTools);
	TazniteHoe.setCreativeTab(CreativeTabs.tabTools);
	TazmiteOre.setCreativeTab(CreativeTabs.tabBlock);
	DelphiPlanks.setCreativeTab(CreativeTabs.tabBlock);
	MysteriousRock.setCreativeTab(CreativeTabs.tabBlock);
	DelphiStick.setCreativeTab(CreativeTabs.tabMaterials);
	TazniteHelmet.setCreativeTab(CreativeTabs.tabCombat);
	TazniteChestplate.setCreativeTab(CreativeTabs.tabCombat);
	TazniteLeggings.setCreativeTab(CreativeTabs.tabCombat);
	TazniteBoots.setCreativeTab(CreativeTabs.tabCombat);
	HellStoneBlock.setCreativeTab(CreativeTabs.tabBlock);
	DelphiLog.setCreativeTab(CreativeTabs.tabBlock);
	DelphiLeaves.setCreativeTab(CreativeTabs.tabBlock);
	PrometheusGrass.setCreativeTab(CreativeTabs.tabBlock);
	AresDirt.setCreativeTab(CreativeTabs.tabBlock);
	DelphiSapling.setCreativeTab(CreativeTabs.tabBlock);
	DelphiSword.setCreativeTab(CreativeTabs.tabCombat);
	DelphiPickaxe.setCreativeTab(CreativeTabs.tabTools);
	DelphiAxe.setCreativeTab(CreativeTabs.tabTools);
	DelphiShovel.setCreativeTab(CreativeTabs.tabTools);
	DelphiHoe.setCreativeTab(CreativeTabs.tabTools);
	ForeverBerry.setCreativeTab(CreativeTabs.tabFood);
	HazzaPortal.setCreativeTab(CreativeTabs.tabBlock);
	CookedRatMeat.setCreativeTab(CreativeTabs.tabFood);
	MysticalKey.setCreativeTab(CreativeTabs.tabMaterials);
	HazzaFire.setCreativeTab(CreativeTabs.tabBlock);
	ForeverSeeds.setCreativeTab(CreativeTabs.tabBlock);
	Cloud.setCreativeTab(CreativeTabs.tabBlock);
	AncientBricks.setCreativeTab(CreativeTabs.tabBlock);
	ChestOfAlexander.setCreativeTab(CreativeTabs.tabBlock);
	TazniteBlock.setCreativeTab(CreativeTabs.tabBlock);
	TazniteSpawner.setCreativeTab(CreativeTabs.tabBlock);
	CoroniumOre.setCreativeTab(CreativeTabs.tabBlock);
	CoroniumTorch.setCreativeTab(CreativeTabs.tabDecorations);
	CoroniumDust.setCreativeTab(CreativeTabs.tabMaterials);
	
	//Block Register
	GameRegistry.registerBlock(AresDirt);
	GameRegistry.registerBlock(DelphiLeaves);
	GameRegistry.registerBlock(DelphiLog);
	GameRegistry.registerBlock(DelphiSapling);
	GameRegistry.registerBlock(HellStoneBlock);
	GameRegistry.registerBlock(PrometheusGrass);
	GameRegistry.registerBlock(TazmiteOre);
	GameRegistry.registerBlock(DelphiPlanks);
	GameRegistry.registerBlock(MysteriousRock);
	GameRegistry.registerBlock(ForeverBerryBush);
	GameRegistry.registerBlock(HazzaPortal);
	GameRegistry.registerBlock(HazzaFire);
	GameRegistry.registerBlock(Cloud);
	GameRegistry.registerBlock(AncientBricks);
	GameRegistry.registerBlock(ChestOfAlexander);
	GameRegistry.registerBlock(TazniteBlock);
	GameRegistry.registerBlock(TazniteSpawner);
	GameRegistry.registerBlock(CoroniumOre);
	GameRegistry.registerBlock(CoroniumTorch);
	
	//Block Step Sounds
	HellStoneBlock.setStepSound(Block.soundStoneFootstep);
	AresDirt.setStepSound(Block.soundGrassFootstep);
	PrometheusGrass.setStepSound(Block.soundGrassFootstep);
	TazmiteOre.setStepSound(Block.soundStoneFootstep);
	DelphiLog.setStepSound(Block.soundWoodFootstep);
	DelphiPlanks.setStepSound(Block.soundWoodFootstep);
	DelphiLeaves.setStepSound(Block.soundPowderFootstep);
	
	//Crafting Recipes
	GameRegistry.addShapelessRecipe(new ItemStack(DelphiPlanks, 4), new Object[] {HazzaMod.DelphiLog});
	GameRegistry.addRecipe(new ItemStack(MysteriousRock,1,2), new Object[]{"aa","aa", Character.valueOf('a'),DragonScaleBar,});
	GameRegistry.addRecipe(new ItemStack(DelphiStick,4), new Object[]{" a "," a ",  Character.valueOf('a'),DelphiPlanks,});
	GameRegistry.addRecipe(new ItemStack(DelphiStick,4), new Object[]{"  a","  a", Character.valueOf('a'),DelphiPlanks,});
	GameRegistry.addRecipe(new ItemStack(DelphiStick,4), new Object[]{"a  ","a  ", Character.valueOf('a'),DelphiPlanks,});
	GameRegistry.addRecipe(new ItemStack(HellStoneSword,1), new Object[]{" a ", " a ", " b ", Character.valueOf('a'),HellStoneBlock, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(HellStoneAxe,1), new Object[]{" aa", " ba", " b ", Character.valueOf('a'),HellStoneBlock, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(HellStonePickaxe,1), new Object[]{"aaa", " b ", " b ", Character.valueOf('a'),HellStoneBlock, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(HellStoneHoe,1), new Object[]{" aa", " b ", " b ", Character.valueOf('a'),HellStoneBlock, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(HellStoneShovel,1), new Object[]{" a ", " b ", " b ", Character.valueOf('a'),HellStoneBlock, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(DragonScaleHelmet,1), new Object[]{"***", "* *", "   ", Character.valueOf('*'), DragonScale});
	GameRegistry.addRecipe(new ItemStack(DragonScaleChestplate,1), new Object[]{"* *", "***", "***", Character.valueOf('*'), DragonScale});
	GameRegistry.addRecipe(new ItemStack(DragonScaleLeggings,1), new Object[]{"***", "* *", "* *", Character.valueOf('*'), DragonScale});
	GameRegistry.addRecipe(new ItemStack(DragonScaleBoots,1), new Object[]{"   ", "* *", "* *", Character.valueOf('*'), DragonScale});
	GameRegistry.addRecipe(new ItemStack(SwordOfZeus,1), new Object[]{"bbb", "bab", "bbb", Character.valueOf('a'), Item.swordGold, Character.valueOf('b'),GodlyPotion});
	GameRegistry.addRecipe(new ItemStack(CoalSword,1), new Object[]{" a ", " a ", " * ", Character.valueOf('*'),DelphiStick, Character.valueOf('a'), Item.coal});
	GameRegistry.addRecipe(new ItemStack(GodlyPotion,1), new Object[]{"a", "*", Character.valueOf('*'),DragonScale, Character.valueOf('a'),WaterBottle});
	GameRegistry.addShapelessRecipe(new ItemStack(GodlyPotion, 1), new Object[] {WaterBottle,DragonScale});
	GameRegistry.addRecipe(new ItemStack(MythicalBottle,1), new Object[]{"a a", "a a", "aaa", Character.valueOf('a'), Block.glass});
	GameRegistry.addRecipe(new ItemStack(TazniteSword,1), new Object[]{" a ", " a ", " b ", Character.valueOf('a'),TazniteGem, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(TazniteAxe,1), new Object[]{" aa", " ba", " b ", Character.valueOf('a'),TazniteGem, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(TaznitePickAxe,1), new Object[]{"aaa", " b ", " b ", Character.valueOf('a'),TazniteGem, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(TazniteHoe,1), new Object[]{" aa", " b ", " b ", Character.valueOf('a'),TazniteGem, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(TazniteShovel,1), new Object[]{" a ", " b ", " b ", Character.valueOf('a'),TazniteGem, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(TazniteHelmet,1), new Object[]{"***", "* *", "   ", Character.valueOf('*'),TazniteGem});
	GameRegistry.addRecipe(new ItemStack(TazniteChestplate,1), new Object[]{"* *", "***", "***", Character.valueOf('*'),TazniteGem});
	GameRegistry.addRecipe(new ItemStack(TazniteLeggings,1), new Object[]{"***", "* *", "* *", Character.valueOf('*'),TazniteGem});
	GameRegistry.addRecipe(new ItemStack(TazniteBoots,1), new Object[]{"   ", "* *", "* *", Character.valueOf('*'),TazniteGem});
	GameRegistry.addRecipe(new ItemStack(Block.workbench,1), new Object[]{" aa", " aa", "   ", Character.valueOf('a'),DelphiPlanks});
	GameRegistry.addSmelting(DragonScale.shiftedIndex, new ItemStack (DragonScaleBar, 1), 10F);
	GameRegistry.addRecipe(new ItemStack(DelphiSword,1), new Object[]{" a ", " a ", " b ", Character.valueOf('a'),DelphiPlanks, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(DelphiAxe,1), new Object[]{" aa", " ba", " b ", Character.valueOf('a'),DelphiPlanks, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(DelphiPickaxe,1), new Object[]{"aaa", " b ", " b ", Character.valueOf('a'),DelphiPlanks, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(DelphiHoe,1), new Object[]{" aa", " b ", " b ", Character.valueOf('a'),DelphiPlanks, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(DelphiShovel,1), new Object[]{" a ", " b ", " b ", Character.valueOf('a'),DelphiPlanks, Character.valueOf('b'),DelphiStick});
	GameRegistry.addRecipe(new ItemStack(TazniteBlock,1), new Object[]{"aaa","aaa","aaa", Character.valueOf('a'),TazniteGem});
	GameRegistry.addShapelessRecipe(new ItemStack(TazniteGem,9), new Object[] {TazniteBlock});
	GameRegistry.addRecipe(new ItemStack(CoroniumTorch,4), new Object[]{" b "," a ",  Character.valueOf('a'),DelphiStick,Character.valueOf('b'),CoroniumDust});
	GameRegistry.addRecipe(new ItemStack(CoroniumTorch,4), new Object[]{"  b","  a", Character.valueOf('a'),DelphiStick,Character.valueOf('b'),CoroniumDust});
	GameRegistry.addRecipe(new ItemStack(CoroniumTorch,4), new Object[]{"b  ","a  ", Character.valueOf('a'),DelphiStick,Character.valueOf('b'),CoroniumDust });

	//Entity Registers
	EntityRegistry.registerGlobalEntityID(EntityDarkDragon.class, "Dark Dragon", 127,0x363636, 0x8a8a8a);
	EntityRegistry.registerGlobalEntityID(EntityKeeperDragon.class, "Keeper Dragon", 125,0x363636, 0xddbb00);
	EntityRegistry.registerGlobalEntityID(EntityRat.class, "Rat", 126,0x363636, 0x861a6d);
	EntityRegistry.registerGlobalEntityID(EntityHostileVillager.class, "Hostile Villager", 124,0x363636, 0x861a6d);

	//Entity Spawn
	EntityRegistry.addSpawn("Keeper Dragon", 15, 0, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.desert});
	EntityRegistry.addSpawn("Rat", 50, 0, 1, EnumCreatureType.monster, new BiomeGenBase[] {HazzaMod.DovahBiome});
	EntityRegistry.addSpawn("Hostile Villager", 20, 2, 4, EnumCreatureType.monster, new BiomeGenBase[] {HazzaMod.DovahBiome});

	// Adds Text To Eggs
	ModLoader.addLocalization("entity.Dark Dragon.name", "Dark Dragon");
	ModLoader.addLocalization("entity.Keeper Dragon.name", "Keeper Dragon");
	ModLoader.addLocalization("entity.Rat.name", "Rat");
	ModLoader.addLocalization("entity.Hostile Villager.name", "Hostile Villager");
			
	//Renders Entity
	RenderingRegistry.instance().registerEntityRenderingHandler(EntityDarkDragon.class, new RenderDarkDragon(new ModelDarkDragon(), 0.5F));
	RenderingRegistry.instance().registerEntityRenderingHandler(EntityKeeperDragon.class, new RenderKeeperDragon(new ModelDarkDragon(), 0.5F));
	RenderingRegistry.instance().registerEntityRenderingHandler(EntityRat.class, new RenderRat(new ModelRat(), 0.5F));
	RenderingRegistry.instance().registerEntityRenderingHandler(EntityHostileVillager.class, new RenderHostileVillager(new ModelHostileVillager(), 0.5F));

	//Achievement Descriptions
	ModLoader.addAchievementDesc(TheScaleOfLife, "The Scale Of Life", "Get a Dragon Scale");
	ModLoader.addAchievementDesc(FoodOfTheGods, "Food Of The Gods", "Get Dragon Flesh");
	ModLoader.addAchievementDesc(GemOfGreed, "The Gem Of Greed", "Get A Taznite Gem");
	ModLoader.addAchievementDesc(FireDirt, "The Fire Dirt", "Collect Ares Dirt");
	ModLoader.addAchievementDesc(Interesting, "Interesting...", "Craft A Mysterious Rock");
	ModLoader.addAchievementDesc(rat,"Willard.", "Eat a rat");
	ModLoader.addAchievementDesc(WhatInThe,"What In The World...", "Find A Strange Key.");
	}
}