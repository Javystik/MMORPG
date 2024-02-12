package com.twodeveloperscat.mmorpg.persistense.entity.Items;

public class ShopItem extends Item {
	private int cost;

	public ShopItem(String name, ItemType type, ItemTier itemTier, String description,
	    int healthBonus, int manaBonus, int strengthBonus, int cost) {
		super(name, type, itemTier, description, healthBonus, manaBonus, strengthBonus);
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
