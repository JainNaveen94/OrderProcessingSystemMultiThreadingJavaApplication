package com.navtech.OrderProcessingSystems.exception.custom;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {
		System.out.println(OrderProcessingConstants.INVALID_PRODUCT);
	}

	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}

}
