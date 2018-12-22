package com.web.dndapp.dao;

import java.io.File;
import java.util.List;

import com.web.dndapp.dto.Background;

public interface BackgroundDAO {

	public Background getBackgroundFromFile(File file) throws Exception;

	public List<Background> loadBackgrounds() throws Exception;

	public Background getBackground(String name) throws Exception;

}
