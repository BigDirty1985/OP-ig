package bigdirty1985.opig.recipes;

import bigdirty1985.opig.Block.ModBlocks;
import bigdirty1985.opig.Items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {

		// test Shapeless Recipe
		//GameRegistry.addShapelessRecipe(new ItemStack(ModItems.leatherCured, 4), Items.LEATHER);
		// Shaped Recipe
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.papyrusSheet), "SS ", "SS ", 'S', ModItems.soakedPapyrus);
		// FurnaceRecipe
		//GameRegistry.addSmelting(Items.LEATHER, new ItemStack(ModItems.leatherCured), 0.7f);

	}

}