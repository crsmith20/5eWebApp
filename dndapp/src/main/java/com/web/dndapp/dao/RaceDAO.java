package com.web.dndapp.dao;

import java.io.File;
import java.util.List;

import com.web.dndapp.dto.Race;

public interface RaceDAO {

	public Race getRaceFromFile(File file) throws Exception;

	public List<Race> loadRaces() throws Exception;

	public Race getRace(String name) throws Exception;
}
