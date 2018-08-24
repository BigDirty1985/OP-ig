package bigdirty1985.opig.EntityAI;

import java.lang.reflect.Array;
import java.util.Random;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import bigdirty1985.opig.Items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDirt.DirtType;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EntityAIRoot extends EntityAIBase {

	private static final Predicate<IBlockState> IS_TALL_GRASS = BlockStateMatcher.forBlock(Blocks.TALLGRASS)
			.where(BlockTallGrass.TYPE, Predicates.equalTo(BlockTallGrass.EnumType.GRASS));
	/** The entity owner of this AITask */
	private final EntityLiving rootingEntity;
	/** The world the grass eater entity is eating from */
	private final World entityWorld;
	/** Number of ticks since the entity started to eat grass */
	int rootingDirtTimer;
	Random rand = new Random();
	Block canRoot;
	// replacement blocks
	IBlockState PODZOL = Blocks.DIRT.getStateFromMeta(2);
	IBlockState DIRT = Blocks.DIRT.getStateFromMeta(0);
	IBlockState COARSE_DIRT = Blocks.DIRT.getStateFromMeta(1);
	IBlockState GRASS_PATH = Blocks.GRASS_PATH.getStateFromMeta(0);

	IBlockState rBlocks[] = { DIRT, PODZOL, GRASS_PATH }, rBlock;
	IBlockState replacement = rBlocks[rand.nextInt(rBlocks.length)];
	Item pigLootTable[] = { Blocks.BROWN_MUSHROOM.getItemDropped(null, rand, 2), Items.BONE, Items.BEETROOT_SEEDS,
			Items.MELON_SEEDS };
	ItemStack pigLoot = new ItemStack(pigLootTable[rand.nextInt(pigLootTable.length)], rand.nextInt(1));

	public EntityAIRoot(EntityLiving rootingEntityIn) {
		this.rootingEntity = rootingEntityIn;
		this.entityWorld = rootingEntityIn.worldObj;
		this.setMutexBits(7);
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute() {
		if (this.rootingEntity.getRNG().nextInt(this.rootingEntity.isChild() ? 50 : 1000) != 0) {
			return false;
		} else {
			BlockPos blockpos = new BlockPos(this.rootingEntity.posX, this.rootingEntity.posY, this.rootingEntity.posZ);
			return IS_TALL_GRASS.apply(this.entityWorld.getBlockState(blockpos)) ? true
					: this.entityWorld.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS;
		}
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		this.rootingDirtTimer = 40;
		this.entityWorld.setEntityState(this.rootingEntity, (byte) 10);
		this.rootingEntity.getNavigator().clearPathEntity();
	}

	/**
	 * Resets the task
	 */
	public void resetTask() {
		this.rootingDirtTimer = 0;
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting() {
		return this.rootingDirtTimer > 0;
	}

	/**
	 * Number of ticks since the entity started to eat grass
	 */
	public int getrootingDirtTimer() {
		return this.rootingDirtTimer;
	}

	/**
	 * Updates the task
	 */
	public void updateTask() {
		this.rootingDirtTimer = Math.max(0, this.rootingDirtTimer - 1);

		if (this.rootingDirtTimer == 4) {
			BlockPos blockpos = new BlockPos(this.rootingEntity.posX, this.rootingEntity.posY, this.rootingEntity.posZ);

			if (IS_TALL_GRASS.apply(this.entityWorld.getBlockState(blockpos))) {
				if (this.entityWorld.getGameRules().getBoolean("mobGriefing")) {
					this.entityWorld.destroyBlock(blockpos, false);
				}

				this.rootingEntity.eatGrassBonus();
			} else {
				BlockPos blockpos1 = blockpos.down();

				if (this.entityWorld.getBlockState(blockpos1).getBlock() == Blocks.GRASS
						|| this.entityWorld.getBlockState(blockpos1).getBlock() == Blocks.GRASS_PATH
						|| this.entityWorld.getBlockState(blockpos1).getBlock() == Blocks.DIRT
						|| this.entityWorld.getBlockState(blockpos1).getBlock() == PODZOL
						|| this.entityWorld.getBlockState(blockpos1).getBlock() == COARSE_DIRT) {
					if (this.entityWorld.getGameRules().getBoolean("mobGriefing")) {
						
						if(/*rand.nextInt(1) == 1*/true) {
						this.entityWorld.playEvent(2001, blockpos1, Block.getIdFromBlock(Blocks.GRASS));
						this.entityWorld.setBlockState(blockpos1, replacement, 2);
						// this.entityWorld.spawnEntityInWorld(new EntityItem(entityWorld,
						// blockpos.getX(), blockpos.getY() +1, blockpos.getZ(), pigLoot));

						if (rand.nextInt(5) == 0) {
							rootingEntity.entityDropItem(pigLoot, 0.2f);
							if (rand.nextInt(10) == 0) {
								rootingEntity.entityDropItem(new ItemStack(ModItems.poo, 1), 0.2f);
							}
						}}
						// System.out.println("Pig Dug up "+ pigLoot.getItem().getUnlocalizedName() +" *
						// "+ pigLoot.stackSize);
					}

					this.rootingEntity.eatGrassBonus();
				}
			}
		}
	}
}
