package venelalex.bettertobacco.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import venelalex.bettertobacco.init.ArmorMaterialList;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;

public class TobaccoHelmet extends ArmorItem{

	public TobaccoHelmet() {
		super(ArmorMaterialList.tobacco, EquipmentSlotType.HEAD, new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group));
	}
}
