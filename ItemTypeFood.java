package HazzaMod;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

public class ItemTypeFood extends ItemFood
{
    /** Number of ticks to run while 'EnumAction'ing until result. */
    public final int itemUseDuration;

    /** The amount this food item heals the player. */
    private final int healAmount;
    private final float saturationModifier;

    /** Whether wolves like this food (true for raw and cooked porkchop). */
    private final boolean isWolfsFavoriteMeat;

    /**
     * If this field is true, the food can be consumed even if the player don't need to eat.
     */
    private boolean alwaysEdible;

    /**
     * represents the potion effect that will occurr upon eating this food. Set by setPotionEffect
     */
    private int potionId;

    /** set by setPotionEffect */
    private int potionDuration;

    /** set by setPotionEffect */
    private int potionAmplifier;

    /** probably of the set potion effect occurring */
    private float potionEffectProbability;

    public ItemTypeFood(int par1, int par2, float par3, boolean par4)
    {
        super(par1, par2, par4);
        this.itemUseDuration = 32;
        this.healAmount = par2;
        this.isWolfsFavoriteMeat = par4;
        this.saturationModifier = par3;
        this.setCreativeTab(CreativeTabs.tabFood);
    }
    
    public String getTextureFile()
    {
            return "/Hazza/Items/HazzaItems.png";
    }
}
