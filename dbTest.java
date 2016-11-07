package hostelsolutions;

import java.sql.*;
import java.util.Scanner;

public class dbTest {

    // Database credentials
    static final String USER = "username"; // Unused currently
    static final String PASS = "password"; // Unused currently

    public static void main(String[] args) throws SQLException {

        // Slowly replacing with preparedStatement
        Statement stmt = null;

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql;

        String insertTableSQL = " INSERT INTO EMPLOYEES " + " (first,last,ID)"
                + " values (?, ?, ?)";

        try {
            // STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:h2:~/doggo", "sa", "");

            // Queries

            System.out.println("Creating database...");
            stmt = conn.createStatement();

            // Create table is method, will throw exception if already exists
            createTable("Employees", conn);

            /**
             * Need a method for this, also need to check for same values Look
             * at insertTableSQL string to understand how the values are being
             * placed with these statements, 1 is in the first col (first name),
             * 2 is 2nd col, 3 is 3rd col
             */
            preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, "Barney");
            preparedStatement.setString(2, "Rubble");
            preparedStatement.setInt(3, 1);

            preparedStatement.execute();

            // Selects first and last from the table
            sql = "SELECT * FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String first = rs.getString("first");
                String last = rs.getString("last");
                String id = rs.getString("id");
                // Display values
                System.out.print("First: " + first);
                System.out.print(", Last: " + last);
                System.out.println(", ID: " + id);
            }
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }// end main

    private static void createTable(String table, Connection conn)
            throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + table
                + "  (First           VARCHAR(255),"
                + "   Last            VARCHAR(255),"
                + "   ID          	      Integer)";

        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }

}// end FirstExample
