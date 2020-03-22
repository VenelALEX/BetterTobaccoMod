package venelalex.bettertobacco.blocks.crops;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import venelalex.bettertobacco.init.BetterTobaccoItems;

public class TobaccoPlant extends CropsBlock implements IGrowable{
	
	public static final IntegerProperty TOBACCO_PLANT_AGE = BlockStateProperties.AGE_0_7;

	public TobaccoPlant() {
		super(Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(5).sound(SoundType.PLANT).tickRandomly());
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}
	
	@OnlyIn(Dist.CLIENT)
	protected IItemProvider getSeedsItem() {
		return BetterTobaccoItems.TOBACCO_SEEDS;
	}
	
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(this.getSeedsItem());
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() instanceof FarmlandBlock;
	}
	
	public IntegerProperty getAgeProperty() {
		return TOBACCO_PLANT_AGE;
	}
	
	public int getMaxAge()
	{
		return 7;
	}
	
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}
	
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}
	
	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		this.grow(worldIn, pos, state);
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(TOBACCO_PLANT_AGE);
	}
	
	protected Item getSeed() {
		return BetterTobaccoItems.TOBACCO_SEEDS;
	}
	
	protected Item getCrop() {
		return BetterTobaccoItems.RAW_TOBACCO;
	}
	
}
