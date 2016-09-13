package pms.hostelsolutions.cen3031;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppStart extends Application {

	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			Pane page = (Pane) FXMLLoader.load(AppStart.class.getResource("Login.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login Screen");
			primaryStage.show();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
