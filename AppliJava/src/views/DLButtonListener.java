

package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class DLButtonListener implements ActionListener{

    private PostRequest web;
    private int id;
    private String idGroup;

    public DLButtonListener(int id, String idGroup){
        this.id = id;
        this.idGroup = idGroup;
    }

    public void actionPerformed(ActionEvent e){
    	try {
    		//System.out.println(""+id+" "+idGroup+"");
	        String[] parts;
	        parts = idGroup.split("\"");
			idGroup = parts[2].replace(":", "");
			idGroup = idGroup.replace("}", "");
			idGroup = idGroup.replace(",", "");
			idGroup = idGroup.replace("{", "");
			idGroup = idGroup.replace("]", "");
        	web.downloadGroupFile(id, idGroup);
        } catch (Exception err) {}
    }

}