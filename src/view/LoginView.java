package view;

import controller.AuthController;
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
import javafx.stage.Stage;

public class LoginView {
	//Stage
	private Stage stage;
	
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
	
	private AuthController authController;
	
	@SuppressWarnings("exports")
	public LoginView(Stage stage) {
		this.stage = stage;
		this.authController = new AuthController(this.stage);
		this.run();
	}
	
	private void run() {
		this.createComponent();
		this.arrange();
		this.setStyling();
		this.setAllignment();
		this.setEvent();		
	}
	
	private void createComponent() {
		titleLabel = new Label("Welcome Back to VoDtion");
		subtTitle = new Label("Enter your credentials here");
		emailLabel = new Label("Email or username");
		passwordLabel = new Label("Password");
		emailField = new TextField();
		passwordField = new PasswordField();
		btnSignIn = new Button("Sign In");
	}
	
	private void setStyling() {
		titleLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
		subtTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
		BorderPane.setMargin(titleLabel, new Insets(80, 0, 0, 0));
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
		btnSignIn.setOnAction(e -> {
			authController.handleLogin(this.getEmail(), this.getPassword());
		});
	}
	
	@SuppressWarnings("exports")
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
