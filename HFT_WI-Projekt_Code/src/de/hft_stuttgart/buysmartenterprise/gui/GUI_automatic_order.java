package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_automatic_order {

	private JFrame frmBuysmartEnterprise;
	private JTable table;
	private JTextField txtStandardmenge;
	private JTextField textField;
	private JTextField txtAusgewhlterStandardlieferant;
	private JTextField txtLieferantB;
	private JTextField txtPreis;
	private JTextField textField_1;
	DBAccess dbAccess = new DBAccess();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_automatic_order window = new GUI_automatic_order();
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
	public GUI_automatic_order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuysmartEnterprise = new JFrame();
		frmBuysmartEnterprise.setTitle("HighSpeed Procurement");
		frmBuysmartEnterprise.setBounds(100, 100, 700, 300);
		frmBuysmartEnterprise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ausgew\u00E4hltes Teil"},
				{"Intel\u00AE Core\u2122 i7-9700 Prozessor"},
			},
			new String[] {
				"New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(624);
		
		txtStandardmenge = new JTextField();
		txtStandardmenge.setHorizontalAlignment(SwingConstants.CENTER);
		txtStandardmenge.setEditable(false);
		txtStandardmenge.setSelectionColor(new Color(255, 0, 0));
		txtStandardmenge.setText("Standardmenge");
		txtStandardmenge.setColumns(10);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 128, 128));
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		txtAusgewhlterStandardlieferant = new JTextField();
		txtAusgewhlterStandardlieferant.setEditable(false);
		txtAusgewhlterStandardlieferant.setHorizontalAlignment(SwingConstants.CENTER);
		txtAusgewhlterStandardlieferant.setText("Ausgewählter Standardlieferant");
		txtAusgewhlterStandardlieferant.setColumns(10);
		
		txtLieferantB = new JTextField();
		txtLieferantB.setForeground(new Color(128, 128, 128));
		txtLieferantB.setEditable(false);
		txtLieferantB.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLieferantB.setColumns(10);
		
		txtPreis = new JTextField();
		txtPreis.setEditable(false);
		txtPreis.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreis.setText("Preis");
		txtPreis.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Bestellung abschließen");
		btnNewButton_4.setBackground(new Color(0, 128, 192));
		
		JButton btnNewButton_4_1 = new JButton("Bestellung verwerfen");
		btnNewButton_4_1.setBackground(new Color(0, 128, 192));
		GroupLayout groupLayout = new GroupLayout(frmBuysmartEnterprise.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtStandardmenge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_4_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtLieferantB)
								.addComponent(txtAusgewhlterStandardlieferant, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPreis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(57))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtAusgewhlterStandardlieferant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPreis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtStandardmenge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLieferantB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		
		JLabel lblNewLabel = new JLabel("BuySmart Enterprise");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("                                                                            ");
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Shop");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_dashboard openDashboard = new GUI_dashboard();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Settings");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		panel.add(btnNewButton_3);
		frmBuysmartEnterprise.getContentPane().setLayout(groupLayout);
		
		//Log Out: It just leads to the Login, real Log Out TBD
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBuysmartEnterprise.setVisible(false);
				GUI_Login openLogin = new GUI_Login();			
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
}
