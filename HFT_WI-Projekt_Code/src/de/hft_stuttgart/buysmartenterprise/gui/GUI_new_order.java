package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class GUI_new_order {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	DBAccess dbAccess = new DBAccess();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_new_order window = new GUI_new_order();
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
	public GUI_new_order() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Highspeed Procurement");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 35, 664, 226);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 66, 221, 32);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Teile auswählen");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_9.setBounds(0, 0, 221, 32);
		panel_4.add(lblNewLabel_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(427, 66, 162, 32);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Lieferanten auswählen");
		lblNewLabel_7.setBounds(0, 0, 162, 32);
		panel_6.add(lblNewLabel_7);
		lblNewLabel_7.setBackground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(599, 66, 56, 32);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Preis:");
		lblNewLabel_6.setBounds(0, 0, 56, 32);
		panel_7.add(lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		
		textField = new JTextField();
		textField.setBounds(334, 108, 48, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Zur Bestellung hinzufügen");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(448, 187, 96, 32);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bestellung abschließen");
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(559, 187, 96, 32);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(599, 101, 56, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox<String> teilecomboBox = new JComboBox<>();
		teilecomboBox.setBounds(10, 107, 221, 21);
		panel.add(teilecomboBox);
		teilecomboBox.setMaximumRowCount(8);
		teilecomboBox.setForeground(new Color(0, 0, 0));
		teilecomboBox.setBackground(new Color(255, 255, 255));
		teilecomboBox.addItem("Cache");
		teilecomboBox.addItem("RAM");
		teilecomboBox.addItem("SSD");
		teilecomboBox.addItem("CPU");
		teilecomboBox.addItem("Netzteil");
		teilecomboBox.addItem("Akku");
		teilecomboBox.addItem("Motherboard");
		teilecomboBox.addItem("Grafikkarte");
		teilecomboBox.addItem("Netzwerkkarte");
		teilecomboBox.addItem("Sonstiges");
		
		
		JComboBox<String> lieferantComboBox = new JComboBox<>();
		lieferantComboBox.setBounds(427, 109, 162, 20);
		panel.add(lieferantComboBox);
		try {
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT name from db5.lieferanten";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String data = rs.getString("name");
				lieferantComboBox.addItem(data);
			}
			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
			
		} catch (Exception e1) {
			System.out.println("Unbekannter Fehler: " + e1.getMessage());
		}
		
		
		JLabel lblNewLabel_8 = new JLabel("Menge festlegen");
		lblNewLabel_8.setBounds(248, 66, 143, 32);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 683, 33);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise   ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Neue Bestellung");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(Color.GRAY);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                                                   ");
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_dashboard openDashboard = new GUI_dashboard();
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("Profile");
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.BLACK);
		panel_1.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_profile openProfile = new GUI_profile();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel_1.add(btnNewButton_3);
		
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_login openLogin = new GUI_login();			
			}
		});
		
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
