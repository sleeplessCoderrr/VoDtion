package service;

import java.util.ArrayList;

import model.User;

public class UserService {
	
	public String getSalt(ArrayList<User> userList, String username) {
		int isValid = searchUser(userList, username);
		if(isValid >= -1) {
            return userList.get(isValid).getSalt();
		}
		return "";
	}
	
	private int searchUser(ArrayList<User> userList, String username) {
		for (int i=0; i<userList.size(); i++) {
			if(userList.get(i).getEmail().equals(username) || userList.get(i).getUsername().equals(username)) return i;
		}
		return -1;
	}

}
