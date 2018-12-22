package com.web.dndapp.security;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("./src/main/resources/data/passwords.txt"))) {
			String lines;
			while ((lines = reader.readLine()) != null) {
				String[] line = lines.split(":");
				if (user.equals(line[0])) {
					if (pass.equals(line[1])) {
						model.addAttribute("user", CurrentUser.loadUser(user));
						return "redirect:/";
					}
				}
			}
			LOG.info("Email or Password Incorrect");
		} catch (IOException e) {
			LOG.error("File Path Incorrect", e);
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
		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("./src/main/resources/data/passwords.txt"))) {
			String lines = null;
			while ((lines = reader.readLine()) != null) {
				String[] line = lines.split(":");
				if (username.equals(line[0])) {
					if (Encryption.hashPassword(password).equals(line[1])) {
						LOG.info("User already exists");
						return "redirect:/register";
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOG.debug("File was not found", e);
			return "redirect:/register";
		} catch (IOException e) {
			LOG.debug("There was an error opening the file.", e);
			return "redirect:/register";
		}
		FileUtility.writePassword(Paths.get("./src/main/resources/data/passwords.txt"), username, password);
		return "redirect:/login";
	}
}
