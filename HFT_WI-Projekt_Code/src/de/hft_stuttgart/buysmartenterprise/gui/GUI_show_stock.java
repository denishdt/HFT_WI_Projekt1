package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI_show_stock {

	private JFrame frame;
	private JTextField txtBestandDerEinzelteile;
	private JTextField textField;
	private JTextField tfEinzelteil1;
	private JTextField tfEinzelteil2;
	private JTextField tfEinzelteil3;
	private JTextField txtBestand;
	private JTextField tfAnzahl1;
	private JTextField tfAnzahl2;
	private JTextField tfAnzahl3;
	private JComboBox<String> comboBox;
	DBAccess dbAccess = new DBAccess();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_show_stock window = new GUI_show_stock();
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
	public GUI_show_stock() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 33);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise  ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bestand der Einzelteile anzeigen");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(0, 124, 128));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                    ");
		panel.add(lblNewLabel_2);
		
		JButton btnHome = new JButton("Home");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(Color.BLACK);
		panel.add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_dashboard openDashboard = new GUI_dashboard();
			}
		});
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBackground(Color.BLACK);
		panel.add(btnProfile);
		btnProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_profile openProfile = new GUI_profile();
			}
		});
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(Color.BLACK);
		panel.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GUI_login openLogin = new GUI_login();
						
			}
		});
		
		JList<String> list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"RAM", "Netzteil", "SSD", "Motherboard", "CPU", "Akku", "Grafikkarte", "Netzwerkkarte"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Get the selected item from the JList
                    String selectedValue = list.getSelectedValue();
                    loadTeil(selectedValue);

                    // Update the JTextField with the selected item
                    textField.setText(selectedValue);
                }
            }
        });
		
		list.setBounds(26, 101, 300, 165);
		frame.getContentPane().add(list);
		
		txtBestandDerEinzelteile = new JTextField();
		txtBestandDerEinzelteile.setForeground(new Color(0, 124, 128));
		txtBestandDerEinzelteile.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtBestandDerEinzelteile.setHorizontalAlignment(SwingConstants.CENTER);
		txtBestandDerEinzelteile.setText("Komponente auswählen");
		txtBestandDerEinzelteile.setBounds(26, 68, 300, 33);
		frame.getContentPane().add(txtBestandDerEinzelteile);
		txtBestandDerEinzelteile.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Bestand");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(0, 124, 128));
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(359, 68, 300, 33);
		frame.getContentPane().add(textField);
		
		comboBox = new JComboBox();
		comboBox.setBounds(359, 101, 233, 22);
		frame.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(589, 99, 68, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadBestand((String) list.getSelectedValue(), (String) comboBox.getSelectedItem());
				
			}
		});
		
		frame.setVisible(true);
	}
	
	private void loadTeil(String komponente) {
    	try {
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT " + komponente + " from db5.teilebestand WHERE " + komponente + " IS NOT NULL";
			ResultSet rs = stm.executeQuery(sql);
			
			comboBox.removeAllItems();
			
			while(rs.next()) {
				String data = rs.getString(komponente);
				comboBox.addItem(data);
			}
			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
		} catch (Exception e) {
			System.out.println("Unbekannter Fehler: " + e.getMessage());
		}
    }
	
	private void loadBestand(String komponente, String teil) {
		try {
			Connection con = dbAccess.getConnection();
			String preisSql = "SELECT bestand FROM db5.teilebestand WHERE " + komponente + " = ?";
			try (PreparedStatement pst = con.prepareStatement(preisSql)){
				pst.setString(1, teil);
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()) {
                	int data = rs.getInt("bestand");
                	textField_1.setText(Integer.toString(data));
                }
                
			} catch (Exception e) {
				System.out.println("Unbekannter Fehler: " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Unbekannter Fehler: " + e.getMessage());
		}
	}
}
