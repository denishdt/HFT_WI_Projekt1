package de.hft_stuttgart.buysmartenterprise.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_login;

/**
 * 
 * Startet das Programm und &ouml;ffnet "GUI_login"
 *
 */
public class Main {
	
	private static String user = "";
	DBAccess dbAccess = new DBAccess();
	
	public static void main(String [] args) {
		System.out.println("HighSpeed Procurement by BuySmart Enterprise");
		GUI_login openLogin = new GUI_login();	
	}
	
	public void setUser(String u) {
		user = u;
	}
	
	public String getUser() {
		return user;
	}
	//yaro
	public String getPassword() {
		String pw;
		try {
			dbAccess.connect();
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT password FROM login WHERE binary username='" + user + "'";
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				pw = rs.getString("password");
				return pw;
			}
			return "";
		} catch (Exception e) {
			System.out.println("Unbekannter Fehler: " + e.getMessage());
			return "";
		}
	
	}}
