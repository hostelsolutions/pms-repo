package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class DBRooms {
	private String query;
	protected Connection conn = null;
	private Statement statement = null;
	protected ResultSet rs = null;
	
	public DBRooms() {
		
	}
	
	public ResultSet generateQuery(String column) {
		
		try {
			
			switch (column) {
			case "floor_1":
				query = "SELECT floor_1 FROM ROOMS";
				break;
			case "floor_2":
				query = "SELECT floor_2 FROM ROOMS";
				break;
			case "floor_3":
				query = "SELECT floor_3 FROM ROOMS";
				break;
			case "floor_4":
				query = "SELECT floor_4 FROM ROOMS";
				break;
			case "floor_5":
				query = "SELECT floor_5 FROM ROOMS";
				break;
				
			}
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			statement = (Statement) conn.createStatement();
			rs = statement.executeQuery(query);
			
		} catch (Exception e) {
			
			System.out.println("Not Connecting");
			
		}
		
		return rs;
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
