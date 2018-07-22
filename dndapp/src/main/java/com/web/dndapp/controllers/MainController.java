package com.web.dndapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.dndapp.dto.Race;
import com.web.dndapp.utility.FileUtility;

@Controller
public class MainController {
	
	private final static Logger LOG = LoggerFactory.getLogger(MainController.class);

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
		
		List<Race> races = FileUtility.loadRaces();
		model.addAttribute("races", races);
		
		return "races";
	}

	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	public String character(ModelMap model) {
		return "characters";
	}
}
