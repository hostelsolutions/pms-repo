package hostelsolutions;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PMSReportListing extends JFrame implements ActionListener  {
	
	private JCheckBox check1 = new JCheckBox("Management Statistics");
	private JCheckBox check2 = new JCheckBox("Property Statistics");
	private JCheckBox check3 = new JCheckBox("Accounting Statistics");
	private JCheckBox check4 = new JCheckBox("Rate Report");
	private JCheckBox check5 = new JCheckBox("Arrivals Report");
	private JCheckBox check6 = new JCheckBox("Departure Report");
	private JCheckBox check7 = new JCheckBox("In House Report");
	private JCheckBox check8 = new JCheckBox("Future Rooms Sold");
	private JCheckBox check9 = new JCheckBox("End of Month Reports");
	private JCheckBox check10 = new JCheckBox("End of Year Reports");
	
	private JButton pull = new JButton("Pull Report");
	private JButton cancel = new JButton("Cancel");
	private JPanel btnPanel = new JPanel();
	private JPanel checkBox = new JPanel();
	
	public PMSReportListing() {
		super("Reports...");
		setSize(300, 300);
		
		checkBox.setLayout(new GridLayout(10, 10));
		btnPanel.setLayout(new FlowLayout());
		
		btnPanel.add(pull);
		btnPanel.add(cancel);
		
		checkBox.add(check1);
		checkBox.add(check2);
		checkBox.add(check3);
		checkBox.add(check4);
		checkBox.add(check5);
		checkBox.add(check6);
		checkBox.add(check7);
		checkBox.add(check8);
		checkBox.add(check9);
		checkBox.add(check10);
		
		
		
		add(btnPanel, BorderLayout.SOUTH);
		add(checkBox, BorderLayout.NORTH);
		
		pull.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pull) {
			if (check1.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("Management Statistics.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check2.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("Property Statistics.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check3.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("Accounting Statistics.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check4.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("Rate Report.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check5.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("Arrivals.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check6.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("Departures.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check7.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("In-House.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check8.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("Future Rooms Sold.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check9.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("End of Month Reports.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (check10.isSelected()) {
				try {
					PrintWriter pr = new PrintWriter(new FileWriter(new File("End of Year Reports.txt")));
					pr.print("This is a test report ");
					this.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		
			
			
			
		}
		
		if (e.getSource() == cancel) {
			this.setVisible(false);
		}
		
	}
	
}
