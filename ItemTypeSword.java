package HazzaMod;

import net.minecraft.src.*;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemTypeSword extends ItemSword
{
    private int weaponDamage;
    private final EnumToolMaterial toolMaterial;

    public ItemTypeSword(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
    }

    public String getTextureFile()
    {
            return "/Hazza/Items/HazzaItems.png";
    }
}
