package com.web.dndapp.dao;

import java.io.File;
import java.util.List;
import com.web.dndapp.dto.Class;

public interface ClassDAO {

	public Class getClassFromFile(File file) throws Exception;

	public List<Class> loadClasses() throws Exception;

	public Class getClass(String name) throws Exception;
}
