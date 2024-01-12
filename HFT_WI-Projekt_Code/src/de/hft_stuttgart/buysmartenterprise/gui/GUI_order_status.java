package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 * Hier werden die Bestellungen inklusive Status aufgelistet.
 * 
 *
 */
public class GUI_order_status {

	private JFrame frmBuysmartEnterprise;
	private JTable table;
	DBAccess dbAccess = new DBAccess();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_order_status window = new GUI_order_status();
					window.frmBuysmartEnterprise.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_order_status() {
		dbAccess.connect();
		initialize();
		updateStatusColumn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuysmartEnterprise = new JFrame();
		frmBuysmartEnterprise.setTitle("HighSpeed Procurement");
		frmBuysmartEnterprise.setResizable(false);
		frmBuysmartEnterprise.setBounds(100, 100, 700, 360);
		frmBuysmartEnterprise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bestellungsnummer:", "Lieferant:", "Status:"
			}
		));
		//setUpStatusColumn(table, table.getColumnModel().getColumn(2));
		
		JPanel panel = new JPanel();
		
		
		panel.setBackground(new Color(0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(frmBuysmartEnterprise.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addGap(12))
		);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise  ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bestellstatus einsehen      ");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                 ");
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_dashboard openDashboard = new GUI_dashboard();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_profile openProfile = new GUI_profile();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		frmBuysmartEnterprise.getContentPane().setLayout(groupLayout);
		
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_login openLogin = new GUI_login();	
			}
		});
		
		frmBuysmartEnterprise.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbAccess.disconnect();
				System.exit(0);
			}
		});
		
		frmBuysmartEnterprise.setVisible(true);
	}
	
	 /**
	 * Hier wird auf Basis von der Tabelle order (Datenbank), die Bestellungen erfasst und dementsprechend
	 * in die Liste hinzugef&uuml;gt (Bestellnr., Lieferant, Status (als ComboBox)).
	 */
	public void updateStatusColumn() {
	        try {
	            Connection con = dbAccess.getConnection();
	            Statement stm = con.createStatement();
	            String sql = "SELECT * from db5.order";
	            ResultSet rs = stm.executeQuery(sql);
	         // Erstellt ein neues TableModel für die Tabelle mit den Spalten "Bestellungsnummer", "Lieferant" und "Status"

	            DefaultTableModel model = new DefaultTableModel(
	                    new Object[][]{},
	                    new String[]{"Bestellungsnummer:", "Lieferant:", "Status:"}
	            );
	            
	            while (rs.next()) {
	                Object[] data = {
	                        rs.getString("orderid"),
	                        rs.getString("lieferant"),
	                        getStatusLabel(rs.getString("status"))
	                };
	                model.addRow(data);
	            }

	            table.setModel(model);
	            setUpStatusComboBoxEditor(table.getColumnModel().getColumn(2));

	        } catch (Exception e) {
	            System.out.println("Unbekannter Fehler: " + e.getMessage());
	        }
	    }

	    /**Man kann den Status der jeweiligen Bestellung pflegen (versendet/eingetroffen). 
	     * @param statusColumn
	     */
	    public void setUpStatusComboBoxEditor(TableColumn statusColumn) {
	        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Versendet", "Eingetroffen"});
	        statusColumn.setCellEditor(new DefaultCellEditor(comboBox));
	        
	        comboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					updateStatus(table.getSelectedRow(), comboBox.getSelectedItem().toString());
					
				}
			});
	    }
	    
	    /**Das Ergebnis der Methode setUpStatusComboBoxEditor(TableColumn statusColumn) wird in der Datenbank eingespeichert.
	     * @param selectedRow
	     * @param selectedStatus
	     */
	    public void updateStatus(int selectedRow, String selectedStatus) {
	    	if(selectedRow != -1) {
	    		try {
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					String orderid = table.getValueAt(selectedRow, 0).toString();
					String sql = "UPDATE db5.order SET status = '" + selectedStatus + "' WHERE orderid = '" + orderid + "'";
					stm.executeUpdate(sql);
				} catch (Exception e) {
					System.out.println("Unbekannter Fehler: " + e.getMessage());
				}
	    	}
	    }

	    /**In der Datenbank wird bei einer neuen Bestellung der Status als 'pending' eingetragen, jedoch wird dies in der Liste 
	     * als 'Versendet' angezeigt.
	     * @param status
	     * @return
	     */
	    public String getStatusLabel(String status) {
	        return status.equals("Pending") ? "Versendet" : "Eingetroffen";
	    }
	
}
