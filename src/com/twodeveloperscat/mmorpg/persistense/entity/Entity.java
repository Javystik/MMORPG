package com.twodeveloperscat.mmorpg.persistense.entity;

//Шаблончик для сутностей гравця та моба
//Можна додати принципі поля хп, та скільки нада хп для некст лвл в будущому
public abstract class Entity {
	protected String name;
	protected double level;
	protected int health;
	protected int mana;
	protected int strength;

	public Entity(String name, double level, int health, int mana, int strength) {
		this.name = name;
		this.level = level;
		this.health = health;
		this.mana = mana;
		this.strength = strength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public String toString() {
		return "Entity{" +
		    "name='" + name + '\'' +
		    ", level=" + level +
		    ", health=" + health +
		    ", mana=" + mana +
		    ", strength=" + strength +
		    '}';
	}
	//Класи персонажа, вообще лишня штука помойму або реалізовувати по іншому нада
	//Но нехай буде шолі, кіть шо потім заюзаєм
	private enum EntityClass{
		BEGGINER("Початківець", 0, 0, 0),
		WARRIOR("Воїн", 1,0,0.5),
		MAGE("Маг", 0.5,1,0);

		EntityClass(String nameClass, double healthBonus, double manaBonus,
		    double strengthBonus) {
			this.nameClass = nameClass;
			this.healthBonus = healthBonus;
			this.manaBonus = manaBonus;
			this.strengthBonus = strengthBonus;
		}

		private String nameClass;
		private double healthBonus;
		private double manaBonus;
		private double strengthBonus;

		public String getNameClass() {
			return nameClass;
		}

		public void setNameClass(String nameClass) {
			this.nameClass = nameClass;
		}

		public double getHealthBonus() {
			return healthBonus;
		}

		public void setHealthBonus(double healthBonus) {
			this.healthBonus = healthBonus;
		}

		public double getManaBonus() {
			return manaBonus;
		}

		public void setManaBonus(double manaBonus) {
			this.manaBonus = manaBonus;
		}

		public double getStrengthBonus() {
			return strengthBonus;
		}

		public void setStrengthBonus(double strengthBonus) {
			this.strengthBonus = strengthBonus;
		}
	}
}
