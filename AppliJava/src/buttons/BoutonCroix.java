package buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import views.*;

public class BoutonCroix extends JLabel{

    private ImageIcon imgBoutonNormal = new ImageIcon("rsc/images/croix.png");
    private ImageIcon imgBoutonHover = new ImageIcon("rsc/images/croix_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("rsc/images/croix_press.png");
    private FenetreGestionnaire fenetre;

    private JPanel panListClient;

    public BoutonCroix(JPanel pan, FenetreGestionnaire fenetre) {
        super();
        this.setIcon(imgBoutonNormal);
        this.panListClient = pan;
        this.fenetre=fenetre;
        this.addMouseListener(new BoutonCroixListener(this, fenetre));
    }

    public void setHovered(){

        this.setIcon(imgBoutonHover);
        this.repaint();
    }

    public void setPressed(){
        this.setIcon(imgBoutonPress);
        this.repaint();
    }

    public void setNormal(){
        this.setIcon(imgBoutonNormal);
        this.repaint();
    }
}
