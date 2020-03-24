package venelalex.bettertobacco.init;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.item.Cigarette;
import venelalex.bettertobacco.item.DriedTobacco;
import venelalex.bettertobacco.item.RawTobacco;
import venelalex.bettertobacco.item.Snus;
import venelalex.bettertobacco.item.SnusCan;
import venelalex.bettertobacco.item.TobaccoEssence;
import venelalex.bettertobacco.item.TobaccoFilter;
import venelalex.bettertobacco.item.TobaccoIngot;
import venelalex.bettertobacco.item.TobaccoSeeds;
import venelalex.bettertobacco.item.UsedCigarette;
import venelalex.bettertobacco.item.UsedSnus;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BetterTobaccoItems {
	
	public static final RawTobacco RAW_TOBACCO = new RawTobacco();
	public static final TobaccoSeeds TOBACCO_SEEDS = new TobaccoSeeds();
	public static final DriedTobacco DRIED_TOBACCO = new DriedTobacco();
	public static final TobaccoFilter TOBACCO_FILTER = new TobaccoFilter();
	public static final Cigarette CIGARETTE = new Cigarette();
	public static final Snus SNUS = new Snus();
	public static final UsedSnus USED_SNUS = new UsedSnus();
	public static final SnusCan SNUS_CAN = new SnusCan();
	public static final TobaccoEssence TOBACCO_ESSENCE = new TobaccoEssence();
	public static final TobaccoIngot TOBACCO_INGOT = new TobaccoIngot();
	public static final UsedCigarette USED_CIGARETTE = new UsedCigarette();
	
	@SubscribeEvent
	public static void register(final net.minecraftforge.event.RegistryEvent.Register<Item> event) 
	{
		
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(RAW_TOBACCO.setRegistryName(bettertobacco.MY_MOD_ID, "raw_tobacco_item"));
		registry.register(TOBACCO_SEEDS.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_seeds_item"));
		registry.register(DRIED_TOBACCO.setRegistryName(bettertobacco.MY_MOD_ID, "dried_tobacco_item"));
		registry.register(TOBACCO_FILTER.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_filter_item"));
		registry.register(CIGARETTE.setRegistryName(bettertobacco.MY_MOD_ID, "cigarette_item"));
		registry.register(SNUS.setRegistryName(bettertobacco.MY_MOD_ID, "snus_item"));
		registry.register(USED_SNUS.setRegistryName(bettertobacco.MY_MOD_ID, "used_snus_item"));
		registry.register(SNUS_CAN.setRegistryName(bettertobacco.MY_MOD_ID, "snus_can_item"));
		registry.register(TOBACCO_ESSENCE.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_essence_item"));
		registry.register(TOBACCO_INGOT.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_ingot_item"));
		registry.register(USED_CIGARETTE.setRegistryName(bettertobacco.MY_MOD_ID, "used_cigarette_item"));
	}

}
