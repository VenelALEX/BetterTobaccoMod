package venelalex.bettertobacco.init;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import venelalex.bettertobacco.bettertobacco;
import venelalex.bettertobacco.item.Cigarette;
import venelalex.bettertobacco.item.DriedHemp;
import venelalex.bettertobacco.item.DriedTobacco;
import venelalex.bettertobacco.item.HempSeeds;
import venelalex.bettertobacco.item.Joint;
import venelalex.bettertobacco.item.RawHemp;
import venelalex.bettertobacco.item.RawTobacco;
import venelalex.bettertobacco.item.Snus;
import venelalex.bettertobacco.item.SnusCan;
import venelalex.bettertobacco.item.TobaccoAxe;
import venelalex.bettertobacco.item.TobaccoChestplate;
import venelalex.bettertobacco.item.TobaccoEssence;
import venelalex.bettertobacco.item.TobaccoFilter;
import venelalex.bettertobacco.item.TobaccoHelmet;
import venelalex.bettertobacco.item.TobaccoHoe;
import venelalex.bettertobacco.item.TobaccoIngot;
import venelalex.bettertobacco.item.TobaccoLeggins;
import venelalex.bettertobacco.item.TobaccoPickaxe;
import venelalex.bettertobacco.item.TobaccoSeeds;
import venelalex.bettertobacco.item.TobaccoShoes;
import venelalex.bettertobacco.item.TobaccoShovel;
import venelalex.bettertobacco.item.TobaccoSword;
import venelalex.bettertobacco.item.UsedCigarette;
import venelalex.bettertobacco.item.UsedSnus;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BetterTobaccoItems {
	
	public static final TobaccoSeeds TOBACCO_SEEDS = new TobaccoSeeds();
	public static final RawTobacco RAW_TOBACCO = new RawTobacco();
	public static final DriedTobacco DRIED_TOBACCO = new DriedTobacco();
	public static final TobaccoFilter TOBACCO_FILTER = new TobaccoFilter();
	public static final Cigarette CIGARETTE = new Cigarette();
	public static final UsedCigarette USED_CIGARETTE = new UsedCigarette();
	public static final SnusCan SNUS_CAN = new SnusCan();
	public static final Snus SNUS = new Snus();
	public static final UsedSnus USED_SNUS = new UsedSnus();
	public static final TobaccoEssence TOBACCO_ESSENCE = new TobaccoEssence();
	public static final TobaccoIngot TOBACCO_INGOT = new TobaccoIngot();
	
	public static final TobaccoHelmet TOBACCO_HELMET = new TobaccoHelmet();
	public static final TobaccoChestplate TOBACCO_CHESTPLATE = new TobaccoChestplate();
	public static final TobaccoLeggins TOBACCO_LEGGINS = new TobaccoLeggins();
	public static final TobaccoShoes TOBACCO_SHOES = new TobaccoShoes();
	
	public static final TobaccoAxe TOBACCO_AXE = new TobaccoAxe();
	public static final TobaccoPickaxe TOBACCO_PICKAXE = new TobaccoPickaxe();
	public static final TobaccoHoe TOBACCO_HOE = new TobaccoHoe();
	public static final TobaccoShovel TOBACCO_SHOVEL = new TobaccoShovel();
	public static final TobaccoSword TOBACCO_SWORD = new TobaccoSword();
	
	public static final RawHemp RAW_HEMP = new RawHemp();
	public static final DriedHemp DRIED_HEMP = new DriedHemp();
	public static final Joint JOINT = new Joint();
	public static final HempSeeds HEMP_SEEDS = new HempSeeds();
	
	
	@SubscribeEvent
	public static void register(final net.minecraftforge.event.RegistryEvent.Register<Item> event) 
	{
		
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(TOBACCO_SEEDS.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_seeds_item"));
		registry.register(RAW_TOBACCO.setRegistryName(bettertobacco.MY_MOD_ID, "raw_tobacco_item"));	
		registry.register(DRIED_TOBACCO.setRegistryName(bettertobacco.MY_MOD_ID, "dried_tobacco_item"));
		registry.register(TOBACCO_FILTER.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_filter_item"));
		registry.register(CIGARETTE.setRegistryName(bettertobacco.MY_MOD_ID, "cigarette_item"));
		registry.register(USED_CIGARETTE.setRegistryName(bettertobacco.MY_MOD_ID, "used_cigarette_item"));
		registry.register(SNUS_CAN.setRegistryName(bettertobacco.MY_MOD_ID, "snus_can_item"));
		registry.register(SNUS.setRegistryName(bettertobacco.MY_MOD_ID, "snus_item"));
		registry.register(USED_SNUS.setRegistryName(bettertobacco.MY_MOD_ID, "used_snus_item"));	
		registry.register(TOBACCO_ESSENCE.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_essence_item"));
		registry.register(TOBACCO_INGOT.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_ingot_item"));
		
		registry.register(TOBACCO_HELMET.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_helmet_item"));
		registry.register(TOBACCO_CHESTPLATE.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_chestplate_item"));
		registry.register(TOBACCO_LEGGINS.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_leggings_item"));
		registry.register(TOBACCO_SHOES.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_shoes_item"));
		
		registry.register(TOBACCO_AXE.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_axe_item"));
		registry.register(TOBACCO_PICKAXE.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_pickaxe_item"));
		registry.register(TOBACCO_HOE.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_hoe_item"));
		registry.register(TOBACCO_SHOVEL.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_shovel_item"));
		registry.register(TOBACCO_SWORD.setRegistryName(bettertobacco.MY_MOD_ID, "tobacco_sword_item"));
		
		registry.register(RAW_HEMP.setRegistryName(bettertobacco.MY_MOD_ID, "raw_hemp_item"));
		registry.register(DRIED_HEMP.setRegistryName(bettertobacco.MY_MOD_ID, "dried_hemp_item"));
		registry.register(JOINT.setRegistryName(bettertobacco.MY_MOD_ID, "joint_item"));
		registry.register(HEMP_SEEDS.setRegistryName(bettertobacco.MY_MOD_ID, "hemp_seeds_item"));
	}

}
