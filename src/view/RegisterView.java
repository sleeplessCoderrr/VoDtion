package view;

import controller.AuthController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView {
    private Stage stage;
    private final BorderPane root = new BorderPane();
    private final GridPane fieldContainer = new GridPane();
    private final FlowPane redirectContainer = new FlowPane();
    private final VBox titleBox = new VBox();
    private final VBox bottomBox = new VBox();
    private Label titleLabel, fullNameLabel, emailLabel, passwordLabel, redirectMessage, redirectToogle;
    private TextField emailField, fullNameField;
    private PasswordField passwordField;
    private Button btnSignUp, btnSignUpGoogle;
    private final AuthController authController;

    public RegisterView(Stage stage) {
        this.stage = stage;
        this.authController = new AuthController(this.stage);
        this.run();
    }

    private void run(){
        this.createComponent();
        this.arrange();

        return;
    }

    private void createComponent() {
        titleLabel = new Label("Create New Account");
        fullNameLabel = new Label("Full name");
        emailLabel = new Label("Email");
        passwordLabel = new Label("Password");
        redirectMessage = new Label("Already have an account?");
        redirectToogle = new Label("Sign in");

        emailField = new TextField();
        fullNameField = new TextField();
        passwordField = new PasswordField();

        btnSignUp = new Button("Sign In");
        btnSignUpGoogle = new Button("Sign Up Google");

        return;
    }

    private void arrange(){
        titleBox.getChildren().addAll(titleLabel);

        fieldContainer.add(fullNameLabel, 0, 0);
        fieldContainer.add(fullNameField, 0, 1);
        fieldContainer.add(emailLabel, 0, 2);
        fieldContainer.add(emailField, 0, 3);
        fieldContainer.add(passwordLabel, 0, 4);
        fieldContainer.add(passwordField, 0, 5);

        redirectContainer.getChildren().addAll(redirectMessage, redirectToogle);
        bottomBox.getChildren().addAll(btnSignUp, btnSignUpGoogle, redirectContainer);

        root.setTop(titleBox);
        root.setCenter(fieldContainer);
        root.setBottom(bottomBox);

        return;
    }

    private void setAllignment(){
        BorderPane.setAlignment(titleLabel, Pos.TOP_CENTER);
        fieldContainer.setAlignment(Pos.CENTER);
        redirectContainer.setAlignment(Pos.CENTER);

        return;
    }

    public BorderPane getRoot(){
        return this.root;
    }
}











