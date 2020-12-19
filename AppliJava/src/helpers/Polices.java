package helpers;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GraphicsEnvironment;
import java.awt.BorderLayout;
import java.awt.Font;


public class Polices{
    public static final Font arial = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 40);
    public static final Font sansSerif = new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 15);
    public static final Font little_arial = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);
    public static final Font promo = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 13);
    public static final Font loginName = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15);   
    public static final Font fileChooser = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 11);   
    public static final Font stockageRestant = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 13);

    // Methode permettant d'afficher les fontes disponibles dans une fenetre

    public static void ListeFontes() {
        JFrame fontFrame = new JFrame();
        GraphicsEnvironment gE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] liste = gE.getAvailableFontFamilyNames();
        JLabel label;
        JPanel panneau = new JPanel();
    
        panneau.setLayout(new GridLayout(20, 0, 10, 0));
        for (String nom : liste) {
            label = new JLabel();
            label.setFont(new Font(nom, Font.PLAIN, 18));
            label.setText(nom);
            panneau.add(label);
        } 
        fontFrame.add(new JScrollPane(panneau), BorderLayout.CENTER);
    
        fontFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fontFrame.setSize(500, 500);
        fontFrame.setLocation(100, 100);
        fontFrame.setVisible(true);
    }
}