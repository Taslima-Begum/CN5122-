package Client;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Message implements Serializable{

    private String type;
    private byte[] b;
    private File file;
    String srcUser;
    String messageBody;
    ArrayList<String> destUsers=new ArrayList<>();
    ArrayList<String> onlineUsers=new ArrayList<>();
    ArrayList<String> offlineUsers=new ArrayList<>();
    String username;
    String password;
    boolean response;
    String chatName;
    String fileName;
    //clientSendingMessages type MESSAGE
    public Message(String type, String srcUser, ArrayList<String> destUsers, String messageBody, String chatName){
		this.type=type;
		this.srcUser=srcUser;
		this.destUsers=destUsers;
		this.messageBody=messageBody;
		this.chatName=chatName;
	}
    //clientLogin type= LOGIN
    public Message(String type, String username, String password){
  		this.type=type;
  		this.username=username;
  		this.password=password;
  	}
    //clientSendFile type=FILE
    public Message(String type, String srcUser, ArrayList<String>destUsers, byte[] file, String fileName, String chatName){
  		this.type=type;
  		this.srcUser=srcUser;
  	}
    
    //serverregister type=REGISTER & type=LOGIN
    public Message(String type, boolean response,String reason){
    	
  	}
    
    //server users type=USER
    public Message(String type , ArrayList<String> onlineUsers,ArrayList<String> offlineUsers){
    	this.onlineUsers=onlineUsers;
   	}
    
    //client userListrequest type=USER
    public Message(String type){
 
   	}

    public String getReason() {
        return this.type;
    }
    public String getType() {
        return this.type;
    }
    
    public String getChatName() {
        return this.chatName;
    }
    
    public ArrayList<String> getOnlineUser(){
    	return this.onlineUsers;
    }
    public ArrayList<String> getOfflineUser(){
    	return this.offlineUsers;
    }
    
    public String getsrcUser() {
        return this.srcUser;
    }
    
    public ArrayList<String> getdestUsers() {
        return this.destUsers;
    }
    
    public byte[] getFileBytes() {
        return this.b;
    }
    
    public String getMessageBody() {
        return this.messageBody;
    }

    public boolean getResponse() {
        return this.response;
    }
    public String getFileName() {
        return this.fileName;
    }


}