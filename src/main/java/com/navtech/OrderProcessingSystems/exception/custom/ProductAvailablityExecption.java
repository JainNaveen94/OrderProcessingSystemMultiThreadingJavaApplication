package com.navtech.OrderProcessingSystems.exception.custom;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

@SuppressWarnings("serial")
public class ProductAvailablityExecption extends RuntimeException {

	public ProductAvailablityExecption() {
		System.out.println(OrderProcessingConstants.PRODUCT_UNAVAILABLE);
	}

	public ProductAvailablityExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductAvailablityExecption(String message) {
		super(message);
	}

	public ProductAvailablityExecption(Throwable cause) {
		super(cause);
	}

}
