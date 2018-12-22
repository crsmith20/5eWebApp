package com.web.dndapp.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Level {

	private Map<String, Integer> level;

	public Level() {
		level = new HashMap<>();
	}

	public Level(Map<String, Integer> level) {
		this();
		this.setClassLevels(level);
	}

	public Set<String> getClasses() {
		return this.level.keySet();
	}

	public void addClassAndLevel(String className, Integer level) {
		this.level.put(className, level);
	}

	public void addClass(String className) {
		this.addClassAndLevel(className, 1);
	}

	public Integer getLevelByClass(String clazz) {
		if (clazz == null) {
			return 0;
		}
		return this.level.containsKey(clazz) ? this.level.get(clazz) : 0;
	}

	public boolean hasClass(String clazz) {
		return this.level.containsKey(clazz);
	}

	/**
	 * 
	 * @return total level of character
	 */
	public int getLevel() {
		int total = 0;
		for (String clazz : this.level.keySet()) {
			total += level.get(clazz);
		}
		return total;
	}

	public void setClassLevels(Map<String, Integer> level) {
		this.level = level;
	}
}
