package com.web.dndapp.dto;

import java.util.List;

public class Background {

	String name;
	List<String> profiency; // list of skills
	List<String> tools;
	List<String> languages;
	List<String> equipment;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setProfiency(List<String> profiency) {
		this.profiency = profiency;
	}

	public List<String> getProfiency() {
		return this.profiency;
	}

	public void setTools(List<String> tools) {
		this.tools = tools;
	}

	public List<String> getTools() {
		return this.tools;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getLanguages() {
		return this.languages;
	}

	public void setEquipment(List<String> equipment) {
		this.equipment = equipment;
	}

	public List<String> getEquipment() {
		return this.equipment;
	}
}
