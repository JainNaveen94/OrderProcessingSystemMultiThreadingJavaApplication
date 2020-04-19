package com.navtech.OrderProcessingSystems.order;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

public class UserOrderDAO {

	// Collection To Manage User's Order
	private ConcurrentHashMap<Integer, UserOrder> orders;

	// Single Private Instance of UserOrderDAO
	private static UserOrderDAO userOrderDao;

	// Private Constructor so that no new Instance is created
	private UserOrderDAO() {
		this.orders = new ConcurrentHashMap<Integer, UserOrder>();
	}

	// Get the Single Instance of UserOrder DAO
	public static UserOrderDAO getUserOrderDAOInstance() {
		if (userOrderDao == null) {
			userOrderDao = new UserOrderDAO();
		}
		return userOrderDao;
	}

	// Used to Initilize the User Order Collection from json File
	public void initiateUserOrderHashMap() {
		userOrderDao.setOrders(userOrderDao.listToHashMap(userOrderDao.getUserOrders()));
	}

	// Used To Read the JSON File of User Orders
	private List<UserOrder> getUserOrders() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<UserOrder>> typeReference = new TypeReference<List<UserOrder>>() {
		};
		try {
			return mapper.readValue(new File(OrderProcessingConstants.ORDER_PATH), typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<UserOrder>();
	}

	// Used to Convert the List of User Orders to ConcurrentHashMap of User Orders
	private ConcurrentHashMap<Integer, UserOrder> listToHashMap(List<UserOrder> orderList) {
		ConcurrentHashMap<Integer, UserOrder> orders = new ConcurrentHashMap<Integer, UserOrder>();
		// Converting List to HashMap Here
		for (UserOrder order : orderList) {
			orders.put(order.getOrderId(), order);
		}
		return orders;
	}

	// Getter-Setter of the Concurrent HashMap //
	public ConcurrentHashMap<Integer, UserOrder> getOrders() {
		return userOrderDao.orders;
	}

	private void setOrders(ConcurrentHashMap<Integer, UserOrder> orders) {
		userOrderDao.orders = orders;
	}

}
