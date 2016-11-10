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

public class Login extends JFrame implements ActionListener {

	private JButton login = new JButton("Login");
	private JButton cancel = new JButton("Cancel");
	private JLabel header = new JLabel("[Insert Company Name/Image]");
	private JLabel username = new JLabel("Username");
	private JLabel password = new JLabel("Password");
	private JTextField user = new JTextField();
	private JPasswordField pass = new JPasswordField();
	
	private JPanel btnPanel = new JPanel();
	private JPanel credPanel = new JPanel();
	private JPanel headPanel = new JPanel();
	
	protected File data;

	public Login() {
		super("Login");
		setSize(300, 150);
		
		
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
			
			
			if (userName.equals("user") && pword.equals("12345")) {
				PMSMainScreen mscreen = new PMSMainScreen();
				mscreen.setVisible(true);
				mscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(false);
			}
		
		}
		
		if (e.getSource() == cancel) {
			System.exit(0);
		}
		
	}

}