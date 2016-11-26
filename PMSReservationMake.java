package hostelsolutions;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PMSReservationMake extends JFrame implements ActionListener {

	
	private JLabel first = new JLabel("First Name: ");
	private JLabel last = new JLabel("Last Name: ");
	private JButton contact = new JButton("Contact Info");
	private JTextField fname = new JTextField();
	private JTextField lname = new JTextField();
	
	private JLabel cc = new JLabel("Credit Card #: ");
	private JTextField card = new JTextField();
	
	private JLabel ci = new JLabel("Date In");
	private JLabel co = new JLabel("Date Out");
	private JTextField dateIn = new JTextField();
	private JTextField dateOut = new JTextField();
	private JButton roomNum = new JButton("Select Room");
	private JLabel room = new JLabel("");
	
	private JButton confirm = new JButton("Confirm");
	private JButton cancel = new JButton("Cancel");
	
	private JPanel contactPanel = new JPanel();
	private JPanel ctrlBtn = new JPanel();
	
	protected ContactInfo contactInfo = new ContactInfo();
	
	public PMSReservationMake() {
		super("Make a Reservation");
		setSize(500, 350);
		this.setLocationRelativeTo(null);
		
		
		
		contactPanel.setLayout(new GridLayout(6, 6));

		contactPanel.add(first);
		contactPanel.add(fname);
		contactPanel.add(last);
		contactPanel.add(lname);
		contactPanel.add(ci);
		contactPanel.add(dateIn);
		contactPanel.add(co);
		contactPanel.add(dateOut);
		contactPanel.add(cc);
		contactPanel.add(card);
		contactPanel.add(roomNum);
		
		contactPanel.add(room);
		
		ctrlBtn.add(confirm);
		ctrlBtn.add(cancel);
		ctrlBtn.add(contact);
		add(contactPanel, BorderLayout.NORTH);
		add(ctrlBtn, BorderLayout.SOUTH);

		contact.addActionListener(this);
		cancel.addActionListener(this);
		confirm.addActionListener(this);
		roomNum.addActionListener(this);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == contact) {
			PMSContactRes cont = new PMSContactRes(contactInfo);
			cont.setVisible(true);
			cont.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		
		if (e.getSource() == cancel) {
			this.setVisible(false);
		}
		
		if (e.getSource() == confirm) {
			// get all the data, send it to the constructor
			String first = fname.getText();
			String last = lname.getText();
			String dateI = dateIn.getText();
			String dateO = dateOut.getText();
			String rNum = room.getText();
			// rNum is from a button layout, unsure how it will retrieve
			DBAddReservation db = new DBAddReservation(first,last,dateI,dateO,rNum);
			this.setVisible(false);
		}
		
		if (e.getSource() == roomNum) {
			PMSRoomListing rooms = new PMSRoomListing();
			rooms.setVisible(true);
			rooms.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			room.setText(rooms.roomNum);
			
		}

	}

}
