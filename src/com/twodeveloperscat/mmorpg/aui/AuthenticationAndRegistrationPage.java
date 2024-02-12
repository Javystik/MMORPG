package com.twodeveloperscat.mmorpg.aui;

import com.twodeveloperscat.mmorpg.domain.PlayerAuthService;
import com.twodeveloperscat.mmorpg.domain.PlayerRegService;
import com.twodeveloperscat.mmorpg.persistense.entity.character.Player;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AuthenticationAndRegistrationPage {
	public static Scanner scanner = new Scanner(System.in);
	public static void mainPage(){
		boolean isExit = true;
		while (isExit) {
			System.out.println("Вітаємо вас в меню Реєстрації та Авторизації оберіть вашу дію!");
			System.out.println("1: Авторизація");
			System.out.println("2: Реєстрація");
			System.out.println("0: Вихід");

			System.out.print("Ваша дія: ");

			int choise = scanner.nextInt();
			scanner.nextLine();

			switch (choise){
				case 1:
					authentication();
					break;
				case 2:
					registration();
					break;
				case 0:
					System.out.println("Вихід! Хорошого дня!");
					isExit = false;
					break;
				default:
					System.out.println("Невірний вибір повторіть спробу!");
					break;
			}
		}
	}

	private static void registration() {
		System.out.print("Введіть логін: ");
		String name = scanner.nextLine();

		System.out.print("Введіть пароль: ");
		String password = scanner.nextLine();

		System.out.print("Підтвердіть пароль: ");
		String repeatPassword = scanner.nextLine();

		List<String> errors = PlayerRegService.validateRegistration(name, password, repeatPassword);

		if (!errors.isEmpty()) {
			System.err.println("Помилки реєстрації:");
			for (String error : errors) {
				System.err.println(error);
			}
		}else{
			System.out.println("Успішна реєстрація!");
		}
	}

	private static void authentication() {
		System.out.print("Введіть логін: ");
		String name = scanner.nextLine();

		System.out.print("Введіть пароль: ");
		String password = scanner.nextLine();

		Optional<Player> authenticatedPlayer = PlayerAuthService.authentication(name, password);

		if (authenticatedPlayer.isPresent()) {
			System.out.println("Автентифікація пройшла успішно!");
			GameMenuPage gameMenuPage = new GameMenuPage(authenticatedPlayer);
			gameMenuPage.mainPage();
		} else {
			System.err.println("Такого користувача не існує або пароль введено неправильно");
		}
	}
}
