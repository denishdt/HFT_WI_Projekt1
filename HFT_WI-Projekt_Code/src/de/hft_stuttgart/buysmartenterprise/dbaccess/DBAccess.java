package de.hft_stuttgart.buysmartenterprise.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAccess {

	public static void dbAccess() {
		System.out.println("MySQL Connect Example V2 AWS");
		
		Connection con = null;
		
		String url = "jdbc:mysql://3.69.96.96:80/";
		String dbName = "db5";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "db5";
		String password = "!db5.pgm23?WS2";
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database");
			
			/**
			Statement stmt = con.createStatement();
			ResultSet rs;
			
			rs = stmt.executeQuery("SELECT MANR, Vorname, Nachname, Rolle FROM mitarbeiter");
			
			while(rs.next()) {
				int manr = rs.getInt("MANr");
				String nachname = rs.getString("Nachname");
				String vorname = rs.getString("Vorname");
				String rolle = rs.getString("Rolle");
				System.out.println("MA-Nr: " + manr + " | " + vorname + " " + nachname + " | Rolle: " + rolle);
			}
			**/
			con.close();
			System.out.println("Disconnected from Database");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
