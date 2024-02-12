package com.twodeveloperscat.mmorpg.persistense.entity.character;

import com.twodeveloperscat.mmorpg.persistense.entity.Inventory;

public class Player extends Character {
	private String id;
	private String password;
	private int coins;
	private Inventory inventory;

	public Player(String name, int level, int health, int mana, int strength, String id,
	    String password, int coins, Inventory inventory) {
		super(name, level, health, mana, strength);
		this.id = id;
		this.password = password;
		this.coins = coins;
		this.inventory = inventory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
