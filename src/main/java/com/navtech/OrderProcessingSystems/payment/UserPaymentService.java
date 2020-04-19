package com.navtech.OrderProcessingSystems.payment;

import java.util.concurrent.ConcurrentHashMap;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;
import com.navtech.OrderProcessingSystems.exception.custom.PaymentNotFoundException;

public class UserPaymentService {

	// Creating the Instance of User Payment DAO
	UserPaymentDAO paymentDao = UserPaymentDAO.getUserPaymentDAOInstance();

	public UserPaymentService() {
		// Initilizing the User Payment Collection
		paymentDao.initiateUserPaymentHashMap();
	}

	// Fetching the Payment Details
	public synchronized UserPayment fetechUserPayment(int userId) {
		UserPayment payment = new UserPayment();
		payment = paymentDao.getPayments().get(userId);
		if (payment == null) {
			throw new PaymentNotFoundException(OrderProcessingConstants.INVALID_PAYMENT);
		}
		return payment;
	}

	// Updating the Payment Details
	public boolean updatePaymentBalance(int userId, double amountLeft) {

		// Get the Hashmap of Payments
		ConcurrentHashMap<Integer, UserPayment> payments = paymentDao.getPayments();

		// Get the User Specific Payment Detail
		UserPayment payment = payments.get(userId);

		// Check for payment before Updating the Payment
		if (payment == null) {
			throw new PaymentNotFoundException(OrderProcessingConstants.INVALID_PAYMENT);
		}

		// Setup the Updated Payment
		payment.setAmount(amountLeft);

		// Payment Updation Done Here
		payments.put(userId, payment);

		return true;
	}

}
