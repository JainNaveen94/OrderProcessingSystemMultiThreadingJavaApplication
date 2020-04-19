package com.navtech.OrderProcessingSystems.exception.custom;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

@SuppressWarnings("serial")
public class PaymentFailedException extends RuntimeException {

	public PaymentFailedException() {
		System.out.println(OrderProcessingConstants.PAYMENT_FAILED);
	}

	public PaymentFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentFailedException(String message) {
		super(message);
	}

	public PaymentFailedException(Throwable cause) {
		super(cause);
	}

}
