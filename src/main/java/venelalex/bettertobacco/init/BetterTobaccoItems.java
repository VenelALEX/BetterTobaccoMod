package venelalex.bettertobacco.init;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.item.Cigarette;
import venelalex.bettertobacco.item.DriedTobacco;
import venelalex.bettertobacco.item.RawTobacco;
import venelalex.bettertobacco.item.TobaccoFilter;
import venelalex.bettertobacco.item.TobaccoSeeds;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BetterTobaccoItems {
	
	public static final RawTobacco RAW_TOBACCO = new RawTobacco();
	public static final TobaccoSeeds TOBACCO_SEEDS = new TobaccoSeeds();
	public static final DriedTobacco DRIED_TOBACCO = new DriedTobacco();
	public static final TobaccoFilter TOBACCO_FILTER = new TobaccoFilter();
	public static final Cigarette CIGARETTE = new Cigarette();
	
	@SubscribeEvent
	public static void register(final net.minecraftforge.event.RegistryEvent.Register<Item> event) 
	{
		
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(RAW_TOBACCO.setRegistryName(bettertobacco.MY_MOD_ID, "raw_tobacco_item"));
		registry.register(TOBACCO_SEEDS.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_seeds_item"));
		registry.register(DRIED_TOBACCO.setRegistryName(bettertobacco.MY_MOD_ID, "dried_tobacco_item"));
		registry.register(TOBACCO_FILTER.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_filter_item"));
		registry.register(CIGARETTE.setRegistryName(bettertobacco.MY_MOD_ID, "cigarette_item"));
	}

}
