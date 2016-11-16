package hostelsolutions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PMSAdminAddUser extends JFrame implements ActionListener {
		
	private String userName;
	private String password;
	private int adminStatus = 0; // 0 for not admin, 1 for admin.
	
	private JPanel buttonPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	private JPanel contents = new JPanel();
	private JTextField user = new JTextField();
	private JPasswordField pass = new JPasswordField();
	private JCheckBox isAdmin = new JCheckBox();
	private JLabel directive = new JLabel("Enter a new user");
	private JLabel name = new JLabel("Username: ");
	private JLabel pw = new JLabel("Password: ");
	private JLabel ad = new JLabel("Is Admin?");
	private JButton accept = new JButton("Accept");
	private JButton cancel = new JButton("Cancel");
	private boolean admin = false;
	
		public PMSAdminAddUser() {
			super("Add a user...");
			infoPanel.setLayout(new FlowLayout());
			contents.setLayout(new GridLayout(2, 2));
			buttonPanel.setLayout(new FlowLayout());
			
			infoPanel.add(directive);
			contents.add(name);
			contents.add(user);
			contents.add(pw);
			contents.add(pass);
			
			buttonPanel.add(ad);
			buttonPanel.add(isAdmin);
			buttonPanel.add(accept);
			buttonPanel.add(cancel);
			
			accept.addActionListener(this);
			cancel.addActionListener(this);
			
			setSize(300, 125);
			add(infoPanel, BorderLayout.NORTH);
			add(contents, BorderLayout.CENTER);
			add(buttonPanel, BorderLayout.SOUTH);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == accept) {
				userName = user.getText();
				char[] code = pass.getPassword();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < code.length; i++) {
					sb.append(code[i]);
				}
				password = sb.toString();
				
				if (isAdmin.isSelected()) {
					admin = true;
				} else {
					admin = false;
				}
				
				DBUserConnections db = new DBUserConnections(userName, password, admin);
				db.addUser();
				
				this.dispose();
			}
			
			if (e.getSource() == cancel) {
				this.dispose();
			}
			
			
		}
}
