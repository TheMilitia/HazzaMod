package HazzaMod;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Calendar;

import net.minecraft.src.*;

public class EntityDarkDragon extends EntityMob
{

    public EntityDarkDragon(World par1World)
    {
        super(par1World);
        this.texture = "/Hazza/Mobs/DragonTexture.png";
        this.moveSpeed = 0.40F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
    }

    /**
     * This method returns a value to be applied directly to entity speed, this factor is less than 1 when a slowdown
     * potion effect is applied, more than 1 when a haste potion effect is applied and 2 for fleeing entities.
     */
    public float getSpeedModifier()
    {
        return super.getSpeedModifier() * (this.isChild() ? 1.5F : 1.0F);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
    }

    @SideOnly(Side.CLIENT)



    public int getMaxHealth()
    {
        return 175;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        int var1 = super.getTotalArmorValue() + 2;

        if (var1 > 20)
        {
            var1 = 20;
        }

        return var1;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }


    /**
     * Returns the amount of damage a mob should deal.
     */
    public int getAttackStrength(Entity par1Entity)
    {
        ItemStack var2 = this.getHeldItem();
        int var3 = 4;

        if (var2 != null)
        {
            var3 += var2.getDamageVsEntity(this);
        }

        return var3;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return HazzaMod.DragonScale.shiftedIndex;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
        int i = rand.nextInt(3) + rand.nextInt(1 + par2);

        for (int j = 0; j < i; j++)
        {
            dropItem(HazzaMod.DragonScale.shiftedIndex, 1);
        }

        i = rand.nextInt(3) + 1 + rand.nextInt(1 + par2);

        for (int k = 0; k < i; k++)
        {
            {
                dropItem(HazzaMod.DragonFlesh.shiftedIndex, 1);
            }
        }
    }
    

    

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }



    protected void func_82164_bB()
    {
        super.func_82164_bB();

        if (this.rand.nextFloat() < (this.worldObj.difficultySetting == 3 ? 0.05F : 0.01F))
        {
            int var1 = this.rand.nextInt(3);

            if (var1 == 0)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.swordSteel));
            }
            else
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.shovelSteel));
            }
        }
    }

 @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 16)
        {
            this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.zombie.remedy", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public boolean func_82230_o()
    {
        return this.getDataWatcher().getWatchableObjectByte(14) == 1;
    }
}
