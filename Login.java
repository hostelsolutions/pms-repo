package hostelsolutions;

// Use test as username and 12345 as password to log in

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	private JButton login = new JButton("Login");
	private JButton cancel = new JButton("Cancel");
	private JLabel header = new JLabel("[Insert Company Name/Image]");
	private JLabel username = new JLabel("Username");
	private JLabel password = new JLabel("Password");
	private JTextField user = new JTextField();
	private JPasswordField pass = new JPasswordField();
	protected boolean admin;
	
	
	private JPanel btnPanel = new JPanel();
	private JPanel credPanel = new JPanel();
	private JPanel headPanel = new JPanel();
	
	protected File data;

	public Login() {
		super("Login");
		setSize(300, 150);
		this.setLocationRelativeTo(null);
		
		btnPanel.setLayout(new FlowLayout());
		credPanel.setLayout(new GridLayout(2, 2));
		headPanel.setLayout(new FlowLayout());
		
		header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnPanel.add(login);
		btnPanel.add(cancel);
		
		credPanel.add(username);
		credPanel.add(user);
		credPanel.add(password);
		credPanel.add(pass);
		
		headPanel.add(header);
		
		add(headPanel, BorderLayout.NORTH);
		add(credPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		pass.setEchoChar('*');
		login.addActionListener(this);
		cancel.addActionListener(this);
		this.getRootPane().setDefaultButton(login); //Press enter to login
		
		this.setFocusable(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String userName = user.getText();
		char[] code = pass.getPassword();
		StringBuilder pwordChecker = new StringBuilder();
		for (int i = 0; i < code.length; i++) {
			pwordChecker.append(code[i]);
		}
		String pword = pwordChecker.toString();
		if (e.getSource() == login) {
			
			DBUserConnections userConn = new DBUserConnections(userName, pword);
			if (userConn.isValidated()) {
				PMSMainScreen mainScrn = new PMSMainScreen();
				mainScrn.setVisible(true);
				this.setVisible(false);
				
				mainScrn.setDefaultCloseOperation(EXIT_ON_CLOSE);
				mainScrn.setSize(600,600);
				mainScrn.setLocationRelativeTo(null);
				admin = userConn.isAdmin;
				mainScrn.currentUser = this;
				mainScrn.initUser();
				
				
			} else if (!userConn.isValidated()) {
				
			}
		}
		
		if (e.getSource() == cancel) {
			System.exit(0);
		}
		
	}

}
