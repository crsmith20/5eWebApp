package com.web.dndapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.dndapp.dao.CharacterDAO;
import com.web.dndapp.dao.RaceDAO;
import com.web.dndapp.dto.Race;

@Controller
public class MainController {
	
	private final static Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	@Autowired private CharacterDAO characterDAO;
	@Autowired private RaceDAO raceDAO;
//	@Autowired private DiceRollService diceRollService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		LOG.info("Loading Main Page");
		if (model.get("user") != null) {
			model.addAttribute("user", model.get("user"));
		}
		return "index";
	}

	@RequestMapping(value = "/races", method = RequestMethod.GET)
	public String races(ModelMap model) throws Exception {
		LOG.info("Loading race files");
		
		List<Race> races = raceDAO.loadRaces();
		model.addAttribute("races", races);
		
		return "races";
	}

	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	public String character(ModelMap model) {
		return "characters";
	}

	@RequestMapping(value = "/addCharacter", method = RequestMethod.POST)
	public String addCharacter(ModelMap model) {

		return "redirect:characters";
	}

	@RequestMapping(value = "/updateCharacter", method = RequestMethod.POST)
	public String updateCharacter(ModelMap model) {

		return "redirect:characters";
	}

	@RequestMapping(value = "/character/{id}", method = RequestMethod.GET)
	public String viewCharacter(ModelMap model, @PathVariable("id") long id) {

		return "characterView";
	}

	@RequestMapping(value = "/roller", method = RequestMethod.GET)
	public String diceRoller(ModelMap model) {
		return "roller";
	}

//	@RequestMapping(value = "/roll", method = RequestMethod.POST)
//	public String roll(ModelMap model, @RequestParam("dice") int dice, @RequestParam("number") int number) {
//		int result = diceRollService.rollDice(dice, number);
//		model.addAttribute("result", result);
//		return "redirect:/roller";
//	}
}
