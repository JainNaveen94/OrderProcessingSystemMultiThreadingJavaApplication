package com.navtech.OrderProcessingSystems.order;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;
import com.navtech.OrderProcessingSystems.exception.custom.InvalidOrderException;

public class UserOrderService {

	// Creating the Instance of User Order DAO
	UserOrderDAO userOrderDao = UserOrderDAO.getUserOrderDAOInstance();
	
	public UserOrderService() {
		// Initilze the User Order Collection
		userOrderDao.initiateUserOrderHashMap();
	}
	
	// fetech the Order From Database or collection
	public UserOrder fetchOrder(int orderId) {
		UserOrder order = new UserOrder();
		order = userOrderDao.getOrders().get(orderId);
		if(order == null) {
			throw new InvalidOrderException(OrderProcessingConstants.INVALID_ORDER);
		}
		return order;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public void printUserOrder() {
//
//		ConcurrentHashMap<Integer, UserOrder> orders = userOrderDao.getOrders();
//
//		for (Integer key : orders.keySet()) {
//			System.out.println(key);
//		}
//
//	}
//
//	public void printUserOrderAmount() {
//		ConcurrentHashMap<Integer, UserOrder> orders = userOrderDao.getOrders();
//
//		System.out.println(orders.get(1).getTotalAmount());
//	}
//
//	public boolean updateUserOrderDetail() {
//
//		ConcurrentHashMap<Integer, UserOrder> orders = userOrderDao.getOrders();
//
//		UserOrder order = orders.get(1);
//
//		System.out.println(order.getTotalAmount());
//
//		order.setTotalAmount(300);
//
//		orders.put(1, order);
//
//		order = orders.get(1);
//
//		System.out.println(order.getTotalAmount());
//
//		return true;
//
//	}

}
