package hostelsolutions;
import javax.swing.JFrame;

public class Main {
	protected static Login login;
	public static void main(String[] args) {
		login = new Login();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
	}

}
