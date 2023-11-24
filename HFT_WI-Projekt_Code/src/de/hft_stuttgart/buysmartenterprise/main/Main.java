package de.hft_stuttgart.buysmartenterprise.main;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_Login;


public class Main {

	public static void main(String [] args) {
		System.out.println("HighSpeed Procurement by BuySmart Enterprise");
		DBAccess dbAccess = new DBAccess();
		dbAccess.connect();
		
		GUI_Login openLogin = new GUI_Login();	
	}
}
