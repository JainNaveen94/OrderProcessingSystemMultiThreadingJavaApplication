package com.navtech.OrderProcessingSystems.exception.custom;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

@SuppressWarnings("serial")
public class PaymentNotFoundException extends RuntimeException {

	public PaymentNotFoundException() {
		System.out.println(OrderProcessingConstants.INVALID_PAYMENT);
	}

	public PaymentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentNotFoundException(String message) {
		super(message);
	}

	public PaymentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
