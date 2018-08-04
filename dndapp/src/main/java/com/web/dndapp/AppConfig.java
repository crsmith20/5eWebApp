package com.web.dndapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.dndapp.dao.CharacterDAO;
import com.web.dndapp.dao.RaceDAO;
import com.web.dndapp.dao.impl.CharacterDAOImpl;
import com.web.dndapp.dao.impl.RaceDAOImpl;

@Configuration
public class AppConfig {

	@Bean
	public RaceDAO raceDAO() {
		return new RaceDAOImpl();
	}

	@Bean
	public CharacterDAO characterDAO() {
		return new CharacterDAOImpl();
	}
}
