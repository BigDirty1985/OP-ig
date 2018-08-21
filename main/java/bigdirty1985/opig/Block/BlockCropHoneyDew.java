package bigdirty1985.opig.Block;

import bigdirty1985.opig.Items.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropHoneyDew extends BlockCrops {

	public BlockCropHoneyDew() {
		setUnlocalizedName("cropHoneyDew");
		setRegistryName("cropHoneyDew");
	}

	@Override
	protected Item getSeed() {
		return ModItems.honeyDewSeed;
	}

	@Override
	protected Item getCrop() {
		return ModItems.honeyDewSlice;
	}

}