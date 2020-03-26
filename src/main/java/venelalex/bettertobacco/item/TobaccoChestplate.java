package venelalex.bettertobacco.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import venelalex.bettertobacco.init.ArmorMaterialList;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;

public class TobaccoChestplate extends ArmorItem{

	public TobaccoChestplate() {
		super(ArmorMaterialList.tobacco, EquipmentSlotType.CHEST, new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group));
		// TODO Auto-generated constructor stub
	}
}
