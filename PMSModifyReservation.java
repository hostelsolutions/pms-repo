package hostelsolutions;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PMSModifyReservation extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel first = new JLabel("First Name: ");
	private JLabel last = new JLabel("Last Name: ");
	private JButton contact = new JButton("Contact Info");
	private JTextField fname = new JTextField();
	private JTextField lname = new JTextField();
	
	private JLabel cc = new JLabel("Credit Card #: ");
	private JTextField card = new JTextField();
	
	private JLabel rooms = new JLabel("Room Number:");
	
	private JLabel ci = new JLabel("Date In");
	private JLabel co = new JLabel("Date Out");
	private JFormattedTextField  dateIn;
	private JFormattedTextField  dateOut;
	//private JButton roomNum = new JButton("Select Room");
	
	private JButton confirm = new JButton("Confirm");
	private JButton cancel = new JButton("Cancel");
	
	private JPanel contactPanel = new JPanel();
	private JPanel ctrlBtn = new JPanel();
	
	private String roomNum;
	
	protected ContactInfo contactInfo = new ContactInfo();
	private String uID;
	
	private JTextField rNum = new JTextField("Room Number");
	
	DBModifyReservation db;
	
	public PMSModifyReservation(String ID) {
		super("Modify a Reservation");
		
		// gets the ID, sends it to the database to modify
		uID = ID;
		db = new DBModifyReservation(uID);
		
		setSize(500, 350);
		this.setLocationRelativeTo(null);

		
		// formats date cells
		Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = formatter.format(date);
        dateIn = new JFormattedTextField(createFormatter("####-##-## ##:##:##"));
        dateIn.setColumns(20);
        dateIn.setText(dateString);
		
        dateOut = new JFormattedTextField(createFormatter("####-##-## ##:##:##"));
        dateOut.setColumns(20);
        dateOut.setText(dateString);
        
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
		contactPanel.add(rooms);
		contactPanel.add(rNum);
		
		ctrlBtn.add(confirm);
		ctrlBtn.add(cancel);
		ctrlBtn.add(contact);
		add(contactPanel, BorderLayout.NORTH);
		add(ctrlBtn, BorderLayout.SOUTH);

		contact.addActionListener(this);
		cancel.addActionListener(this);
		confirm.addActionListener(this);
		//roomNum.addActionListener(this);
		setVisible(true);
		
		fname.setText(db.firstName);
		lname.setText(db.lastName);
		dateIn.setText(db.dateIn);
		dateOut.setText(db.dateOut);
		roomNum = db.roomNum;
		
		rNum.setText(roomNum);
		
//		// combo box
//		String[] choices = { "100","101", "102","103", "104","105", "106","107", "108","109", 
//				"200","201","202", "203","204", "205", "206", "207","208", "209"};
//		
//		final JComboBox<String> cb = new JComboBox<String>(choices);
//	    cb.setVisible(true);
//	    contactPanel.add(cb);
//	    cb.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	        	roomNum = (String) cb.getSelectedItem();
//	        }
//	      });
//	    
//	    cb.setSelectedItem(rNum);
		
		
	}
	
    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is incorrect, yyy-MM-dd hh:mm:ss: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
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
			String Num = rNum.getText(); // need to know how to get these
			String rType = "Standard";
			db.modData(last, first, rType, Num, dateI, dateO);
			this.setVisible(false);
		}
		
//		if (e.getSource() == roomNum) {
//			PMSRoomListing rooms = new PMSRoomListing();
//			rooms.setVisible(true);
//			rooms.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		}

	}

}
