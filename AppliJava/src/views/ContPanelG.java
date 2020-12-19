package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import java.io.*;
import java.net.*;
import java.lang.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Properties;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.GridBagConstraints;
import helpers.*;
import web.*;

import buttons.*;


public class ContPanelG extends JPanel{
    
    private int id;
    private String idG;
    private PostRequest web;
    private JPanel titlePan;
    private JLabel textFile;
    private JPanel loginPan;
    private Avatar avatarPan;
    private JPanel groupPan;
    private JPanel filePan;
    private JPanel promoPan;
    private JPanel croixPan;
    private JPanel reducePan;
    private JPanel stockageTextPan;
    private JPanel stockageBarPan;
    private GridBagLayout gbLayout;
    private FlowLayout flwLayout;
    private FenetreGestionnaire fenetre;
    
    public ContPanelG(FenetreGestionnaire fenetre, int id){
        super();
        
        flwLayout = new FlowLayout();
        flwLayout.setVgap(0);
        flwLayout.setHgap(0);
        
        this.fenetre=fenetre;
        this.id=id;
        this.setLayout(null);
        this.buildCroixZone(fenetre);
        this.buildReduceZone(fenetre);
        this.setBackground(Palette.LIGHT_GREY);
        this.buildTitlePanel();
        this.buildAvatarZone();
        this.buildLoginZone();
        this.buildProgressBarStockage();
        this.buildFileChooser();
        this.buildGroupList();
    } 
    
    private void buildGroupList() {
        
        JPanel panEvent = new JPanel(); //Panel ou on place tous les evenements
        JScrollPane scroll = new JScrollPane(panEvent, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(50, 175, 500, 300);
        scroll.setBackground(Palette.DARK_GREY);
        this.add(scroll);//ajout du panel qui contient tous les panel/event
        //on a donc un panel avec dedans des panels/event et une scrollbar sur la gauche
        
        //j'ajoute quelques boutons pour remplir le jpanel
        panEvent.setLayout(new GridLayout(50, 1));
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel nomGroup;
        JButton dlButton;
        JPanel panelGroup;
        String result=null;
        String result2=null;
        String idGroup=null;
        String groupName;

        try {
            result=web.getUserGroups(id);
        } catch (Exception e) {}
        
        String[] parts;
        parts = result.split("\"");
        int taille = 0;
        URL url = null;
        BufferedImage image = null;
        Avatar groupImgPan;
        int j = 0;
        
        for (int i = 1; i < parts.length; i++) {
            
            if (i%2==0) {
                taille=taille+1;
                result = parts[i].replace(":", "");
                result = result.replace("}", "");
                result = result.replace(",", "");
                result = result.replace("{", "");
                result = result.replace("]", "");
                try {

                    idGroup=web.getInfoGroup(result);
                    groupName=web.getGroupName(result);
                    url = new URL(web.getGroupImg(result));
                    image = ImageIO.read(url);
                    groupImgPan = new Avatar();
                    groupImgPan.setLayout(new GridBagLayout());
                    //groupImgPan.setBounds(0, 0, 50, 50); //Génère l'image carré de dimension 20x20, dans le coin en haut à gauche
                    groupImgPan.setPreferredSize(new Dimension(50,50));
                    groupImgPan.setImage(image);
                    groupImgPan.setOpaque(false);
                    panelGroup = new JPanel();
                    panelGroup.setPreferredSize(new Dimension(50, 50));
                    panelGroup.setLayout(new GridBagLayout());
                    nomGroup = new JLabel(""+groupName);
                    System.out.println(nomGroup.getText());
                    nomGroup.setOpaque(false);
                    nomGroup.setFont(Polices.little_arial);
                    dlButton = new JButton("Synchroniser");
                    dlButton.addActionListener(new DLButtonListener(id, idGroup));

                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.gridx=0;
                    gbc.gridy=0;
                    gbc.insets.left = 0;
                    gbc.insets.right = 25;
                    panelGroup.add(groupImgPan, gbc);
                    gbc.gridx=1;
                    panelGroup.add(nomGroup, gbc);
                    gbc.gridx=2;
                    panelGroup.add(dlButton);
                    panEvent.add(panelGroup);
                    
                    j++;

                    if (j%2 == 0){
                        panelGroup.setBackground(Palette.DARK_BLUE);
                        nomGroup.setForeground(Palette.WHITE);
                    }else{
                        panelGroup.setBackground(Palette.LIGHT_BLUE);
                        nomGroup.setForeground(Palette.DARK_BLUE);
                    }
                    
                    
                } catch(Exception e) {}
            }
        }
        setSize(930, 610);//je redimensionne la fenetre
        setVisible(true);
    }
    
    private void buildTitlePanel() {
        titlePan = new JPanel();
        titlePan.setLayout(new GridBagLayout());
        titlePan.setBackground(Palette.DARK_BLUE);
        titlePan.setLocation(0, 30);
        titlePan.setBounds(0, 0, 600, 30);
        this.add(titlePan);
        
        JLabel textTitre1 = new JLabel("IUT");
        textTitre1.setForeground(Palette.WHITE);
        textTitre1.setFont(Polices.little_arial);
        titlePan.add(textTitre1);
        
        JLabel textTitre2 = new JLabel("Drive");
        textTitre2.setForeground(Palette.SAPPHIRE_BLUE);
        textTitre2.setFont(Polices.little_arial);
        titlePan.add(textTitre2);
    }
    
    private void buildCroixZone(FenetreGestionnaire fenetre) {
        BoutonCroix croix = new BoutonCroix(reducePan, fenetre);
        croixPan = new JPanel();
        croixPan.setBackground(Palette.DARK_BLUE);
        croixPan.setLayout(new GridBagLayout());
        croixPan.setBounds(570, 0, 30, 30);
        croixPan.add(croix);
        this.add(croixPan);
    }
    
    private void buildReduceZone(FenetreGestionnaire fenetre) {
        BoutonReduce reduce = new BoutonReduce(reducePan, fenetre);
        reducePan = new JPanel();
        reducePan.setBackground(Palette.DARK_BLUE);
        reducePan.setLayout(new GridBagLayout());
        reducePan.setBounds(540, 0, 30, 30);
        reducePan.add(reduce);
        this.add(reducePan);
    }
    
    private void buildAvatarZone() {
        try {
            URL url = new URL(web.getAvatar(id));
            BufferedImage image = ImageIO.read(url);
            avatarPan = new Avatar();
            avatarPan.setLayout(new GridBagLayout());
            avatarPan.setBounds(20, 50, 100, 100);
            avatarPan.setImage(image);
            this.add(avatarPan);
        } catch(Exception e) {}
        try {
            URL url = new URL(web.getDefaultAvatar());
            BufferedImage image = ImageIO.read(url);
            avatarPan = new Avatar();
            avatarPan.setLayout(new GridBagLayout());
            avatarPan.setBounds(20, 50, 100, 100);
            avatarPan.setImage(image);
            this.add(avatarPan);
        } catch(Exception exc) {}
    }
    
    private void buildLoginZone() {
        loginPan = new JPanel();
        loginPan.setBackground(Palette.LIGHT_GREY);
        loginPan.setLayout(new GridBagLayout());
        loginPan.setBounds(138, 50, 150, 20);
        this.add(loginPan);
        
        try {
            JLabel textLogin = new JLabel(web.getLoginName(id));
            textLogin.setForeground(Palette.DARK_GREY);
            textLogin.setFont(Polices.little_arial);
            loginPan.add(textLogin);
        } catch(Exception e) {}
        
        promoPan = new JPanel();
        promoPan.setBackground(Palette.LIGHT_GREY);
        promoPan.setLayout(new GridBagLayout());
        promoPan.setBounds(150, 75, 90, 16);
        this.add(promoPan);
        
        try {
            JLabel textPromo = new JLabel(web.getPromotion(id));
            textPromo.setForeground(Palette.DARK_GREY);
            textPromo.setFont(Polices.promo);
            promoPan.add(textPromo);
        } catch(Exception e) {}
        
    }
    
    private void buildProgressBarStockage() {
        
        int size=0;
        int maxsize=0;
        try {
            size=web.getSpace(id);
            maxsize=web.getMaxSpace(id);
        } catch (Exception e) {
            System.out.println("Impossible de recuperer l'espace de stockage utilise par l'utilisateur");
        }
        //PANNEAU DE LA BARRE DE STOCKAGE
        stockageBarPan = new JPanel();
        stockageBarPan.setBackground(Palette.DARK_BLUE); //LIGHT_GREY
        stockageBarPan.setLayout(new GridBagLayout());
        stockageBarPan.setBounds(150, 120, 420, 20);
        this.add(stockageBarPan);
        
        //BAR DE STOCKAGE
        JProgressBar progress = new JProgressBar();
        progress.setMaximum(maxsize);
        progress.setStringPainted(true);
        progress.setPreferredSize(new Dimension(420, 20));
        progress.setValue(size);
        stockageBarPan.add(progress);
        
        
        stockageTextPan = new JPanel();
        stockageTextPan.setBackground(Palette.LIGHT_GREY); //LIGHT_GREY
        stockageTextPan.setLayout(new GridBagLayout());
        stockageTextPan.setBounds(150, 90, 420, 30);
        this.add(stockageTextPan);
        
        JLabel stockageText = new JLabel(""+size+" Mo / "+maxsize+" Mo utilises");
        stockageText.setForeground(Palette.SAPPHIRE_BLUE);
        stockageText.setFont(Polices.stockageRestant);
        stockageTextPan.add(stockageText);
    }
    private void buildFileChooser() {
        filePan = new JPanel();
        filePan.setBackground(Palette.DARK_GREY);
        filePan.setLayout(new GridBagLayout());
        filePan.setBounds(310, 50, 260, 30);
        this.add(filePan);
        
        textFile = new JLabel( readInFile("file.emplacement") );
        textFile.setForeground(Palette.SAPPHIRE_BLUE);
        textFile.setFont(Polices.fileChooser);
        filePan.add(textFile);
        textFile.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                openFileChooser();
                
            }
            public void mouseEntered(MouseEvent e){
                
            }
            public void mouseExited(MouseEvent m){
                
            }
            public void mousePressed(MouseEvent m){
                
            }
            public void mouseReleased(MouseEvent m){
                
            }
            
        });
        
    }
    
    private void openFileChooser() {
        JFileChooser choix = new JFileChooser();
        String fileEmplacement = new String();
        String otherFolder;
        choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retour=choix.showOpenDialog(fenetre);
        if(retour==JFileChooser.APPROVE_OPTION){
            //choix.getSelectedFile().getName();
            fileEmplacement=choix.getSelectedFile().getAbsolutePath();
            otherFolder = fileEmplacement + File.separator;
            saveFolderEmplacement(otherFolder);
            textFile.setText(otherFolder);
            
        } else {
            //Mettre une erreur
        }
        
    }
    
    private void saveFolderEmplacement(String emplacement) {
        final Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            prop.setProperty("file.emplacement", emplacement);
            prop.store(output, null);
        } catch (final IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
    
    private int createProperties() {
        String currentUsersHomeDir = System.getProperty("user.home");
        String otherFolder = currentUsersHomeDir + File.separator + "IUTDrive" + File.separator;
        saveFolderEmplacement(otherFolder);
        return 0;
    }
    
    private String readInFile(String clef) {
        String filename = "config.properties";
        String valeur = new String();
        final Properties prop = new Properties();
        
        
        File tmpDir = new File("config.properties");
        if (tmpDir.exists() == false) {
            System.out.println("Le fichier properties n'existe pas " + filename +"\nCreation en cours...");
            if(createProperties()!=0) {
                System.out.println("Probleme: impossible de creer le fichier " + filename+ ".");
            }
            else {
                System.out.println("Fichier properties genere.");
            }
        }
        InputStream input = null;
        try {
            input = new FileInputStream(filename);
            prop.load(input);
            if (clef.equals("file.emplacement")) {
                valeur=prop.getProperty("file.emplacement");
            }
            else if (clef.equals("utilisateur.id")) {
                valeur=prop.getProperty("utilisateur.id");
            }
            else {
                System.out.println("Erreur: Clef " + clef + " introuvable.");
                valeur=null;
            }
        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return valeur;
    }
    
}