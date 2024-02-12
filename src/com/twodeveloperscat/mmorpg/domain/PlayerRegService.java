package com.twodeveloperscat.mmorpg.domain;

import com.twodeveloperscat.mmorpg.persistense.entity.Inventory;
import com.twodeveloperscat.mmorpg.persistense.entity.character.Player;
import com.twodeveloperscat.mmorpg.persistense.json.JsonConvertor;
import com.twodeveloperscat.mmorpg.persistense.json.JsonPath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class PlayerRegService {
	private static void registration(String name, String password) {
		Player player = new Player(name, 1, 100, 5, 5, generationId(), password, 0, new Inventory(new ArrayList<>()));
		List<Player> playerList = JsonConvertor.deserialization(JsonPath.PLAYER, Player.class);

		if (playerList == null) {
			playerList = new ArrayList<>();
		}

		playerList.add(player);
		JsonConvertor.serialization(playerList, JsonPath.PLAYER);
	}
	public static List<String> validateRegistration(String name, String password, String repeatPassword){
		PlayerService playerService = new PlayerService();
		List<String> errors = new ArrayList<>();

		final int MIN_SIZE = 4;
		final int MAX_SIZE = 30;

		if(name.isBlank() || password.isBlank()){
			errors.add("Поле логіну або паролю не може бути пустим!");
		}
		if(name.length() < MIN_SIZE || name.length() > MAX_SIZE){
			errors.add("Поле логіну не може бути менше ніж " + MIN_SIZE
			    + " та більше ніж " + MAX_SIZE);
		}
		if(password.length() < MIN_SIZE || password.length() > MAX_SIZE){
			errors.add("Поле паролю не може бути менше ніж " + MIN_SIZE
			    + " та більше ніж " + MAX_SIZE);
		}
		Optional<Player> player2 = playerService.findUserByName(name);
		if(player2.isPresent()){
			errors.add("Цей логін вже використовується! Оберіть інший!");
		}
		if(!errors.isEmpty()){
			return errors;
		}
		if(!repeatPassword.equals(password)){
			errors.add("Пароль та повторний пароль не співпадають!");
		}
		registration(name, password);
		return Collections.emptyList();
	}

	private static String generationId() {
		StringBuilder playerID = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int digit = random.nextInt(10);
			playerID.append(digit);
		}
		return playerID.toString();
	}
}
