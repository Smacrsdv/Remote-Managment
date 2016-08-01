package com.smacrs.timemanagment.helper.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {

	private static String DB_URL;
	private static String DB_USER_NAME;
	private static String DB_PASSWORD;
	private static String DRIVER_NAME;

	static {

		try {
			getDBDeatils();
			//Class.forName(DRIVER_NAME).newInstance();
		} catch (  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
	}

	public static void closeConnection(Connection con) throws SQLException {

		if (con != null && !con.isClosed())
			con.close();

	}

	public static void cleanUp(Connection con, PreparedStatement pre, ResultSet rs) throws SQLException {

		if (rs != null && !rs.isClosed())
			rs.close();

		if ((pre != null && !pre.isClosed()))
			pre.close();

		closeConnection(con);
	}

	private static String getDBDeatils() throws IOException {

		String path = "src/main/resources/config/";
		String fileName = "db.properties";

		InputStream inputStream = null;
		String ver = null;
		try {
			Properties prop = new Properties();

			inputStream = new FileInputStream(path + fileName);

			prop.load(inputStream);

			DB_PASSWORD = prop.getProperty("db.password");
			DB_USER_NAME = prop.getProperty("db.username");
			DB_URL = prop.getProperty("db.url") + "?useUnicode=true&characterEncoding=utf8";
			DRIVER_NAME = prop.getProperty("db.driver");

		} catch (Exception e) {
			System.err.println("proerties file not found & will create it");

		} finally {
			inputStream.close();
		}
		return ver;
	}

	public static void updateDB(String sql) throws SQLException {
		getConnection().createStatement().executeUpdate(sql);
	}
}
