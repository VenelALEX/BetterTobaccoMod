package venelalex.bettertobacco.init;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import venelalex.bettertobacco.bettertobacco;

public class BetterTobaccoTags {
	
	public static final class Items{
		
		public static final Tag<Item> USED_TOBACCO = genTag(bettertobacco.MY_MOD_ID, "used_tobacco");
		
		private static Tag<Item> genTag(String modid, String name){
			return new ItemTags.Wrapper(new ResourceLocation(modid, name));
		}
		
	}
}
