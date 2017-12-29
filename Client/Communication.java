<<<<<<< HEAD

import java.io.*;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Communication {
	static Socket s;
	public Communication() {
		
		try {
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("properties.prop");
			p.load(fis);
			fis.close();
			s = new Socket(p.getProperty("SERVERIPADDRESS"),Integer.parseInt(p.getProperty("PORT")));
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void send(Message m) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void receive() {
		try {
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			BufferedInputStream bis = new BufferedInputStream(ois);
			Message m= (Message)ois.readObject();
			readMessage(m);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readMessage(Message m) {
		switch(m.getType()) {
			case "LOGIN" :
				if(m.getResponse()) {
					LoginGUI.frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "Logging in......", "", JOptionPane.INFORMATION_MESSAGE);
					Message a = new Message("USERS");
					Communication.send(a);
				}
				if(!m.getResponse()) {
					JOptionPane.showMessageDialog(null, m.getReason(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "REGISTER" :
				if(m.getResponse()) {
					LoginGUI a = new LoginGUI();
				}
				if(!m.getResponse()) {
					JOptionPane.showMessageDialog(null, m.getReason(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;		
			case "MESSAGE" :
				for(chatGUI a:chats.listChats) {
					if(a.getChatName().equals(m.getChatName())) {
						chats.updatechat(a,m.getsrcUser(),m.getMessageBody());
					}
				}
				break;
			case "USERS" :
				MainActivityGUI window = new MainActivityGUI(m.getOnlineUser(),m.getOfflineUser());
		}
	}	
=======

import java.io.*;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Communication {
	static Socket s;
	public Communication() {
		
		try {
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("properties.prop");
			p.load(fis);
			fis.close();
			s = new Socket(p.getProperty("SERVERIPADDRESS"),Integer.parseInt(p.getProperty("PORT")));
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void send(Message m) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void receive() {
		try {
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			BufferedInputStream bis = new BufferedInputStream(ois);
			Message m= (Message)ois.readObject();
			readMessage(m);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readMessage(Message m) {
		switch(m.getType()) {
			case "LOGIN" :
				if(m.getResponse()) {
					LoginGUI.frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "Logging in......", "", JOptionPane.INFORMATION_MESSAGE);
					Message a = new Message("USERS");
					Communication.send(a);
				}
				if(!m.getResponse()) {
					JOptionPane.showMessageDialog(null, m.getReason(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "REGISTER" :
				if(m.getResponse()) {
					LoginGUI a = new LoginGUI();
				}
				if(!m.getResponse()) {
					JOptionPane.showMessageDialog(null, m.getReason(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;		
			case "MESSAGE" :
				for(chatGUI a:chats.listChats) {
					if(a.getChatName().equals(m.getChatName())) {
						chats.updatechat(a,m.getsrcUser(),m.getMessageBody());
					}
				}
				break;
			case "USERS" :
				MainActivityGUI window = new MainActivityGUI(m.getOnlineUser(),m.getOfflineUser());
		}
	}	
>>>>>>> a0fa085f58d915215188a0bb98f0e2bb8742b9f0
}