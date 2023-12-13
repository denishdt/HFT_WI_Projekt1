package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;
import de.hft_stuttgart.buysmartenterprise.main.Main;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class GUI_profile {

	private JFrame frame;
	private JTextField fieldChangeUsernameOld;
	private JTextField fieldChangeUsernameNew;
	DBAccess dbAccess = new DBAccess();
	Main main = new Main();
	private JPasswordField fieldChangePasswordOld;
	private JPasswordField fieldChangePasswordNew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_profile window = new GUI_profile();
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
	public GUI_profile() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 325);
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
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_dashboard openDashboard = new GUI_dashboard();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_login openLogin = new GUI_login();
			}
		});
		
		JLabel lblChangeUsername = new JLabel("Benutzername ändern");
		lblChangeUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblChangePassword = new JLabel("Passwort ändern");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		fieldChangeUsernameOld = new JTextField();
		fieldChangeUsernameOld.setColumns(10);
		
		fieldChangeUsernameNew = new JTextField();
		fieldChangeUsernameNew.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Alter Benutzername:");
		
		JLabel lblNewLabel_2_1 = new JLabel("NeuerBenutzername:");
		
		JLabel lblNewLabel_2_2 = new JLabel("Altes Passwort:");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Neues Passwort:");
		
		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String oldUsername = fieldChangeUsernameOld.getText();
					String newUsername = fieldChangeUsernameNew.getText();
					String oldPassword = fieldChangePasswordOld.getText();
					String newPassword = fieldChangePasswordNew.getText();
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					if(fieldChangeUsernameOld.getText().isEmpty() && fieldChangeUsernameNew.getText().isEmpty() && fieldChangePasswordOld.getText().isEmpty() && fieldChangePasswordNew.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Bitte fülle alle nötigen Felder aus", "Fehler", JOptionPane.ERROR_MESSAGE);
						return;
						
					} else if(fieldChangeUsernameOld.getText().isEmpty() && fieldChangeUsernameNew.getText().isEmpty() && !fieldChangePasswordOld.getText().isEmpty() && !fieldChangePasswordNew.getText().isEmpty()) {
						if(oldPassword.equals(main.getPassword())) {
							String sql = "UPDATE db5.login SET password = '" + newPassword + "' WHERE binary password = '" + oldPassword + "' AND binary username = '" + main.getUser() + "'";
							stm.execute(sql);
							JOptionPane.showMessageDialog(frame, "Passwort wurde aktualisiert", "Profil", JOptionPane.INFORMATION_MESSAGE);
							fieldChangePasswordOld.setText("");
							fieldChangePasswordNew.setText("");
						} else {
							JOptionPane.showMessageDialog(frame, "Altes Passwort stimmt nicht überein", "Fehler", JOptionPane.ERROR_MESSAGE);
							fieldChangePasswordOld.setText("");
							fieldChangePasswordNew.setText("");
						}
						
					} else if(!fieldChangeUsernameOld.getText().isEmpty() && !fieldChangeUsernameNew.getText().isEmpty() && fieldChangePasswordOld.getText().isEmpty() && fieldChangePasswordNew.getText().isEmpty()){
						if(oldUsername.equals(main.getUser())) {
							String sql = "UPDATE db5.login SET username = '" + newUsername + "' WHERE binary username = '" + oldUsername + "'";
							stm.execute(sql);
							JOptionPane.showMessageDialog(frame, "Benutzername wurde aktualisiert", "Profil", JOptionPane.INFORMATION_MESSAGE);
							fieldChangeUsernameOld.setText("");
							fieldChangeUsernameNew.setText("");
						} else {
							JOptionPane.showMessageDialog(frame, "Benutzername konnte nicht gefunden werden", "Fehler", JOptionPane.ERROR_MESSAGE);
							fieldChangeUsernameOld.setText("");
							fieldChangeUsernameNew.setText("");
						}
						
					} else if(!oldPassword.equals(main.getPassword()) || !oldUsername.equals(main.getUser())) {
						JOptionPane.showMessageDialog(frame, "Benutzername oder Passwort falsch", "Fehler", JOptionPane.ERROR_MESSAGE);
						
					} else if(!oldPassword.equals(main.getPassword()) || !oldUsername.equals(main.getUser()) && newUsername.isEmpty() || newPassword.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Bitte fülle alle nötigen Felder aus", "Fehler", JOptionPane.ERROR_MESSAGE);
						
					} else if(!oldPassword.equals(main.getPassword()) || !oldUsername.equals(main.getUser()) && !newUsername.isEmpty() || !newPassword.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Benutzername oder Passwort falsch", "Fehler", JOptionPane.ERROR_MESSAGE);
						
					} else if(!fieldChangeUsernameOld.getText().isEmpty() && !fieldChangeUsernameNew.getText().isEmpty() && !fieldChangePasswordOld.getText().isEmpty() && !fieldChangePasswordNew.getText().isEmpty()){
						String sql1 = "UPDATE db5.login SET username = '" + newUsername + "' WHERE username = '" + oldUsername + "'";
						String sql2 = "UPDATE db5.login SET password = '" + newPassword + "' WHERE password = '" + oldPassword + "'";
						stm.execute(sql1);
						stm.execute(sql2);
						fieldChangePasswordOld.setText("");
						fieldChangePasswordNew.setText("");
						fieldChangeUsernameOld.setText("");
						fieldChangeUsernameNew.setText("");
						JOptionPane.showMessageDialog(frame, "Benutzername und Passwort wurden aktualisiert", "Profil", JOptionPane.INFORMATION_MESSAGE);
					
					} else {
						JOptionPane.showMessageDialog(frame, "Bitte fülle alle nötigen Felder aus", "Fehler", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					System.out.println("Unbekannter Fehler: " + ex.getMessage());
				}
			}
		});
		
		JButton btnNewUser = new JButton("Neuer Benutzer");
		btnNewUser.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = main.getUser();
				try {
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					String sql = "SELECT username FROM db5.login WHERE username = '" + main.getUser() + "' AND role = 'manager'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						frame.setVisible(false);
						GUI_new_employee openNewEmployee = new GUI_new_employee();
					} else {
						JOptionPane.showMessageDialog(frame, "Keine Berechtigung für diesen Bereich", "Fehler", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (Exception e2) {
					System.out.println("Unbekannter Fehler: " + e2.getMessage());
				}
				
			}
		});
		
		fieldChangePasswordOld = new JPasswordField();
		
		fieldChangePasswordNew = new JPasswordField();
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(btnNewUser)
					.addPreferredGap(ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addGap(38))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(lblChangeUsername))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldChangeUsernameNew, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldChangeUsernameOld, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblChangePassword, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(100))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(fieldChangePasswordNew, Alignment.LEADING)
								.addComponent(lblNewLabel_2_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldChangePasswordOld, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
							.addGap(71))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChangePassword)
						.addComponent(lblChangeUsername))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldChangeUsernameOld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldChangeUsernameNew, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldChangePasswordOld, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldChangePasswordNew, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnNewUser))
					.addGap(25))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
