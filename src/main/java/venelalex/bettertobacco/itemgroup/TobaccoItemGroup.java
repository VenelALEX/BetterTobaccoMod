package venelalex.bettertobacco.itemgroup;


import java.util.function.Supplier;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import venelalex.bettertobacco.bettertobacco;

public class TobaccoItemGroup extends ItemGroup{

		public final Supplier<IItemProvider> my_supplier;
	
		public TobaccoItemGroup(String label, Supplier<IItemProvider> supplier) {
			super(bettertobacco.MY_MOD_ID + "." + label);
			this.my_supplier = supplier;
		}
		
		@Override
		public ItemStack createIcon() {
			return new ItemStack(my_supplier.get());
		}
}
