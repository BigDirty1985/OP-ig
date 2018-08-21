package bigdirty1985.opig.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;

public class ItemBase extends Item implements ItemModelProvider {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel(Item item) {
		OPig.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}




}