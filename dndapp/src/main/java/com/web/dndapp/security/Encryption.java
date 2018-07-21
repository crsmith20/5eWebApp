package com.web.dndapp.security;

import org.springframework.util.DigestUtils;

public final class Encryption {

	public static String hashPassword(String pw) {
		String password = DigestUtils.md5DigestAsHex(pw.getBytes());
		
		return password;
	}
}
