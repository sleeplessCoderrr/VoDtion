package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoginView;

public class MainApp extends Application{
		
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
		LoginView loginForm = new LoginView(primaryStage);
		Scene login = new Scene(loginForm.getRoot(), 400, 300);
		primaryStage.setTitle("VoDtion");
		primaryStage.setScene(login);
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
