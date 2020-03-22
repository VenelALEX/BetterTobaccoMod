package venelalex.bettertobacco.data.providers;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.Items;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.init.BetterTobaccoItems;
import venelalex.bettertobacco.item.RawTobacco;

public class BetterTobaccoRecipeProvider extends RecipeProvider{

	public BetterTobaccoRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.RAW_TOBACCO, 1)//
		.patternLine("TTT")//
		.patternLine("TTT")//
		.patternLine("TTT")//
		.key('T', net.minecraft.item.Items.WHEAT_SEEDS)//
		.addCriterion("Einfach_so", hasItem(net.minecraft.item.Items.WHEAT_SEEDS))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "tobacco_recipe"));;
	}

}
