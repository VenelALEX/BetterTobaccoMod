package venelalex.bettertobacco.data.providers;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import venelalex.bettertobacco.bettertobacco;

public final class BetterTobaccoContainerTypes {
	
	public static ContainerType<SnusCanContainer> snus_can;
	
	private BetterTobaccoContainerTypes() {};
	
	public static void registerContainerTypes(RegistryEvent.Register<ContainerType<?>> event) {
		snus_can = register("snus_can_container", new ContainerType<>(SnusCanContainer::new));
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void registerScreens(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(snus_can, SnusCanContainerScreen::new);
	}
	
	private static <T extends Container> ContainerType<T> register(String name, ContainerType<T> type) {
		type.setRegistryName(bettertobacco.MY_MOD_ID, name);
		ForgeRegistries.CONTAINERS.register(type);
		return type;
	}
}
