package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import bigdirty1985.opig.Block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;


public class ItemHoneyDewSeed extends ItemSeeds implements ItemModelProvider {

	public ItemHoneyDewSeed() {
		super(ModBlocks.cropHoneyDew, Blocks.FARMLAND);
		setUnlocalizedName("cornSeed");
		setRegistryName("cornSeed");
	}

	@Override
	public void registerItemModel(Item item) {
		OPig.proxy.registerItemRenderer(item, 0, "cornSeed");
	}

}