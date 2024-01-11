package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author Justin
 *Die Klasse GUI_dashboard repräsentiert das Haupt-Dashboard der BuySmart Enterprise-Anwendung.
 * Sie ermöglicht den Zugriff auf verschiedene Funktionen und Ansichten.
 */

public class GUI_dashboard {
	
	private JFrame frmBuysmartEnterprises;
	DBAccess dbAccess = new DBAccess();

	/**
     * Der Einstiegspunkt für die BuySmart Enterprise-Anwendung.
     * @param args Die Befehlszeilenargumente.
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_dashboard window = new GUI_dashboard();
					window.frmBuysmartEnterprises.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_dashboard() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuysmartEnterprises = new JFrame();
		frmBuysmartEnterprises.setTitle("HighSpeed Procurement");
		frmBuysmartEnterprises.setBounds(100, 100, 830, 380);
		frmBuysmartEnterprises.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuysmartEnterprises.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmBuysmartEnterprises.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton_4 = new JButton("Alle Lieferanten anzeigen");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(128, 128, 128));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_show_supplier openShowSupplier = new GUI_show_supplier();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Neuen Lieferanten hinzufügen");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(128, 128, 128));
		btnNewButton_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_new_supplier openNewSupplier = new GUI_new_supplier();
			}
		});
		
		JButton btnNewButton_6 = new JButton("Standartlieferanten festlegen");
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(128, 128, 128));
		btnNewButton_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_standard_supplier openStandardSupplier = new GUI_standard_supplier();
			}
		});
		
		JButton btnNewButton_7 = new JButton("Bestand der Einzelteile anzeigen");
			btnNewButton_7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frmBuysmartEnterprises.setVisible(false);
					GUI_show_stock openShowStock = new GUI_show_stock();
							
				}
			});
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(new Color(128, 128, 128));
		
		JButton btnNewButton_8 = new JButton("Standardmenge für Teile festlegen");
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(new Color(128, 128, 128));
		btnNewButton_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_standard_quantity openStandardQuantity = new GUI_standard_quantity();
			}
		});
		
		JButton btnNewButton_9 = new JButton("Bestellstatus einsehen");
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setBackground(new Color(128, 128, 128));
		btnNewButton_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_order_status openOrderStatus = new GUI_order_status();
			}
		});
		
		JButton btnNewButton_11 = new JButton("Bestellung erstellen");
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(new Color(128, 128, 128));
		btnNewButton_11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_new_order openNewOrder = new GUI_new_order();
			}
		});
		
		JButton btnNewButton_12 = new JButton("Automatische Bestellung");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(new Color(128, 128, 128));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addGap(44)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_9, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_6, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_6))
					.addGap(65)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_7)
						.addComponent(btnNewButton_9)
						.addComponent(btnNewButton_8))
					.addGap(65)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_11)
						.addComponent(btnNewButton_12)))
		);
		panel_1.setLayout(gl_panel_1);
		btnNewButton_12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_automatic_order openAutomaticOrder = new GUI_automatic_order();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("BuySmart Enterprise");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("                                                                           ");
		panel.add(lblNewLabel);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Profile");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_profile openProfile = new GUI_profile();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_2);
		frmBuysmartEnterprises.getContentPane().setLayout(groupLayout);
		
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_login openLogin = new GUI_login();
				
			}
		});
		
		frmBuysmartEnterprises.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbAccess.disconnect();
				System.exit(0);
			}
		});
		
		frmBuysmartEnterprises.setVisible(true);
	}
}
