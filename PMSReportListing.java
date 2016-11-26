package hostelsolutions;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PMSReportListing extends JFrame implements ActionListener  {
	
	private String[] labels = {"Management Statistics", "Property Statistics", "Accounting Statistics", 
								  "Rate Report", "Arrivals Report", "Departure Report", "In House Report", 
								  "Future Rooms Sold", "End of Month Reports", "End of Year Reports"};
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
				try{
				    PrintWriter writer = new PrintWriter("Management Statistics 11/29/2016", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check2.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("Property Statistics 11/29/2016", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}		
			}
			if (check3.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("Accounting Statistics 11/29/2016", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("You got no money");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check4.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("Rate Report 11/29/2016 - 12/29/2016", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check5.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("Arrivals 11/29/2016", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check6.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("Departures 11/29/2016", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check7.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("In-House 11/29/2016", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check8.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("Future Rooms Sold...", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check9.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("End of Month Reports...", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			if (check10.isSelected()) {
				try{
				    PrintWriter writer = new PrintWriter("End of Year Reports", "UTF-8");
				    writer.println("This is an example of what would be printed in a real report");
				    writer.println("This would actually be a PDF with correct formatting");
				    writer.println("Time constraints forbid this");
				    writer.close();
				} catch (IOException e1) {
				   // do something
				}
			}
			
		}
		
		if (e.getSource() == cancel) {
			this.setVisible(false);
		}
		
	}
	
}
