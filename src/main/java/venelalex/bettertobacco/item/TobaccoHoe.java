package venelalex.bettertobacco.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;
import venelalex.bettertobacco.init.ToolMaterialList;

public class TobaccoHoe extends HoeItem{

	public TobaccoHoe() {
		super(ToolMaterialList.tobacco, 1.0f, new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group));
		// TODO Auto-generated constructor stub
	}
}
