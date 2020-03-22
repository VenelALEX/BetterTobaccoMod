package venelalex.bettertobacco.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.blocks.TobaccoPlant;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BetterTobaccoBlocks {
	
	public static final TobaccoPlant TOBACCO_PLANT = new TobaccoPlant();
	
	@SubscribeEvent
	public static void register(final net.minecraftforge.event.RegistryEvent.Register<Block> event) 
	{
		final IForgeRegistry<Block> registry = event.getRegistry();
		
		registry.register(TOBACCO_PLANT.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_plant_block"));
	}
	
	@SubscribeEvent
	public static void registerItemBlock(Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
	}

}
