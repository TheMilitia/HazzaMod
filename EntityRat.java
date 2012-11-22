package HazzaMod;

import net.minecraft.src.*;

import org.lwjgl.opengl.Display;

public class EntityRat extends EntityMob
{
	   private int field_40152_d;
    public EntityRat(World world)
    {
    	
        super(world);
        texture = "/Hazza/Mobs/DovahRat.png";
        setSize(0.5F, 0.5F);
        moveSpeed = .4F;

        isImmuneToFire = false;
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));

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
        return HazzaMod.CookedRatMeat.shiftedIndex;
    }
    


    
        
    

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityRat spawnBabyAnimal(EntityAnimal entityanimal)
    {
        return new EntityRat(worldObj);
    }

    public int getMaxHealth()
    {
        return 5;
    }
}
