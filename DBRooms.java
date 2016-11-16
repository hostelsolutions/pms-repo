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
		try {
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			query = "SELECT * FROM ROOMS";
			statement = (Statement) conn.createStatement();
			rs = statement.executeQuery(query);
			
		} catch (Exception e) {
			System.out.println("Not Connecting");
		}
	}
	
	public DBRooms(int tableSelection) {
		try {
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			query = "SELECT * FROM ROOMS";
//			switch (tableSelection) {
//			case 1:
//				query = "SELECT floor_1 FROM ROOMS";
//				break;
//			case 2:
//				query = "SELECT floor_2 FROM ROOMS";
//				break;
//			case 3:
//				query = "SELECT floor_3 FROM ROOMS";
//				break;
//			case 4:
//				query = "SELECT floor_4 FROM ROOMS";
//				break;
//			case 5:
//				query = "SELECT floor_5 FROM ROOMS";
//				break;
//			}
			
			statement = (Statement) conn.createStatement();
			rs = statement.executeQuery(query);
			
		} catch (Exception e) {
			System.out.println("Not Connecting");
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
	
	public DefaultTableModel buildTableModel(ResultSet rs) {
			ResultSetMetaData metaData = this.getMeta();
			
			Vector<String> columns = new Vector<String>();
			Vector<Vector<Object>> rooms = new Vector<Vector<Object>>();
			Vector<Object> vec = new Vector<Object>();
			try {
				int ctr = metaData.getColumnCount();
				System.out.println(ctr);
				for (int i = 1; i <= ctr; i++) {
					columns.add(metaData.getColumnName(i));
				}
				
				while (rs.next()) {
					for (int i = 1; i <= ctr; i++) {
						vec.add(rs.getObject(i));
					}
				}
				rooms.add(vec);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return new DefaultTableModel(rooms, columns);
	}
	
}
