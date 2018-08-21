package bigdirty1985.opig.event;

import com.google.common.eventbus.Subscribe;

import bigdirty1985.opig.Items.ModItems;
import jline.internal.Log;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.util.Random;

public class OPigEventHandler {

	EntityPig newPig;
	@SubscribeEvent
	public void pigSpawn(EntityJoinWorldEvent e) {
		Entity ee = e.getEntity();
		//EntityLiving el = (EntityLiving) ee;
		if (e.getEntity() instanceof EntityPig) {
			Log.info("Pig Spawned!");
			EntityPig ep = (EntityPig) ee;
			makePigsHungry((EntityPig) e.getEntity(), e);
			if (e.getEntity() instanceof EntityAgeable) {
				Log.info("Its a Baby!");
				if(ep.getHealth() != 8) {
					Log.info("Twins!");
					newPig = new EntityPig(ep.getEntityWorld());
					newPig.setPosition(ep.posX, ep.posY, ep.posZ);
					newPig.setHealth(8);
					newPig.createChild(newPig);
					//ep.getEntityWorld().spawnEntityInWorld(newPig); //That spawns the Entity
					
					}}
				}
				
		}
			
	@SubscribeEvent
	public void deadPig(LivingDropsEvent event) {
		if (event.getEntity() instanceof EntityPig) {
			// DEBUG
			System.out.println("EntityPig drops event");
			ItemStack itemStackToDrop = new ItemStack(ModItems.bacon, new Random().nextInt(3));
			event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX,

					event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));

		}

	}

	private void makePigsHungry(EntityPig e, EntityJoinWorldEvent event) {
		e.tasks.addTask(1, new EntityAIEatGrass(e));
		Log.info("Pig is hungry!");

	}

}
