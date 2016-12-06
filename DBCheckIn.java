package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBCheckIn extends DBConnection {
	private Connection conn = null;
	private PreparedStatement statement = null;
	protected ResultSet rs = null;
	private String sqlSelect;
	private String sqlDelete;
	private String sqlInsert;

	protected String uID;
	protected String firstName;
	protected String lastName;
	protected String roomType;
	protected String roomNum;
	protected String checkI;
	protected String checkO;

	// need timestamp of time cancelled
	public DBCheckIn(String ID) {
		uID = ID;
	}

	public void checkIn() {
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo", "root", "root");
			conn.setAutoCommit(false); // transaction block start

			sqlSelect = "SELECT * FROM ARRIVING WHERE id_num = ?";
			statement = (PreparedStatement) conn.prepareStatement(sqlSelect);
			statement.setString(1, uID);
			rs = statement.executeQuery();
			while (rs.next()) {
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				roomNum = rs.getString("room_num");
				roomType = rs.getString("room_type");
				checkI = rs.getString("date_in");
				checkO = rs.getString("date_out");
			}
			sqlSelect = "SELECT * FROM in_house WHERE id_num = ?";
			statement = (PreparedStatement) conn.prepareStatement(sqlSelect);
			statement.setString(1, uID);
			rs = statement.executeQuery();

			if (!rs.next()) {
				sqlInsert = "INSERT INTO in_house (id_num, last_name, first_name, room_num, room_type, date_in, date_out)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
				statement = (PreparedStatement) conn.prepareStatement(sqlInsert);
				statement.setString(1, uID);
				statement.setString(2, lastName);
				statement.setString(3, firstName);
				statement.setString(4, roomNum);
				statement.setString(5, roomType);
				statement.setString(6, checkI);
				statement.setString(7, checkO);
				statement.execute();
			}

			sqlDelete = "DELETE FROM ARRIVING WHERE id_num = ?";
			statement = (PreparedStatement) conn.prepareStatement(sqlDelete);
			statement.setString(1, uID);
			statement.executeUpdate();
			conn.commit(); // transaction block end

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSetMetaData getMeta() {
		try {
			return (ResultSetMetaData) rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
