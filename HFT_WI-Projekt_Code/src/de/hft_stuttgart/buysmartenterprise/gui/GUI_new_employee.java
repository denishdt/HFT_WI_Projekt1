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

import javax.swing.JButton;

public class GUI_new_employee {

	private JFrame frame;
	DBAccess dbAccess = new DBAccess();

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
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
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
