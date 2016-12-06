package hostelsolutions;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBAddReservation {

	private Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	private String query;
	
	protected String firstName;
	protected String lastName;
	protected String dateIn;
	protected String dateOut;
	private String ID;
	
	public DBAddReservation(String first, String last, String dateI, String dateO, String rNum) {
		
		PMSIDSystem IDCreate = new PMSIDSystem();
		ID = IDCreate.returnID();
		firstName = first;
		lastName = last;
		dateIn = dateI;
		dateOut = dateO;
		
		// should have roomtype/room num from the button menu 
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doggo","root","root");
			query = "INSERT INTO ARRIVING (id_num, last_name, first_name, room_num, room_type, "
					+ "date_in, date_out) VALUES (?, ?, ?, ?, ?, ?, ?)";
			statement = (PreparedStatement) conn.prepareStatement(query);
			statement.setString(1, ID); 
			statement.setString(2,lastName);
			statement.setString(3,firstName);
			statement.setString(4,"22"); //room num
			statement.setString(5,"coolroom"); //room type
			statement.setString(6,dateIn);
			statement.setString(7,dateOut);
			statement.execute();
		} catch (Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
	}
}
