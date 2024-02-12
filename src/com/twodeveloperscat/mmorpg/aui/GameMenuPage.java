package com.twodeveloperscat.mmorpg.aui;

import com.twodeveloperscat.mmorpg.domain.PlayerService;
import com.twodeveloperscat.mmorpg.persistense.entity.Items.Item;
import com.twodeveloperscat.mmorpg.persistense.entity.Items.Item.ItemTier;
import com.twodeveloperscat.mmorpg.persistense.entity.Items.Item.ItemType;
import com.twodeveloperscat.mmorpg.persistense.entity.character.Player;
import com.twodeveloperscat.mmorpg.persistense.json.JsonConvertor;
import com.twodeveloperscat.mmorpg.persistense.json.JsonPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GameMenuPage {
	public final Scanner scanner = new Scanner(System.in);
	private final Optional<Player> activePlayer;
	private static final PlayerService playerService = new PlayerService();
	public GameMenuPage(Optional<Player> activePlayer) {
		this.activePlayer = activePlayer;
	}
	public void mainPage() {
		boolean isExit = false;

		while (!isExit) {
			System.out.println("Вітаємо вас в консольній рпг грі! Оберіть вашу дію");
			System.out.println("1: Переглянути профіль");
			System.out.println("2: Переглянути топ ігроків");
			System.out.println("3: Піти в рейд");
			System.out.println("4: Ринок");
			System.out.println("5: Вікно прокачок");
			System.out.println("0: Вихід");

			System.out.print("Ваша дія: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					viewProfile(activePlayer);
					break;
				case 2:
					viewTopPlayers();
					break;
				case 3:
					goRaid();
					break;
				case 4:
					market();
					break;
				case 5:
					skillWindow();
					break;
				case 6:
					createItem();
				case 0:
					System.out.println("Вихід з гри. Хорошого дня!");
					isExit = true;
					break;
				default:
					System.out.println("Невірний вибір, спробуйте ще раз.");
					break;
			}
		}
	}

	private void createItem() {
		System.out.println("Створення нового предмета:");

		System.out.print("Назва предмета: ");
		String name = scanner.nextLine();

		System.out.println("Типи предметів:");
		int i = 1;
		for (ItemType itemType : ItemType.values()) {
			System.out.println(i + ": " + itemType.getNameType());
			i++;
		}

		System.out.print("Оберіть тип предмета (введіть номер): ");
		int typeChoice = scanner.nextInt();
		ItemType type = ItemType.values()[typeChoice - 1];

		System.out.println("Рівні предметів:");
		i = 1;
		for (ItemTier itemTier : ItemTier.values()) {
			System.out.println(i + ": " + itemTier.getNameTier());
			i++;
		}

		System.out.print("Оберіть рівень предмета (введіть номер): ");
		int tierChoice = scanner.nextInt();
		ItemTier itemTier = ItemTier.values()[tierChoice - 1];

		scanner.nextLine();

		System.out.print("Опис предмета: ");
		String description = scanner.nextLine();

		System.out.print("Бонус здоров'я: ");
		int healthBonus = scanner.nextInt();

		System.out.print("Бонус мани: ");
		int manaBonus = scanner.nextInt();

		System.out.print("Бонус сили: ");
		int strengthBonus = scanner.nextInt();

		Item newItem = new Item(name, type, itemTier, description, healthBonus, manaBonus, strengthBonus);

		List<Item> itemList = new ArrayList<>();
		itemList.add(newItem);

		JsonConvertor.serialization(itemList, JsonPath.ITEM);

		System.out.println("Створено новий предмет: " + newItem.getName());
	}

	private static void viewProfile(Optional<Player> activePlayer) {
		if (activePlayer.isPresent()) {
			Player player = activePlayer.get();
			System.out.println("Профіль гравця:");
			System.out.println(String.format(
			    "Гравець: %s\n" +
				  "Рівень: %d\n" +
				  "Хпшки: %d\n" +
				  "Мана: %d\n" +
				  "Сила: %d\n" +
				  "Монети: %d\n" +
				  "Доп. інформація:\n" +
				  "id: %s\n" +
				  "Пароль: %s",
			    player.getName(), player.getLevel(), player.getHealth(),
			    player.getMana(), player.getStrength(), player.getCoins(), player.getId(), player.getPassword()
			));

			if (player.getInventory() != null) {
				player.getInventory().printInventory();
			} else {
				System.out.println("Інвентар порожній.");
			}
		} else {
			System.out.println("Гравець не знайдений.");
		}
	}


	private static void viewTopPlayers() {
		int i = 1;
		List<Player> playerList = playerService.getPlayersSortedByLevel();
		for (Player player: playerList){
			System.out.println(i + ": " + player.getName()
			    + " рівень: " + player.getLevel());
			i++;
		}
	}
	private static void goRaid() {
		System.out.println("Не реалізовано");
	}
	private static void market() {
		System.out.println("Не реалізовано");
	}
	private static void skillWindow() {
		System.out.println("Не реалізовано");
	}

	public Optional<Player> getActivePlayer() {
		return activePlayer;
	}
}
