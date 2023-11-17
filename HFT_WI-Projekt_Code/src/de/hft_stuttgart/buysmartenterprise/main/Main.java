package de.hft_stuttgart.buysmartenterprise.main;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_standard_supplier;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_standard_quantity;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_min_quantity;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_new_order;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_Login;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_automatic_order;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_dashboard;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_order_status;
import de.hft_stuttgart.buysmartenterprise.gui.GUI_new_supplier;


public class Main {

	public static void main(String [] args) {
		DBAccess.dbAccess();
		System.out.println("HighSpeed Procurement by BuySmart Enterprise");
		
		GUI_dashboard guiOne = new GUI_dashboard();
		GUI_automatic_order guiTwo = new GUI_automatic_order();
		GUI_order_status guiTree = new GUI_order_status();
		GUI_new_supplier guiFour = new GUI_new_supplier();
		GUI_standard_supplier quiFive = new GUI_standard_supplier();
		GUI_standard_quantity quiSix = new GUI_standard_quantity();
		GUI_min_quantity quiSeven = new GUI_min_quantity();
		GUI_Login quiEight = new GUI_Login();
		GUI_new_order quiNine = new GUI_new_order();
		
	}
}
