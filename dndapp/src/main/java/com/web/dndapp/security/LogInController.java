package com.web.dndapp.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.dndapp.utility.CurrentUser;
import com.web.dndapp.utility.FileUtility;

@Controller
@SessionAttributes("user")
public class LogInController {

	private final static Logger LOG = LoggerFactory.getLogger(LogInController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		String user = username;
		String pass = Encryption.hashPassword(password);
		try {
			Scanner filescan = new Scanner(new File("./src/main/resources/data/passwords.txt"));
			while (filescan.hasNextLine()) {
				String lines = filescan.nextLine();
				String[] line = lines.split(":");
				if (user.equals(line[0])) {
					if (pass.equals(line[1])) {
						model.addAttribute("user", CurrentUser.loadUser(user));
						filescan.close();
						return "redirect:/";
					}
				}
			}
			LOG.info("Email or Password Incorrect");
			filescan.close();
		} catch (Exception e) {
			LOG.error("File Path Incorrect");
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(ModelMap model, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		
		Scanner filescan;
		try {
			filescan = new Scanner(new File("./src/main/resources/data/passwords.txt"));
			while (filescan.hasNextLine()) {
				String lines = filescan.nextLine();
				String[] line = lines.split(":");
				if (username.equals(line[0])) {
					if (Encryption.hashPassword(password).equals(line[1])) {
						filescan.close();
						LOG.info("User already exists");
						return "redirect:/register";
					}
				}
			}
		} catch (FileNotFoundException e) {
			return "redirect:/register";
		}
		FileUtility.writePassword(new File("./src/main/resources/data/passwords.txt"), username, password);
		filescan.close();
		return "redirect:/login";
	}
}
