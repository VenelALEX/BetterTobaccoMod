package venelalex.bettertobacco.item;


import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;
import venelalex.bettertobacco.init.BetterTobaccoItems;

public class Snus extends Item{
	
	public Snus() {
		super(new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group).maxStackSize(1).rarity(Rarity.RARE));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		//Positive effects
		playerIn.addPotionEffect(new EffectInstance(Effects.LUCK, 6000, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 6000, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 6000, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 6000, 1));
		
		//Negative effects
		playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1));
		
		ItemStack giveStack = new ItemStack(BetterTobaccoItems.USED_SNUS, 1);
		
		return ActionResult.newResult(ActionResultType.SUCCESS, giveStack);
	}
	
}
