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

	public static synchronized void addchat(chatGUI c) {
		listChats.add(c);
		if(c.getChatType().equals("private"))
			MainActivityGUI.addToPrivateChatList(c);
		else
			MainActivityGUI.addToGroupChatList(c);
	}

	public static void removechat(chatGUI chatName) {
		listChats.remove(chatName);
	}

	public static synchronized void updatechat(String chatName, String srcUser, String message,ComponentOrientation alignment) {
		chatGUI chat = getChat(chatName);
		chat.setMessagesOrientation(alignment);
		if(!alignment.isLeftToRight()) {
			chat.setMessages(message + " : " +  srcUser); 
		}
		if(!alignment.isLeftToRight()) {
			chat.setMessages(srcUser + ": " + message);
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