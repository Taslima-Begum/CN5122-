
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class chats {
	static ArrayList<chatGUI>listChats= new ArrayList<>();
	
	public static void addchat(chatGUI c) {
		listChats.add(c);
		MainActivityGUI.d.addElement(c);
		System.out.print(listChats.size());
	}
	
	public static synchronized void updatechat(chatGUI chat, String srcUser, String message) {
		chat.messages.append(srcUser + ": " + message);
	}
	
}