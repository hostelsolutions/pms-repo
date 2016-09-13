package pms.hostelsolutions.cen3031;

import java.awt.Desktop;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController {
	
	
    @FXML
    private PasswordField passField;

    @FXML
    private Label userLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Hyperlink resetLink;

    @FXML
    private TextField userField;

    @FXML
    private Label passLabel;

    @FXML
    private Button logButton;
    
    @FXML
    private void onEnterPress(KeyEvent e) {
    	String testpass = ""; // For testing only
    	String realpass = "abc123"; // For testing only
    	testpass = passField.getText();
    	if (e.getCode() == KeyCode.ENTER) {
    		if (testpass.equals(realpass)) {
    			System.out.println("Woo"); // Testing
    		} else {
    			System.out.println("Boo"); // Testing
    		}
    	}
    	
    }
    
    
  
    

}
