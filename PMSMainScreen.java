package hostelsolutions;

import java.awt.BorderLayout;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class PMSMainScreen extends JFrame implements ActionListener, ListSelectionListener {
	private JTabbedPane tab = new JTabbedPane(JTabbedPane.BOTTOM);
	private JMenuBar menu = new JMenuBar();
	protected Login currentUser;
	private JMenu file = new JMenu("File");
	private JMenu res = new JMenu("Reservation");
	private JMenu tools = new JMenu("Tools");
	private JMenu options = new JMenu("Options");
	private JMenu rprts = new JMenu("Reports");
	private JMenu help = new JMenu("Help");
	private JButton checkIn = new JButton("Check In");
	private JButton checkOut = new JButton("Check Out");
	private JMenuItem logout = new JMenuItem("Logout");
	private JMenuItem create = new JMenuItem("New...");
	private JMenuItem modify = new JMenuItem("Edit...");
	private JMenuItem cancel = new JMenuItem("Cancel");
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenu adminTools = new JMenu("Admin Tools");
	private JMenuItem addUser = new JMenuItem("Add an Employee");
	private JMenuItem removeUser = new JMenuItem("Remove an Employee");
	private JMenuItem editPermission = new JMenuItem("Edit Permissions");
	private JMenuItem reset = new JMenuItem("Reset Password");
	private JMenuItem rprtsListing = new JMenuItem("Reports Listing");

	private DBCancelReservation DBCancel;
	private String primaryKey = ""; // stores row where you clicked

	// currently cells now uneditable but cannot refresh still
	private DBArrivalReservations arrivalDB = new DBArrivalReservations();
	private DefaultTableModel arrivalModel;
	private JTable arrivalTable;
	private Vector<String> arrivalColumns = new Vector<String>();
	private Vector<Vector<Object>> arrivalRows = new Vector<Vector<Object>>();

	private DBInHouse inHouseDB = new DBInHouse();
	private DefaultTableModel inHouseModel;
	private JTable inHouseTable = new JTable();
	private Vector<String> inHouseColumns = new Vector<String>();
	private Vector<Vector<Object>> inHouseRows = new Vector<Vector<Object>>();
	
	DBDepartures departDB = new DBDepartures();
	private DefaultTableModel departModel;
	private JTable departTable = new JTable();
	private Vector<String> departColumns = new Vector<String>();
	private Vector<Vector<Object>> departRows = new Vector<Vector<Object>>();
	
	DBCancellations cancelDB = new DBCancellations();
	private DefaultTableModel cancelModel;
	private JTable cancelTable = new JTable();
	private Vector<String> cancelColumns = new Vector<String>();
	private Vector<Vector<Object>> cancelRows = new Vector<Vector<Object>>();

	public PMSMainScreen() {
		super("[Insert Property Name]");
		this.setLocationRelativeTo(null);

		refreshTable();
		arrivalTable.setFillsViewportHeight(true);
		departTable.setFillsViewportHeight(true);

		res.add(create);
		res.add(modify);
		res.add(cancel);
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
		menu.add(checkIn);
		menu.add(checkOut);

		this.setJMenuBar(menu);

		add(tab, BorderLayout.CENTER);
		setSize(850, 600);
		setVisible(true);
		create.addActionListener(this);
		modify.addActionListener(this);
		logout.addActionListener(this);
		cancel.addActionListener(this);
		exit.addActionListener(this);
		rprtsListing.addActionListener(this);
		checkIn.addActionListener(this);
		checkOut.addActionListener(this);

		// Timer timer = new Timer(0, new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// this seems to only tell it to update data, not how to do it
		// ((AbstractTableModel)
		// arrivalTable.getModel()).fireTableDataChanged();
		// }
		// });
		//
		// timer.setDelay(10); // delay for 30 seconds
		// timer.start();

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
			Main.login.setVisible(true);
			this.dispose();

		}

		if (e.getSource() == cancel) {
			if(!primaryKey.isEmpty()) {
				DBCancel = new DBCancelReservation(primaryKey);
				DBCancel.cancelRes();
				refreshTable();
			}
			
		}

		if (e.getSource() == rprtsListing) {
			PMSReportListing rpt = new PMSReportListing();
			rpt.setVisible(true);
		}
		//
		// if (e.getSource() == accessAdmin) {
		// if (currentUser.admin) {
		// PMSAdminAddUser add = new PMSAdminAddUser();
		// add.setVisible(true);
		// add.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// }
		//
		// }

		if (e.getSource() == checkIn) {
			if (!primaryKey.isEmpty()) {
				DBCheckIn cIn = new DBCheckIn(primaryKey);
				cIn.checkIn();
				refreshTable();
			}

		}
		
		if (e.getSource() == modify) {
			if (!primaryKey.isEmpty()) {
				//Modify reservation
			}

		}

		if (e.getSource() == checkOut) {
			if (!primaryKey.isEmpty()) {
				DBCheckOut cOut = new DBCheckOut(primaryKey);
				cOut.checkOut();
				refreshTable();
			}
		}

		if (e.getSource() == exit) {
			System.exit(0);
		}
	}

	public void addTabs() {
		tab.addTab("Arrivals", arrivalTable);
		tab.addTab("In House", inHouseTable);
		tab.addTab("Departures", departTable);
		tab.addTab("Cancellations", cancelTable);
	}

	// public void refreshTable(JTable table, Vector<String> columns,
	// Vector<Vector<Object>> rows, DBConnection dbConn) {
	// int selectedIndex = tab.getSelectedIndex();
	// DefaultTableModel clear = new DefaultTableModel();
	// table = new JTable(clear);
	// if(dbConn instanceof DBArrivalReservations) {
	// dbConn = new DBArrivalReservations();
	// buildTableModel(((DBArrivalReservations)dbConn).rs, dbConn, columns,
	// rows);
	// }
	// if(dbConn instanceof DBCheckIn) {
	// buildTableModel(((DBCheckIn)dbConn).rs, dbConn, columns, rows);
	// }
	// remove(tab);
	// DefaultTableModel newModel = new CustomTableModel(rows, columns);
	// table = new JTable(newModel);
	// addTabs();
	// add(tab, BorderLayout.CENTER);
	//
	// }

	public void refreshTable() {
		tab.removeAll();
		DefaultTableModel clear = new DefaultTableModel();
		arrivalTable = new JTable(clear);
		arrivalDB = new DBArrivalReservations();
		buildTableModel(arrivalDB.rs, arrivalDB, arrivalColumns, arrivalRows);
		arrivalModel = new CustomTableModel(arrivalRows, arrivalColumns);
		arrivalTable = new JTable(arrivalModel);
		arrivalTable.getSelectionModel().addListSelectionListener(this);

		inHouseTable = new JTable(clear);
		inHouseDB = new DBInHouse();
		buildTableModel(inHouseDB.rs, inHouseDB, inHouseColumns, inHouseRows);
		inHouseModel = new CustomTableModel(inHouseRows, inHouseColumns);
		inHouseTable = new JTable(inHouseModel);
		inHouseTable.getSelectionModel().addListSelectionListener(this);
		
		departTable = new JTable(clear);
		departDB = new DBDepartures();
		buildTableModel(departDB.rs, departDB, departColumns, departRows);
		departModel = new CustomTableModel(departRows, departColumns);
		departTable = new JTable(departModel);
		departTable.getSelectionModel().addListSelectionListener(this);
		
		cancelTable = new JTable(clear);
		cancelDB = new DBCancellations();
		buildTableModel(cancelDB.rs, cancelDB, cancelColumns, cancelRows);
		cancelModel = new CustomTableModel(cancelRows, cancelColumns);
		cancelTable = new JTable(cancelModel);
		cancelTable.getSelectionModel().addListSelectionListener(this);
		
		remove(tab);

		addTabs();
		add(tab, BorderLayout.CENTER);
	}

	// currently only makes the reservations and columns data to send to the
	// customtablemodel
	public DefaultTableModel buildTableModel(ResultSet rs, DBConnection dbConn, Vector<String> columns,
			Vector<Vector<Object>> rows) {
		ResultSetMetaData metaData = (ResultSetMetaData) dbConn.getMeta();
		rows.removeAllElements();

		try {
			columns.removeAllElements();
			// columns
			int columnCount = metaData.getColumnCount();
			for (int column = 1; column <= columnCount; column++) {
				columns.add(metaData.getColumnName(column));
			}

			// data of the table
			while (rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

					vec.add(rs.getObject(columnIndex));
				}
				rows.add(vec);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(rows, columns);
	}

	// think more methods need to be implemented for editing data, like adding
	// or removing rows, I really
	// do not know how though
	class CustomTableModel extends DefaultTableModel {
		public CustomTableModel(Vector<Vector<Object>> rows, Vector<String> columns) {
			super(rows, columns);
		}

		public boolean isCellEditable(int row, int col) {
			return false;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == arrivalTable.getSelectionModel()) {
			primaryKey = arrivalTable.getValueAt(arrivalTable.getSelectedRow(), 0).toString();
		} else if (e.getSource() == inHouseTable.getSelectionModel()) {
			primaryKey = inHouseTable.getValueAt(inHouseTable.getSelectedRow(), 0).toString();
		}
	}

}
