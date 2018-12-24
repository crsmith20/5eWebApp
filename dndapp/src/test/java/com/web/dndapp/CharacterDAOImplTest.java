package com.web.dndapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.dndapp.dao.BackgroundDAO;
import com.web.dndapp.dao.ClassDAO;
import com.web.dndapp.dao.RaceDAO;
import com.web.dndapp.dao.impl.CharacterDAOImpl;
import com.web.dndapp.dto.Background;
import com.web.dndapp.dto.Character;
import com.web.dndapp.dto.Class;
import com.web.dndapp.dto.Race;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CharacterDAOImplTest {

	@Mock
	private Environment env;

	@Mock
	private ClassDAO classDAO;

	@Mock
	private RaceDAO raceDAO;

	@Mock
	private BackgroundDAO backgroundDAO;

	@InjectMocks
	private CharacterDAOImpl cdi;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetCharacterFromFileNoArchetypes() throws Exception {
		List<Background> bgs = new ArrayList<>();
		Background bg = new Background();
		bg.setName("Acolyte");
		bgs.add(bg);
		List<Race> races = new ArrayList<>();
		Race race = new Race();
		race.setName("Human");
		races.add(race);
		List<Class> clazz = new ArrayList<>();
		Class cl = new Class();
		cl.setName("Barbarian");
		clazz.add(cl);

		when(backgroundDAO.loadBackgrounds()).thenReturn(bgs);
		when(raceDAO.loadRaces()).thenReturn(races);
		when(classDAO.loadClasses()).thenReturn(clazz);

		Character c = cdi.getCharacterFromFile(Paths.get("./src/main/resources/data/characters/test/1.txt"));

		assertEquals(1 ,c.getId());
		assertEquals("Chris" ,c.getPlayer());
		assertEquals("Test" ,c.getName());
		assertEquals(1, c.getCclass().size());
		assertTrue(c.getCclass().containsKey("Barbarian"));
		assertEquals("Human" ,c.getRace().getName());
		assertEquals("Acolyte" ,c.getBackground().getName());
		assertEquals("Chaotic Good" ,c.getAlignment());
		assertEquals(0 ,c.getExperience());
		assertEquals(2 ,c.getProficiencyBonus());
		assertEquals(20 ,c.getStrength());
		assertEquals(5 ,c.getStrengthMod());
		assertEquals(20 ,c.getDexterity());
		assertEquals(5 ,c.getDexterityMod());
		assertEquals(20 ,c.getConstitution());
		assertEquals(5 ,c.getConstitutionMod());
		assertEquals(8 ,c.getIntelligence());
		assertEquals(-1 ,c.getIntelligenceMod());
		assertEquals(8 ,c.getWisdom());
		assertEquals(-1 ,c.getWisdomMod());
		assertEquals(8 ,c.getCharisma());
		assertEquals(-1 ,c.getCharismaMod());
		assertEquals(2 ,c.getSavingThrows().size());
		assertEquals("Strength", c.getSavingThrows().get(0));
		assertEquals("Constitution", c.getSavingThrows().get(1));
		assertEquals(4 ,c.getSkills().size());
		assertEquals("Athletics", c.getSkills().get(0));
		assertEquals("Intimidation", c.getSkills().get(1));
		assertEquals("Religion", c.getSkills().get(2));
		assertEquals("Perception", c.getSkills().get(3));
		assertEquals(9 ,c.getPassivePerception());
		assertEquals(5 ,c.getLanguages().size());
		assertEquals("Common", c.getLanguages().get(0));
		assertEquals("Elvish", c.getLanguages().get(1));
		assertEquals("Light Armor", c.getLanguages().get(2));
		assertEquals("Medium Armor", c.getLanguages().get(3));
		assertEquals("All Weapons", c.getLanguages().get(4));
		assertEquals(20 ,c.getArmorClass());
		assertEquals(5 ,c.getInitiative());
		assertEquals(30 ,c.getSpeed());
		assertEquals(17 ,c.getHp());
		assertEquals(1 ,c.getHitDice().size());
		assertTrue(c.getHitDice().containsKey("d12"));
		assertEquals(Integer.valueOf(1), c.getHitDice().get("d12"));
		assertEquals(3, c.getEquipment().size());
		assertEquals("4 Javalins", c.getEquipment().get(0));
		assertEquals("1 Longsword", c.getEquipment().get(1));
		assertEquals("2 handaxes", c.getEquipment().get(2));
		assertEquals(0 ,c.getPp());
		assertEquals(0 ,c.getGp());
		assertEquals(0 ,c.getEp());
		assertEquals(0 ,c.getSp());
		assertEquals(0 ,c.getCp());
		assertNull(c.getPersonality());
		assertNull(c.getIdeals());
		assertNull(c.getBonds());
		assertNull(c.getFlaws());
		assertEquals(1 ,c.getFeatures().size());
		assertTrue("Rage", c.getFeatures().containsKey("Rage"));
		assertEquals(25 ,c.getAge());
		assertEquals("6'" ,c.getHeight());
		assertEquals(200 ,c.getWeight());
		assertEquals("Blue" ,c.getEyes());
		assertEquals("White" ,c.getSkin());
		assertEquals("Bald" ,c.getHair());
		assertEquals("Tall medium build. Bald with blue eyes" ,c.getAppearance());
		assertNull(c.getAllies());
		assertEquals("Doesn't remember his childhood" ,c.getBackstory());
		assertNull(c.getAdditional());
		assertNull(c.getTreasure());
		assertNull(c.getSpellClass());
		assertNull(c.getSpellAbility());
		assertEquals(0, c.getSpellSave());
		assertEquals(0, c.getSpellAttack());
		assertNull(c.getCantrips());
		assertEquals(0, c.getFirstSlots());
		assertNull(c.getFirstSpells());
		assertEquals(0, c.getSecondSlots());
		assertNull(c.getSecondSpells());
		assertEquals(0, c.getThirdSlots());
		assertNull(c.getThirdSpells());
		assertEquals(0, c.getFourthSlots());
		assertNull(c.getFourthSpells());
		assertEquals(0, c.getFifthSlots());
		assertNull(c.getFifthSpells());
		assertEquals(0, c.getSixthSlots());
		assertNull(c.getSixthSpells());
		assertEquals(0, c.getSeventhSlots());
		assertNull(c.getSeventhSpells());
		assertEquals(0, c.getEighthSlots());
		assertNull(c.getEighthSpells());
		assertEquals(0, c.getNinthSlots());
		assertNull(c.getNinthSpells());
	}

	@Test
	public void testGetCharacterFromFileArchetypes() throws Exception {
		List<Background> bgs = new ArrayList<>();
		Background bg = new Background();
		bg.setName("Acolyte");
		bgs.add(bg);
		List<Race> races = new ArrayList<>();
		Race race = new Race();
		race.setName("Human");
		races.add(race);
		List<Class> clazz = new ArrayList<>();
		Class cl = new Class();
		cl.setName("Barbarian");
		Map<String, Class> subclazz = new HashMap<>();
		Class subcl = new Class();
		subcl.setName("Totem");
		subclazz.put(subcl.getName(), subcl);
		cl.setArchetypes(subclazz);
		clazz.add(cl);

		when(backgroundDAO.loadBackgrounds()).thenReturn(bgs);
		when(raceDAO.loadRaces()).thenReturn(races);
		when(classDAO.loadClasses()).thenReturn(clazz);

		Character c = cdi.getCharacterFromFile(Paths.get("./src/main/resources/data/characters/test/2.txt"));

		assertEquals(2, c.getId());
		assertEquals("Chris", c.getPlayer());
		assertEquals("Test", c.getName());
		assertEquals(1, c.getCclass().size());
		assertTrue(c.getCclass().containsKey("Totem Barbarian"));
		assertEquals("Human", c.getRace().getName());
		assertEquals("Acolyte", c.getBackground().getName());
		assertEquals("Chaotic Good", c.getAlignment());
		assertEquals(0, c.getExperience());
		assertEquals(2, c.getProficiencyBonus());
		assertEquals(20, c.getStrength());
		assertEquals(5, c.getStrengthMod());
		assertEquals(20, c.getDexterity());
		assertEquals(5, c.getDexterityMod());
		assertEquals(20, c.getConstitution());
		assertEquals(5, c.getConstitutionMod());
		assertEquals(8, c.getIntelligence());
		assertEquals(-1, c.getIntelligenceMod());
		assertEquals(8, c.getWisdom());
		assertEquals(-1, c.getWisdomMod());
		assertEquals(8, c.getCharisma());
		assertEquals(-1, c.getCharismaMod());
		assertEquals(2, c.getSavingThrows().size());
		assertEquals("Strength", c.getSavingThrows().get(0));
		assertEquals("Constitution", c.getSavingThrows().get(1));
		assertEquals(4, c.getSkills().size());
		assertEquals("Athletics", c.getSkills().get(0));
		assertEquals("Intimidation", c.getSkills().get(1));
		assertEquals("Religion", c.getSkills().get(2));
		assertEquals("Perception", c.getSkills().get(3));
		assertEquals(9, c.getPassivePerception());
		assertEquals(5, c.getLanguages().size());
		assertEquals("Common", c.getLanguages().get(0));
		assertEquals("Elvish", c.getLanguages().get(1));
		assertEquals("Light Armor", c.getLanguages().get(2));
		assertEquals("Medium Armor", c.getLanguages().get(3));
		assertEquals("All Weapons", c.getLanguages().get(4));
		assertEquals(20, c.getArmorClass());
		assertEquals(5, c.getInitiative());
		assertEquals(30, c.getSpeed());
		assertEquals(17, c.getHp());
		assertEquals(1, c.getHitDice().size());
		assertTrue(c.getHitDice().containsKey("d12"));
		assertEquals(Integer.valueOf(1), c.getHitDice().get("d12"));
		assertEquals(3, c.getEquipment().size());
		assertEquals("4 Javalins", c.getEquipment().get(0));
		assertEquals("1 Longsword", c.getEquipment().get(1));
		assertEquals("2 handaxes", c.getEquipment().get(2));
		assertEquals(0, c.getPp());
		assertEquals(0, c.getGp());
		assertEquals(0, c.getEp());
		assertEquals(0, c.getSp());
		assertEquals(0, c.getCp());
		assertNull(c.getPersonality());
		assertNull(c.getIdeals());
		assertNull(c.getBonds());
		assertNull(c.getFlaws());
		assertEquals(1, c.getFeatures().size());
		assertTrue("Rage", c.getFeatures().containsKey("Rage"));
		assertEquals(25, c.getAge());
		assertEquals("6'", c.getHeight());
		assertEquals(200, c.getWeight());
		assertEquals("Blue", c.getEyes());
		assertEquals("White", c.getSkin());
		assertEquals("Bald", c.getHair());
		assertEquals("Tall medium build. Bald with blue eyes", c.getAppearance());
		assertNull(c.getAllies());
		assertEquals("Doesn't remember his childhood", c.getBackstory());
		assertNull(c.getAdditional());
		assertNull(c.getTreasure());
		assertNull(c.getSpellClass());
		assertNull(c.getSpellAbility());
		assertEquals(0, c.getSpellSave());
		assertEquals(0, c.getSpellAttack());
		assertNull(c.getCantrips());
		assertEquals(0, c.getFirstSlots());
		assertNull(c.getFirstSpells());
		assertEquals(0, c.getSecondSlots());
		assertNull(c.getSecondSpells());
		assertEquals(0, c.getThirdSlots());
		assertNull(c.getThirdSpells());
		assertEquals(0, c.getFourthSlots());
		assertNull(c.getFourthSpells());
		assertEquals(0, c.getFifthSlots());
		assertNull(c.getFifthSpells());
		assertEquals(0, c.getSixthSlots());
		assertNull(c.getSixthSpells());
		assertEquals(0, c.getSeventhSlots());
		assertNull(c.getSeventhSpells());
		assertEquals(0, c.getEighthSlots());
		assertNull(c.getEighthSpells());
		assertEquals(0, c.getNinthSlots());
		assertNull(c.getNinthSpells());
	}

	@Test
	public void testDeleteCharacter() throws IOException {
		Path testPath = Files.createFile(Paths.get("./src/main/resources/data/characters/-1.txt"));
		// asserts that the file was created properly
		assertTrue(Files.exists(testPath));

		when(env.getProperty(Mockito.anyString())).thenReturn("./src/main/resources/data/characters/");

		// delete the character
		assertTrue(cdi.deleteCharacter(-1L));

		// check to make sure the file was deleted
		assertFalse(Files.exists(testPath));
	}

	@Test
	public void testGetNextId() throws IOException {
		// set up
		Path temp = Files.createTempDirectory(Paths.get("./src/main/resources"), "tempdata");
		Path[] testPaths = { Paths.get(temp.toString(), "1.txt"),
				Paths.get(temp.toString(), "2.txt"),
				Paths.get(temp.toString(), "3.txt") };
		for (int i = 0; i < testPaths.length; i++) {
			Files.createFile(testPaths[i]);
		}
		
		when(env.getProperty(Mockito.anyString())).thenReturn(temp.toString());

		long result = cdi.getNextId();
		
		assertEquals(4L, result);
	}
}
