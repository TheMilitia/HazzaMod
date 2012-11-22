package HazzaMod;

import net.minecraft.src.*;

public class RenderHostileVillager extends RenderLiving
{
        public RenderHostileVillager(ModelBase modelbase, float f)
        {
                super(modelbase, f);
        }
        public void func_177_a(EntityHostileVillager entitycoyote, double d, double d1, double d2,
                        float f, float f1)
        {
                super.doRenderLiving(entitycoyote, d, d1, d2, f, f1);
        }
        public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2,
                        float f, float f1)
        {
         func_177_a((EntityHostileVillager )entityliving, d, d1, d2, f, f1);
        }
        public void doRender(Entity entity, double d, double d1, double d2,
                        float f, float f1)
        {
         func_177_a((EntityHostileVillager )entity, d, d1, d2, f, f1);
        }
}