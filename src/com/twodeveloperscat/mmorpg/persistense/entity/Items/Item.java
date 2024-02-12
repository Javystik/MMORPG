package com.twodeveloperscat.mmorpg.persistense.entity.Items;

import com.twodeveloperscat.mmorpg.persistense.entity.Entity;

public class Item implements Entity {
	private String name;
	private ItemType type;
	private ItemTier itemTier;
	private String description;
	private int healthBonus;
	private int manaBonus;
	private int strengthBonus;

	public Item(String name, ItemType type, ItemTier itemTier, String description,
	    int healthBonus,
	    int manaBonus, int strengthBonus) {
		this.name = name;
		this.type = type;
		this.itemTier = itemTier;
		this.description = description;
		this.healthBonus = healthBonus;
		this.manaBonus = manaBonus;
		this.strengthBonus = strengthBonus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	public ItemTier getItemTier() {
		return itemTier;
	}
	public void setItemTier(ItemTier itemTier) {
		this.itemTier = itemTier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHealthBonus() {
		return healthBonus;
	}
	public void setHealthBonus(int healthBonus) {
		this.healthBonus = healthBonus;
	}
	public int getManaBonus() {
		return manaBonus;
	}
	public void setManaBonus(int manaBonus) {
		this.manaBonus = manaBonus;
	}
	public int getStrengthBonus() {
		return strengthBonus;
	}
	public void setStrengthBonus(int strengthBonus) {
		this.strengthBonus = strengthBonus;
	}
	public enum ItemTier{
		COMMON("Простий"),
		UNCOMMON("Незвичайний"),
		RARE("Рідкісний"),
		EPIC("Епічний"),
		LEGENDARY("Легендарний"),
		MYTHIC("Міфічний");
		private final String nameTier;
		ItemTier(String nameTier) {
			this.nameTier = nameTier;
		}
		public String getNameTier() {
			return nameTier;
		}
	}
	public enum ItemType {
		WEAPON("Зброя"),
		ARMOR("Броня"),
		CONSUMABLE("Споживчий"),
		ACCESSORY("Аксесуар");

		private final String nameType;

		ItemType(String nameType) {
			this.nameType = nameType;
		}

		public String getNameType() {
			return nameType;
		}
	}
}