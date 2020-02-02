package com.web.dndapp.utility;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.dndapp.security.Encryption;

public final class FileUtility {
	
	private final static Logger LOG = LoggerFactory.getLogger(FileUtility.class);

	public static void writePassword(Path file, String username, String password) {
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write(username + ":" + Encryption.hashPassword(password));
		} catch (IOException e) {
			LOG.debug("Error writing user", e);
		}
	}
}
