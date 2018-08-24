package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;


public class ItemFiletMignon extends ItemFood implements ItemModelProvider, ItemOreDict {

	public ItemFiletMignon() {
		super(5, 5.0f, true);
		setUnlocalizedName("filetMignon");
		setRegistryName("filetMignon");
		setCreativeTab(CreativeTabs.FOOD);
	}

	@Override
	public void registerItemModel(Item item) {
		OPig.proxy.registerItemRenderer(this, 0, "filetMignon");
	}

	@Override
	public void initOreDict() {
		OreDictionary.registerOre("filetMignon", this);
	}

}