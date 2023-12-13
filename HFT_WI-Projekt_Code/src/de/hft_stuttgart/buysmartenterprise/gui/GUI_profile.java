package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JTextField;

public class GUI_profile {

	private JFrame frame;
	private JTextField fieldChangeUsernameOld;
	private JTextField fieldChangeUsernameNew;
	private JTextField fieldChangePasswordOld;
	private JTextField fieldChangePasswordNew;
	DBAccess dbAccess = new DBAccess();

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
		frame.setBounds(100, 100, 647, 255);
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
		lblChangeUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblChangePassword = new JLabel("Passwort ändern");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		fieldChangeUsernameOld = new JTextField();
		fieldChangeUsernameOld.setText("Alter Benutzername");
		fieldChangeUsernameOld.setColumns(10);
		
		fieldChangeUsernameNew = new JTextField();
		fieldChangeUsernameNew.setText("Neuer Benutzername");
		fieldChangeUsernameNew.setColumns(10);
		
		fieldChangePasswordOld = new JTextField();
		fieldChangePasswordOld.setText("Altes Passwort");
		fieldChangePasswordOld.setColumns(10);
		
		fieldChangePasswordNew = new JTextField();
		fieldChangePasswordNew.setText("Neues Passwort");
		fieldChangePasswordNew.setColumns(10);
		
		JButton btnSave = new JButton("Speichern");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(lblChangeUsername)
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addComponent(lblChangePassword, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldChangeUsernameNew, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldChangeUsernameOld, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldChangePasswordOld, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldChangePasswordNew, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addGap(84))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(526, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChangePassword)
						.addComponent(lblChangeUsername))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(fieldChangeUsernameOld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(fieldChangeUsernameNew, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(fieldChangePasswordOld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(fieldChangePasswordNew, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addGap(22))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
