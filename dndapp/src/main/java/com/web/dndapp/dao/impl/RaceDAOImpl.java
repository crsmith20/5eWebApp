package com.web.dndapp.dao.impl;

import java.io.BufferedReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.dndapp.dao.RaceDAO;
import com.web.dndapp.dto.Race;

public class RaceDAOImpl implements RaceDAO {

	private final static Logger LOG = LoggerFactory.getLogger(RaceDAOImpl.class);

	@Override
	public Race getRaceFromFile(Path file) throws Exception {
		LOG.info("Loading race file {}", file.toString());

		List<String> common = new ArrayList<>();
		common.add("Race");
		common.add("AbilityScoreIncrease");
		common.add("Age");
		common.add("Alignment");
		common.add("Size");
		common.add("Speed");
		common.add("Languages");
		common.add("Additional");
		common.add("Subrace");

		Race race = new Race();
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			Map<String, String> feats = new HashMap<>();
			// iterates through race file
			String lines = null;
			while ((lines = reader.readLine()) != null) {
				String[] line = lines.split(":", 2);
				// if this line contains data that is common amongst all races, i.e. not a
				// subrace
				if (common.contains(line[0])) {
					// switch according to data type
					switch (line[0]) {
					case "Race":
						// only one
						race.setName(line[1]);
						break;
					case "AbilityScoreIncrease":
						// only one
						Map<String, Integer> asi = new HashMap<>();
						line[1] = line[1].replace(" ", "");
						String[] abilities = line[1].split(":");
						for (int i = 0; i < abilities.length; i += 2) {
							asi.put(abilities[i], Integer.valueOf(abilities[i + 1]));
						}
						race.setAsi(asi);
						break;
					case "Age":
						// only one
						race.setAge(Integer.valueOf(line[1]));
						break;
					case "Alignment":
						// only one
						String[] alignment = line[1].replace(" ", "").split(",");
						race.setAlignment(Arrays.asList(alignment));
						break;
					case "Size":
						// only one
						race.setSize(line[1]);
						break;
					case "Speed":
						// only one
						race.setSpeed(Integer.valueOf(line[1]));
						break;
					case "Languages":
						// only one
						String[] languages = line[1].replace(" ", "").split(",");
						race.setLanguages(Arrays.asList(languages));
						break;
					case "Additional":
						// multiple feats, update racial feats later
						String[] feat = line[1].split(":", 2);
						feats.put(feat[0], feat[1]);
						break;
					case "Subrace":
						Map<String, Race> races = new HashMap<>();
						String[] subraces = line[1].replace(" ", "").split(",");
						// possible for more than one subrace
						for (int i = 0; i < subraces.length; i++) {
							// creates new subrace
							Race subrace = new Race();
							// sets name of subrace
							subrace.setName(subraces[i]);
							// intializes a new feat map for subrace
							subrace.setFeats(new HashMap<String, String>());
							// adds subrace to map
							races.put(subrace.getName(), subrace);
						}
						// sets subraces
						race.setSubrace(races);
						break;
					}
				}
				// if the line is data for a subrace, only should happen since all other data is
				// in common
				else if (race.getSubrace().containsKey(line[0])) {
					Race subrace = getRaceFromFileHelper(race.getSubrace().get(line[0]), line[1], common);
					race.getSubrace().put(subrace.getName(), subrace);
				}
			}
			if (race.getFeats() != null) {
				updateFeats(race, feats);
			} else {
				race.setFeats(feats);
			}
		}
		// return completed race
		return race;
	}

	private Race getRaceFromFileHelper(Race subrace, String subline, List<String> common) {
		String[] line = subline.split(":", 2);
		Map<String, String> feats = new HashMap<>();
		if (common.contains(line[0])) {
			// switch according to data type
			switch (line[0]) {
			case "Race":
				// only one
				subrace.setName(line[1]);
				break;
			case "AbilityScoreIncrease":
				// only one
				Map<String, Integer> asi = new HashMap<>();
				line[1] = line[1].replace(" ", "");
				String[] abilities = line[1].split(":");
				for (int i = 0; i < abilities.length; i += 2) {
					asi.put(abilities[i], Integer.valueOf(abilities[i + 1]));
				}
				subrace.setAsi(asi);
				break;
			case "Age":
				// only one
				subrace.setAge(Integer.valueOf(line[1]));
				break;
			case "Alignment":
				// only one
				String[] alignment = line[1].replace(" ", "").split(",");
				subrace.setAlignment(Arrays.asList(alignment));
				break;
			case "Size":
				// only one
				subrace.setSize(line[1]);
				break;
			case "Speed":
				// only one
				subrace.setSpeed(Integer.valueOf(line[1]));
				break;
			case "Languages":
				// only one
				String[] languages = line[1].replace(" ", "").split(",");
				subrace.setLanguages(Arrays.asList(languages));
				break;
			case "Additional":
				// multiple feats, update racial feats later
				String[] feat = line[1].split(":", 2);
				feats.put(feat[0], feat[1]);
				break;
			case "Subrace":
				Map<String, Race> races = new HashMap<>();
				String[] subraces = line[1].replace(" ", "").split(",");
				// possible for more than one subrace
				for (int i = 0; i < subraces.length; i++) {
					// creates new subrace
					Race subsubrace = new Race();
					// sets name of subrace
					subsubrace.setName(subraces[i]);
					// intializes a new feat map for subrace
					subsubrace.setFeats(new HashMap<String, String>());
					// adds subrace to map
					races.put(subsubrace.getName(), subsubrace);
				}
				// sets subraces
				subrace.setSubrace(races);
				break;
			}
		}
		// if the line is data for a subrace, only should happen since all other data is
		// in common
		else if (subrace.getSubrace().containsKey(line[0])) {
			Race subsubrace = getRaceFromFileHelper(subrace.getSubrace().get(line[0]), line[1], common);
			subrace.getSubrace().put(subsubrace.getName(), subsubrace);
		}
		if (subrace.getFeats() != null) {
			updateFeats(subrace, feats);
		} else {
			subrace.setFeats(feats);
		}
		return subrace;
	}

	private void updateFeats(Race race, Map<String, String> feats) {
		for (String key : feats.keySet()) {
			race.getFeats().put(key, feats.get(key));
		}
	}

	@Override
	public List<Race> loadRaces() throws Exception {
		List<Race> races = new ArrayList<>();
		Path folder = Paths.get("./src/main/resources/data/races");
		// for file in resources/data/races
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
			for (Path file : stream) {
				if (!file.toString().equals("raceTemplate.txt")) {
					Race race = getRaceFromFile(file);
					races.add(race);
				}
			}
		}
		return races;
	}

	@Override
	public Race getRace(String name) throws Exception {
		Path folder = Paths.get("./src/main/resources/data/races");
		// for file in resources/data/races
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
			for (Path file : stream) {
				if (file.toString().equals(name + ".txt")) {
					return getRaceFromFile(file);
				}
			}
		}
		return null;
	}

}
