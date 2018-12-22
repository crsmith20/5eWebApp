package com.web.dndapp.dao;

import java.nio.file.Path;
import java.util.List;

import com.web.dndapp.dto.Character;

public interface CharacterDAO {

	public List<Character> loadCharacters() throws Exception;

	public Character getCharacterFromFile(Path file) throws Exception;

	public Character getCharacterByName(String name) throws Exception;

	public Character getCharacterById(long id) throws Exception;

	public Character updateCharacter(long id) throws Exception;

	public boolean deleteCharacter(long id) throws Exception;

	public boolean saveCharacter(Character character) throws Exception;
}
