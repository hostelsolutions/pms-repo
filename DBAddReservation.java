package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBAddReservation {

	private Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	private String query;
	
	protected String firstName;
	protected String lastName;
	protected String dateIn;
	protected String dateOut;
	
	
	
	public DBAddReservation() {
		
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			query = "INSERT INTO ARRIVING (?, ?, ?, ?, ?, ?, ?)";
			statement = (PreparedStatement) conn.prepareStatement(query);
			
		} catch (Exception e) {
			
		}
	}
}
