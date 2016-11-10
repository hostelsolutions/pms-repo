package hostelsolutions;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PMSContactRes extends JFrame implements ActionListener {

    private String[] testStates = { "AK", "AZ", "CA", "DE", "FL", "GA", "HI",
            "NC", "SC", "NM", "TX", "VT", "NY", "MA" };
    private JLabel addressLine = new JLabel("Address: ");
    private JLabel addressLine2 = new JLabel("");
    private JLabel addressLine3 = new JLabel("");
    private JTextField address1 = new JTextField();
    private JTextField address2 = new JTextField();
    private JTextField address3 = new JTextField();
    private JLabel phone = new JLabel("Phone");
    private JTextField pnumber = new JTextField();
    private JLabel email = new JLabel("Email");
    private JTextField emailadd = new JTextField();
    private JLabel state = new JLabel("State");
    private JComboBox states = new JComboBox(testStates);
    private JLabel zip = new JLabel("Zip Code");
    private JTextField zipCode = new JTextField();

    private JPanel panel = new JPanel();

    private JButton accept = new JButton("Accept");
    private JButton cancel = new JButton("Cancel");
    private JPanel btnPanel = new JPanel();

    private ContactInfo tempInfo;
    
    public PMSContactRes(ContactInfo contactInfo) {
        super("Contact Info");
        setSize(500, 300);

        tempInfo = contactInfo;
        panel.setLayout(new GridLayout(7, 7));
        btnPanel.setLayout(new FlowLayout());

        panel.add(addressLine);
        panel.add(address1);
        panel.add(addressLine2);
        panel.add(address2);
        panel.add(addressLine3);
        panel.add(address3);
        panel.add(state);
        panel.add(states);
        panel.add(zip);
        panel.add(zipCode);
        panel.add(phone);
        panel.add(pnumber);
        panel.add(email);
        panel.add(emailadd);
        btnPanel.add(accept);
        btnPanel.add(cancel);

        add(panel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);
        accept.addActionListener(this);
        cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == accept) {
            tempInfo.setAddress1(address1.getText());
            tempInfo.setAddress2(address2.getText());
            tempInfo.setCity(address3.getText());
            tempInfo.setState((String)states.getSelectedItem());
            tempInfo.setZip(zipCode.getText());
            tempInfo.setPhone(pnumber.getText());
            tempInfo.setEmail(emailadd.getText());
            this.setVisible(false);
        }

        if (e.getSource() == cancel) {
            this.setVisible(false);
        }
    }

}
