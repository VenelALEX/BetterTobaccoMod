package venelalex.bettertobacco.item;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;
import venelalex.bettertobacco.init.ToolMaterialList;

public class TobaccoPickaxe extends PickaxeItem{

	public TobaccoPickaxe() {
		super(ToolMaterialList.tobacco, 5, -2.5f, new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group));
		// TODO Auto-generated constructor stub
	}
}
