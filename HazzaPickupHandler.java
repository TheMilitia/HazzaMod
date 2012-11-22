package HazzaMod;

import net.minecraft.src.AchievementList;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import cpw.mods.fml.common.IPickupNotifier;

public class HazzaPickupHandler implements IPickupNotifier {

	@Override
	public void notifyPickup(EntityItem item, EntityPlayer player) {
		if(item.item.itemID == HazzaMod.DragonFlesh.shiftedIndex){player.addStat(HazzaMod.FoodOfTheGods,1);}
 		if(item.item.itemID == HazzaMod.DragonScale.shiftedIndex){player.addStat(HazzaMod.TheScaleOfLife,1);}
      	if(item.item.itemID == HazzaMod.TazniteGem.shiftedIndex){player.addStat(HazzaMod.GemOfGreed,1);}
    	if(item.item.itemID == HazzaMod.AresDirt.blockID){player.addStat(HazzaMod.FireDirt,1);}   
    	if(item.item.itemID == HazzaMod.CookedRatMeat.shiftedIndex){player.addStat(HazzaMod.rat,1);}  
    	if(item.item.itemID == HazzaMod.MysticalKey.shiftedIndex){player.addStat(HazzaMod.WhatInThe,1);}  
	}

}
