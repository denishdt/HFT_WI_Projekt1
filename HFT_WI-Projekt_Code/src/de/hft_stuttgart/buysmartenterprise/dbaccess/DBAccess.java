package de.hft_stuttgart.buysmartenterprise.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBAccess {

	private static final String URL = "jdbc:mysql://3.69.96.96:80/";
	private static final String DBNAME = "db5";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "db5";
	private static final String PASSWORD = "!db5.pgm23?WS2";
	
	private Connection connection;
	
	public void connect() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error connecting to the database: " + e.getMessage());
		}
	}
	
	public void firstConnect() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);
			System.out.println("Connected to the database");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error connecting to the database: " + e.getMessage());
		}
	}

	public void disconnect() {
		try {
			connection.close();
			System.out.println("Disconnected from Database");
		} catch (Exception e) {
			System.err.println("Error disconnecting from database: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
