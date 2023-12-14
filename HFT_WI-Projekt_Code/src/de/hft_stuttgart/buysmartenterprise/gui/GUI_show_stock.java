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

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 300);
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
			String[] values = new String[] {"Cache", "RAM", "SSD", "CPU"};
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

                    // Update the JTextField with the selected item
                    textField.setText(selectedValue);
                }
            }
        });
		
		list.setBounds(10, 101, 300, 136);
		frame.getContentPane().add(list);
		
		txtBestandDerEinzelteile = new JTextField();
		txtBestandDerEinzelteile.setForeground(new Color(0, 124, 128));
		txtBestandDerEinzelteile.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtBestandDerEinzelteile.setHorizontalAlignment(SwingConstants.CENTER);
		txtBestandDerEinzelteile.setText("Bestand der Einzelteile");
		txtBestandDerEinzelteile.setBounds(10, 68, 300, 33);
		frame.getContentPane().add(txtBestandDerEinzelteile);
		txtBestandDerEinzelteile.setColumns(10);
		
		textField = new JTextField();
		textField.setText(" ");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(356, 69, 81, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		tfEinzelteil1 = new JTextField();
		tfEinzelteil1.setBounds(356, 115, 208, 27);
		frame.getContentPane().add(tfEinzelteil1);
		tfEinzelteil1.setColumns(10);
		
		tfEinzelteil2 = new JTextField();
		tfEinzelteil2.setColumns(10);
		tfEinzelteil2.setBounds(356, 153, 208, 27);
		frame.getContentPane().add(tfEinzelteil2);
		
		tfEinzelteil3 = new JTextField();
		tfEinzelteil3.setColumns(10);
		tfEinzelteil3.setBounds(356, 190, 208, 27);
		frame.getContentPane().add(tfEinzelteil3);
		
		txtBestand = new JTextField();
		txtBestand.setEditable(false);
		txtBestand.setText("Bestand");
		txtBestand.setHorizontalAlignment(SwingConstants.CENTER);
		txtBestand.setColumns(10);
		txtBestand.setBounds(583, 68, 81, 33);
		frame.getContentPane().add(txtBestand);
		
		tfAnzahl1 = new JTextField();
		tfAnzahl1.setColumns(10);
		tfAnzahl1.setBounds(608, 115, 31, 27);
		frame.getContentPane().add(tfAnzahl1);
		
		tfAnzahl2 = new JTextField();
		tfAnzahl2.setColumns(10);
		tfAnzahl2.setBounds(608, 156, 31, 27);
		frame.getContentPane().add(tfAnzahl2);
		
		tfAnzahl3 = new JTextField();
		tfAnzahl3.setColumns(10);
		tfAnzahl3.setBounds(608, 193, 31, 27);
		frame.getContentPane().add(tfAnzahl3);
		frame.setVisible(true);
	}
	
}
