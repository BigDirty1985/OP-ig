package bigdirty1985.opig.Items;

import bigdirty1985.opig.OPig;
import bigdirty1985.opig.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static ItemBase pliers,saw,hammer,leatherCured,
	rawPapyrus,soakedPapyrus,papyrusSheet,driedPapyrusSheet,bacon;
	
	public static Item honeyDewSeed;
	public static Item honeyDewSlice;
	public static ItemSword knife;
	public static void init() {
		//food
		bacon = register(new ItemBase("bacon").setCreativeTab(CreativeTabs.FOOD));
		
		
		//Materials
		//rawPapyrus = register(new ItemBase("rawPapyrus").setCreativeTab(CreativeTabs.MATERIALS));
		//soakedPapyrus = register(new ItemBase("soakedPapyrus").setCreativeTab(CreativeTabs.MATERIALS));
		//papyrusSheet = register(new ItemBase("papyrusSheet").setCreativeTab(CreativeTabs.MATERIALS));
		//driedPapyrusSheet = register(new ItemBase("driedPapyrusSheet").setCreativeTab(CreativeTabs.MATERIALS));
		//leatherCured= register(new ItemBase("leatherCured").setCreativeTab(CreativeTabs.MATERIALS));
		
		//Tools
		//saw = register(new ItemBase("saw").setCreativeTab(CreativeTabs.TOOLS));
		//pliers = register(new ItemBase("pliers").setCreativeTab(CreativeTabs.TOOLS));
		//hammer = register(new ItemBase("hammer").setCreativeTab(CreativeTabs.TOOLS));
		//knife =  (ItemSword) register(new ItemSword(OPig.flintToolMaterial,"knife").setCreativeTab(CreativeTabs.TOOLS));
		//knife.setContainerItem(knife);
		
	}

	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);

		if (item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}

		return item;
	}

}