package de.hft_stuttgart.buysmartenterprise.main;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

public class Main {

	public static void main(String [] args) {
		DBAccess.dbAccess();
		System.out.println("Hallo, wir sind BuySmart Enterprise!");
	}
}
