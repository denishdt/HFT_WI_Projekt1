package de.hft_stuttgart.buysmartenterprise.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI_Lieferantenanzeigen {

	private JFrame frmHighspeedProcurement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Lieferantenanzeigen window = new GUI_Lieferantenanzeigen();
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
	public GUI_Lieferantenanzeigen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHighspeedProcurement = new JFrame();
		frmHighspeedProcurement.setTitle("HighSpeed Procurement");
		frmHighspeedProcurement.setBounds(100, 100, 700, 300);
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
		
		JLabel lblNewLabel_2 = new JLabel("                                                       ");
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Profile");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Lieferanten Anzeigen:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JComboBox comboBox = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(frmHighspeedProcurement.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(261)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(287)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		frmHighspeedProcurement.getContentPane().setLayout(groupLayout);
	}
}
