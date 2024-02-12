package com.twodeveloperscat.mmorpg.persistense.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.twodeveloperscat.mmorpg.persistense.entity.Entity;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonConvertor {

	private JsonConvertor() {
	}

	public static <E extends Entity> void serialization(List<E> entityList, JsonPath jsonPath){
		Gson gson = new GsonBuilder()
		    .setPrettyPrinting()
		    .create();

		String json = gson.toJson(entityList);

		try (FileWriter writer = new FileWriter(jsonPath.getPath(), false)) {
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static <E extends Entity> List<E> deserialization(JsonPath jsonPath, Class<E> entityClass) {
		try {
			String jsonString = new String(Files.readAllBytes(Paths.get(jsonPath.getPath())));

			Gson gson = new Gson();
			Type entityType = TypeToken.getParameterized(List.class, entityClass).getType();

			return gson.fromJson(jsonString, entityType);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
