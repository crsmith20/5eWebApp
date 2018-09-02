package com.web.dndapp.dao;

import java.util.List;

import com.web.dndapp.dto.Character;

public interface CharacterDAO {

	public List<Character> loadCharacters();

	public Character getCharacterByName(String name);

	public Character getCharacterById(long id);

	public Character updateCharacter(long id);

	public boolean deleteCharacter(long id);

	public boolean saveCharacter(Character character);
}
