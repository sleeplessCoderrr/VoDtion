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
	ArrayList<User> userList = new ArrayList<>();
	
	public AuthController(Stage stage) {
		this.stage = stage;
		this.userService = new UserService();
	}
	
	public void handleLogin(String text, String password) {
		User user = userService.getUser(userList, text);
		
		String username = user.getUsername();
		String salt = user.getSalt();
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
