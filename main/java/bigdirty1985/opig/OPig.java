
package bigdirty1985.opig;

import bigdirty1985.opig.Block.ModBlocks;
import bigdirty1985.opig.Items.ModItems;
import bigdirty1985.opig.event.FurnaceFuelHandler;
import bigdirty1985.opig.event.OPigEventHandler;
import bigdirty1985.opig.proxy.CommonProxy;
import bigdirty1985.opig.recipes.ModRecipes;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = OPig.modId, name = OPig.name, version = OPig.version, acceptedMinecraftVersions = "[1.10.2]")
public class OPig {

	public static final String modId = "opig";
	public static final String name = "OP-ig";
	public static final String version = "1.1.0";

	@Mod.Instance(modId)
	public static OPig instance;
	
	

	//Tool Materials
	public static final Item.ToolMaterial flintToolMaterial = EnumHelper.addToolMaterial("FLINT", 2, 100, 3, 2, 10);
	
	
	@SidedProxy(serverSide = "bigdirty1985.opig.proxy.CommonProxy", clientSide = "bigdirty1985.opig.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	
		System.out.println(name + " is trying like super hard not to F up your game...");
		
		
		ModBlocks.init();
		ModItems.init();
		ModRecipes.init();
		FMLCommonHandler.instance().bus().register(new OPigEventHandler());
		OPigConfig.init(event);

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(name + " No crash? Thats a good sign. Those errors probably aren't that important.");

		GameRegistry.registerFuelHandler(new FurnaceFuelHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		System.out.println(name + " Wait... It actually worked? HMPH! How bout that.....");
	}

}