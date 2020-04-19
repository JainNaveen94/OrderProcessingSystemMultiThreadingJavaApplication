package com.navtech.OrderProcessingSystems.exception.custom;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

@SuppressWarnings("serial")
public class InvalidUserException extends RuntimeException {

	public InvalidUserException() {
		System.out.println(OrderProcessingConstants.INVALIED_USER);
	}

	public InvalidUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidUserException(String arg0) {
		super(arg0);
	}

	public InvalidUserException(Throwable arg0) {
		super(arg0);
	}

}
