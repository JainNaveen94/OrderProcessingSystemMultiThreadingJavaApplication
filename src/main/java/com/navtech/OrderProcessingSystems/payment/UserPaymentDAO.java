package com.navtech.OrderProcessingSystems.payment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

public class UserPaymentDAO {

	// Collection To Manage User Payments
	private ConcurrentHashMap<Integer, UserPayment> payments;

	// Single Private Instance of UserPaymentDAO
	private static UserPaymentDAO userPaymentDao;

	// Private Constructor so that no new Instance is created
	private UserPaymentDAO() {
		this.payments = new ConcurrentHashMap<Integer, UserPayment>();
	}

	// Get the Single Instance of User Payment DAO
	public static UserPaymentDAO getUserPaymentDAOInstance() {
		if (userPaymentDao == null) {
			userPaymentDao = new UserPaymentDAO();
		}
		return userPaymentDao;
	}

	// Used to Initilize the User Payments Collection from json File
	public void initiateUserPaymentHashMap() {
		userPaymentDao.setPayments(userPaymentDao.listToHashMap(userPaymentDao.getUserPayments()));
	}

	// Used to Read the JSON File of User Payment
	private List<UserPayment> getUserPayments() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<UserPayment>> typeReference = new TypeReference<List<UserPayment>>() {
		};
		try {
			return mapper.readValue(new File(OrderProcessingConstants.PAYMENT_PATH), typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<UserPayment>();
	}

	// Used to Convert the List of User Payments to ConcurrentHashMap of User Payments
	private ConcurrentHashMap<Integer, UserPayment> listToHashMap(List<UserPayment> userPaymentList) {
		ConcurrentHashMap<Integer, UserPayment> payments = new ConcurrentHashMap<Integer, UserPayment>();
		// Converting List to HashMap Here
		for (UserPayment payment : userPaymentList) {
			payments.put(payment.getUserId(), payment);
		}
		return payments;
	}

	// Getter-Setter 
	public ConcurrentHashMap<Integer, UserPayment> getPayments() {
		return userPaymentDao.payments;
	}

	private void setPayments(ConcurrentHashMap<Integer, UserPayment> payments) {
		userPaymentDao.payments = payments;
	}

}
