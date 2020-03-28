package venelalex.bettertobacco.data.providers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import venelalex.bettertobacco.item.Snus;

public class SnusCanItemsHandler extends ItemStackHandler{
	
	public SnusCanItemsHandler() {
		super(2);
	}
	
	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		if(stack.getItem() instanceof Snus) {
			return stack;
		};
		return super.insertItem(slot, stack, simulate);
	}

}
