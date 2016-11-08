package hostelsolutions;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class PMSMainScreen extends JFrame implements ActionListener {
	private String[] columns = {"ID", "Last Name", "First Name", "Room #", "Room Type", "Date In", "Date Out"};
	private Object[][] testData = {
			{new Integer(12), "Guo", "Dahai", new Integer(204), "King", "12/13/2016", "12/14/2016"},
			{new Integer(13), "Marsh", "Alex", new Integer(401), "Jr. Suite", "11/24/2016", "01/31/2017"},
			{new Integer(14), "Res", "Test", new Integer(1211), "King", "11/01/2016", "11/02/2016"}
	};
	private JTable table = new JTable(testData, columns);
	private JButton add = new JButton("Add");
	private JButton modify = new JButton("Modify");
	private JButton cancel = new JButton("Cancel");
	private JButton logout = new JButton("Log Out");
	private JButton reports = new JButton("Reports");
	private JPanel btnPanel = new JPanel();
	private JPanel big = new JPanel();
	
	private JTabbedPane tab = new JTabbedPane();
	
	
	public PMSMainScreen() {
		super("[Insert Property Name]");
		table.setFillsViewportHeight(true);
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(add);
		btnPanel.add(modify);
		btnPanel.add(cancel);
		btnPanel.add(logout);
		btnPanel.add(reports);
		tab.insertTab("Arrivals", null, table, "Arrivals", 0);
		tab.insertTab("Departures", null, table, "Departures", 1);
		
		big.setLayout(new FlowLayout());
		big.add(tab);
		
		add(btnPanel, BorderLayout.SOUTH);

		add(big, BorderLayout.CENTER);
		big.setPreferredSize(new Dimension(700, 650));
		setSize(850,600);
		setVisible(true);
		add.addActionListener(this);
		cancel.addActionListener(this);
		modify.addActionListener(this);
		logout.addActionListener(this);
		reports.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add && this.isFocusable()) {
			PMSReservationMake res = new PMSReservationMake();
			res.setVisible(true);
			res.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		if (e.getSource() == logout && this.isFocusable()) {
			Login log = new Login();
			log.setVisible(true);
			log.setAlwaysOnTop(true);
			this.setFocusable(false);
		}
		
		if (e.getSource() == reports && this.isFocusable()) {
			PMSReportListing rpt = new PMSReportListing();
			rpt.setVisible(true);
		}
	}
}
