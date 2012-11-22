package HazzaMod;

import net.minecraft.src.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemTypeSpecialSword extends ItemSword
{
    private int weaponDamage;
    private final EnumToolMaterial toolMaterial;

    public ItemTypeSpecialSword(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
    }
    
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
 	{
 	par1ItemStack.addEnchantment(Enchantment.knockback, 7);
 	}

    public String getTextureFile()
    {
            return "/Hazza/Items/HazzaItems.png";
    }
}
