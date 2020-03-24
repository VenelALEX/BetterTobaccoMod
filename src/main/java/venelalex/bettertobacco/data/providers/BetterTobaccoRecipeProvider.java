package venelalex.bettertobacco.data.providers;

import java.util.function.Consumer;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.Items;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.init.BetterTobaccoItems;
import venelalex.bettertobacco.init.BetterTobaccoTags;
import venelalex.bettertobacco.item.RawTobacco;

public class BetterTobaccoRecipeProvider extends RecipeProvider{

	public BetterTobaccoRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		tobaccoFilterRecipe(consumer);
		cigaretteRecipe(consumer);
		driedTobaccoSmelting(consumer);
		snusRecipe(consumer);
		snusCanRecipe(consumer);
		tobaccoEssenceRecipe(consumer);
		tobaccoIngotRecipe(consumer);
	}
	
	//Crafting Recipes
	
	private void tobaccoFilterRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.TOBACCO_FILTER, 4)//
		.patternLine("PPP")//
		.patternLine("PWP")//
		.patternLine("PPP")//
		.key('P', net.minecraft.item.Items.PAPER)//
		.key('W', net.minecraft.item.Items.STRING)
		.addCriterion("I hope your are at least at the age of 18 :P but it's just a filter", hasItem(net.minecraft.item.Items.PAPER))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "tobacco_filter_recipe"));
	}
	
	private void cigaretteRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.CIGARETTE, 1)//
		.patternLine("PPP")//
		.patternLine("FDD")//
		.patternLine("PPP")//
		.key('P', net.minecraft.item.Items.PAPER)//
		.key('F', BetterTobaccoItems.TOBACCO_FILTER)
		.key('D', BetterTobaccoItems.DRIED_TOBACCO)
		.addCriterion("I hope your are at least at the age of 18 :P but it's just a cigarette", hasItem(net.minecraft.item.Items.PAPER))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "cigarette_recipe"));
	}
	
	private void snusRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.SNUS, 1)//
		.patternLine("FSF")//
		.patternLine("SES")//
		.patternLine("FSF")//
		.key('F', BetterTobaccoItems.TOBACCO_FILTER)//
		.key('S', net.minecraft.item.Items.STRING)
		.key('E', BetterTobaccoItems.TOBACCO_ESSENCE)
		.addCriterion("I hope your are at least at the age of 18 :P but it's just a snus", hasItem(net.minecraft.item.Items.STRING))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "snus_recipe"));
	}
	
	private void snusCanRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.SNUS_CAN, 1)//
		.patternLine("I")//
		.patternLine("P")//
		.patternLine("I")//
		.key('P', net.minecraft.item.Items.PAPER)
		.key('I', net.minecraft.item.Items.IRON_INGOT)
		.addCriterion("I hope your are at least at the age of 18 :P but it's just a snus can", hasItem(net.minecraft.item.Items.PAPER))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "snus_can_recipe"));
	}
	
	private void tobaccoEssenceRecipe(Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.TOBACCO_ESSENCE, 1)//
		.patternLine("NNN")//
		.patternLine("NTN")//
		.patternLine("NNN")//
		.key('N', net.minecraft.item.Items.IRON_NUGGET)
		.key('T', BetterTobaccoItems.DRIED_TOBACCO)
		.addCriterion("I hope your are at least at the age of 18 :P but it's just a tobacco essence", hasItem(net.minecraft.item.Items.IRON_NUGGET))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "tobacco_essence_recipe"));
	}
	
	private void tobaccoIngotRecipe(Consumer<IFinishedRecipe> consumer) {
			
		ShapedRecipeBuilder.shapedRecipe(BetterTobaccoItems.TOBACCO_INGOT, 1)//
		.patternLine("TTT")//
		.patternLine("TDT")//
		.patternLine("TTT")//
		.key('D', net.minecraft.item.Items.DIAMOND)
		.key('T', BetterTobaccoTags.Items.USED_TOBACCO)
		.addCriterion("I hope your are at least at the age of 18 :P but it's just a tobacco ingot", hasItem(net.minecraft.item.Items.DIAMOND))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "tobacco_ingot_recipe"));
	}
	
	//Smelting Recipes
	
	private void driedTobaccoSmelting(Consumer<IFinishedRecipe> consumer) {
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(BetterTobaccoItems.RAW_TOBACCO), BetterTobaccoItems.DRIED_TOBACCO, 10, 20)
		.addCriterion("Cook your tobacco!", hasItem(BetterTobaccoItems.RAW_TOBACCO))
		.build(consumer, new ResourceLocation(bettertobacco.MY_MOD_ID, "dried_tobacco_cooking_recipe"));
	}

}
