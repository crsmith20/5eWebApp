package com.web.dndapp.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.web.dndapp.dto.User;

public final class CurrentUser {

	public static User loadUser(String username) {
		User user = new User();

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("./src/main/resources/data/users.txt"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains(username)) {
					String[] userLine = line.split(",");
					user.setUsername(userLine[0]);
					user.setname(userLine[1]);
					return user;
				}
			}
			user = null;
		} catch (IOException e) {
			user = null;
		}
		return user;
	}
}
