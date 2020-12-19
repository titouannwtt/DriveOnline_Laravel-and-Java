package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;


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

public class PostRequest {

	private static final String USER_AGENT = "Mozilla/5.0";


	public static String getGroupImg(String idGroup) throws IOException  {
        String result=null;
        String post_url = "http://37.58.131.231/daemon/getGroupById";
        String post_params = "id="+idGroup;
        result=sendPOST(post_url, post_params);
        String[] parts = result.split("\"");
        result = ""+parts[11].replace("\\", "");
        String[] parts2 = result.split("/revision");
        result = parts2[0];
        if(result.contains("/storage/.images/")) {
            result= "http://37.58.131.231"+result;
        }
        return result;
        
    }

    public static String getGroupName(String idGroup) throws IOException  {
        String result=null;
        String post_url = "http://37.58.131.231/daemon/getGroupById";
        String post_params = "id="+idGroup;
        result=sendPOST(post_url, post_params);
        String[] parts = result.split("\"");
        result = ""+parts[7];
        return result;
        
    }

	public static String getLoginName(int id) throws IOException  {
		String result=null;
		String arg="name";
		String post_url = "http://37.58.131.231/daemon/getSomethingOfUser";
		String post_params = "something="+arg+"&id="+id;
		result=sendPOST(post_url, post_params);
		String[] parts = result.split("\"");
		result = parts[3];
		return result;
	}

	public static String getPromotion(int id) throws IOException  {
		String result=null;
		String arg="promotion";
		String post_url = "http://37.58.131.231/daemon/getSomethingOfUser";
		String post_params = "something="+arg+"&id="+id;
		result=sendPOST(post_url, post_params);
		String[] parts = result.split("\"");
		result = parts[3];
		return result;
	}

	public static String getDefaultAvatar() throws IOException {
		String result="http://37.58.131.231/storage/.images/users/0.png";
		return result;
	}

	public static int getSpace(int id) throws IOException {
		int x = 0;
		String result=null;
		String arg="size_used";
		String post_url = "http://37.58.131.231/daemon/getSomethingOfUser";
		String post_params = "something="+arg+"&id="+id;
		try {
			result=sendPOST(post_url, post_params);
			String[] parts = result.split(":");
			result = parts[1].replace("}]", "");
		}
		catch(Exception e) {
			result = "0";
		}
		x=Integer.parseInt(result);
		x=x/1000000;
		return x;
	}


	public static String downloadGroupFile(int id, String idGroup) throws IOException  {
		String url=null;
		String post_url = "http://37.58.131.231/daemon/getFolder";
		String post_params = "id_user="+id+"&id_group="+idGroup;
		url=sendPOST(post_url, post_params);
		url= "http://"+url;
			try {
				BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream(readInFile("file.emplacement")+File.separator+""+idGroup+"_"+getGroupName(idGroup));
				byte dataBuffer[] = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					fileOutputStream.write(dataBuffer, 0, bytesRead);
				}

				Process process;
				String string = readInFile("file.emplacement")+""+idGroup+"_"+getGroupName(idGroup);
				process = Runtime.getRuntime().exec("unzip *", null);
			} catch (IOException e) {
			    // handle exception
			}
		return url;
	}

	
    public static String readInFile(String clef) {
        String filename = "config.properties";
        String valeur = new String();
        final Properties prop = new Properties();
        
        
        File tmpDir = new File("config.properties");
        if (tmpDir.exists() == false) {
            System.out.println("Le fichier properties n'existe pas " + filename +"\nCreation en cours...");
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
    

	public static int getMaxSpace(int id) throws IOException {
		int x = 0;
		String result=null;
		String arg="size_max";
		String post_url = "http://37.58.131.231/daemon/getSomethingOfUser";
		String post_params = "something="+arg+"&id="+id;
		try {
			result=sendPOST(post_url, post_params);
			String[] parts = result.split(":");
			result = parts[1].replace("}]", "");
		}
		catch(Exception e) {
			result = "0";
		}
		x=Integer.parseInt(result);
		x=x/1000000;
		return x;
	}

	public static String getAvatar(int id) throws IOException  {
		String result=null;
		String arg="image";
		String post_url = "http://37.58.131.231/daemon/getSomethingOfUser";
		String post_params = "something="+arg+"&id="+id;
		try {
			result=sendPOST(post_url, post_params);
			String[] parts = result.split("\"");
			result = "http://37.58.131.231"+parts[3].replace("\\", "");
		}
		catch(Exception e) {
			result = "http://37.58.131.231/storage/.images/users/0.png";
		}
		return result;
		
	}

	public static String getInfoGroup(String idGroup) throws IOException  {
		String result=null;
		String post_url = "http://37.58.131.231/daemon/getGroupById";
		String post_params = "id="+idGroup;
		result=sendPOST(post_url, post_params);
		return result;
	}

	public static String getUserGroups(int id) throws IOException  {
		String result=null;
		String post_url = "http://37.58.131.231/daemon/getUserGroups";
		String post_params = "id="+id;
		result=sendPOST(post_url, post_params);
		return result;
	}

	public static int checkPassword(String mail, String password) throws IOException  {
		String result=null;
		String post_url = "http://37.58.131.231/daemon/login";
		String post_params = "mail="+mail+"&"+"password="+password;
		result=sendPOST(post_url, post_params);
		int resultINT = Integer.parseInt(result);
		return resultINT;
	}

	public static String sendPOST(String post_url, String post_params) throws IOException {
		URL obj = new URL(post_url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(post_params.getBytes());
		os.flush();
		os.close();

		int responseCode = con.getResponseCode();

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();
		} else {
			System.out.println("Une erreur est survenu dans la requete");
			return "error";
		}

	}

}
