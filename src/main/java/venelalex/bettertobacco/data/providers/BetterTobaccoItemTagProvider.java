package venelalex.bettertobacco.data.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import venelalex.bettertobacco.init.BetterTobaccoItems;
import venelalex.bettertobacco.init.BetterTobaccoTags;

public class BetterTobaccoItemTagProvider extends ItemTagsProvider{

	public BetterTobaccoItemTagProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void registerTags() {
		getBuilder(BetterTobaccoTags.Items.USED_TOBACCO)
		.add(BetterTobaccoItems.USED_CIGARETTE)
		.add(BetterTobaccoItems.USED_SNUS);
	}

}
