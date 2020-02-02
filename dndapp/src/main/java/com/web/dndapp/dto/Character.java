package com.web.dndapp.dto;

import java.util.List;
import java.util.Map;

public class Character {
	
	private long id;
	private String player;
	private String name;
	private Level level;
	private Map<String, Class> cclass;
	private Race race;
	private Background background;
	private String alignment;
	private long experience;
	private int proficiencyBonus;
	private int strength;
	private int strengthMod;
	private int dexterity;
	private int dexterityMod;
	private int constitution;
	private int constitutionMod;
	private int intelligence;
	private int intelligenceMod;
	private int wisdom;
	private int wisdomMod;
	private int charisma;
	private int charismaMod;
	private List<String> savingThrows;
	private List<String> skills;
	private int passivePerception;
	private List<String> languages;
	private int armorClass;
	private int initiative;
	private int speed;
	private int hp;
	private Map<String, Integer> hitDice;
	private List<String> equipment;
	private int pp;
	private int gp;
	private int ep;
	private int sp;
	private int cp;
	private String personality;
	private String ideals;
	private String bonds;
	private String flaws;
	private Map<String, String> features;
	private int age;
	private String height;
	private int weight;
	private String eyes;
	private String skin;
	private String hair;
	private String appearance;
	private List<String> allies;
	private String backstory;
	private Map<String, String> additional;
	private List<String> treasure;
	// only important for spell casters;
	private String spellClass;
	private String spellAbility;
	private int spellSave;
	private int spellAttack;
	private List<String> cantrips;
	private int firstSlots;
	private List<String> firstSpells;
	private int secondSlots;
	private List<String> secondSpells;
	private int thirdSlots;
	private List<String> thirdSpells;
	private int fourthSlots;
	private List<String> fourthSpells;
	private int fifthSlots;
	private List<String> fifthSpells;
	private int sixthSlots;
	private List<String> sixthSpells;
	private int seventhSlots;
	private List<String> seventhSpells;
	private int eighthSlots;
	private List<String> eighthSpells;
	private int ninthSlots;
	private List<String> ninthSpells;

	public Character() {
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getPlayer() {
		return this.player;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setCclass(Map<String, Class> cclass) {
		this.cclass = cclass;
	}

	public Map<String, Class> getCclass() {
		return this.cclass;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Race getRace() {
		return this.race;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public Background getBackground() {
		return this.background;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getAlignment() {
		return this.alignment;
	}

	public void setExperience(long experience) {
		this.experience = experience;
	}

	public long getExperience() {
		return this.experience;
	}

	public void setProficiencyBonus(int bonus) {
		this.proficiencyBonus = bonus;
	}

	public int getProficiencyBonus() {
		return this.proficiencyBonus;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStrength() {
		return this.strength;
	}

	public void setStrengthMod(int strength) {
		this.strengthMod = strength;
	}

	public int getStrengthMod() {
		return this.strengthMod;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getDexterity() {
		return this.dexterity;
	}

	public void setDexterityMod(int dexterity) {
		this.dexterityMod = dexterity;
	}

	public int getDexterityMod() {
		return this.dexterityMod;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getConstitution() {
		return this.constitution;
	}

	public void setConstitutionMod(int constitution) {
		this.constitutionMod = constitution;
	}

	public int getConstitutionMod() {
		return this.constitutionMod;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getIntelligence() {
		return this.intelligence;
	}

	public void setIntelligenceMod(int intelligence) {
		this.intelligenceMod = intelligence;
	}

	public int getIntelligenceMod() {
		return this.intelligenceMod;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getWisdom() {
		return this.wisdom;
	}

	public void setWisdomMod(int wisdom) {
		this.wisdomMod = wisdom;
	}

	public int getWisdomMod() {
		return this.wisdomMod;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getCharisma() {
		return this.charisma;
	}

	public void setCharismaMod(int charisma) {
		this.charismaMod = charisma;
	}

	public int getCharismaMod() {
		return this.charismaMod;
	}

	public void setSavingThrows(List<String> savingThrows) {
		this.savingThrows = savingThrows;
	}

	public List<String> getSavingThrows() {
		return this.savingThrows;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getSkills() {
		return this.skills;
	}

	public void setPassivePerception(int passivePerception) {
		this.passivePerception = passivePerception;
	}

	public int getPassivePerception() {
		return this.passivePerception;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getLanguages() {
		return this.languages;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getArmorClass() {
		return this.armorClass;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getInitiative() {
		return this.initiative;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHitDice(Map<String, Integer> hitDice) {
		this.hitDice = hitDice;
	}

	public Map<String, Integer> getHitDice() {
		return this.hitDice;
	}

	public void setEquipment(List<String> equipment) {
		this.equipment = equipment;
	}

	public List<String> getEquipment() {
		return this.equipment;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getPp() {
		return this.pp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public int getGp() {
		return this.gp;
	}

	public void setEp(int ep) {
		this.ep = ep;
	}

	public int getEp() {
		return this.ep;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getSp() {
		return this.sp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getCp() {
		return this.cp;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getPersonality() {
		return this.personality;
	}

	public void setIdeals(String ideals) {
		this.ideals = ideals;
	}

	public String getIdeals() {
		return this.ideals;
	}

	public void setBonds(String bonds) {
		this.bonds = bonds;
	}

	public String getBonds() {
		return this.bonds;
	}

	public void setFlaws(String flaws) {
		this.flaws = flaws;
	}

	public String getFlaws() {
		return this.flaws;
	}

	public void setFeatures(Map<String, String> features) {
		this.features = features;
	}

	public Map<String, String> getFeatures() {
		return this.features;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHeight() {
		return this.height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	public String getEyes() {
		return this.eyes;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getSkin() {
		return this.skin;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getHair() {
		return this.hair;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public String getAppearance() {
		return this.appearance;
	}

	public void setAllies(List<String> allies) {
		this.allies = allies;
	}

	public List<String> getAllies() {
		return this.allies;
	}

	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}

	public String getBackstory() {
		return this.backstory;
	}

	public void setAdditional(Map<String, String> additional) {
		this.additional = additional;
	}

	public Map<String, String> getAdditional() {
		return this.additional;
	}

	public void setTreasure(List<String> treasure) {
		this.treasure = treasure;
	}

	public List<String> getTreasure() {
		return this.treasure;
	}

	public void setSpellClass(String spellClass) {
		this.spellClass = spellClass;
	}

	public String getSpellClass() {
		return this.spellClass;
	}

	public void setSpellAbility(String spellAbility) {
		this.spellAbility = spellAbility;
	}

	public String getSpellAbility() {
		return this.spellAbility;
	}

	public void setSpellSave(int spellSave) {
		this.spellSave = spellSave;
	}

	public int getSpellSave() {
		return this.spellSave;
	}

	public void setSpellAttack(int spellAttack) {
		this.spellAttack = spellAttack;
	}

	public int getSpellAttack() {
		return this.spellAttack;
	}

	public void setCantrips(List<String> cantrips) {
		this.cantrips = cantrips;
	}

	public List<String> getCantrips() {
		return this.cantrips;
	}

	public void setFirstSlots(int firstSlots) {
		this.firstSlots = firstSlots;
	}

	public int getFirstSlots() {
		return this.firstSlots;
	}

	public void setFirstSpells(List<String> firstSpells) {
		this.firstSpells = firstSpells;
	}

	public List<String> getFirstSpells() {
		return this.firstSpells;
	}

	public void setSecondSlots(int secondSlots) {
		this.secondSlots = secondSlots;
	}

	public int getSecondSlots() {
		return this.secondSlots;
	}

	public void setSecondSpells(List<String> secondSpells) {
		this.secondSpells = secondSpells;
	}

	public List<String> getSecondSpells() {
		return this.secondSpells;
	}

	public void setThirdSlots(int thirdSlots) {
		this.thirdSlots = thirdSlots;
	}

	public int getThirdSlots() {
		return this.thirdSlots;
	}

	public void setThirdSpells(List<String> thirdSpells) {
		this.thirdSpells = thirdSpells;
	}

	public List<String> getThirdSpells() {
		return this.thirdSpells;
	}

	public void setFourthSlots(int fourthSlots) {
		this.fourthSlots = fourthSlots;
	}

	public int getFourthSlots() {
		return this.fourthSlots;
	}

	public void setFourthSpells(List<String> fourthSpells) {
		this.fourthSpells = fourthSpells;
	}

	public List<String> getFourthSpells() {
		return this.fourthSpells;
	}

	public void setFifthSlots(int fifthSlots) {
		this.fifthSlots = fifthSlots;
	}

	public int getFifthSlots() {
		return this.fifthSlots;
	}

	public void setFifthSpells(List<String> fifthSpells) {
		this.fifthSpells = fifthSpells;
	}

	public List<String> getFifthSpells() {
		return this.fifthSpells;
	}

	public void setSixthSlots(int sixthSlots) {
		this.sixthSlots = sixthSlots;
	}

	public int getSixthSlots() {
		return this.sixthSlots;
	}

	public void setSixthSpells(List<String> sixthSpells) {
		this.sixthSpells = sixthSpells;
	}

	public List<String> getSixthSpells() {
		return this.sixthSpells;
	}

	public void setSeventhSlots(int seventhSlots) {
		this.seventhSlots = seventhSlots;
	}

	public int getSeventhSlots() {
		return this.seventhSlots;
	}

	public void setSeventhSpells(List<String> seventhSpells) {
		this.seventhSpells = seventhSpells;
	}

	public List<String> getSeventhSpells() {
		return this.seventhSpells;
	}

	public void setEighthSlots(int eighthSlots) {
		this.eighthSlots = eighthSlots;
	}

	public int getEighthSlots() {
		return this.eighthSlots;
	}

	public void setEighthSpells(List<String> eighthSpells) {
		this.eighthSpells = eighthSpells;
	}

	public List<String> getEighthSpells() {
		return this.eighthSpells;
	}

	public void setNinthSlots(int ninthSlots) {
		this.ninthSlots = ninthSlots;
	}

	public int getNinthSlots() {
		return this.ninthSlots;
	}

	public void setNinthSpells(List<String> ninthSpells) {
		this.ninthSpells = ninthSpells;
	}

	public List<String> getNinthSpells() {
		return this.ninthSpells;
	}
}
