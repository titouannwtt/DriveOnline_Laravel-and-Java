package helpers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Avatar extends JPanel {
 
		private BufferedImage image;
 
		public void setImage(BufferedImage image) {
			this.image=image;
			repaint();
		}
 
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if ( image!=null ) {
				final double width;
				final double height;
				if ( image.getWidth()>image.getHeight() ) {
					final double scale = (getWidth()*1f)/image.getWidth();
					width = getWidth();
					height = image.getHeight()*scale;
				}
				else {
					final double scale = (getHeight()*1f)/image.getHeight();
					height = getHeight();
					width = image.getWidth()*scale;
				}
				final double x = (getWidth()-width)/2;
				final double y = (getHeight()-height)/2;
				g.drawImage(image, (int)x, (int)y, (int)width, (int)height, this);
			}
		}
 
	}