package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

/**
 * Hier kann man einen neuen Lieferanten hinzuf&uuml;gen
 * 
 *
 */
public class GUI_new_supplier {

	private JFrame frm;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfAdresse;
	private JTextField tfTelefon;
	private JTextField tfIban;
	private JTextField tfFax;
	private JTextField tfZahlungsfrist;
	DBAccess dbAccess = new DBAccess();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_new_supplier window = new GUI_new_supplier();
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
	public GUI_new_supplier() {
		dbAccess.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	/**Hier werden die Checkboxen ausgelesen und in der Datenbank (tabelle: lieferanten) gespeichert.
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
	
	private void initialize() {
		frm = new JFrame();
		frm.setTitle("HighSpeed Procurement");
		frm.setBounds(100, 100, 702, 416);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise  ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Neuen Lieferanten hinzufügen   ");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(new Color(64, 128, 128));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                    ");
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
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
		
		JButton btnNewButton_2 = new JButton("Profile");
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
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
				GUI_login openLogin = new GUI_login();
						
			}
		});
		
		
		JLabel lblNewLabel_3 = new JLabel("Lieferant für:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JCheckBox cbRam = new JCheckBox("RAM");
		
		JCheckBox cbSsd = new JCheckBox("SSD");
		
		JCheckBox cbCpu = new JCheckBox("CPU");
		
		JCheckBox cbNetzteil = new JCheckBox("Netzteil");
		
		JCheckBox cbAkku = new JCheckBox("Akku");
		
		JCheckBox cbMotherboard = new JCheckBox("Motherboard");
		
		JCheckBox cbGrafikkarte = new JCheckBox("Grafikkarte");
		
		JCheckBox cbNetzwerkkarte = new JCheckBox("Netzwerkkarte");
		
		JLabel lblNewLabel_4 = new JLabel("Lieferantendaten eingeben:");
		
		JLabel lblName = new JLabel("Name:");
		
		tfName = new JTextField();
		tfName.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		
		tfAdresse = new JTextField();
		tfAdresse.setColumns(10);
		
		JLabel label = new JLabel("New label");
		
		JLabel lblTelefon = new JLabel("Telefon:");
		
		tfTelefon = new JTextField();
		tfTelefon.setColumns(10);
		
		JLabel lblIban = new JLabel("IBAN:");
		
		tfIban = new JTextField();
		tfIban.setColumns(10);
		
		JLabel lblFax = new JLabel("Fax:");
		
		tfFax = new JTextField();
		tfFax.setColumns(10);
		
		JLabel lblZahlungsfrist = new JLabel("Zahlungsfrist:");
		
		tfZahlungsfrist = new JTextField();
		tfZahlungsfrist.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Speichern");
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = tfName.getText();
					String adress = tfAdresse.getText();
					String email = tfEmail.getText();
					String phone = tfTelefon.getText();
					String fax = tfFax.getText();
					String iban = tfIban.getText();
					String zahlungsfrist = tfZahlungsfrist.getText();
					String lieferantenart = getLieferantenart(cbRam, cbSsd, cbCpu, cbNetzteil, cbAkku, cbMotherboard, cbGrafikkarte, cbNetzwerkkarte);
					String newSuplier = "INSERT INTO db5.lieferanten(name, adress, email, phone, fax, iban, zahlungsfrist, lieferantenart) VALUES('" + name + "', '" + adress + "', '" + email + "', '" + phone + "', '" + fax + "', '" + iban + "', '" + zahlungsfrist + "', '" + lieferantenart + "')";
					
					if (name.isEmpty() || adress.isEmpty() || email.isEmpty() || phone.isEmpty() || fax.isEmpty() || iban.isEmpty() || zahlungsfrist.isEmpty() || lieferantenart.isEmpty()) {
						JOptionPane.showMessageDialog(frm, "Bitte fülle alle Felder aus!", "Fehler", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Connection con = dbAccess.getConnection();
					Statement stm = con.createStatement();
					stm.execute(newSuplier);
				} catch (Exception e1) {
					System.out.println("Unbekannter Fehler: " + e1.getMessage());
					return;
				}
				tfName.setText("");
				tfAdresse.setText("");
				tfEmail.setText("");
				tfTelefon.setText("");
				tfFax.setText("");
				tfIban.setText("");
				tfZahlungsfrist.setText("");
				JOptionPane.showMessageDialog(frm, "Neuer Lieferant hinzugefügt!", "Neuer Lieferant", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cbMotherboard, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(cbNetzwerkkarte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cbRam, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addGap(14))
						.addComponent(cbGrafikkarte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cbSsd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(13)
							.addComponent(cbCpu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cbAkku, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(cbNetzteil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(171))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addGap(516))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(217)
					.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(317))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tfName, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAdresse, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
							.addGap(195)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTelefon, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
							.addGap(186))
						.addComponent(tfEmail, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
					.addGap(142))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblZahlungsfrist, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addGap(159))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(tfZahlungsfrist, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
								.addComponent(tfIban, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
								.addComponent(tfAdresse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblIban, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addGap(179)))
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(289)
							.addComponent(btnNewButton_4)
							.addGap(25))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(tfFax, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
								.addComponent(tfTelefon, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblFax, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addGap(169)))
							.addGap(142))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbRam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cbSsd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cbCpu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cbNetzteil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cbNetzwerkkarte))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbMotherboard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cbGrafikkarte)
						.addComponent(cbAkku, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfName, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfAdresse, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
						.addComponent(tfTelefon, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIban)
						.addComponent(lblFax))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfIban, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFax, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblZahlungsfrist)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfZahlungsfrist, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
						.addComponent(btnNewButton_4))
					.addGap(29))
		);
		frm.getContentPane().setLayout(groupLayout);
		
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
