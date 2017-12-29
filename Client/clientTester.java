package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class clientTester {
	public static void main(String[] args) {
		try {
//			Communication c = new Communication();
//			LoginGUI window = new LoginGUI();
			 ArrayList<String> onlineUsers = new ArrayList<String>();
			 ArrayList<String> offlineUsers=new ArrayList<String>();
			 onlineUsers.add("user1");
			 onlineUsers.add("user2");
			 onlineUsers.add("user3");
			 onlineUsers.add("user4");
			 onlineUsers.add("user5");
			 onlineUsers.add("user6");
			 onlineUsers.add("user7");
			 onlineUsers.add("user8");
			 onlineUsers.add("user9");
			 onlineUsers.add("user10");
			 onlineUsers.add("user11");
			 onlineUsers.add("user12");
			 onlineUsers.add("user13");
			 onlineUsers.add("user14");
			 offlineUsers.add("user15");
			 offlineUsers.add("user16");
			 offlineUsers.add("user17");
			 MainActivityGUI a=new MainActivityGUI(onlineUsers,offlineUsers);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}