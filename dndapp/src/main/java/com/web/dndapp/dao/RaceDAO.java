package com.web.dndapp.dao;

import java.nio.file.Path;
import java.util.List;

import com.web.dndapp.dto.Race;

public interface RaceDAO {

	public Race getRaceFromFile(Path file) throws Exception;

	public List<Race> loadRaces() throws Exception;

	public Race getRace(String name) throws Exception;
}
