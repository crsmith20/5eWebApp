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
import org.springframework.beans.factory.annotation.Autowired;

import com.web.dndapp.dao.BackgroundDAO;
import com.web.dndapp.dao.CharacterDAO;
import com.web.dndapp.dao.ClassDAO;
import com.web.dndapp.dao.RaceDAO;
import com.web.dndapp.dto.Background;
import com.web.dndapp.dto.Character;
import com.web.dndapp.dto.Class;
import com.web.dndapp.dto.Level;
import com.web.dndapp.dto.Race;

public class CharacterDAOImpl implements CharacterDAO {

	private final static Logger LOG = LoggerFactory.getLogger(RaceDAOImpl.class);

	@Autowired
	private ClassDAO classDAO;

	@Autowired
	private RaceDAO raceDAO;

	@Autowired
	private BackgroundDAO backgroundDAO;

	@Override
	public List<Character> loadCharacters() throws Exception {
		List<Character> characters = new ArrayList<>();
		Path folder = Paths.get("./src/main/resources/data/characters");
		// for file in resources/data/characters
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
			for (Path file : stream) {
				if (!file.toString().equals("charactertemplate.txt")) {
					Character character = getCharacterFromFile(file);
					characters.add(character);
				}
			}
		}
		return characters;
	}

	@Override
	public Character getCharacterFromFile(Path file) throws Exception {
		LOG.info("Loading Character id {}", file.toString().substring(0, file.toString().lastIndexOf('.')));

		Character character = new Character();
		character.setId(Long.valueOf(file.toString().substring(0, file.toString().lastIndexOf('.'))));
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			String lines = null;
			while ((lines = reader.readLine()) != null) {
				String[] line = lines.split(":", 2);
				if (!line[1].isEmpty()) {
					switch (line[0]) {
					case "Player":
						character.setPlayer(line[1]);
						break;
					case "Name":
						character.setName(line[1]);
						break;
					case "Class":
						Map<String, Class> classes = new HashMap<>();
						Map<String, Integer> temp = new HashMap<>();
						String[] clazz = line[1].split(":");
						for (int i = 0; i < clazz.length; i += 2) {
							temp.put(clazz[i], Integer.valueOf(clazz[i + 1]));
						}
						character.setLevel(new Level(temp));
						character.setProficiencyBonus(genProfBonus(character.getLevel().getLevel()));
						classes = convertToClass(temp);
						character.setCclass(classes);
						break;
					case "Race":
						Race race = convertToRace(line[1]);
						character.setRace(race);
						break;
					case "Background":
						Background bg = convertToBackground(line[1]);
						character.setBackground(bg);
						break;
					case "Alignment":
						character.setAlignment(line[1]);
						break;
					case "Experience":
						character.setExperience(Long.valueOf(line[1]));
						break;
					case "Strength":
						character.setStrength(Integer.valueOf(line[1]));
						character.setStrengthMod((character.getStrength() - 10) / 2);
						break;
					case "Dexterity":
						character.setDexterity(Integer.valueOf(line[1]));
						character.setDexterityMod((character.getDexterity() - 10) / 2);
						break;
					case "Constitution":
						character.setConstitution(Integer.valueOf(line[1]));
						character.setConstitutionMod((character.getConstitution() - 10) / 2);
						break;
					case "Intelligence":
						character.setIntelligence(Integer.valueOf(line[1]));
						character.setIntelligenceMod((character.getIntelligence() - 10) / 2);
						break;
					case "Wisdom":
						character.setWisdom(Integer.valueOf(line[1]));
						character.setWisdomMod((character.getWisdom() - 10) / 2);
						break;
					case "Charisma":
						character.setCharisma(Integer.valueOf(line[1]));
						character.setCharismaMod((character.getCharisma() - 10) / 2);
						break;
					case "Savingthrows":
						character.setSavingThrows(Arrays.asList(line[1].split(",")));
						break;
					case "Skills":
						character.setSkills(Arrays.asList(line[1].split(",")));
						break;
					case "Passiveperception":
						character.setPassivePerception(Integer.valueOf(line[1]));
						break;
					case "Languages":
						character.setLanguages(Arrays.asList(line[1].split(",")));
						break;
					case "Armorclass":
						character.setArmorClass(Integer.valueOf(line[1]));
						break;
					case "Initiative":
						character.setInitiative(Integer.valueOf(line[1]));
						break;
					case "Speed":
						character.setSpeed(Integer.valueOf(line[1]));
						break;
					case "Hp":
						character.setHp(Integer.valueOf(line[1]));
						break;
					case "Hitdice":
						Map<String, Integer> hitdice = new HashMap<>();
						String[] dice = line[1].split(":");
						for (int i = 0; i < dice.length; i += 2) {
							hitdice.put(dice[i], Integer.valueOf(dice[i + 1]));
						}
						character.setHitDice(hitdice);
						break;
					case "Equipment":
						character.setEquipment(Arrays.asList(line[1].split(",")));
						break;
					case "Pp":
						character.setPp(Integer.valueOf(line[1]));
						break;
					case "Gp":
						character.setGp(Integer.valueOf(line[1]));
						break;
					case "Ep":
						character.setEp(Integer.valueOf(line[1]));
						break;
					case "Sp":
						character.setSp(Integer.valueOf(line[1]));
						break;
					case "Cp":
						character.setCp(Integer.valueOf(line[1]));
						break;
					case "Personality":
						character.setPersonality(line[1]);
						break;
					case "Ideals":
						character.setIdeals(line[1]);
						break;
					case "Bonds":
						character.setBonds(line[1]);
						break;
					case "Flaws":
						character.setFlaws(line[1]);
						break;
					case "Features":
						Map<String, String> features = new HashMap<>();
						String[] feats = line[1].split(":");
						for (int i = 0; i < feats.length; i += 2) {
							features.put(feats[i], feats[i + 1]);
						}
						character.setFeatures(features);
						break;
					case "Age":
						character.setAge(Integer.valueOf(line[1]));
						break;
					case "Height":
						character.setHeight(line[1]);
						break;
					case "Weight":
						character.setWeight(Integer.valueOf(line[1]));
						break;
					case "Eyes":
						character.setEyes(line[1]);
						break;
					case "Skin":
						character.setSkin(line[1]);
						break;
					case "Hair":
						character.setHair(line[1]);
						break;
					case "Appearance":
						character.setAppearance(line[1]);
						break;
					case "Allies":
						character.setAllies(Arrays.asList(line[1].split(",")));
						break;
					case "Backstory":
						character.setBackstory(line[1]);
						break;
					case "Additional":
						Map<String, String> additional = new HashMap<>();
						String[] add = line[1].split(":");
						for (int i = 0; i < add.length; i += 2) {
							additional.put(add[i], add[i + 1]);
						}
						character.setAdditional(additional);
						break;
					case "Treasure":
						character.setTreasure(Arrays.asList(line[1].split(",")));
						break;
					case "Spellclass":
						character.setSpellClass(line[1]);
						break;
					case "Spellability":
						character.setSpellAbility(line[1]);
						break;
					case "Spellsave":
						character.setSpellSave(Integer.valueOf(line[1]));
						break;
					case "Spellattack":
						character.setSpellAttack(Integer.valueOf(line[1]));
						break;
					case "Cantrips":
						character.setCantrips(Arrays.asList(line[1].split(",")));
						break;
					case "1stslots":
						character.setFirstSlots(Integer.valueOf(line[1]));
						break;
					case "1stspells":
						character.setFirstSpells(Arrays.asList(line[1].split(",")));
						break;
					case "2ndslots":
						character.setSecondSlots(Integer.valueOf(line[1]));
						break;
					case "2ndspells":
						character.setFirstSpells(Arrays.asList(line[1].split(",")));
						break;
					case "3rdslots":
						character.setThirdSlots(Integer.valueOf(line[1]));
						break;
					case "3rdspells":
						character.setFirstSpells(Arrays.asList(line[1].split(",")));
						break;
					case "4thslots":
						character.setFourthSlots(Integer.valueOf(line[1]));
						break;
					case "4thspells":
						character.setFourthSpells(Arrays.asList(line[1].split(",")));
						break;
					case "5thslots":
						character.setFifthSlots(Integer.valueOf(line[1]));
						break;
					case "5thspells":
						character.setFifthSpells(Arrays.asList(line[1].split(",")));
						break;
					case "6thslots":
						character.setSixthSlots(Integer.valueOf(line[1]));
						break;
					case "6thspells":
						character.setSixthSpells(Arrays.asList(line[1].split(",")));
						break;
					case "7thslots":
						character.setSeventhSlots(Integer.valueOf(line[1]));
						break;
					case "7thspells":
						character.setSeventhSpells(Arrays.asList(line[1].split(",")));
						break;
					case "8thslots":
						character.setEighthSlots(Integer.valueOf(line[1]));
						break;
					case "8thspells":
						character.setEighthSpells(Arrays.asList(line[1].split(",")));
						break;
					case "9thslots":
						character.setNinthSlots(Integer.valueOf(line[1]));
						break;
					case "9thspells":
						character.setNinthSpells(Arrays.asList(line[1].split(",")));
						break;
					}
				}
			}
		}
		return character;
	}

	private Background convertToBackground(String string) throws Exception {
		List<Background> backgrounds = backgroundDAO.loadBackgrounds();
		for (Background background : backgrounds) {
			if (string.equalsIgnoreCase(background.getName())) {
				return background;
			}
		}
		return null;
	}

	private Race convertToRace(String string) throws Exception {
		List<Race> races = raceDAO.loadRaces();
		for (Race race : races) {
			if (string.equalsIgnoreCase(race.getName())) {
				return race;
			}
		}
		return null;
	}

	private Map<String, Class> convertToClass(Map<String, Integer> temp) throws Exception {
		Map<String, Class> holder = new HashMap<>();
		List<Class> classes = classDAO.loadClasses();
		for (String className : temp.keySet()) {
			if (className.split(" ").length == 1) {
				for (Class clazz : classes) {
					if (className.equalsIgnoreCase(clazz.getName())) {
						holder.put(clazz.getName(), clazz);
						break;
					}
				}
			} else {
				int pos = className.lastIndexOf(" ");
				String mainClass = className.substring(pos + 1);
				for (Class clazz : classes) {
					if (mainClass.equalsIgnoreCase(clazz.getName())) {
						String subclass = className.substring(0, pos);
						Map<String, Class> archetypes = clazz.getArchetypes();
						for (String clas : archetypes.keySet()) {
							if (subclass.equalsIgnoreCase(clas)) {
								Class archetype = clazz.getArchetypes().get(clas);
								holder.put(className, archetype);
							}
						}
					}
				}
			}
		}
		return holder;
	}

	private int genProfBonus(int level) {
		if (level < 5) {
			return 2;
		} else if (level < 9) {
			return 3;
		} else if (level < 13) {
			return 4;
		} else if (level < 17) {
			return 5;
		} else {
			return 6;
		}
	}

	@Override
	public Character getCharacterByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character getCharacterById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character updateCharacter(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCharacter(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveCharacter(Character character) {
		// TODO Auto-generated method stub
		return false;
	}

}
