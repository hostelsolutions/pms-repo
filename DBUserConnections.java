package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
public class DBUserConnections {

	protected Connection conn = null;
	protected Statement statement = null;
	protected PreparedStatement stmt = null;
	protected String query = "";
	private String userName;
	private String password;
	private ResultSet rs = null;
 	protected boolean isAdmin = false;
 	String adminVal;
 	
	public DBUserConnections(String user, String pass) {
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			userName = user;
			password = pass;
			query = "SELECT * FROM LOGIN";
			statement = (Statement) conn.createStatement();
			rs = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println("Not Connecting");
		}
	}
	
	public DBUserConnections(String user, String pass, boolean isAdmin) {
		
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			userName = user;
			password = pass;
			this.isAdmin = isAdmin;
			
		} catch (Exception e) {
			System.out.println("Not Connecting");
		}
	}

	public boolean isValidated() {
		try {
			
			while (rs.next()) {
				if (rs.getString("username").equals(userName) && rs.getString("password").equals(password)) {
					if (rs.getString("admin").equals("1")) {
						isAdmin = true;
					}
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void addUser() {
		
		try {
			query = "INSERT INTO LOGIN (username, password, admin) VALUES (?, ?, ?)";
			stmt = (PreparedStatement) conn.prepareStatement(query);
			
			stmt.setString(1, userName);
			stmt.setString(2, password);
			if (isAdmin) {
				stmt.setInt(3, 1);
			} else if (!isAdmin) {
				stmt.setInt(3, 0);
			}
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
