package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBCancelReservation {

	private Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	private String sqlSelect;
	private String sqlDelete;
	private String sqlInsert;
	
	protected String uID;
	protected String firstName;
	protected String lastName;
	protected String dateCancelled;
	protected String roomType;


	// need timestamp of time cancelled
	public DBCancelReservation(String ID) {
		uID = ID;
	}
	
	public void cancelRes(){
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			conn.setAutoCommit(false); //transaction block start
			
			sqlSelect = "SELECT * FROM ARRIVING WHERE id_num = ?";
			statement = (PreparedStatement) conn.prepareStatement(sqlSelect);
			statement.setString(1, uID);
			rs = statement.executeQuery();
			while(rs.next()){
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				roomType = rs.getString("room_type");
				
				// time it is cancelled
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				dateCancelled = timestamp.toString();
			}
			
			sqlInsert = "INSERT INTO CANCELLATIONS (id_num, last_name, first_name, room_type, cancelled_on)"
					+ " VALUES (?, ?, ?, ?, ?)";
			statement = (PreparedStatement) conn.prepareStatement(sqlInsert);
			statement.setString(1, uID);
			statement.setString(2, lastName);
			statement.setString(3, firstName);
			statement.setString(4, roomType);
			statement.setString(5, dateCancelled);
			statement.execute();
			
			sqlDelete = "DELETE FROM ARRIVING WHERE id_num = ?";
			statement = (PreparedStatement) conn.prepareStatement(sqlDelete);
			statement.setString(1, uID);
			statement.executeUpdate();
			conn.commit(); //transaction block end
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
