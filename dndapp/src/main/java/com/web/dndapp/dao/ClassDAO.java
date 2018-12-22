package com.web.dndapp.dao;

import java.nio.file.Path;
import java.util.List;

import com.web.dndapp.dto.Class;

public interface ClassDAO {

	public Class getClassFromFile(Path file) throws Exception;

	public List<Class> loadClasses() throws Exception;

	public Class getClass(String name) throws Exception;
}
