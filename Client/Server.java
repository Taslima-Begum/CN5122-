package Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server {
	public static void main(String[] args) {
		// create socket with PORT_NO
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			Socket s = serverSocket.accept();
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message c =(Message) ois.readObject(); ;
			System.out.println(c.getType());
			Message u =(Message) ois.readObject(); ;
			System.out.println(u.getType());
			ois.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       	}
}
