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

public class GUI_dashboard {

	private JFrame frmBuysmartEnterprises;
	DBAccess dbAccess = new DBAccess();

	/**
	 * Launch the application.
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
		frmBuysmartEnterprises.setBounds(100, 100, 700, 300);
		frmBuysmartEnterprises.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmBuysmartEnterprises.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_4 = new JButton("Alle Lieferanten anzeigen");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(128, 128, 128));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 0;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Neuen Lieferanten hinzufügen");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(128, 128, 128));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 0;
		panel_1.add(btnNewButton_5, gbc_btnNewButton_5);
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
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 5;
		gbc_btnNewButton_6.gridy = 0;
		panel_1.add(btnNewButton_6, gbc_btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_standard_supplier openStandardSupplier = new GUI_standard_supplier();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("                       ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("                                ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton_7 = new JButton("Bestand der Einzelteile anzeigen");
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 3;
		panel_1.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Standardmenge für Einzelteile festlegen");
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 2;
		gbc_btnNewButton_8.gridy = 3;
		panel_1.add(btnNewButton_8, gbc_btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_standard_quantity openStandardQuantity = new GUI_standard_quantity();
			}
		});
		
		JButton btnNewButton_9 = new JButton("Bestellstatus einsehen");
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_9.gridx = 5;
		gbc_btnNewButton_9.gridy = 3;
		panel_1.add(btnNewButton_9, gbc_btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_order_status openOrderStatus = new GUI_order_status();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("                    ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("                          ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JButton btnNewButton_10 = new JButton("Mindestmenge festlegen");
		btnNewButton_10.setForeground(new Color(255, 255, 255));
		btnNewButton_10.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_10.gridx = 0;
		gbc_btnNewButton_10.gridy = 6;
		panel_1.add(btnNewButton_10, gbc_btnNewButton_10);
		btnNewButton_10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_min_quantity openMinQuantity = new GUI_min_quantity();
			}
		});
		
		JButton btnNewButton_11 = new JButton("Bestellung erstellen");
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(new Color(0, 128, 64));
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_11.gridx = 2;
		gbc_btnNewButton_11.gridy = 6;
		panel_1.add(btnNewButton_11, gbc_btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprises.setVisible(false);
				GUI_new_order openNewOrder = new GUI_new_order();
			}
		});
		
		JButton btnNewButton_12 = new JButton("Automatische Bestellung");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(new Color(0, 128, 64));
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.gridx = 5;
		gbc_btnNewButton_12.gridy = 6;
		panel_1.add(btnNewButton_12, gbc_btnNewButton_12);
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
		
		JButton btnNewButton_3 = new JButton("Shop");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("                                                                           ");
		panel.add(lblNewLabel);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Settings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Profile");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton_1);
		
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
				GUI_Login openLogin = new GUI_Login();
				
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
