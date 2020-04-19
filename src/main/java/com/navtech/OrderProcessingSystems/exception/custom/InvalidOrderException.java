package com.navtech.OrderProcessingSystems.exception.custom;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

@SuppressWarnings("serial")
public class InvalidOrderException extends RuntimeException {

	public InvalidOrderException() {
		System.out.println(OrderProcessingConstants.INVALID_ORDER);
	}

	public InvalidOrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidOrderException(String arg0) {
		super(arg0);
	}

	public InvalidOrderException(Throwable arg0) {
		super(arg0);
	}

}
