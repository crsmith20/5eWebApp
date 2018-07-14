package com.web.dndapp.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Race {

	private String name = "";
	// Ability, Bonus
	private Map<String, Integer> asi;
	private List<String> alignment;
	private List<String> languages;
	private String size = "Medium";
	private int age = 0;
	// Name, Race
	private Map<String, Race> subrace;
	private int speed = 0;
	// Name, Description
	private Map<String, String> feats;

	public Race() {}

	public Race(String name, List<String> alignment, List<String> languages, Map<String, Race> subrace, int age, String size,
			int speed, Map<String, Integer> asi, Map<String, String> feats) {
		this.name = name;
		this.asi = asi;
		this.alignment = alignment;
		this.languages = languages;
		this.size = size;
		this.age = age;
		this.subrace = subrace;
		this.speed = speed;
		this.feats = feats;
	}

	public Race getRaceFromFile(File file) throws Exception {
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
		Scanner filescan = new Scanner(file);
		// iterates through race file
		while (filescan.hasNextLine()) {
			// to house feats until end
			Map<String, String> feats = new HashMap<>();
			String lines = filescan.nextLine();
			String[] line = lines.split(":", 2);
			// if this line contains data that is common amongst all races, i.e. not a subrace
			if (common.contains(line[0])) {
				// switch according to data type
				switch (line[0]) {
					case "Race":
						// only one
						race.setName(line[1]);
					case "AbilityScoreIncrease":
						// only one
						Map<String, Integer> asi = new HashMap<>();
						line[1] = line[1].replace(" ", "");
						String[] abilities = line[1].split(":");
						for (int i = 0; i < abilities.length; i += 2) {
							asi.put(abilities[i], Integer.valueOf(abilities[i + 1]));
						}
						race.setAsi(asi);
					case "Age":
						// only one
						race.setAge(Integer.valueOf(line[1]));
					case "Alignment":
						// only one
						 String[] alignment = line[1].replace(" ", "").split(",");
						 race.setAlignment(Arrays.asList(alignment));
					case "Size":
						// only one
						race.setSize(line[1]);
					case "Speed":
						// only one
						race.setSpeed(Integer.valueOf(line[1]));
					case "Languages":
						// only one
						String[] languages = line[1].replace(" ", "").split(",");
						race.setLanguages(Arrays.asList(languages));
					case "Additional":
						// multiple feats, update racial feats later
						String[] feat = line[1].split(":", 2);
						feats.put(feat[0], line[1]);
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
				}
			}
			// if the line is data for a subrace, only should happen since all other data is in common
			else if (race.getSubraces().containsKey(line[0])) {
				// gets current subrace to edit
				Race currentRace = race.getSubraces().get(line[0]);
				// gets the actual info to update subrace with
				String[] subline = line[1].split(":");
				// same as above minus subrace since a subrace won't have a subrace
				if (common.contains(subline[0])) {
					switch (line[0]) {
						case "Race":
							currentRace.setName(line[1]);
						case "AbilityScoreIncrease":
							Map<String, Integer> asi = new HashMap<>();
							line[1] = line[1].replace(" ", "");
							String[] abilities = line[1].split(":");
							for (int i = 0; i < abilities.length; i += 2) {
								asi.put(abilities[i], Integer.valueOf(abilities[i + 1]));
							}
							currentRace.setAsi(asi);
						case "Age":
							currentRace.setAge(Integer.valueOf(line[1]));
						case "Alignment":
							 String[] alignment = line[1].replace(" ", "").split(",");
							 currentRace.setAlignment(Arrays.asList(alignment));
						case "Size":
							currentRace.setSize(line[1]);
						case "Speed":
							currentRace.setSpeed(Integer.valueOf(line[1]));
						case "Languages":
							String[] languages = line[1].replace(" ", "").split(",");
							currentRace.setLanguages(Arrays.asList(languages));
						case "Additional":
							String[] feat = line[1].split(":", 2);
							currentRace.getFeats().put(feat[0], line[1]);
					}
					// updates the subrace in the race object
					race.getSubraces().put(currentRace.getName(), currentRace);
				}
			}
			// once all lines are through, update feats
			race.setFeats(feats);
		}
		// return completed race
		filescan.close();
		return race;
	}

	public String getName() {
		return this.name;
	}

	public Map<String, Integer> getAsi() {
		return this.asi;
	}

	public List<String> getAlignment() {
		return this.alignment;
	}

	public List<String> getLanguages() {
		return this.languages;
	}

	public String getSize() {
		return this.size;
	}

	public int getAge() {
		return this.age;
	}

	public Map<String, Race> getSubraces() {
		return this.subrace;
	}

	public int getSpeed() {
		return this.speed;
	}

	public Map<String, String> getFeats() {
		return this.feats;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAsi(Map<String, Integer> asi) {
		this.asi = asi;
	}

	public void setAlignment(List<String> alignment) {
		this.alignment = alignment;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSubrace(Map<String, Race> subrace) {
		this.subrace = subrace;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setFeats(Map<String, String> feats) {
		this.feats = feats;
	}

	public String toString() {
		return "String";
	}
}
