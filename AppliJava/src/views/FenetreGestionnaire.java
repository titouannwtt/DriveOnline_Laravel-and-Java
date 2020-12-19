package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenetreGestionnaire extends JFrame {

    public static final int WINDOW_SIZE_X = 600;
    public static final int WINDOW_SIZE_Y = 500;

    public FenetreGestionnaire(int id) {

        super("IUT DRIVE");
        this.setSize(FenetreGestionnaire.WINDOW_SIZE_X, FenetreGestionnaire.WINDOW_SIZE_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        ContPanelG contPanelG = new ContPanelG(this, id);
        this.setContentPane(contPanelG);
        this.setUndecorated(true);
        this.setVisible(true);

		JFrameDragListener frameDragListener = new JFrameDragListener(this);
		this.addMouseListener(frameDragListener);
		this.addMouseMotionListener(frameDragListener);

		this.pack();
		this.setLocationRelativeTo(null);
        this.setSize(FenetreGestionnaire.WINDOW_SIZE_X, FenetreGestionnaire.WINDOW_SIZE_Y);
		this.setVisible(true);

    }

    public static class JFrameDragListener extends MouseAdapter {

	    private final JFrame frame;
	    private Point mouseDownCompCoords = null;
	    private boolean appui = false;

	    public JFrameDragListener(JFrame frame) {
	        this.frame = frame;
	    }

	    public void mouseReleased(MouseEvent e) {
	        mouseDownCompCoords = null;
	        appui=false;
	    }

	    public void mousePressed(MouseEvent e) {
	        mouseDownCompCoords = e.getPoint();
	    }

	    public void mouseDragged(MouseEvent e) {
	    	if((e.getX() <= 540 && e.getY() <= 30) || appui==true) {
		        Point currCoords = e.getLocationOnScreen();
		        appui=true;
		        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
	    	}
	    }
	}
}