package venelalex.bettertobacco.init;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.item.RawTobacco;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BetterTobaccoItems {
	
	public static final RawTobacco RAW_TOBACCO = new RawTobacco();
	
	@SubscribeEvent
	public static void register(final net.minecraftforge.event.RegistryEvent.Register<Item> event) 
	{
		
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(RAW_TOBACCO.setRegistryName(bettertobacco.MY_MOD_ID, "raw_tobacco_item"));
	}

}
