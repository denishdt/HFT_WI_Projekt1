package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;
import de.hft_stuttgart.buysmartenterprise.main.Main;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;




public class GUI_login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	DBAccess dbAccess = new DBAccess();
	Main main = new Main();
	/**
	 */


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_login window = new GUI_login();
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
	public GUI_login() {
		dbAccess.firstConnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("HighSpeed Procurement");
		frame.setResizable(false);
		frame.getContentPane().setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		frame.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		frame.setBounds(100, 100, 720, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("Willkommen");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblNewLabel_2 = new JLabel("Benutzername:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Passwort");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		
		//Succesfull Login leads to the dashboard
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String username = textField.getText();
					String password = textField_1.getText();
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					String sql = "select * from login where binary username='"+ username + "' and binary password='"+ password + "'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						main.setUser(username);
						frame.setVisible(false);
						GUI_dashboard openDashboard = new GUI_dashboard();
					} else {
						JOptionPane.showMessageDialog(frame, "Benutzername oder Passwort falsch!", "Fehler", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						textField_1.setText("");
					}
					
				} catch (Exception ex) {
					System.out.println("Unbekannter Fehler: " + ex.getMessage());
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnNewButton.setForeground(UIManager.getColor("CheckBox.interiorBackground"));
		
		JLabel lblNewLabel = new JLabel("BuySmartEnterprise");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JSeparator separator = new JSeparator();
		
		JButton btnNewButton_1 = new JButton("Passwort vergessen?");
		btnNewButton_1.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(191)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
					.addGap(190))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)))
					.addGap(34)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(98))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addGap(239))
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(186))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addGap(24))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(203))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addGap(24))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(175, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(142))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
					.addGap(10))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
					.addGap(10))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbAccess.disconnect();
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
	}
}