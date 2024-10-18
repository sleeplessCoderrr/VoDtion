package service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import model.User;
import util.Encryption;

public class UserService {
	
	public User getUser(ArrayList<User> userList, String username) {
		int isValid = searchUser(userList, username);
		if(isValid != -1) {
			int i = isValid;
			try {
				User user = new User(
						userList.get(i).getUsername(), 
						userList.get(i).getEmail(), 
						Encryption.hashPassword(userList.get(i).getUsername(), userList.get(i).getSalt()), 
						userList.get(i).getSalt());
				return user;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		return null;
	}
	
	private int searchUser(ArrayList<User> userList, String username) {
		for (int i=0; i<userList.size(); i++) {
			if(userList.get(i).getEmail().equals(username) || userList.get(i).getUsername().equals(username)) return i;
		}
		return -1;
	}

}
