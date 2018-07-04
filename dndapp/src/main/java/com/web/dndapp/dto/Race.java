package com.web.dndapp.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Race {

	String name = "";
	
	Map<String, Integer> asi;
	
	List<String> alignment;
	
	List<String> languages;
	
	String size = "Medium";
	
	int age = 0;
	
	List<Race> subrace;
	
	int speed = 0;
	
	List<Map<String, Object>> feats;
	
	public Race() {}
	
	public Race(String name, List<String> alignment, List<String> languages, List<Race> subrace, int age, String size, int speed, Map<String, Integer> asi, List<Map<String, Object>> feats) {
		this.name = name;
		this.asi = asi;
		this.alignment = alignment;
		this.languages = languages;
		this.size = size;
		this.age = age;
		this. subrace = subrace;
		this.speed = speed;
		this.feats = feats;
	}
	
	public Race getRaceFromFile(File file) throws Exception {
		Race race = new Race();
		Scanner filescan = new Scanner(file);
		while (filescan.hasNextLine()) {
			String lines = filescan.nextLine();
			String[] line = lines.split(":", 2);
			switch(line[0]) {
				case "Race":
					
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
	
	public List<Race> getSubraces() {
		return this.subrace;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public List<Map<String, Object>> getFeats() {
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
	
	public void setSubrace(List<Race> subrace) {
		this.subrace = subrace;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setFeats(List<Map<String, Object>> feats) {
		this.feats = feats;
	}
	
	public String toString() {
		return "String";
	}
}
