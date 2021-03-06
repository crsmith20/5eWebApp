package com.web.dndapp.dao;

import java.nio.file.Path;
import java.util.List;

import com.web.dndapp.dto.Background;

public interface BackgroundDAO {

	public Background getBackgroundFromFile(Path file) throws Exception;

	public List<Background> loadBackgrounds() throws Exception;

	public Background getBackground(String name) throws Exception;

}
