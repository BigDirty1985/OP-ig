package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;


public class ItemRawBacon extends ItemFood implements ItemModelProvider, ItemOreDict {

	public ItemRawBacon() {
		super(1, 1.0f, true);
		setUnlocalizedName("rawBacon");
		setRegistryName("rawBacon");
		setCreativeTab(CreativeTabs.FOOD);
	}

	@Override
	public void registerItemModel(Item item) {
		OPig.proxy.registerItemRenderer(this, 0, "rawBacon");
	}

	@Override
	public void initOreDict() {
		OreDictionary.registerOre("rawBacon", this);
	}

}