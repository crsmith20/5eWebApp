package com.web.dndapp.utility;

import java.io.File;
import java.io.FileWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.dndapp.security.Encryption;

public final class FileUtility {
	
	private final static Logger LOG = LoggerFactory.getLogger(FileUtility.class);

	public static void writePassword(File file, String username, String password) {
		FileWriter fr = null;
		try {
			fr = new FileWriter(file);
			fr.write(username + ":" + Encryption.hashPassword(password));
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
