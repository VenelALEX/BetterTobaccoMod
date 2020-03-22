package venelalex.bettertobacco.dataservice;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.data.providers.BetterTobaccoLootTableProvider;
import venelalex.bettertobacco.data.providers.BetterTobaccoRecipeProvider;

@EventBusSubscriber(modid = bettertobacco.MY_MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterTobaccoDataGenerator {

	@SubscribeEvent
	public static void data(GatherDataEvent event) {
		final DataGenerator my_generator = event.getGenerator();
		
		my_generator.addProvider(new BetterTobaccoRecipeProvider(my_generator));
		
		my_generator.addProvider(new BetterTobaccoLootTableProvider(my_generator));
	}
}
