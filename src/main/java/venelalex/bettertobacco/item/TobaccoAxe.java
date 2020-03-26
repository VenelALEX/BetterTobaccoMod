package venelalex.bettertobacco.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;
import venelalex.bettertobacco.init.ToolMaterialList;

public class TobaccoAxe extends AxeItem{

	public TobaccoAxe() {
		super(ToolMaterialList.tobacco, 8.5f, -2.5f, new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group));
		// TODO Auto-generated constructor stub
	}
}
