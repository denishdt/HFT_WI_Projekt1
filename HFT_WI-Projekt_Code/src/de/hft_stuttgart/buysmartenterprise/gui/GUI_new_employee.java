package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class GUI_new_employee {

	private JFrame frame;
	DBAccess dbAccess = new DBAccess();
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_new_employee window = new GUI_new_employee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_new_employee() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Benutzer");
		frame.setBounds(100, 100, 620, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("                                                                            ");
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Shop");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(frame, "Vorgang abbrechen und zurückkehren?", "Warnung", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					GUI_dashboard openDashboard = new GUI_dashboard();
				} else {
					return;
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(frame, "Vorgang abbrechen und zurückkehren?", "Warnung", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					GUI_profile openProfile = new GUI_profile();
				} else {
					return;
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Neuen Benutzer anlegen");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3 = new JLabel("Benutzername:");
		
		JLabel lblNewLabel_4 = new JLabel("Passwort:");
		
		JLabel lblNewLabel_5 = new JLabel("Rolle:");
		
		fieldUsername = new JTextField();
		fieldUsername.setColumns(10);
		
		fieldPassword = new JPasswordField();
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Mitarbeiter");
		comboBox.addItem("Führungskraft");
		
		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = fieldUsername.getText();
				char[] passwordChars = fieldPassword.getPassword();
				String password = new String(passwordChars);
				String selectedRole = (String) comboBox.getSelectedItem();
				String role;
				if(selectedRole.equals("Führungskraft")) {
					role = "manager";
				} else {
					role = "employee";
				}
				try {
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					if(username.isEmpty() || password.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Bitte fülle alle nötigen Felder aus", "Fehler", JOptionPane.ERROR_MESSAGE);
					} else {
						String sql = "INSERT INTO db5.login(username, password, role) VALUES('" + username + "', '" + password + "', '" + role + "')";
						stm.execute(sql);
						fieldUsername.setText("");
						fieldPassword.setText("");
						JOptionPane.showMessageDialog(frame, "Neuer Benutzer wurde angelegt", "Benutzer", JOptionPane.INFORMATION_MESSAGE);
						
					}
				} catch (Exception e2) {
					System.out.println("Unbekannter Fehler: " + e2.getMessage());
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(476, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addGap(41))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(154)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 167, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(fieldUsername, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
									.addComponent(fieldPassword, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))))
					.addGap(184))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(fieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(fieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(btnSave)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		btnNewButton_3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(frame, "Vorgang abbrechen und ausloggen?", "Warnung", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					GUI_login openLogin = new GUI_login();
				} else {
					return;
				}
			}
		});
		frame.setVisible(true);
	}
}
