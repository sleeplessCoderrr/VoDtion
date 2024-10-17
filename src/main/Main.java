package main;

import app.LoginForm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginForm loginForm = new LoginForm("Welcome Back to VoDtion", "Enter you credentials");
		Scene login = new Scene(loginForm.getRoot(), 400, 300);
		primaryStage.setTitle("LoginPage");
		primaryStage.setScene(login);
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
