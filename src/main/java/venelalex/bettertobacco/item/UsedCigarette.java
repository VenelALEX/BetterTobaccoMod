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

public class UsedCigarette extends Item{

	public UsedCigarette() {
		super(new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group));
		// TODO Auto-generated constructor stub
	}
	
}
