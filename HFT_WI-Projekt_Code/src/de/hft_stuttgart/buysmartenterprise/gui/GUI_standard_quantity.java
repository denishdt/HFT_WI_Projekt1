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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI_standard_quantity {

	private JFrame frm;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	DBAccess dbAccess = new DBAccess();
	private JLabel lblNewLabel_7;
	private JTextField textField_1;
	private JComboBox<String> comboBox_1 = new JComboBox<>();
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_standard_quantity window = new GUI_standard_quantity();
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
	public GUI_standard_quantity() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm = new JFrame();
		frm.setTitle("HighSpeed Procurement");
		frm.setBounds(100, 100, 700, 300);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		
		lblNewLabel_3 = new JLabel("Komponente ausw\u00E4hlen:");
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("Grafikkarte");
        comboBox.addItem("RAM");
        comboBox.addItem("Akku");
        comboBox.addItem("Motherboard");
        comboBox.addItem("SSD");
        comboBox.addItem("Netzteil");
        comboBox.addItem("CPU");
        comboBox.addItem("Netzwerkkarte");
        comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadTeil((String)comboBox.getSelectedItem());
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Einzelteil ausw\u00E4hlen:");
		
		JLabel lblNewLabel_5 = new JLabel("Standardmenge eingeben:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Mindestmenge eingeben:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Speichern");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String min = textField.getText();
				String std = textField_1.getText();
				String teil = (String) comboBox_1.getSelectedItem();
				
				if(min.isEmpty() && std.isEmpty()) {
					JOptionPane.showMessageDialog(frm, "Bitte fülle alle Felder aus!", "Fehler", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Connection con = dbAccess.getConnection();
						Statement stm = con.createStatement();
						String sql = "INSERT INTO db5.teilmengen (teil, standardmenge, mindestmenge) VALUES ('" + teil + "', '" + std + "', '" + min + "')";
						stm.execute(sql);
						JOptionPane.showMessageDialog(frm, "Mengen wurden erfolgreich aktualisiert", "",JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						System.out.println("Fehler beim Speichern der Daten: " + e2.getMessage());
					}
				}
				
			}
		});
		
		btnNewButton_4 = new JButton("Automatische Bestellung");
		
		GroupLayout groupLayout = new GroupLayout(frm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNewLabel_5)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_7)
											.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addGap(255)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4)
							.addComponent(lblNewLabel_3)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		lblNewLabel = new JLabel("BuySmart Enterprise   ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Standard & Mindestmenge festlegen");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		panel.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
				GUI_dashboard openDashboard = new GUI_dashboard();
			}
		});
		
		btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
				GUI_profile openProfile = new GUI_profile();
			}
		});
		
		btnNewButton_3 = new JButton("Log Out");
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
				GUI_login openLogin = new GUI_login();
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		frm.getContentPane().setLayout(groupLayout);
		
		frm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbAccess.disconnect();
				System.exit(0);
			}
		});
		
		frm.setVisible(true);
	}
	
	private void loadTeil(String komponente) {
    	try {
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT " + komponente + " from db5.teilebestand WHERE " + komponente + " IS NOT NULL";
			ResultSet rs = stm.executeQuery(sql);
			
			comboBox_1.removeAllItems();
			
			while(rs.next()) {
				String data = rs.getString(komponente);
				comboBox_1.addItem(data);
			}
			
			frm.getContentPane().revalidate();
			frm.getContentPane().repaint();
		} 
    	
    	catch (Exception e) {
			System.out.println("Unbekannter Fehler: " + e.getMessage());
		}
    }
}
