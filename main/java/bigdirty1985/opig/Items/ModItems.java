package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static ItemPoo poo;
	public static ItemLard lard;
	public static ItemBacon bacon;
	public static ItemRawBacon rawBacon;
	public static ItemRawMignon rawMignon;
	public static ItemFiletMignon filetMignon;
	
	public static void init() {
		//food
		rawBacon = register(new ItemRawBacon());
		bacon = register(new ItemBacon());
		rawMignon = register(new ItemRawMignon());
		filetMignon = register(new ItemFiletMignon());
		poo = register(new ItemPoo("poo"));
		lard = register(new ItemLard());
		
		//Materials
		
	}

	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);

		if (item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}

		return item;
	}

}