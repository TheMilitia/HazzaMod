package HazzaMod;

import net.minecraft.src.*;

import org.lwjgl.opengl.Display;

public class EntityKeeperDragon extends EntityMob
{
	   private int field_40152_d;
    public EntityKeeperDragon(World world)
    {
    	
        super(world);
        texture = "/Hazza/Mobs/KeeperDragon.png";
        setSize(0.9F, 1.3F);
        moveSpeed = .3F;

        isImmuneToFire = true;
        
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, net.minecraft.src.EntityPlayer.class, moveSpeed, false));
        tasks.addTask(3, new EntityAIAttackOnCollide(this, net.minecraft.src.EntityVillager.class, moveSpeed, true));
        tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, moveSpeed));
        tasks.addTask(6, new EntityAIWander(this, moveSpeed));
        
        tasks.addTask(7, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
        tasks.addTask(7, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityPlayer.class, 16F, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityVillager.class, 16F, 0, false));
    }
    
    public int func_82193_c(Entity par1Entity)
    {
    return 2;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
    

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
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
    	dropItem(HazzaMod.MysticalKey.shiftedIndex, 1);
    	dropItem(HazzaMod.DragonScale.shiftedIndex, 1);
    }
    

    
        
    

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityKeeperDragon spawnBabyAnimal(EntityAnimal entityanimal)
    {
        return new EntityKeeperDragon(worldObj);
    }

    public int getMaxHealth()
    {
        return 50;
    }
}
