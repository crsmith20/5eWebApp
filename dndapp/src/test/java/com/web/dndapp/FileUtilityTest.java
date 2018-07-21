package com.web.dndapp;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.dndapp.dto.Race;
import com.web.dndapp.utility.FileUtility;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUtilityTest {

//	@Test
//	public void testGetRaceFromFile() throws Exception {
//		File file = new File("./src/main/resources/data/races/dwarf.txt");
//		
//		Race race = FileUtility.getRaceFromFile(file);
//		
//		assertEquals("Dwarf", race.getName());
//		assertEquals(350, race.getAge());
//		assertEquals("Lawful", race.getAlignment().get(0));
//		assertEquals("Good", race.getAlignment().get(1));
//		assertEquals("Medium", race.getSize());
//		assertEquals(25, race.getSpeed());
//		assertEquals("Common", race.getLanguages().get(0));
//		assertEquals("Dwarvish", race.getLanguages().get(1));
//	}
}
