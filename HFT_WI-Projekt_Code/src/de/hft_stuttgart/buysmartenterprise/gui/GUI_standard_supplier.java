package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI_standard_supplier {

	private JFrame frm;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JCheckBox chckbxNewCheckBox;
	private JComboBox comboBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_6;
	private JCheckBox chckbxNewCheckBox_7;
	private JCheckBox chckbxNewCheckBox_8;
	private JCheckBox chckbxNewCheckBox_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_standard_supplier window = new GUI_standard_supplier();
					window.frm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_standard_supplier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm = new JFrame();
		frm.setTitle("HighSpeed Procurement");
		frm.setBounds(100, 100, 700, 300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		
		lblNewLabel_3 = new JLabel("Lieferanten ausw\u00E4hlen:");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frm.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 49, SpringLayout.NORTH, frm.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, frm.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frm.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 683, SpringLayout.WEST, frm.getContentPane());
		frm.getContentPane().setLayout(springLayout);
		
		lblNewLabel = new JLabel("BuySmart Enterprise   ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Standardlieferant festlegen");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(128, 128, 128));
		panel.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Shop");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Settings");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		frm.getContentPane().add(panel);
		frm.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Als Standardlieferant festlegen f\u00FCr:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 79, SpringLayout.EAST, lblNewLabel_3);
		frm.getContentPane().add(lblNewLabel_4);
		
		chckbxNewCheckBox = new JCheckBox("Cache");
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 0, SpringLayout.WEST, lblNewLabel_4);
		frm.getContentPane().add(chckbxNewCheckBox);
		
		comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 20, SpringLayout.WEST, frm.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -89, SpringLayout.WEST, chckbxNewCheckBox);
		frm.getContentPane().add(comboBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Netzteil");
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox, -6, SpringLayout.NORTH, chckbxNewCheckBox_1);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_1, 0, SpringLayout.WEST, lblNewLabel_4);
		frm.getContentPane().add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Grafikkarte");
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox_1, -6, SpringLayout.NORTH, chckbxNewCheckBox_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_2, 0, SpringLayout.WEST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox_2, -110, SpringLayout.SOUTH, frm.getContentPane());
		frm.getContentPane().add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("Akku");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_3, 0, SpringLayout.NORTH, chckbxNewCheckBox_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_3, 6, SpringLayout.EAST, chckbxNewCheckBox_2);
		frm.getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("SSD");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_5, 0, SpringLayout.NORTH, chckbxNewCheckBox);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_5, 0, SpringLayout.WEST, chckbxNewCheckBox_3);
		frm.getContentPane().add(chckbxNewCheckBox_5);
		
		chckbxNewCheckBox_4 = new JCheckBox("CPU");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_4, 0, SpringLayout.NORTH, chckbxNewCheckBox_1);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_4, 0, SpringLayout.WEST, chckbxNewCheckBox_3);
		frm.getContentPane().add(chckbxNewCheckBox_4);
		
		chckbxNewCheckBox_6 = new JCheckBox("RAM");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_6, 0, SpringLayout.NORTH, chckbxNewCheckBox);
		frm.getContentPane().add(chckbxNewCheckBox_6);
		
		chckbxNewCheckBox_7 = new JCheckBox("Motherboard");
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_7, 39, SpringLayout.EAST, chckbxNewCheckBox_4);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_6, 0, SpringLayout.WEST, chckbxNewCheckBox_7);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_7, 0, SpringLayout.NORTH, chckbxNewCheckBox_1);
		frm.getContentPane().add(chckbxNewCheckBox_7);
		
		chckbxNewCheckBox_8 = new JCheckBox("Netzwerkkarte");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_8, 0, SpringLayout.NORTH, chckbxNewCheckBox_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_8, 0, SpringLayout.WEST, chckbxNewCheckBox_6);
		frm.getContentPane().add(chckbxNewCheckBox_8);
		
		chckbxNewCheckBox_9 = new JCheckBox("Sonstiges");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_9, 7, SpringLayout.SOUTH, chckbxNewCheckBox_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_9, 0, SpringLayout.WEST, lblNewLabel_4);
		frm.getContentPane().add(chckbxNewCheckBox_9);
		
		frm.setVisible(true);
	}
}
