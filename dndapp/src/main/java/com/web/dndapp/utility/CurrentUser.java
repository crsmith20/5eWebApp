package com.web.dndapp.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.web.dndapp.dto.User;

public final class CurrentUser {

	public static User loadUser(String username) {
		User user = new User();

		try {
			Scanner filescan = new Scanner(new File("./src/main/resources/data/users.txt"));
			while (filescan.hasNextLine()) {
				String line = filescan.nextLine();
				if (line.contains(username)) {
					String[] userLine = line.split(",");
					user.setUsername(userLine[0]);
					user.setname(userLine[1]);
					break;
				}
			}
			filescan.close();
		} catch (FileNotFoundException e) {
			user = null;
		}
		return user;
	}
}
