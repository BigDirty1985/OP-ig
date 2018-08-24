package bigdirty1985.opig.event;

import com.google.common.eventbus.Subscribe;

import bigdirty1985.opig.OPigConfig;
import bigdirty1985.opig.EntityAI.EntityAIRoot;
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
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.util.Random;

public class OPigEventHandler {

	EntityAgeable newPig;
	Random r = new Random();
	

	/*
	 * 
	 * @SubscribeEvent public void pigSpawn(LivingSpawnEvent e) {
	 * 
	 * if (e.getEntity() instanceof EntityPig) { EntityPig ep = (EntityPig)
	 * e.getEntity(); if (ep.getGrowingAge() < 50) { Log.info("Pig Spawned!");
	 * makePigsHungry(ep); if (ep.getGrowingAge() <= -23000) {
	 * Log.info("Its a Baby!" + ep.getGrowingAge()); if (ep.getGrowingAge() >=
	 * -24000) { Log.info("Twins!"); newPig = new EntityPig(ep.getEntityWorld());
	 * newPig.setPosition(ep.posX, ep.posY, ep.posZ); // newPig.setHealth(8);
	 * newPig.setGrowingAge(-23000); // makePigsHungry(newPig);
	 * ep.getEntityWorld().spawnEntityInWorld(newPig); // That spawns the Entity } }
	 * } } }
	 */

	@SubscribeEvent
	public void updatePigAI(EntityJoinWorldEvent e){
		if (e.getEntity() instanceof EntityPig) {
			makePigsHungry((EntityPig)e.getEntity());
			System.out.println("ejw hungry");
		}
	}
	
	@SubscribeEvent
	public void updatePigAI(LivingSpawnEvent e){
		if (e.getEntity() instanceof EntityPig) {
			makePigsHungry((EntityPig)e.getEntity());
			System.out.println("lse hungry");
		}
	}
	
	@SubscribeEvent
	public void spawnTwins(BabyEntitySpawnEvent b) {
		if (b.getChild() instanceof EntityPig) {
			System.out.println("Piglet born");
			makePigsHungry((EntityPig) b.getChild());

			for (int i = OPigConfig.extraPiglets, x = 0; x < i; x++) {
				newPig = new EntityPig(b.getParentA().worldObj);
				newPig.setPosition(b.getParentA().posX, b.getParentA().posY, b.getParentA().posZ);
				newPig.setGrowingAge(-23000);
				makePigsHungry((EntityPig) newPig);
				b.getParentA().worldObj.spawnEntityInWorld(newPig);
				//System.out.println("Twin Born");
			}

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

	private void makePigsHungry(EntityPig e) {
		if (OPigConfig.isRootingEnabled) {
			e.tasks.addTask(5, new EntityAIRoot(e));
			Log.info("Pig is hungry!");
		} else {
			//Log.info("Pig is not hungry....");
		}
	}

}
