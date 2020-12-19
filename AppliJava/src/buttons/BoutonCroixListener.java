package buttons;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import views.*;

public class BoutonCroixListener implements MouseListener {

    private BoutonCroix bouton;
    private FenetreGestionnaire fenetre;

    public BoutonCroixListener(BoutonCroix bouton, FenetreGestionnaire fenetre) {
        this.bouton = bouton;
        this.fenetre = fenetre;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        ImageIcon img = new ImageIcon("rsc/images/croix.png");
        int input = JOptionPane.showConfirmDialog(
            fenetre, "Souhaitez-vous fermer le micro-logiciel ?\nVos fichiers ne seront plus synchronises.", "Neutraliser IUT-Drive ?",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.NO_OPTION, img);
        if(input == JOptionPane.YES_OPTION) System.exit(0);
        if(input == JOptionPane.NO_OPTION);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.bouton.setPressed();

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.bouton.setNormal();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        this.bouton.setHovered();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        this.bouton.setNormal();
    }
}
