package venelalex.bettertobacco.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier{
	
	tobacco(0.0f, 10.0f, 1600, 4, 10, BetterTobaccoItems.TOBACCO_INGOT);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairItem;
	
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairItem = repairMaterial;
	}


	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}


	@Override
	public float getEfficiency() {
		return this.efficiency;
	}


	@Override
	public int getEnchantability() {
		return this.enchantability;
	}


	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}


	@Override
	public int getMaxUses() {
		return this.durability;
	}


	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairItem);
	}
}
