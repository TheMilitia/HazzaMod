package HazzaMod;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class HazzaCraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,IInventory craftMatrix) {}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		if(item.itemID == HazzaMod.MysteriousRock.blockID){player.addStat(HazzaMod.Interesting,1);}

	}

}
