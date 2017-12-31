<<<<<<< HEAD

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientTester {
	public static void main(String[] args) {
		try {
//			Socket s = new Socket(args[0], Integer.parseInt(args[1]));
//		
//			MainActivityGUI window = new MainActivityGUI();
			Communication c = new Communication();
			LoginGUI window = new LoginGUI();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
	}
=======
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
>>>>>>> ce77366b3ec70f731b58bae5fa0255ec2e23d551
}