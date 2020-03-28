package venelalex.bettertobacco.data.providers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import venelalex.bettertobacco.item.Snus;

public class SlotSnus extends SlotItemHandler{

	public SlotSnus(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return (stack.getItem() instanceof Snus);
	}

}
