package buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import views.*;

public class BoutonReduce extends JLabel{

    private ImageIcon imgBoutonNormal = new ImageIcon("rsc/images/reduce.png");
    private ImageIcon imgBoutonHover = new ImageIcon("rsc/images/reduce_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("rsc/images/reduce_press.png");

    private JPanel panListClient;
    private FenetreGestionnaire fenetre;

    public BoutonReduce(JPanel pan, FenetreGestionnaire fenetre) {
        super();
        this.setIcon(imgBoutonNormal);
        this.panListClient = pan;
        this.fenetre=fenetre;
        this.addMouseListener(new BoutonReduceListener(this, fenetre));
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
