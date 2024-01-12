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
import java.sql.SQLException;
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
/**
 * 
 * Hier wird der Standard lieferant festgelegt für bestimmte Teile.
 *
 */
public class GUI_standard_supplier {

	private JFrame frm;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_6;
	private JCheckBox chckbxNewCheckBox_7;
	private JCheckBox chckbxNewCheckBox_8;
	DBAccess dbAccess = new DBAccess();

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
		dbAccess.connect();
		initialize();
	}
	
	/**Die ausgew&auml;hlten Checkboxen werden ausgelesen und weitergeben.
	 * @param checkBoxes
	 * @return
	 */
	public static String getLieferantenart(JCheckBox...checkBoxes) {
		StringBuilder selectedItem = new StringBuilder();
		for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                if (selectedItem.length() > 0) {
                    selectedItem.append(", ");
                }
                selectedItem.append(checkBox.getText());
            }
        }

        return selectedItem.toString();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm = new JFrame();
		frm.setTitle("HighSpeed Procurement");
		frm.setBounds(100, 100, 697, 300);
		frm.setResizable(false);
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
		lblNewLabel_1.setBackground(new Color(64, 128, 128));
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
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		frm.getContentPane().add(panel);
		frm.getContentPane().add(lblNewLabel_3);
		
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
				GUI_login openLogin = new GUI_login();
						
			}
		});
		
		
		lblNewLabel_4 = new JLabel("Als Standardlieferant festlegen f\u00FCr:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 12, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 112, SpringLayout.EAST, lblNewLabel_3);
		frm.getContentPane().add(lblNewLabel_4);
		
		comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.WEST, frm.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, lblNewLabel_3);
		frm.getContentPane().add(comboBox);
		try {
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT name from db5.lieferanten";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String data = rs.getString("name");
				comboBox.addItem(data);
			}
			frm.getContentPane().revalidate();
			frm.getContentPane().repaint();
			
		} catch (Exception e1) {
			System.out.println("Unbekannter Fehler: " + e1.getMessage());
		}
		
		chckbxNewCheckBox_1 = new JCheckBox("Netzteil");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_1, 79, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_1, 0, SpringLayout.WEST, lblNewLabel_4);
		frm.getContentPane().add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Grafikkarte");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_2, 108, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox_1, -6, SpringLayout.NORTH, chckbxNewCheckBox_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_2, 0, SpringLayout.WEST, lblNewLabel_4);
		frm.getContentPane().add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("Akku");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_3, 0, SpringLayout.NORTH, chckbxNewCheckBox_2);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_3, 6, SpringLayout.EAST, chckbxNewCheckBox_2);
		frm.getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("SSD");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_5, 22, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -135, SpringLayout.WEST, chckbxNewCheckBox_5);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_5, 0, SpringLayout.WEST, chckbxNewCheckBox_3);
		frm.getContentPane().add(chckbxNewCheckBox_5);
		
		chckbxNewCheckBox_4 = new JCheckBox("CPU");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_4, 0, SpringLayout.NORTH, chckbxNewCheckBox_1);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_4, 0, SpringLayout.WEST, chckbxNewCheckBox_3);
		frm.getContentPane().add(chckbxNewCheckBox_4);
		
		chckbxNewCheckBox_6 = new JCheckBox("RAM");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_6, 0, SpringLayout.NORTH, chckbxNewCheckBox_5);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_6, 0, SpringLayout.WEST, lblNewLabel_4);
		frm.getContentPane().add(chckbxNewCheckBox_6);
		
		chckbxNewCheckBox_7 = new JCheckBox("Motherboard");
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_7, 39, SpringLayout.EAST, chckbxNewCheckBox_4);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_7, 0, SpringLayout.NORTH, chckbxNewCheckBox_1);
		frm.getContentPane().add(chckbxNewCheckBox_7);
		
		chckbxNewCheckBox_8 = new JCheckBox("Netzwerkkarte");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_8, 0, SpringLayout.NORTH, chckbxNewCheckBox_5);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_8, 0, SpringLayout.WEST, chckbxNewCheckBox_7);
		frm.getContentPane().add(chckbxNewCheckBox_8);
		
		JButton btnSave = new JButton("Speichern");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -26, SpringLayout.SOUTH, frm.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, panel);
		frm.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String stdSupplierSelected = (String) comboBox.getSelectedItem();
				String checkStdSupplier = "SELECT * FROM db5.standardlieferant WHERE lieferant = '" + stdSupplierSelected + "'";
				
				String stdSupplierTypeSelected = getLieferantenart(chckbxNewCheckBox_1, chckbxNewCheckBox_2, chckbxNewCheckBox_3, chckbxNewCheckBox_4, chckbxNewCheckBox_5, chckbxNewCheckBox_6, chckbxNewCheckBox_7, chckbxNewCheckBox_8);
				try {
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					ResultSet rs = stm.executeQuery(checkStdSupplier);
					
					if (stdSupplierSelected.isEmpty() || stdSupplierTypeSelected.isEmpty()) {
						JOptionPane.showMessageDialog(frm, "Bitte fülle alle Felder aus!", "Fehler", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if (rs.next()) {
					    // Der Standardlieferant existiert bereits
					    int option = JOptionPane.showConfirmDialog(frm, "Der Standardlieferant existiert bereits. Möchtest du ihn überschreiben?", "Warnung", JOptionPane.YES_NO_OPTION);

					    if (option == JOptionPane.YES_OPTION) {
					        String sql = "UPDATE db5.standardlieferant SET lieferantenart = '" + stdSupplierTypeSelected + "' WHERE lieferant = '" + stdSupplierSelected + "'";
					        stm.execute(sql);
					        JOptionPane.showMessageDialog(frm, "Der Standardlieferant wurde erfolgreich überschrieben.", "Neuer Standardlieferant", JOptionPane.INFORMATION_MESSAGE);
					    } else {
					        return;
					    }
					} else {
					    String sql = "INSERT INTO db5.standardlieferant(lieferant, lieferantenart) VALUES('" + stdSupplierSelected + "', '" + stdSupplierTypeSelected + "')";
					    stm.execute(sql);
					    JOptionPane.showMessageDialog(frm, "Der Standardlieferant wurde erfolgreich hinzugefügt.", "Neuer Standardlieferant", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					System.out.println("Unbekannter Fehler: " + e1.getMessage());
				}
			}
		});
		
		frm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbAccess.disconnect();
				System.exit(0);
			}
		});
		
		frm.setVisible(true);
	}
}
