package venelalex.bettertobacco.data.providers;

import java.util.function.Consumer;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
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
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.TOBACCO_FILTER, 4)//
		.patternLine("PPP")//
		.patternLine("PWP")//
		.patternLine("PPP")//
		.key('P', net.minecraft.item.Items.PAPER)//
		.key('W', net.minecraft.item.Items.STRING)
		.addCriterion("I hope your are at least at the age of 18 :P but it's just a filter", hasItem(net.minecraft.item.Items.PAPER))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "tobacco_filter_recipe"));
		
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.CIGARETTE, 1)//
		.patternLine("PPP")//
		.patternLine("FTT")//
		.patternLine("PPP")//
		.key('P', net.minecraft.item.Items.PAPER)//
		.key('F', BetterTobaccoItems.TOBACCO_FILTER)
		.key('T', BetterTobaccoItems.DRIED_TOBACCO)
		.addCriterion("I hope your are at least at the age of 18 :P", hasItem(net.minecraft.item.Items.PAPER))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "cigarette_recipe"));
		
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(BetterTobaccoItems.RAW_TOBACCO), BetterTobaccoItems.DRIED_TOBACCO, 10, 20)
		.addCriterion("Cook your tobacco!", hasItem(BetterTobaccoItems.RAW_TOBACCO))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "dried_tobacco_cooking_recipe"));
	}

}
