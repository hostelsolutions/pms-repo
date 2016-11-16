package hostelsolutions;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class PMSRoomListing extends JFrame implements ActionListener  {
	private JTabbedPane pane = new JTabbedPane();
	
	public PMSRoomListing() {
		super("Available Rooms");
		this.setLocationRelativeTo(null);
		setSize(200, 400);
		
		DBRooms db = new DBRooms(1);
		JTable table1 = new JTable(db.buildTableModel(db.rs));
		db = null;
		db = new DBRooms(2);
		JTable table2 = new JTable(db.buildTableModel(db.rs));
		db = null;
		db = new DBRooms(3);
		JTable table3 = new JTable(db.buildTableModel(db.rs));
		db = null;
		db = new DBRooms(4);
		JTable table4 = new JTable(db.buildTableModel(db.rs));
		db = null;
		db = new DBRooms(5);
		JTable table5 = new JTable(db.buildTableModel(db.rs));
		try {
			db.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table1.setFillsViewportHeight(true);
		table2.setFillsViewportHeight(true);
		table3.setFillsViewportHeight(true);
		table4.setFillsViewportHeight(true);
		table5.setFillsViewportHeight(true);
		
		pane.addTab("Floor 1", table1);
		pane.addTab("Floor 2", table2);
		pane.addTab("Floor 3", table3);
		pane.addTab("Floor 4", table4);
		pane.addTab("Floor 5", table5);
		
		add(pane);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
