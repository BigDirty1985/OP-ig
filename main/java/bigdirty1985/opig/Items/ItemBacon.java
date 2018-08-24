package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;


public class ItemBacon extends ItemFood implements ItemModelProvider, ItemOreDict {

	public ItemBacon() {
		super(1, 4.0f, true);
		setUnlocalizedName("bacon");
		setRegistryName("bacon");
		setCreativeTab(CreativeTabs.FOOD);
	}

	@Override
	public void registerItemModel(Item item) {
		OPig.proxy.registerItemRenderer(this, 0, "bacon");
	}

	@Override
	public void initOreDict() {
		OreDictionary.registerOre("bacon", this);
	}

}