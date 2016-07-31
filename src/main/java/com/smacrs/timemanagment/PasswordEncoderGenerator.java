package com.smacrs.timemanagment;

import java.util.prefs.BackingStoreException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.smacrs.timemanagment.core.services.exceptions.AccountDoesNotExistException;

public class PasswordEncoderGenerator {

	public static void main(String[] args) {

		int i = 0;
		while (i < 10) {
			String password = "Sm@crsSm@crs";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}

	}

	public static void main() {

		int i = 0;
		while (i < 10) {
			String password = "Sm@crsSm@crs";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}
		throw new AccountDoesNotExistException("");

	}
}