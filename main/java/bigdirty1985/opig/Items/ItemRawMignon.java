package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;


public class ItemRawMignon extends ItemFood implements ItemModelProvider, ItemOreDict {

	public ItemRawMignon() {
		super(3, 3.0f, true);
		setUnlocalizedName("rawMignon");
		setRegistryName("rawMignon");
		setCreativeTab(CreativeTabs.FOOD);
	}

	@Override
	public void registerItemModel(Item item) {
		OPig.proxy.registerItemRenderer(this, 0, "rawMignon");
	}

	@Override
	public void initOreDict() {
		OreDictionary.registerOre("rawMignon", this);
	}

}