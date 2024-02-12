package com.twodeveloperscat.mmorpg.persistense.entity;

import com.twodeveloperscat.mmorpg.persistense.entity.Items.Item;
import java.util.List;

public class Inventory implements Entity{
	private List<Item> itemList;

	public Inventory(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public void printInventory() {
		if (itemList.isEmpty()) {
			System.out.println("Інвентарь: порожній");
		} else {
			System.out.println("Інвентарь:");
			for (Item item : itemList) {
				System.out.println("  - " + item.getName() + ": " +
				    "Тип: " + item.getType().getNameType() +
				    ", Рівень: " + item.getItemTier().getNameTier() +
				    ", Опис: " + item.getDescription() +
				    ", Бонуси: HP +" + item.getHealthBonus() +
				    ", Mana +" + item.getManaBonus() +
				    ", Сила +" + item.getStrengthBonus());
			}
		}
	}
}