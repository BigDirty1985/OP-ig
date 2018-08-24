package bigdirty1985.opig;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
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


public class OPigConfig {
	
	public static Configuration config;
	
	public static void init(FMLPreInitializationEvent e){
		config = new Configuration(e.getSuggestedConfigurationFile());
		syncConfig();
	}
	
	public static boolean isRootingEnabled = true; // Save whether pancakes are enabled
	public static int extraPiglets = 1;

	public static void syncConfig() { // Gets called from preInit
	    try {
	        // Load config
	        config.load();

	        // Read props from config
	        Property isRootingEnabledProp = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "isRootingEnabled", // Property name
	                "true", // Default value
	                "Whether or not pigs can root in dirt "); // Comment

	        Property extraPigletProp = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "extraPiglets", // Property name
	                "1", // Default value
	                "how many EXTRA babys do pigs spawn"); // Comment

	        isRootingEnabled = isRootingEnabledProp.getBoolean(); // Get the boolean value, also set the property value to boolean
	        extraPiglets = extraPigletProp.getInt();
	    } catch (Exception e) {
	        // Failed reading/writing, just continue
	    } finally {
	        // Save props to config IF config changed
	        if (config.hasChanged()) config.save();
	    }
	}

}
