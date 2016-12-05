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
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class PMSRemoveUser extends JFrame implements ActionListener {

	private JTabbedPane pane1 = new JTabbedPane();
	private JButton remove = new JButton("Remove...");
	private JButton cancel = new JButton("Cancel");
	private JPanel btnPane = new JPanel();
	private DBUserConnections db = new DBUserConnections();
	
	
	public PMSRemoveUser() {
		super("Remove User");
		setSize(300, 125);
		
		btnPane.setLayout(new FlowLayout());
		JTable table1 = new JTable(constructTableModel(db.rs));
		table1.setFillsViewportHeight(true);
		pane1.addTab("Users", table1);
		
		btnPane.add(cancel);
		btnPane.add(remove);
		
		add(pane1, BorderLayout.CENTER);
		add(btnPane, BorderLayout.SOUTH);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public DefaultTableModel constructTableModel(ResultSet rs) {
		ResultSetMetaData metaData = db.getMeta();
		
		Vector<String> columns = new Vector<String>();
		Vector<Vector<Object>> reservations = new Vector<Vector<Object>>();
		
		
		try {
			int ctr = metaData.getColumnCount();
			for (int i = 1; i <= ctr; i++) {
				columns.add(metaData.getColumnName(i));
			}
			
			while (rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for (int i = 1; i <= ctr; i++) {
					vec.add(rs.getObject(i));
				}
				reservations.add(vec);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(reservations, columns);
	}
		
	

}
