package com.twodeveloperscat.mmorpg.domain;

import com.twodeveloperscat.mmorpg.persistense.entity.character.Player;
import com.twodeveloperscat.mmorpg.persistense.json.JsonConvertor;
import com.twodeveloperscat.mmorpg.persistense.json.JsonPath;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerService {
	private List<Player> players = JsonConvertor.deserialization(JsonPath.PLAYER, Player.class);

	public void addUser(Player player) {
		players.add(player);
		JsonConvertor.serialization(players, JsonPath.PLAYER);
	}

	public Optional<Player> findUserByName(String name) {
		return players.stream()
		    .filter(player -> player.getName().equals(name))
		    .findFirst();
	}
	public List<Player> getPlayersSortedByLevel() {
		return players.stream()
		    .sorted(Comparator.comparingInt(Player::getLevel).reversed())
		    .collect(Collectors.toList());
	}
	public Optional<Player> findUserById(String id) {
		return players.stream()
		    .filter(player -> player.getId().equals(id))
		    .findFirst();
	}

	public void deleteUser(Player user) {
		players.remove(user);
		JsonConvertor.serialization(players, JsonPath.PLAYER);
	}

	public List<Player> findUsersByLevel(int level) {
		List<Player> result = new ArrayList<>();
		for (Player player : players) {
			if (player.getLevel() == level) {
				result.add(player);
			}
		}
		return result;
	}
}
