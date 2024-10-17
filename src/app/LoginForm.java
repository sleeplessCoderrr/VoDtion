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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginForm {
	//Layout Manager
	private BorderPane root = new BorderPane();
	private GridPane fieldContainer = new GridPane();
	private FlowPane buttonContainer = new FlowPane();
	private VBox vBox = new VBox();
	
	//Component
	private Label titleLabel, subtTitle, emailLabel, passwordLabel;
	private TextField emailField;
	private PasswordField passwordField;
	private Button btnSignIn;
	
	public LoginForm(String tittle, String subTitle) {
		titleLabel = new Label(tittle);
		subtTitle = new Label(subTitle);
		emailLabel = new Label("Email");
		passwordLabel = new Label("Password");
		emailField = new TextField();
		passwordField = new PasswordField();
		btnSignIn = new Button("Sign In");
		this.run();
	}
	
	private void run() {
		this.arrange();
		this.setStyling();
		this.setAllignment();
		this.setEvent();		
	}
	
	private void setStyling() {
		titleLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
		subtTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
	}
	
	private void arrange() {
		//Entering to HBox
		vBox.getChildren().add(titleLabel);
		vBox.getChildren().add(subtTitle);
		
		//Entering component to gridPane
		fieldContainer.add(emailLabel, 0, 0);
		fieldContainer.add(emailField, 0, 1);
		fieldContainer.add(passwordLabel, 0, 2);
		fieldContainer.add(passwordField, 0, 3);
		
		//Entering Button to flowPane
		buttonContainer.getChildren().add(btnSignIn);
		
		//Entering all into root
		root.setTop(vBox);
		root.setCenter(fieldContainer); 
		root.setBottom(buttonContainer);
	}
	
	private void setAllignment() {
		BorderPane.setAlignment(titleLabel, Pos.TOP_CENTER);
		fieldContainer.setAlignment(Pos.CENTER);
		buttonContainer.setAlignment(Pos.CENTER);
	}
	
	private void setEvent() {
		BorderPane.setMargin(titleLabel, new Insets(80, 0, 0, 0));
		btnSignIn.setOnAction(e -> {
			System.out.println("berhasil");
		});
	}
	
	public BorderPane getRoot() {
		return this.root;
	}
	
	public String getEmail() {
		return this.emailField.getText();
	}
	
	public String getPassword() {
		return this.passwordField.getText();
	}
	
}
