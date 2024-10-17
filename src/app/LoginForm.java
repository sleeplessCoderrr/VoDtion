package app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class LoginForm {
	//Layout Manager
	private BorderPane root = new BorderPane();
	private GridPane fieldContainer = new GridPane();
	private FlowPane buttonContainer = new FlowPane();
	
	//Component
	private Label titleLabel, emailLabel, passwordLabel;
	private TextField emailField;
	private PasswordField passwordField;
	private Button btnSignIn;
	
	public LoginForm() {
		titleLabel = new Label("Welcome Back to VoDtion");
		emailLabel = new Label("Email");
		passwordLabel = new Label("Password");
		emailField = new TextField();
		passwordField = new PasswordField();
		btnSignIn = new Button("Sign In");
		this.run();
	}
	
	private void run() {
		//Entering component to gridPane
		fieldContainer.add(emailLabel, 0, 0);
		fieldContainer.add(emailField, 0, 1);
		fieldContainer.add(passwordLabel, 0, 2);
		fieldContainer.add(passwordField, 0, 3);
		
		//Entering Button to flowPane
		buttonContainer.getChildren().add(btnSignIn);
		
		//Entering all into root
		root.setTop(titleLabel);
		root.setCenter(fieldContainer); 
		root.setBottom(buttonContainer);
		root.setAlignment(titleLabel, Pos.TOP_CENTER);
		fieldContainer.setAlignment(Pos.CENTER);
		buttonContainer.setAlignment(Pos.CENTER);
		
		root.setMargin(titleLabel, new Insets(80, 0, 0, 0));
		btnSignIn.setOnAction(e -> {
			System.out.println("berhasil");
		});
	}
	
	public BorderPane getRoot() {
		return this.root;
	}
	
}
