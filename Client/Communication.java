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
package Client;

import java.awt.ComponentOrientation;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Communication {
	private static Socket s;
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;

	public Communication() {
		try {
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("properties.prop");
			p.load(fis);
			fis.close();
			s = new Socket(p.getProperty("SERVERIPADDRESS"),Integer.parseInt(p.getProperty("PORT")));
			ois=new ObjectInputStream(s.getInputStream());
			while(!s.isClosed()) {
				receive();
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void send(Message m) {
		try {
			oos.writeObject(m);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void receive() {
		try {
			oos = new ObjectOutputStream(s.getOutputStream());
			Message m= (Message)ois.readObject();
			readMessage(m);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readMessage(Message m) {
		switch(m.getType()) {
		case "LOGIN" :
			if(m.getResponse()) {
				LoginGUI.frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "Logging in......", "", JOptionPane.INFORMATION_MESSAGE);
				Communication.send(new Message("USERS"));
			}
			if(!m.getResponse()) {
				JOptionPane.showMessageDialog(null, m.getReason(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "REGISTER" :
			if(m.getResponse()) {
				JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
				LoginGUI.frame.setVisible(true);
			}
			if(!m.getResponse()) {
				JOptionPane.showMessageDialog(null, m.getReason(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;		
		case "MESSAGE" :
			if(chats.chatExists(m.getChatName())) {
				chats.updatechat(m.getChatName(),m.getsrcUser(),m.getMessageBody(),ComponentOrientation.LEFT_TO_RIGHT);
			}
			else {
				chatGUI q = new chatGUI(m.getChatName(), m.getdestUsers());
				chats.addchat(q);
				chats.updatechat(m.getChatName(),m.getsrcUser(),m.getMessageBody(),ComponentOrientation.LEFT_TO_RIGHT);	
			}
			chats.getChat(m.getChatName()).newMessage();
			break;
		case "FILE" :
			byte[]fileBytes=m.getFileBytes();
			try {
				File f = new File(m.getFileName());
				BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(f));
				for(byte a:fileBytes) {
					bos.write(a);
				}
				bos.flush();
				bos.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "USERS" :
			LoginGUI.frame.dispose();
			MainActivityGUI window = new MainActivityGUI(m.getOnlineUser(),m.getOfflineUser());
		}
	}	

	public static void closeConnection(){
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
>>>>>>> ce77366b3ec70f731b58bae5fa0255ec2e23d551
}