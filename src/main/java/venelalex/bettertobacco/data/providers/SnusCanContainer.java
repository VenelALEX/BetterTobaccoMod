package venelalex.bettertobacco.data.providers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import venelalex.bettertobacco.init.BetterTobaccoItems;
import venelalex.bettertobacco.item.Snus;
import venelalex.bettertobacco.item.SnusCan;

public class SnusCanContainer extends Container{
	
	private final ItemStack item;
	private final IItemHandler itemHandler;
	private int blocked = -1;
	
	public SnusCanContainer(int id, PlayerInventory playerInv) {
		super(BetterTobaccoContainerTypes.snus_can, id);
		this.item = getHeldItem(playerInv.player);
		this.itemHandler = ((SnusCan)this.item.getItem()).getInventory(this.item);
		
		for(int i= 0; i < this.itemHandler.getSlots(); i++) {
			int x = 8 + 18 * (i % 9);
			int y = 18 + 18 * (i / 9);
			addSlot(new SlotItemHandler(this.itemHandler, i, x, y));
		}
		
		final int rowCount = this.itemHandler.getSlots() / 9;
		final int yOffset = (rowCount - 4) * 18;
		
		//Player Inventory
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 9; ++x) {
				addSlot(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 103 + y * 18 + yOffset));
			}
		}
		
		//Hotbar
		for(int x = 0; x < 9; ++x) {
			Slot slot = addSlot(new Slot(playerInv, x, 8 + x * 18, 161 + yOffset) {
				@Override
				public boolean canTakeStack(PlayerEntity playerIn) {return slotNumber != blocked; }
			});
			
			if(x == playerInv.currentItem && ItemStack.areItemStacksEqual(playerInv.getCurrentItem(), this.item)) {
				blocked = slot.slotNumber;
			}
		}
		
	}
	
	private static ItemStack getHeldItem(PlayerEntity player) {
		if(player.getHeldItemMainhand().getItem() instanceof SnusCan) {
			return player.getHeldItemMainhand();
		}
		if(player.getHeldItemOffhand().getItem() instanceof SnusCan) {
			return player.getHeldItemOffhand();
		}
		return ItemStack.EMPTY;
	}
	
	public int getInventoryRows() {
		return this.itemHandler.getSlots() / 9;
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}
	
	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		super.onContainerClosed(playerIn);
		((SnusCan) this.item.getItem()).saveInventory(this.item, this.itemHandler);
	}
	
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		Slot slot = this.getSlot(index);
		
		if(!slot.canTakeStack(playerIn)) {
			return slot.getStack();
		}
		
		if(index == blocked || !slot.getHasStack()) {
			return ItemStack.EMPTY;
		}
		
		ItemStack stack = slot.getStack();
		ItemStack newStack = stack.copy();
		
		int containerSlots = itemHandler.getSlots();
		if(index < containerSlots) {
			if(!this.mergeItemStack(stack, containerSlots, this.inventorySlots.size(), true)) {
				return ItemStack.EMPTY;
			}
			slot.onSlotChanged();
		} else if (!this.mergeItemStack(stack, 0, containerSlots, false)) {
			return ItemStack.EMPTY;
		}
		
		if(stack.isEmpty()) {
			slot.putStack(ItemStack.EMPTY);
		}else {
			slot.onSlotChanged();
		}
		
		return slot.onTake(playerIn, newStack);
	}
	
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player) {
		if(slotId < 0 || slotId > inventorySlots.size()) {
			return super.slotClick(slotId, dragType, clickTypeIn, player);
		}
		
		Slot slot = inventorySlots.get(slotId);
		if(!canTake(slotId, slot, dragType, player, clickTypeIn)) {
			return slot.getStack();
		}
		
		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}
	
	private static boolean isContainerItem(ItemStack stack) {
		return ((stack.getItem() instanceof SnusCan));
	}
	
	
	public boolean canTake(int slotId, Slot slot, int button, PlayerEntity player, ClickType clickType) {
		
		if(slotId == blocked || slotId <= itemHandler.getSlots() - 1 && isContainerItem(player.inventory.getItemStack())) {
			return false;
		}
		
		if(clickType == ClickType.SWAP) {
			int hotbarId = itemHandler.getSlots() + 27 + button;
			
			if(blocked == hotbarId) {
				return false;
			}
			
			Slot hotbarSlot = getSlot(hotbarId);
			if(slotId <= itemHandler.getSlots() - 1) {
				return !isContainerItem(slot.getStack()) && !isContainerItem(hotbarSlot.getStack());
			}
		}
		
		return true;
	}
	

}
