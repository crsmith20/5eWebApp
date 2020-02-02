package com.web.dndapp.dto;

import java.util.List;
import java.util.Map;

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

	public Race(Race o) {
		this.name = o.getName();
		this.asi = o.getAsi();
		this.alignment = o.getAlignment();
		this.languages = o.getLanguages();
		this.size = o.getSize();
		this.age = o.getAge();
		this.speed = o.getSpeed();
		this.feats = o.getFeats();
	}

	public Race chosenSubrace(String subraceName) {
		Race race = new Race(this);
		Race subrace = this.getSubrace().get(subraceName);
		race.setName(subraceName + " " + this.getName());
		race.setAge(subrace.getAge());
		race.setSize(subrace.getSize());

		for (String alignment : subrace.getAlignment()) {
			if (!race.getAlignment().contains(alignment)) {
				race.getAlignment().add(alignment);
			}
		}

		for (String language : subrace.getLanguages()) {
			if (!race.getLanguages().contains(language)) {
				race.getLanguages().add(language);
			}
		}

		for (String asi : subrace.getAsi().keySet()) {
			race.getAsi().put(asi, subrace.getAsi().get(asi));
		}

		for (String feat : subrace.getFeats().keySet()) {
			race.getFeats().put(feat, subrace.getFeats().get(feat));
		}

		if (!subrace.getSubrace().isEmpty()) {
			for (String sr : subrace.getSubrace().keySet()) {
				race.getSubrace().put(sr, subrace.getSubrace().get(sr));
			}
		}

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

	public Map<String, Race> getSubrace() {
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
		return "Race: " + this.getName();
	}
}
