package de.hft_stuttgart.buysmartenterprise.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import de.hft_stuttgart.buysmartenterprise.dbaccess.DBAccess;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class GUI_new_order {
    private JFrame frame;
    private JTextField preisField;
    private JComboBox<String> lieferantComboBox;
    private JComboBox<String> teilecomboBox;
    private JComboBox<String> teilecomboBox_1;
    DBAccess dbAccess = new DBAccess();
    private JTextField mengeField;
    private JTextField verfuegbarMengeField;
    

    
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

    public GUI_new_order() {
        dbAccess.connect();
        initialize(); 
    }

    private void initialize() {
        frame = new JFrame("Highspeed Procurement");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 35, 664, 237);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_4.setBounds(10, 66, 221, 32);
        panel.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_9 = new JLabel("Lieferanten auswählen:");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_9.setBounds(0, 0, 221, 32);
        panel_4.add(lblNewLabel_9);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        panel_6.setBounds(262, 6, 162, 32);
        panel.add(panel_6);
        panel_6.setLayout(null);

        JLabel lblNewLabel_7 = new JLabel("Teile auswählen:");
        lblNewLabel_7.setBounds(0, 0, 162, 32);
        panel_6.add(lblNewLabel_7);
        lblNewLabel_7.setBackground(new Color(255, 255, 255));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
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

        JButton btnNewButton = new JButton("Bestellung abschließen");
        btnNewButton.setBackground(new Color(0, 0, 128));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String teile = (String) teilecomboBox_1.getSelectedItem();
                String mengeStr = mengeField.getText().trim(); // Trimmen Sie den Text, um führende oder nachfolgende Leerzeichen zu entfernen
                String lieferant = (String) lieferantComboBox.getSelectedItem();
                String komponente = (String) teilecomboBox.getSelectedItem();

                if (teile.isEmpty() || mengeStr.isEmpty() || lieferant.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Bitte fülle alle Felder aus!", "Fehler",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int menge = Integer.parseInt(mengeStr);

                    if (menge < 0) {
                        JOptionPane.showMessageDialog(frame, "Bitte geben Sie eine positive Menge ein.", "Fehler",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Überprüfen, ob genügend Teile auf Lager sind, bevor die Bestellung eingefügt wird
                    if (isStockAvailable(komponente, teile, menge)) {
                        calculatePrice(komponente, teile, menge);
                        updateTeilebestand(komponente, teile, menge);
                        insertOrderIntoDatabase(teile, menge, lieferant, Double.parseDouble(preisField.getText()), "Pending");

                        // Setze das Menge-Feld zurück
                        mengeField.setText("");
                    } else {
                        // Fehlermeldung anzeigen, wenn nicht genügend Teile auf Lager sind
                        JOptionPane.showMessageDialog(frame, "Nicht genügend Teile auf Lager.", "Fehler",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ungültige Menge eingegeben. Bitte geben Sie eine positive ganze Zahl ein.", "Fehler",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnNewButton.setBounds(478, 187, 177, 33);
        panel.add(btnNewButton);

        preisField = new JTextField();
        preisField.setEditable(false);
        preisField.setBounds(599, 101, 56, 32);
        panel.add(preisField);
        preisField.setColumns(10);

        teilecomboBox = new JComboBox<>();
        teilecomboBox.setBounds(262, 50, 162, 20);
        panel.add(teilecomboBox);
        teilecomboBox.setMaximumRowCount(8);
        teilecomboBox.setForeground(new Color(0, 0, 0));
        teilecomboBox.setBackground(new Color(255, 255, 255));
        teilecomboBox.addItem("RAM");
        teilecomboBox.addItem("SSD");
        teilecomboBox.addItem("CPU");
        teilecomboBox.addItem("Netzteil");
        teilecomboBox.addItem("Akku");
        teilecomboBox.addItem("Motherboard");
        teilecomboBox.addItem("Grafikkarte");
        teilecomboBox.addItem("Netzwerkkarte");
        teilecomboBox.addItem("Sonstiges");
        teilecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ausgewaehltesTeil = (String) teilecomboBox.getSelectedItem();
				loadTeil(ausgewaehltesTeil);
				
				
			}
		});

        lieferantComboBox = new JComboBox<>();
        lieferantComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ausgewaehlterLieferant = (String) lieferantComboBox.getSelectedItem();
                verfuegbareTeil(ausgewaehlterLieferant);
            }
        });
        lieferantComboBox.setBounds(10, 107, 221, 21);
        panel.add(lieferantComboBox);
        try {
            Connection con = dbAccess.getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT name from db5.lieferanten";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String data = rs.getString("name");
                lieferantComboBox.addItem(data);
            }
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();

        } catch (Exception e1) {
            System.out.println("Unbekannter Fehler: " + e1.getMessage());
        }

        JLabel lblNewLabel_8 = new JLabel("Menge festlegen:");
        lblNewLabel_8.setBounds(436, 66, 143, 32);
        panel.add(lblNewLabel_8);
        lblNewLabel_8.setBackground(new Color(255, 255, 255));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel_8 = new JPanel();
        panel_8.setLayout(null);
        panel_8.setBackground(Color.WHITE);
        panel_8.setBounds(262, 107, 162, 32);
        panel.add(panel_8);
        
        JLabel lblNewLabel_7_1 = new JLabel("Einzelteile auswählen:");
        lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_7_1.setBackground(Color.WHITE);
        lblNewLabel_7_1.setBounds(0, 0, 162, 32);
        panel_8.add(lblNewLabel_7_1);
        
        teilecomboBox_1 = new JComboBox<String>();
        teilecomboBox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Leere die Menge und das Preisfeld.
		        mengeField.setText("");
		        preisField.setText("");
		        
		     // Aktualisiere die verfügbare Menge, wenn ein neues Teil ausgewählt wird.
		        String ausgewaehltesTeil = (String) teilecomboBox_1.getSelectedItem();
		        String ausgewaehlteKomponente = (String) teilecomboBox.getSelectedItem();
		        int bestand = getBestand(ausgewaehlteKomponente, ausgewaehltesTeil);
		        verfuegbarMengeField.setText(String.valueOf(bestand));
        	}
        });
        teilecomboBox_1.setMaximumRowCount(8);
        teilecomboBox_1.setForeground(Color.BLACK);
        teilecomboBox_1.setBackground(Color.WHITE);
        teilecomboBox_1.setBounds(262, 151, 162, 20);
        panel.add(teilecomboBox_1);
        
        mengeField = new JTextField();
        mengeField.setBounds(488, 103, 56, 29);
        panel.add(mengeField);
        mengeField.setColumns(10);
        
        verfuegbarMengeField = new JTextField();
        verfuegbarMengeField.setHorizontalAlignment(SwingConstants.CENTER);
        verfuegbarMengeField.setEditable(false);
        verfuegbarMengeField.setBounds(311, 208, 46, 29);
        panel.add(verfuegbarMengeField);
        verfuegbarMengeField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Verfügbarer Bestand:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(272, 191, 135, 20);
        panel.add(lblNewLabel_3);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        panel_1.setBounds(0, 0, 683, 33);
        frame.getContentPane().add(panel_1);

        JLabel lblNewLabel = new JLabel("BuySmart Enterprise   ");
        lblNewLabel.setForeground(Color.LIGHT_GRAY);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Bestellung erstellen");
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBackground(new Color(64, 128, 128));
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

    /** test kek
     * @param ausgewaehlterLieferant
     */
    private void verfuegbareTeil(String ausgewaehlterLieferant) {
        teilecomboBox.removeAllItems();

        try {
            Connection con = dbAccess.getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT DISTINCT lieferantenart FROM db5.lieferanten WHERE name = '"
                    + ausgewaehlterLieferant + "'";
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                do {
                    String data = rs.getString("lieferantenart");
                    String[] teile = data.split(", ");
                    for (String teil : teile) {
                        teilecomboBox.addItem(teil);
                    }
                } while (rs.next());
            } else {
                teilecomboBox.addItem("Keine Teile verfügbar");
            }

            teilecomboBox.revalidate();
            teilecomboBox.repaint();
        } catch (Exception e) {
            System.out.println("Fehler beim Abrufen der Teile: " + e.getMessage());
        }
    }
    
    private void loadTeil(String komponente) {
        try {
            Connection con = dbAccess.getConnection();
            Statement stm = con.createStatement();
            String sql = "SELECT " + komponente + " FROM db5.teilebestand WHERE " + komponente + " IS NOT NULL";
            ResultSet rs = stm.executeQuery(sql);

            teilecomboBox_1.removeAllItems();

            while (rs.next()) {
                String teil = rs.getString(komponente);
                int bestand = getBestand(komponente, teil);
                teilecomboBox_1.addItem(teil);
            }

            // Menge und Preisfeld leeren, wenn neues Teil ausgewählt
            mengeField.setText("");
            preisField.setText("");

            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        } catch (Exception e) {
            System.out.println("Unbekannter Fehler: " + e.getMessage());
        }
    }

    private int getBestand(String komponente, String teil) {
        try {
            Connection con = dbAccess.getConnection();
            String selectSql = "SELECT bestand FROM db5.teilebestand WHERE " + komponente + " = ?";
            try (PreparedStatement selectPst = con.prepareStatement(selectSql)) {
                selectPst.setString(1, teil);
                ResultSet resultSet = selectPst.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getInt("bestand");
                }
            }
        } catch (Exception ex) {
            System.out.println("Fehler beim Abrufen des Bestands: " + ex.getMessage());
        }
        return 0; // Standardwert, wenn etwas schief geht
    }
    
    private void calculatePrice(String komponente, String teile, int menge) {
        try {
            Connection con = dbAccess.getConnection();

            // Use prepared statement to avoid SQL injection
            String preisSql = "SELECT preis FROM db5.teilebestand WHERE " + komponente + " = ?";
            try (PreparedStatement pst = con.prepareStatement(preisSql)) {
                pst.setString(1, teile);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    double preis = rs.getDouble("preis");
                    double gesamtPreis = preis * menge;
                    preisField.setText(String.valueOf(gesamtPreis));
                } else {
                    JOptionPane.showMessageDialog(frame, "Das ausgewählte Teil hat keinen Preis in der Datenbank.", "Fehler",
                            JOptionPane.ERROR_MESSAGE);
                    preisField.setText("");
                }
            }
        } catch (Exception ex) {
            System.out.println("Fehler beim Abrufen des Preises: " + ex.getMessage());
        }
    }
    private void insertOrderIntoDatabase(String teile, int menge, String lieferant, double preis, String status) {
        try {
            Connection con = dbAccess.getConnection();
            String insertSql = "INSERT INTO db5.order (teile, menge, lieferant, preis, status) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pst = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, teile);
                pst.setInt(2, menge);
                pst.setString(3, lieferant);
                pst.setDouble(4, preis);
                pst.setString(5, status);

                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    // Bestellung erfolgreich eingefügt, hole die automatisch generierte Bestellungs-ID
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int orderId = generatedKeys.getInt(1);
                        // Aktualisiere den Bestand
                        
                        JOptionPane.showMessageDialog(frame, "Bestellung erfolgreich abgeschlossen!", "Erfolg",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Fehler beim Abschließen der Bestellung.", "Fehler",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            System.out.println("Fehler beim Einfügen der Bestellung in die Datenbank: " + ex.getMessage());
        }
    }
    private void updateTeilebestand(String komponente, String teile, int menge) {
        try {
            Connection con = dbAccess.getConnection();
            String updateSql = "UPDATE db5.teilebestand SET bestand = bestand + ? WHERE " + komponente + " = ? ";

            try (PreparedStatement pst = con.prepareStatement(updateSql)) {
                pst.setInt(1, menge);

                pst.setString(2, teile);
                int affectedRows = pst.executeUpdate();

                if (affectedRows <= 0) {
                    System.out.println("Fehler beim Aktualisieren des Teilebestands.");
                }
            }
        } catch (Exception ex) {
            System.out.println("Fehler beim Aktualisieren des Teilebestands: " + ex.getMessage());
        }
    }
    private void showConfirmationDialog() {
        int option = JOptionPane.showConfirmDialog(frame,
                "Möchten Sie die Bestellung abschließen? Diese Aktion kann nicht storniert werden.",
                "Warnung",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            String teile = (String) teilecomboBox_1.getSelectedItem();
            String mengeStr = mengeField.getText().replaceAll("[^\\d.]", "");
            String lieferant = (String) lieferantComboBox.getSelectedItem();
            String komponente = (String) teilecomboBox.getSelectedItem();

            if (teile.isEmpty() || mengeStr.isEmpty() || lieferant.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Bitte fülle alle Felder aus!", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int menge;
            try {
                menge = Integer.parseInt(mengeStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Ungültige Menge eingegeben.", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Überprüfen, ob genügend Teile auf Lager sind, bevor die Bestellung eingefügt wird
            if (isStockAvailable(komponente, teile, menge)) {
                calculatePrice(komponente, teile, menge);
                updateTeilebestand(komponente, teile, menge);
                insertOrderIntoDatabase(teile, menge, lieferant, Double.parseDouble(preisField.getText()), "Pending");

                // Setze das Menge-Feld zurück
                mengeField.setText("");
            } else {
                // Fehlermeldung anzeigen, wenn nicht genügend Teile auf Lager sind
                JOptionPane.showMessageDialog(frame, "Nicht genügend Teile auf Lager.", "Fehler",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Benutzer hat auf "Nein" oder das Schließen des Dialogs geklickt
            // Führe hier Aktionen aus, wenn der Benutzer die Bestellung nicht abschließen möchte

            // Leere die Menge und das Preisfeld
            mengeField.setText("");
            preisField.setText("");
        }
    }

    private boolean isStockAvailable(String komponente, String teile, int menge) {
        try {
            Connection con = dbAccess.getConnection();
            String selectSql = "SELECT bestand FROM db5.teilebestand WHERE " + komponente + " = ?";
            try (PreparedStatement selectPst = con.prepareStatement(selectSql)) {
                selectPst.setString(1, teile);
                ResultSet resultSet = selectPst.executeQuery();

                if (resultSet.next()) {
                    int aktuellerBestand = resultSet.getInt("bestand");
                    return aktuellerBestand >= menge;
                }
            }
        } catch (Exception ex) {
            System.out.println("Fehler beim Überprüfen des Teilebestands: " + ex.getMessage());
        }
        return false;
    }
}