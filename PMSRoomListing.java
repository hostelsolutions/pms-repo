package hostelsolutions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class PMSRoomListing extends JFrame implements ActionListener  {
	private JTabbedPane pane = new JTabbedPane();
	private DBRooms db = new DBRooms();
	private JTable table1 = new JTable(buildTableModel(db.generateQuery("floor_1")));
	private JTable table2 = new JTable(buildTableModel(db.generateQuery("floor_2")));
	private JTable table3 = new JTable(buildTableModel(db.generateQuery("floor_3")));
	private JTable table4 = new JTable(buildTableModel(db.generateQuery("floor_4")));
	private JTable table5 = new JTable(buildTableModel(db.generateQuery("floor_5")));
	protected String roomNum;
	private JButton ok = new JButton("OK");
	private JPanel btn = new JPanel();
	
	public PMSRoomListing() {
		super("Available Rooms");
		this.setLocationRelativeTo(null);
		setSize(200, 400);
		btn.setLayout(new FlowLayout());
		btn.add(ok);
		
		table1.setFillsViewportHeight(true);
		table2.setFillsViewportHeight(true);
		table3.setFillsViewportHeight(true);
		table4.setFillsViewportHeight(true);
		table5.setFillsViewportHeight(true);
		
		table1.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				roomNum = table1.getValueAt(table1.getSelectedRow(), table1.getSelectedColumn()).toString();
			}
		});
		pane.addTab("Floor 1", table1);
		pane.addTab("Floor 2", table2);
		pane.addTab("Floor 3", table3);
		pane.addTab("Floor 4", table4);
		pane.addTab("Floor 5", table5);
		
		add(pane);
		add(btn, BorderLayout.SOUTH);
		ok.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		if (pane.getSelectedIndex() == 1) {
//			roomNum = table1.getValueAt(table1.getSelectedRow(), table1.getSelectedColumn()).toString();
//		}
//		if (pane.getSelectedIndex() == 2) {
//			roomNum = table2.getValueAt(table2.getSelectedRow(), table2.getSelectedColumn()).toString();
//		}
//		if (pane.getSelectedIndex() == 3) {
//			roomNum = table3.getValueAt(table3.getSelectedRow(), table3.getSelectedColumn()).toString();
//		}
//		if (pane.getSelectedIndex() == 4) {
//			roomNum = table4.getValueAt(table4.getSelectedRow(), table4.getSelectedColumn()).toString();
//		}
//		if (pane.getSelectedIndex() == 5) {
//			roomNum = table5.getValueAt(table5.getSelectedRow(), table5.getSelectedColumn()).toString();
//		}
		
		if (e.getSource() == ok) {
			this.setVisible(false);
		}
		
	}
	
	
	
	public DefaultTableModel buildTableModel(ResultSet rs) {
		ResultSetMetaData metaData = db.getMeta();
		
		Vector<String> columns = new Vector<String>();
		Vector<Vector<Object>> rooms = new Vector<Vector<Object>>();
		
		try {
			int ctr = metaData.getColumnCount();
			System.out.println(ctr);
			for (int i = 1; i <= ctr; i++) {
				columns.add(metaData.getColumnName(i));
			}
			
			while (rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for (int i = 1; i <= ctr; i++) {
					vec.add(rs.getObject(i));
				}
				rooms.add(vec);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(rooms, columns);
}
	
	
}
