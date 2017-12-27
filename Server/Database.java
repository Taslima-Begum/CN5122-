import java.sql.*;

public class Database {
	 Statement st;
	
	public Database() {
		try{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
			st = con.createStatement();
			updateDatabase("DROP TABLE IF EXISTS CRED;");
			updateDatabase("CREATE TABLE CRED(username VARCHAR(15) PRIMARY KEY, password VARCHAR(100));");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	 
	public boolean checkUserName(Credentials c) throws SQLException {
		boolean usernameExists=false;
		ResultSet rs = st.executeQuery("SELECT * FROM CRED;");
		while(rs.next()){
			 if(rs.getString("username").equals(c.getUsername())) {
				 return usernameExists=true; 
			 }
		}
		rs.close();
		return usernameExists;
	}
	
	public boolean checkPassword(Credentials c) throws SQLException {
		boolean match=false;
		if(checkUserName(c)) {
			ResultSet rs = st.executeQuery("SELECT * FROM CRED WHERE username = '"+c.getUsername()+"';");
			while(rs.next()){
				 if(c.getPassword().equals(rs.getString("password"))) {
					 return match=true; 
				 }
			}
			rs.close();
		}
		return match;
	}
	
	public void createRecord(Credentials c) throws SQLException {
		checkUserName(c);
		updateDatabase("INSERT INTO CRED VALUES ('"+c.getUsername()+"','"+c.getPassword()+"');");
	}
	
	public void updateDatabase(String query) throws SQLException{
		int n = st.executeUpdate(query);
	}
	

}
