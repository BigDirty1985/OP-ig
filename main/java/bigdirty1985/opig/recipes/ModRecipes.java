package bigdirty1985.opig.recipes;

import bigdirty1985.opig.Block.ModBlocks;
import bigdirty1985.opig.Items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {

		// test Shapeless Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rawMignon), Items.BEEF,ModItems.rawBacon);
		
		// Shaped Recipe
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.TORCH,16), "L", "W","S", 'L', ModItems.lard,'W',Blocks.WOOL,'S',Items.STICK);
		// FurnaceRecipe
		GameRegistry.addSmelting(ModItems.rawMignon, new ItemStack(ModItems.filetMignon), 0.6f);
		GameRegistry.addSmelting(ModItems.rawBacon, new ItemStack(ModItems.bacon), 0.2f);
		

	}

}