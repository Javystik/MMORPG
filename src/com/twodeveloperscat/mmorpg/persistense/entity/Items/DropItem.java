package com.twodeveloperscat.mmorpg.persistense.entity.Items;

public class DropItem extends Item {
	private int dropChance;
	public DropItem(String name, ItemType type, ItemTier itemTier, String description,
	    int healthBonus, int manaBonus, int strengthBonus, int dropChance) {
		super(name, type, itemTier, description, healthBonus, manaBonus, strengthBonus);
		this.dropChance = dropChance;
	}

	public int getDropChance() {
		return dropChance;
	}

	public void setDropChance(int dropChance) {
		this.dropChance = dropChance;
	}
}
