package venelalex.bettertobacco.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;
import venelalex.bettertobacco.init.BetterTobaccoItems;

public class Joint extends Item{

	public Joint() {
		super(new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group).maxStackSize(1).rarity(Rarity.RARE));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		//Positive effects
		playerIn.addPotionEffect(new EffectInstance(Effects.LUCK, 12000, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 12000, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 12000, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 12000, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 12000, 1));
		
		//Negative effects
		playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1));
		playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 2000, 1));
		
		ItemStack giveStack = new ItemStack(BetterTobaccoItems.USED_CIGARETTE, 1);
		
		return ActionResult.newResult(ActionResultType.SUCCESS, giveStack);
	}
}
