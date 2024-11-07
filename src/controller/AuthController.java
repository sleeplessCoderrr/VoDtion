package controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import javafx.stage.Stage;
import model.User;
import service.UserService;
import util.Encryption;

public class AuthController {
	
	private Stage stage;
	private UserService userService;
	
	//!!!todo figure out how to save userlist !!!
	ArrayList<User> userList;
	
	@SuppressWarnings("exports")
	public AuthController(Stage stage) {
		this.stage = stage;
		this.userService = new UserService();
		
		userList = new ArrayList<>();
	}
	
	public void handleLogin(String text, String password) {
		
		String username = text;
		String salt = userService.getSalt(userList, username);
		String hashPassword = null;
		try {
			hashPassword = Encryption.hashPassword(password, salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
	}

}
