package com.smacrs.timemanagment.helper;

import java.io.File;
import java.util.Scanner;

public class FileHandler {

	public static String readFile(File file) throws Exception {
		String fileContent = "", line;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			fileContent += line + "\n";
		}
		scanner.close();
		return fileContent;
	}

	public static String readFile(String path) throws Exception {
		String fileContent = "";
		Scanner scanner = new Scanner(new File(path));
		while (scanner.hasNextLine()) {
			fileContent += scanner.nextLine() + " \n";
		}
		scanner.close();
		return fileContent;
	}

}
