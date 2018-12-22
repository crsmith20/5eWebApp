package com.web.dndapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dndapp.dao.CharacterDAO;
import com.web.dndapp.dao.RaceDAO;
import com.web.dndapp.dto.Race;
import com.web.dndapp.services.DiceRollService;

@Controller
public class MainController {
	
	private final static Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	@Autowired private CharacterDAO characterDAO;
	@Autowired private RaceDAO raceDAO;
	@Autowired private DiceRollService diceRollService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		LOG.info("Loading Main Page");
		if (model.get("user") != null) {
			model.addAttribute("user", model.get("user"));
		}
		model.addAttribute("page", "home");
		return "index";
	}

	@RequestMapping(value = "/races", method = RequestMethod.GET)
	public String races(ModelMap model) throws Exception {
		LOG.info("Loading race files");
		
		List<Race> races = raceDAO.loadRaces();
		model.addAttribute("races", races);
		model.addAttribute("page", "race");
		
		return "races";
	}

	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	public String character(ModelMap model) {
		model.addAttribute("page", "character");
		return "characters";
	}

	@RequestMapping(value = "/addCharacter", method = RequestMethod.POST)
	public String addCharacter(ModelMap model, @RequestBody Character character) {
		model.addAttribute("page", "character");
		return "redirect:characters";
	}

	@RequestMapping(value = "/updateCharacter", method = RequestMethod.POST)
	public String updateCharacter(ModelMap model) {
		model.addAttribute("page", "character");
		return "redirect:characters";
	}

	@RequestMapping(value = "/character/{id}", method = RequestMethod.GET)
	public String viewCharacter(ModelMap model, @PathVariable("id") long id) {
		model.addAttribute("page", "character");
		return "characterView";
	}

	@RequestMapping(value = "/roller", method = RequestMethod.GET)
	public String diceRoller(ModelMap model) {
		model.addAttribute("page", "roller");
		return "roller";
	}

	@RequestMapping(value = "/roll", method = RequestMethod.POST)
	public String roll(ModelMap model, @RequestParam("dice") int dice, @RequestParam("number") int number) {
		int result = diceRollService.rollDice(dice, number);
		model.addAttribute("result", result);
		return "singleRollResult";
	}

	@RequestMapping(value = "/backgrounds", method = RequestMethod.GET)
	public String backgrounds(ModelMap model) {
		model.addAttribute("page", "backgrounds");
		return "backgrounds";
	}
}
