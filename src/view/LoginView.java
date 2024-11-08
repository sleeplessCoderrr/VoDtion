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
	private Stage stage;
	private final BorderPane root = new BorderPane();
	private final GridPane fieldContainer = new GridPane();
	private final FlowPane redirectContainer = new FlowPane();
	private final VBox titleBox = new VBox();
	private final VBox bottomBox = new VBox();
	private Label titleLabel , emailLabel, passwordLabel, redirectMessage, redirectToogle;
	private TextField emailField;
	private PasswordField passwordField;
	private Button btnSignIn, btnSignInGoogle;
	private final AuthController authController;

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

		return;
	}
	
	private void createComponent() {
		titleLabel = new Label("Welcome Back to VoDtion");
		emailLabel = new Label("Email or username");
		passwordLabel = new Label("Password");
		redirectMessage = new Label("Don't have an account?");
		redirectToogle = new Label("Sign up");

		emailField = new TextField();
		passwordField = new PasswordField();

		btnSignIn = new Button("Sign In");
		btnSignInGoogle = new Button("Sign In Google");

		return;
	}
	
	private void setStyling() {
		titleLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
		BorderPane.setMargin(titleLabel, new Insets(80, 0, 0, 0));

		return;
	}
	
	private void arrange() {
		titleBox.getChildren().add(titleLabel);
		
		fieldContainer.add(emailLabel, 0, 0);
		fieldContainer.add(emailField, 0, 1);
		fieldContainer.add(passwordLabel, 0, 2);
		fieldContainer.add(passwordField, 0, 3);

		redirectContainer.getChildren().addAll(redirectMessage, redirectToogle);
		bottomBox.getChildren().addAll(btnSignIn, btnSignInGoogle, redirectContainer);

		root.setTop(titleBox);
		root.setCenter(fieldContainer); 
		root.setBottom(bottomBox);

		return;
	}
	
	private void setAllignment() {
		BorderPane.setAlignment(titleLabel, Pos.TOP_CENTER);
		fieldContainer.setAlignment(Pos.CENTER);
		redirectContainer.setAlignment(Pos.CENTER);

		return;
	}
	
	private void setEvent() {
		btnSignIn.setOnAction(e -> {
			authController.handleLogin(this.getEmail(), this.getPassword());
		});

		return;
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
