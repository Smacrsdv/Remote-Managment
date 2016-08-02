package com.smacrs.timemanagment.helper.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.plaf.synth.SynthDesktopIconUI;

import com.smacrs.timemanagment.helper.FileHandler;

public class DataBaseUpdater {

	private final static String path = "db/";
	private final static String scriptPath = "db/script-";
	private final static String fileName = "script-version.properties";
	private final static String version = "version";
	private final static String defaultVersion = "0";

	public static void main(String[] args) throws Exception {
		update();
	}

	public static void update() throws Exception {
		int ver = Integer.parseInt(getScriptVersion());
		while (true) {
			ver++;
			File file = new File(scriptPath + ver + ".sql");
			// System.out.println(scriptPath + ver + ".sql " + file.exists());
			if (file.exists()) {
				String sqls = FileHandler.readFile(file);

				// System.out.println(sqls);

				String[] sqlsArray = sqls.split(";");

				for (int j = 0; j < sqlsArray.length; j++) { 
					//System.out.println(sqlsArray[j]); 
					try {
						DButil.updateDB(sqlsArray[j] + " ;");
					} catch (SQLException e) {
						if (e.toString().contains("Query was empty")) {
						} else {
							e.printStackTrace();
							System.err.println("Update DB FAIL");
							return;
						}
					}
				}

				setScriptVersion(ver);

				System.out.println("database updated: script-" + ver + ".sql done");
			} else
				break;
		}
	}

	public static String getScriptVersion() throws IOException {
		InputStream inputStream = null;
		String ver = null;
		try {
			Properties prop = new Properties();

			inputStream = new FileInputStream(path + fileName);

			prop.load(inputStream);

			ver = prop.getProperty(version);

			System.out.println(version + ": " + ver);
		} catch (Exception e) {
			System.err.println(fileName + " not found & will create it");
			setScriptVersion(0);
			return defaultVersion;
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
		return ver;
	}

	public static void setScriptVersion(int ver) throws IOException {
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(path + fileName);

			prop.setProperty(version, ver + "");

			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
