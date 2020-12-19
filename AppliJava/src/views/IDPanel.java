package views;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import java.awt.Desktop;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.*;


import views.FenetreGestionnaire;
import web.*;
import helpers.Palette;
import helpers.Polices;

public class IDPanel extends JPanel{

    public static final String ID_IMAGE_PATH = "./rsc/images/user-icon.png";
    public static final String PSWD_IMAGE_PATH = "./rsc/images/password-icon.png";

    private JTextField idField;
    private JPasswordField pswdField;
    private JButton connexionButton;
    private JButton inscriptionButton;
    private ContPanel contPane;

    public IDPanel(Dimension contentPaneSize, ContPanel contPane){

        this.contPane = contPane;
        this.setBackground(Palette.LIGHT_GREY);
        this.setPreferredSize(new Dimension((int)contentPaneSize.getWidth(), 3*(int)contentPaneSize.getHeight()/5));
        GridBagLayout gblayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gblayout);

        idField = new JTextField();
        idField.setFont(Polices.sansSerif);
        pswdField = new JPasswordField();
        pswdField.setFont(Polices.sansSerif);

        javax.swing.JLabel idLabel = new javax.swing.JLabel(new ImageIcon(IDPanel.ID_IMAGE_PATH));
        idLabel.setLabelFor(idField);
        javax.swing.JLabel pswdLabel = new javax.swing.JLabel(new ImageIcon(IDPanel.PSWD_IMAGE_PATH));
        pswdLabel.setLabelFor(pswdField);

        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.left = 25;
        gbc.insets.right = 25;
        this.add(idLabel, gbc);

        gbc.gridy = 2;
        this.add(pswdLabel, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = gbc.weighty = 1.0;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets.bottom = 15;
        gbc.insets.top = 15;
        this.add(idField, gbc);

        gbc.gridy = 2;
        this.add(pswdField, gbc);

        gbc.insets.left = 15;
        gbc.insets.right = 15;
        gbc.insets.bottom = 10;
        gbc.insets.top = 10;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        this.add(connexionButton = new JButton("Connexion"), gbc);
        connexionButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    String password = new String(pswdField.getPassword());
                    String mail = new String(idField.getText());
                    PostRequest web = new PostRequest();
                    int result = -1;
                    try {
                        result=web.checkPassword(mail, password);
                    } catch(Exception except) {}
                    if (result!=-1) {
                        FenetreGestionnaire fenetre = new FenetreGestionnaire(result);
                        contPane.CloseWindow();

                    }
                    else {
                        System.out.println("L'identification a echoue");
                        contPane.ConnexionErrorMsg();
                        pswdField.setText("");
                    }
                }
            });

        pswdField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String password = new String(pswdField.getPassword());
                String mail = new String(idField.getText());
                PostRequest web = new PostRequest();
                int result = -1;
                try {
                    result=web.checkPassword(mail, password);
                } catch(Exception except) {}
                if (result!=-1) {
                    FenetreGestionnaire fenetre = new FenetreGestionnaire(result);
                    contPane.CloseWindow();

                }
                else {
                    System.out.println("L'identification a echoue");
                    contPane.ConnexionErrorMsg();
                    pswdField.setText("");
                }
            }
        });

        idField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String password = new String(pswdField.getPassword());
                String mail = new String(idField.getText());
                PostRequest web = new PostRequest();
                int result = -1;
                try {
                    result=web.checkPassword(mail, password);
                } catch(Exception except) {}
                if (result!=-1) {
                    FenetreGestionnaire fenetre = new FenetreGestionnaire(result);
                    contPane.CloseWindow();

                }
                else {
                    System.out.println("L'identification a echoue");
                    contPane.ConnexionErrorMsg();
                    pswdField.setText("");
                }
            }
        });

        gbc.gridx = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(inscriptionButton = new JButton("S'inscrire"), gbc);
        inscriptionButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    try {
                        Desktop desktop = java.awt.Desktop.getDesktop();
                        URI oURL = new URI("http://37.58.131.231/register");
                        desktop.browse(oURL);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });


    }

    public String getID(){
        return this.idField.getText();
    }

    public String getPswd(){
        return new String(pswdField.getPassword());
    }
}