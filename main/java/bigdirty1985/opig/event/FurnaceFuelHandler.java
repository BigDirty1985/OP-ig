package bigdirty1985.opig.event;

import bigdirty1985.opig.Items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FurnaceFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {

		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
		Item itemFuel = fuel.getItem();

		
		 if (itemFuel == ModItems.lard) {
			return 1400;
		} else {
			return 0;
		}
	}
}