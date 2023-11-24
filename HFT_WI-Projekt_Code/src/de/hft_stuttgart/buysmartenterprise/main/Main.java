package de.hft_stuttgart.buysmartenterprise.main;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_Login;


public class Main {

	public static void main(String [] args) {
		DBAccess.dbAccess();
		System.out.println("HighSpeed Procurement by BuySmart Enterprise");
		
		GUI_Login openLogin = new GUI_Login();	
	}
}
