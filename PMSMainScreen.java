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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class PMSMainScreen extends JFrame implements ActionListener {
	private String[] columns = {"ID", "Last Name", "First Name", "Room #", "Room Type", "Date In", "Date Out"};
	private Object[][] testData = {
			{new Integer(12), "Guo", "Dahai", new Integer(204), "King", "12/13/2016", "12/14/2016"},
			{new Integer(13), "Marsh", "Alex", new Integer(401), "Jr. Suite", "11/24/2016", "01/31/2017"},
			{new Integer(14), "Res", "Test", new Integer(1211), "King", "11/01/2016", "11/02/2016"}
	};
	private JTable table2 = new JTable(testData, columns);
	private JTable table3 = new JTable(testData, columns);
//	private JButton add = new JButton("Add");
//	private JButton modify = new JButton("Modify");
//	private JButton cancel = new JButton("Cancel");
//	private JButton logout = new JButton("Log Out");
//	private JButton reports = new JButton("Reports");
//	private JButton accessAdmin = new JButton("Admin Tools"); // temporary
	private JTabbedPane tab = new JTabbedPane(JTabbedPane.BOTTOM);
	private JMenuBar menu = new JMenuBar();
	protected Login currentUser;
	private DBArrivalReservations db = new DBArrivalReservations();
	private JMenu file = new JMenu("File");
	private JMenu res = new JMenu("Reservation");
	private JMenu tools = new JMenu("Tools");
	private JMenu options = new JMenu("Options");
	private JMenu rprts = new JMenu("Reports");
	private JMenu help = new JMenu("Help");
	private JMenuItem logout = new JMenuItem("Logout");
	private JMenuItem create = new JMenuItem("New...");
	private JMenuItem modify = new JMenuItem("Edit...");
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenu adminTools = new JMenu("Admin Tools");
	private JMenuItem addUser = new JMenuItem("Add an Employee");
	private JMenuItem removeUser = new JMenuItem("Remove an Employee");
	private JMenuItem editPermission = new JMenuItem("Edit Permissions");
	private JMenuItem reset = new JMenuItem("Reset Password");
	private JMenuItem rprtsListing = new JMenuItem("Reports Listing");
	
	public PMSMainScreen() {
		super("[Insert Property Name]");
		this.setLocationRelativeTo(null);
		JTable table1 = new JTable(buildTableModel(db.rs));
		table1.setFillsViewportHeight(true);
		table2.setFillsViewportHeight(true);
		tab.addTab("Arrivals", table1);
		tab.addTab("Departures", table2);
		
		
		res.add(create);
		res.add(modify);
		file.add(logout);
		file.addSeparator();
		file.add(exit);
		tools.add(adminTools);
		adminTools.add(addUser);
		adminTools.add(removeUser);
		adminTools.add(editPermission);
		tools.addSeparator();
		tools.add(reset);
		rprts.add(rprtsListing);
		menu.add(file);
		menu.add(res);
		menu.add(tools);
		menu.add(options);
		menu.add(rprts);
		menu.add(help);
		
		
		this.setJMenuBar(menu);
		

		add(tab, BorderLayout.CENTER);
		setSize(850,600);
		setVisible(true);
		create.addActionListener(this);
		modify.addActionListener(this);
		logout.addActionListener(this);
	}
	
	public void initUser() {
		if (!currentUser.admin) {
			adminTools.setEnabled(false);
		} else {
			adminTools.setEnabled(true);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			PMSReservationMake res = new PMSReservationMake();
			res.setVisible(true);
			res.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		if (e.getSource() == logout) {
			Login log = new Login();
			log.setVisible(true);
			log.setAlwaysOnTop(true);
			this.dispose();
			
		}
		
//		if (e.getSource() == reports) {
//			PMSReportListing rpt = new PMSReportListing();
//			rpt.setVisible(true);
//		}
//		
//		if (e.getSource() == accessAdmin) {
//			if (currentUser.admin) {
//				PMSAdminAddUser add = new PMSAdminAddUser();
//				add.setVisible(true);
//				add.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//			} 
//			
//		}
	}
	
	public DefaultTableModel buildTableModel(ResultSet rs) {
		ResultSetMetaData metaData = db.getMeta();
		
		Vector<String> columns = new Vector<String>();
		Vector<Vector<Object>> reservations = new Vector<Vector<Object>>();
		Vector<Object> vec = new Vector<Object>();
		try {
			int ctr = metaData.getColumnCount();
			for (int i = 1; i <= ctr; i++) {
				columns.add(metaData.getColumnName(i));
			}
			
			while (rs.next()) {
				for (int i = 1; i <= ctr; i++) {
					vec.add(rs.getObject(i));
				}
			}
			reservations.add(vec);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(reservations, columns);
	}
}
