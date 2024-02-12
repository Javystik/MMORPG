package com.twodeveloperscat.mmorpg.domain;

import com.twodeveloperscat.mmorpg.persistense.entity.character.Player;
import java.util.Optional;

public class PlayerAuthService {
	public static Optional<Player> authentication(String name, String password) {
		PlayerService playerService = new PlayerService();
		Optional<Player> optionalPlayer = playerService.findUserByName(name);

		if (optionalPlayer.isPresent()) {
			Player player = optionalPlayer.get();
			if (player.getPassword().equals(password)) {
				return Optional.of(player);
			}
		}
		return Optional.empty();
	}
}
