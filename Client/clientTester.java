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
//			RegisterGUI a =new RegisterGUI();
			ArrayList<String>online=new ArrayList<String>();
			ArrayList<String>offline=new ArrayList<String>();
			offline.add("bhjvcl");
			offline.add("dfdfbfd");
			offline.add("rr");
			offline.add("tre");
			online.add("erferfer");
			MainActivityGUI a =new MainActivityGUI(online,offline);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}