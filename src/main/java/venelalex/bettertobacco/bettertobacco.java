/*
 * @2020 Alexander B./ David F.
 * */

package venelalex.bettertobacco;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import venelalex.bettertobacco.data.providers.BetterTobaccoContainerTypes;

@Mod ("bettertobacco")

public class bettertobacco {
	
	public static bettertobacco instance;
	public static final String MY_MOD_ID = "bettertobacco";
	
	private static final Logger MY_LOGGER = LogManager.getLogger(MY_MOD_ID);
	
	public bettertobacco() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ContainerType.class, BetterTobaccoContainerTypes::registerContainerTypes);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		MY_LOGGER.info(">> Better Tobacco Mod - Setup Complete");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		BetterTobaccoContainerTypes.registerScreens(event);
		MY_LOGGER.info(">> Better Tobacco Mod - Client Setup Complete");
	}
	
	
}
