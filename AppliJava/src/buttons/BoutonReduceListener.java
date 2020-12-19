package buttons;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;

import views.*;

public class BoutonReduceListener implements MouseListener {

    private BoutonReduce bouton;
    private FenetreGestionnaire fenetre;

    public BoutonReduceListener(BoutonReduce bouton, FenetreGestionnaire fenetre) {
        this.bouton = bouton;
        this.fenetre = fenetre;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        fenetre.setState(Frame.ICONIFIED);
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
