package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;


public class ItemLard extends ItemFood implements ItemModelProvider, ItemOreDict {


	public ItemLard() {
		super(4, 2.0f, true);
		setUnlocalizedName("lard");
		setRegistryName("lard");
		setCreativeTab(CreativeTabs.FOOD);
		
		
		
	}

	@Override
	public void registerItemModel(Item item) {
		OPig.proxy.registerItemRenderer(this, 0, "lard");
	}

	@Override
	public void initOreDict() {
		OreDictionary.registerOre("lard", this);
	}
	
	

}