package venelalex.bettertobacco.data.providers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;
import java.util.function.BiConsumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import venelalex.bettertobacco.init.BetterTobaccoBlocks;
import venelalex.bettertobacco.init.BetterTobaccoItems;

public class BetterTobaccoLootTableProvider implements IDataProvider{

	
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
	
	private final DataGenerator generator;
	
	public BetterTobaccoLootTableProvider(DataGenerator generator) {
		this.generator = generator;
	}
	
	@Override
	public void act(DirectoryCache cache) throws IOException {
		registerLootTables((id, lootTable) -> {
			final Path path = getPath(id);
			try {
				IDataProvider.save(GSON, cache, LootTableManager.toJson(lootTable), path);
			} catch(IOException ex) {
				LOGGER.error(">> Error while saving LootTable");
			}
		});
	}
	
	private Path getPath(ResourceLocation id) {
		return generator.getOutputFolder().resolve("data/" + id.getNamespace() + "/loot_tables/" + id.getPath() + ".json");
	}

	@Override
	public String getName() {
		return ">> BetterTobacco LootTables";
	}
	
	protected void registerLootTables(BiConsumer<ResourceLocation, LootTable> consumer) {
		registerBlock(BetterTobaccoBlocks.TOBACCO_PLANT, getTobaccoPlantLootTable(BetterTobaccoItems.RAW_TOBACCO, BetterTobaccoItems.TOBACCO_SEEDS), consumer);
	}
	
	private static void registerBlock(Block block, LootTable lootTable, BiConsumer<ResourceLocation, LootTable> consumer) {
		final ResourceLocation registryName = block.getRegistryName();
		consumer.accept(new ResourceLocation(registryName.getNamespace(), "blocks/" + registryName.getPath()), lootTable);
	}
	
	private static LootTable getTobaccoPlantLootTable(IItemProvider itemProvider, IItemProvider itemProvider2) {
		return LootTable.builder().setParameterSet(LootParameterSets.BLOCK)
				.addLootPool(LootPool.builder()
				.rolls( new RandomValueRange(1, 2))
				.addEntry(ItemLootEntry.builder(itemProvider))
				.acceptCondition(SurvivesExplosion.builder()))
				.addLootPool(LootPool.builder()
				.rolls(new RandomValueRange(1, 3))
				.addEntry(ItemLootEntry.builder(itemProvider2))
				.acceptCondition(SurvivesExplosion.builder()))
				.build();
	}

}
