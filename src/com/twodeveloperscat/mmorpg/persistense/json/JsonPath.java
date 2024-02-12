package com.twodeveloperscat.mmorpg.persistense.json;

public enum JsonPath {
	PLAYER("players.json"),
	ITEM("items.json"),
	DROP_ITEM("dropItems.json"),
	SHOP_ITEM("shopItems.json");
	private final String path;
	JsonPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return "Data/" + path;
	}
}
