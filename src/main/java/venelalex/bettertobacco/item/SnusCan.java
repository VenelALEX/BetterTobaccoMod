package venelalex.bettertobacco.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import venelalex.bettertobacco.data.providers.SnusCanContainer;
import venelalex.bettertobacco.data.providers.SnusCanContainerScreen;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;

public class SnusCan extends Item{

	public SnusCan() {
		super(new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group).maxStackSize(1));
		// TODO Auto-generated constructor stub
	}
	
	public int getInventorySize(ItemStack stack) {
		return 27;
	}
	
	public IItemHandler getInventory(ItemStack stack) {
		ItemStackHandler stackHandler = new ItemStackHandler(getInventorySize(stack));
		stackHandler.deserializeNBT(stack.getOrCreateTag().getCompound("Inventory"));
		return stackHandler;
	}
	
	public void saveInventory(ItemStack stack, IItemHandler itemHandler) {
		if(itemHandler instanceof ItemStackHandler) {
			stack.getOrCreateTag().put("Inventory", ((ItemStackHandler) itemHandler).serializeNBT());
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(!worldIn.isRemote) {
			playerIn.openContainer(new SimpleNamedContainerProvider((id, playerInv, player) -> {
				return new SnusCanContainer(id, playerInv);
			}, new TranslationTextComponent("Snus")));
		}
		
		return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	
	
}
