package Client;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.util.ArrayList;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class chats {
	static ArrayList<chatGUI>listChats= new ArrayList<>();
	
	public static void addchat(chatGUI c) {
		listChats.add(c);
		if(c.getChatType().equals("private"))
			MainActivityGUI.addToPrivateChatList(c);
		else
			MainActivityGUI.addToGroupChatList(c);
		System.out.print(listChats.size());
	}
	
	public static void removechat(chatGUI chatName) {
		listChats.remove(chatName);

	}
	
	public static synchronized void updatechat(String chatName, String srcUser, String message,String alignment) {
		chatGUI chat = getChat(chatName);
		if(alignment.equals("right")) {
			chat.messages.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			chat.messages.append("\n\r" + message + " : " +  srcUser +"\n\r"); 
		}
		if(alignment.equals("left")) {
			chat.messages.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			chat.messages.append("\n\r"+srcUser + ": " + message);
		}
	}
	
	public static boolean chatExists(String chatName) {
		for(chatGUI chat:chats.listChats) {
			if(chat.getFullChatName().equals(chatName)) {
				return true;
			}
		}
		return false;
	}
	
	public static chatGUI getChat(String chatName) {
		for(chatGUI chat:chats.listChats) {
			if(chat.getFullChatName().equals(chatName)) {
				return chat;
			}
		}
		return null;
	}
}