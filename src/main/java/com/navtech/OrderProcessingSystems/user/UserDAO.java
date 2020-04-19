package com.navtech.OrderProcessingSystems.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

public class UserDAO {

	// Collection To Manage Users
	private ConcurrentHashMap<Integer, User> users;

	// Single Private Instance of UserDAO
	private static UserDAO userDao;

	// Private Constructor so that no new Instance is created
	private UserDAO() {
		this.users = new ConcurrentHashMap<Integer, User>();
	}

	// Get the Single Instance of User DAO
	public static UserDAO getUserDAOInstance() {
		if (userDao == null) {
			userDao = new UserDAO();
		}
		return userDao;
	}

	// Used to Initilize the User Order Collection from json File
	public void initiateUserHashMap() {
		userDao.setUsers(userDao.listToHashMap(userDao.getUserList()));
	}

	// Used to Read the JSON File of User
	private List<User> getUserList() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
		};
		try {
			return mapper.readValue(new File(OrderProcessingConstants.USER_PATH), typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}

	// Used to Convert the List of Users to ConcurrentHashMap of Users
	private ConcurrentHashMap<Integer, User> listToHashMap(List<User> userList) {
		ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();
		// Converting List to HashMap Here
		for (User user : userList) {
			users.put(user.getId(), user);
		}
		return users;
	}

	// Getter-Setter For Users List
	public ConcurrentHashMap<Integer, User> getUsers() {
		return userDao.users;
	}

	private void setUsers(ConcurrentHashMap<Integer, User> users) {
		userDao.users = users;
	}

}
