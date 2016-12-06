package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class DBInHouse extends DBConnection{
	private Connection conn = null;
	private Statement statement = null;
	private String query;
	protected ResultSet rs = null;
	
	public DBInHouse() {
		try {
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			query = "SELECT * FROM IN_HOUSE";
			statement = (Statement) conn.createStatement();
			rs = statement.executeQuery(query);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	
	public ResultSetMetaData getMeta() {
		try {
			return (ResultSetMetaData) rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
