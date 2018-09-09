package com.web.dndapp.dto;

import java.util.List;
import java.util.Map;

public class Character {

	long id;
	String player;
	String name;
	Map<Class, Integer> cclass; // class, level
	Race race;
	Background background;
	String alignment;
	long experience;
	int strength;
	int dexterity;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	List<String> savingThrows; // saving throws proficient in
	List<String> skills; // skills proficient in
	int passivePerception;
	List<String> languages; // proficiencies
	int armorClass;
	int initiative;
	int speed;
	int hp;
	Map<String, Integer> hitDice; // die, number
	List<String> equipment; // equipment
	int pp;
	int gp;
	int ep;
	int sp;
	int cp;
	String personality;
	String ideals;
	String bonds;
	String flaws;
	Map<String, String> features; // name, description
	int age;
	String height;
	int weight;
	String eyes;
	String skin;
	String hair;
	String appearance;
	List<String> allies; // list of allies and organizations
	String backstory;
	Map<String, String> additional; // name, description
	List<String> treasure; // list of treasure
	// only important for spell casters
	String spellClass;
	String spellAbility;
	int spellSave;
	int spellAttack;
	List<String> cantrips;
	int firstSlots;
	List<String> firstSpells;
	int secondSlots;
	List<String> secondSpells;
	int thirdSlots;
	List<String> thirdSpells;
	int fourthSlots;
	List<String> fourthSpells;
	int fifthSlots;
	List<String> fifthSpells;
	int sixthSlots;
	List<String> sixthSpells;
	int seventhSlots;
	List<String> seventhSpells;
	int eighthSlots;
	List<String> eighthSpells;
	int ninthSlots;
	List<String> ninthSpells;
}
