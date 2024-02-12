package com.twodeveloperscat.mmorpg.persistense.entity.character;

import com.twodeveloperscat.mmorpg.persistense.entity.character.Character;

public class Enemy extends Character {
	private String id;
	private EnemyType enemyType;

	public Enemy(String name, int level, int health, int mana, int strength, String id,
	    EnemyType enemyType) {
		super(name, level, health, mana, strength);
		this.id = id;
		this.enemyType = enemyType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnemyType getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(EnemyType enemyType) {
		this.enemyType = enemyType;
	}

	private enum EnemyType{
		ORC("Орк"),
		SKELETON("Скелет"),
		ZOMBIE("Зомбі"),
		SLIME("Слайм"),
		GOBLIN("Гоблін"),
		DRAGON("Дракон");
		private String name;

		EnemyType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
