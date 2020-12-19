package views;

import javax.swing.*;

public class FenetreConnexion extends JFrame{

    // Constantes pour la taille de la fenetre
    public static final int WINDOW_SIZE_X = 400;
    public static final int WINDOW_SIZE_Y = 400;

    public FenetreConnexion(){

        super("IUT DRIVE");
        this.pack();
        this.setSize(FenetreConnexion.WINDOW_SIZE_X, FenetreConnexion.WINDOW_SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        ContPanel contPanel = new ContPanel(this.getContentPane().getSize(), this);
        this.setContentPane(contPanel);
        this.setVisible(true);

    }
}