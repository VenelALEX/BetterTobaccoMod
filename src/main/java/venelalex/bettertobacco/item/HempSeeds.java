package venelalex.bettertobacco.item;

import com.electronwill.nightconfig.core.EnumGetMethod;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.FaceDirection;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import venelalex.bettertobacco.init.BetterTobaccoBlocks;
import venelalex.bettertobacco.init.BetterTobaccoItemGroups;

public class HempSeeds extends Item implements IPlantable{

	public HempSeeds() {
		super(new Item.Properties().group(BetterTobaccoItemGroups.my_Item_Group));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		
		ItemStack stack = context.getPlayer().getHeldItem(context.getHand());
		BlockState state = context.getWorld().getBlockState(context.getPos());
		
		if(context.getFace() == Direction.UP && context.getPlayer().canPlayerEdit(context.getPos().offset(context.getFace()), context.getFace(), stack) && state.getBlock().canSustainPlant(state, context.getWorld(), context.getPos(), Direction.UP, this) && context.getWorld().isAirBlock(context.getPos().up())) {
			context.getWorld().setBlockState(context.getPos().up(), BetterTobaccoBlocks.HEMP_PLANT.getDefaultState());
			if(!context.getPlayer().isCreative() && !context.getWorld().isRemote()) {
				stack.shrink(1);
			}
			return ActionResultType.SUCCESS;
			
		}else {
			return ActionResultType.FAIL;
		}
	}
	
	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		
		return PlantType.Crop;
	}
	
	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		return BetterTobaccoBlocks.HEMP_PLANT.getDefaultState();
	}

}
