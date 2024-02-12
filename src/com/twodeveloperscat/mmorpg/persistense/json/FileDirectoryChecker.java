package com.twodeveloperscat.mmorpg.persistense.json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileDirectoryChecker {
	public static void startCheck(){
		fileChecker();
		directoryChecker();
	}
	private static void directoryChecker(){
		List<String> directoryForCreate = new ArrayList<>(Arrays.asList("Data"));

		for (String directoryPath: directoryForCreate){
			Path directory = Paths.get(directoryPath);

			try {
				Files.createDirectories(directory);
			} catch (Exception e) {
				throw new RuntimeException("Не вдалося створити директорію: " + e.getMessage());
			}
		}
	}

	private static void fileChecker() {

		for (JsonPath jsonPath: JsonPath.values()){
			String filePath = jsonPath.getPath();

			File file = new File(filePath);

			if(!Files.exists(file.toPath())){
				try {
					Files.createFile(file.toPath());
				} catch (IOException e) {
					throw new RuntimeException("Не вдалося створити файл: " + e.getMessage());
				}
			}
		}
	}
}
