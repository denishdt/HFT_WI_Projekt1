package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI_order_status {

	private JFrame frmBuysmartEnterprise;
	private JTable table;
	DBAccess dbAccess = new DBAccess();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_order_status window = new GUI_order_status();
					window.frmBuysmartEnterprise.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_order_status() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuysmartEnterprise = new JFrame();
		frmBuysmartEnterprise.setTitle("HighSpeed Procurement");
		frmBuysmartEnterprise.setBounds(100, 100, 700, 267);
		frmBuysmartEnterprise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bestellungsnummer:", "Lieferant:", "Status:"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(frmBuysmartEnterprise.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addGap(12))
		);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise  ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bestellstatus einsehen      ");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                 ");
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_dashboard openDashboard = new GUI_dashboard();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_profile openProfile = new GUI_profile();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		frmBuysmartEnterprise.getContentPane().setLayout(groupLayout);
		
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_login openLogin = new GUI_login();	
			}
		});
		
		frmBuysmartEnterprise.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbAccess.disconnect();
				System.exit(0);
			}
		});
		
		frmBuysmartEnterprise.setVisible(true);
	}
}
