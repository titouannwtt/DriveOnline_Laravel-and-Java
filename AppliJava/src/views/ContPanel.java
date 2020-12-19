package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import helpers.Palette;
import helpers.Polices;

public class ContPanel extends JPanel{

    private JPanel titlePan, msgPan;
    private JLabel labelError;
    private IDPanel IDPan;
    private FenetreConnexion fenetre;
    private FlowLayout flwLayout;

    public ContPanel(Dimension contentPaneSize, FenetreConnexion fenetre){
        super();
        this.fenetre = fenetre;
        flwLayout = new FlowLayout();
        flwLayout.setVgap(0);
        flwLayout.setHgap(0);
        this.setLayout(flwLayout);
        this.setBackground(Palette.DARK_GREY);
        this.buildTitlePanel(contentPaneSize);
        this.buildIDPanel(contentPaneSize);
        this.buildMsgPan(contentPaneSize);


    }

    private void buildTitlePanel(Dimension contentPaneSize){
        titlePan = new JPanel();
        titlePan.setLayout(new GridBagLayout());
        titlePan.setBackground(Palette.DARK_BLUE);
        titlePan.setPreferredSize(new Dimension((int)contentPaneSize.getWidth(), (int)contentPaneSize.getHeight()/5));
        this.add(titlePan);

        JLabel label1 = new JLabel("IUT");
        label1.setForeground(Palette.WHITE);
        label1.setFont(Polices.arial);
        titlePan.add(label1);

        JLabel label2 = new JLabel("Drive");
        label2.setForeground(Palette.SAPPHIRE_BLUE);
        label2.setFont(Polices.arial);
        titlePan.add(label2);
    }

    public void buildIDPanel(Dimension contentPaneSize){
        IDPan = new IDPanel(contentPaneSize, this);
        this.add(IDPan);
    }

    public void buildMsgPan(Dimension contentPaneSize){
        this.msgPan = new JPanel();
        labelError = new JLabel("");
        this.msgPan.setPreferredSize(new Dimension((int)contentPaneSize.getWidth(), (int)contentPaneSize.getHeight()/5 + 20));
        this.msgPan.setBackground(Palette.DARK_BLUE);
        this.msgPan.setOpaque(true);
        this.msgPan.setLayout(new FlowLayout());
        this.add(msgPan);
    }

    public void ConnexionErrorMsg(){

        labelError.setText("L'identification a echoue");
        labelError.setOpaque(false);
        labelError.setFont(Polices.little_arial);
        labelError.setForeground(Palette.WHITE);
        msgPan.add(labelError);
        this.remove(msgPan);
        this.add(msgPan);
        this.validate();

    }

    public void CloseWindow(){
        this.fenetre.dispose();
    }

}
