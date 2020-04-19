package com.navtech.OrderProcessingSystems.user;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;
import com.navtech.OrderProcessingSystems.exception.custom.InvalidUserException;

public class UserService {

	// Creating the Instance of User DAO
	UserDAO userDao = UserDAO.getUserDAOInstance();

	public UserService() {
		// Initilizing the User Collection
		userDao.initiateUserHashMap();
	}

	// Verfied the Existence of User
	public User verfiedUser(int userId) {
		User user = new User();
		user = userDao.getUsers().get(userId);
		if(user == null) {
			throw new InvalidUserException(OrderProcessingConstants.INVALIED_USER);
		}
		return user;
	}

}
