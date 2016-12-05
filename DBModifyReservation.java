package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBModifyReservation {

	private Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	private String sqlSelect;
	private String sqlModify;

	protected String firstName;
	protected String lastName;
	protected String dateIn;
	protected String dateOut;
	protected String roomNum;
	protected String roomType;
	protected String uID;

	public DBModifyReservation(String ID) {
		uID = ID;
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
				roomNum = rs.getString("room_num");
				dateIn = rs.getString("date_in");
				dateOut = rs.getString("date_out");
			}

		} catch (Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
	}

	public void modData(String lName, String fName, String rType, String rNum, String dIn, String dOut){
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			conn.setAutoCommit(false); //transaction block start

			sqlModify = "Update Arrivals SET last_name = ?, first_name = ?,"
					+ " + room_type = ?, room_num = ?, date_in = ?, date_out = ? where id_num = ?";
			statement = (PreparedStatement) conn.prepareStatement(sqlModify);
			statement.setString(7, uID);
			statement.setString(1, lName);
			statement.setString(2, fName);
			statement.setString(3, rType);
			statement.setString(4, rNum);
			statement.setString(5, dIn);
			statement.setString(6, dOut);

		}catch (Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
	}
}
