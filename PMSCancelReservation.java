package hostelsolutions;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PMSCancelReservation extends JFrame implements ActionListener {

	private JPanel btnPanel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JButton confirm = new JButton("Confirm");
	private JButton cancel = new JButton("Cancel");
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	
	
	public PMSCancelReservation() {
		super("Cancel Reservation");
		setSize(300, 125);
		
		btnPanel.setLayout(new FlowLayout());
		panel1.setLayout(new GridLayout(2, 2));
		btnPanel.add(confirm);
		btnPanel.add(cancel);
		
		
		
		add(btnPanel);
		add(panel1);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
