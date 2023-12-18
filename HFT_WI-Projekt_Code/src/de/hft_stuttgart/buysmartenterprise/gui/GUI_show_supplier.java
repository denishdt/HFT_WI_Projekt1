package de.hft_stuttgart.buysmartenterprise.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI_show_supplier {

	private JFrame frmHighspeedProcurement;
	private JTextField txtName;
	private JTextField txtAdresse;
	private JTextField txtIban;
	private JTextField txtEmail;
	private JTextField txtTelefon;
	private JTextField txtFax;
	private JComboBox comboBoxSupplier;
	DBAccess dbAccess = new DBAccess();
	private JTextField txtSupplierFor;
	private JTextField txtStandardSupplier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_show_supplier window = new GUI_show_supplier();
					window.frmHighspeedProcurement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_show_supplier() {
		dbAccess.connect();
		initialize();
		loadSupplier();
	}
	
	public String getSupplierInfo(String supplier, String info) {
		String content = "";
		try {
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT " + info + " FROM db5.lieferanten WHERE name = '" + supplier + "'";
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				content = rs.getString(info);
			}
		} catch (Exception e) {
			System.out.println("Unbekannter Fehler: " + e.getMessage());
		}
		return content;
	}
	
	public String getStandardSupplier(String supplier) {
		String standardSupplier = "";
		try {
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT lieferantenart FROM db5.standardlieferant WHERE lieferant = '" + supplier + "'";
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				standardSupplier = rs.getString("lieferantenart");
			}
		} catch (Exception e) {
			System.out.println("Unbekannter Fehler: " + e.getMessage());
		}
		return standardSupplier;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHighspeedProcurement = new JFrame();
		frmHighspeedProcurement.setTitle("HighSpeed Procurement");
		frmHighspeedProcurement.setBounds(100, 100, 700, 467);
		frmHighspeedProcurement.setResizable(false);
		frmHighspeedProcurement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise  ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alle Lieferanten Anzeigen");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(Color.GRAY);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                                             ");
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmHighspeedProcurement.setVisible(false);
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
				frmHighspeedProcurement.setVisible(false);
				GUI_profile openProfile = new GUI_profile();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmHighspeedProcurement.setVisible(false);
				GUI_login openLogin = new GUI_login();
			}
		});
		
		comboBoxSupplier = new JComboBox();
		comboBoxSupplier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSupplierInfo();
			}
		});
		
		
		JLabel lblLieferant = new JLabel("Lieferant für:");
		lblLieferant.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStandardLieferant = new JLabel("Standardlieferant für:");
		lblStandardLieferant.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblOrt_1 = new JLabel("Ort:");
		lblOrt_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblOrt_2 = new JLabel("Ort:");
		lblOrt_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStraße = new JLabel("Straße:");
		lblStraße.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtAdresse = new JTextField();
		txtAdresse.setColumns(10);
		
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtIban = new JTextField();
		txtIban.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtTelefon = new JTextField();
		txtTelefon.setColumns(10);
		
		JLabel lblFax = new JLabel("Fax:");
		lblFax.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtFax = new JTextField();
		txtFax.setColumns(10);
		
		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String oldName = (String) comboBoxSupplier.getSelectedItem();
				String name = txtName.getText();
				String adress = txtAdresse.getText();
				String iban = txtIban.getText();
				String email = txtEmail.getText();
				String phone = txtTelefon.getText();
				String fax = txtFax.getText();
				
				try {
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					String sql = "UPDATE db5.lieferanten SET name = '" + name + "', adress = '" + adress + "', iban = '" + iban + "', email = '" + email + "', phone = '" + phone + "', fax = '" + fax + "' WHERE name = '" + oldName + "'";
					stm.execute(sql);
					JOptionPane.showMessageDialog(frmHighspeedProcurement, "Änderungen wurden gespeichert", "Lieferanten", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					System.out.println("Unbekannter Fehler: " + e2.getMessage());
				}
			}
		});
		
		JButton btnDelete = new JButton("Löschen");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String supplier = txtName.getText();
				try {
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					String sql = "DELETE FROM db5.lieferanten WHERE name = '" + supplier + "'";
					stm.execute(sql);
					JOptionPane.showMessageDialog(frmHighspeedProcurement, "Lieferant wurde gelöscht", "Lieferanten", JOptionPane.INFORMATION_MESSAGE);
					loadSupplier();
				} catch (Exception e2) {
					System.out.println("Unbekannter Fehler: " + e2.getMessage());
				}
				frmHighspeedProcurement.getContentPane().revalidate();
				frmHighspeedProcurement.getContentPane().repaint();
			}
		});
		
		txtSupplierFor = new JTextField();
		txtSupplierFor.setColumns(10);
		
		txtStandardSupplier = new JTextField();
		txtStandardSupplier.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(frmHighspeedProcurement.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBoxSupplier, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLieferant)
										.addComponent(txtSupplierFor, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtStandardSupplier, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStandardLieferant, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblName)
										.addComponent(lblStraße)
										.addComponent(txtAdresse, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIban, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtIban, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFax, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTelefon, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnSave))
											.addComponent(txtFax, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
									.addGap(79)))))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLieferant)
						.addComponent(lblStandardLieferant))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxSupplier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSupplierFor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStandardSupplier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon)
						.addComponent(lblStraße))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTelefon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFax)
						.addComponent(lblIban))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIban, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnDelete))
					.addGap(54))
		);
		frmHighspeedProcurement.getContentPane().setLayout(groupLayout);
		frmHighspeedProcurement.setVisible(true);
	}
	
	private void updateSupplierInfo() {
		txtName.setText((String) comboBoxSupplier.getSelectedItem());
		txtAdresse.setText(getSupplierInfo((String) comboBoxSupplier.getSelectedItem(), "adress"));
		txtIban.setText(getSupplierInfo((String) comboBoxSupplier.getSelectedItem(), "iban"));
		txtEmail.setText(getSupplierInfo((String) comboBoxSupplier.getSelectedItem(), "email"));
		txtTelefon.setText(getSupplierInfo((String) comboBoxSupplier.getSelectedItem(), "phone"));
		txtFax.setText(getSupplierInfo((String) comboBoxSupplier.getSelectedItem(), "fax"));
		txtSupplierFor.setText(getSupplierInfo((String) comboBoxSupplier.getSelectedItem(), "lieferantenart"));
		txtStandardSupplier.setText(getStandardSupplier((String) comboBoxSupplier.getSelectedItem()));
	}
	
	private void loadSupplier() {
		try {
			Connection con = dbAccess.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT name from db5.lieferanten";
			ResultSet rs = stm.executeQuery(sql);
			
			comboBoxSupplier.removeAllItems();
			
			while(rs.next()) {
				String data = rs.getString("name");
				comboBoxSupplier.addItem(data);
			}
			frmHighspeedProcurement.getContentPane().revalidate();
			frmHighspeedProcurement.getContentPane().repaint();
		} catch (Exception e) {
			System.out.println("Unbekannter Fehler: " + e.getMessage());
		}
	}
}
