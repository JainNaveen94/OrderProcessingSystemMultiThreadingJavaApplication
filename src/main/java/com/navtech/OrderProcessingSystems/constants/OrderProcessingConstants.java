package com.navtech.OrderProcessingSystems.constants;

public class OrderProcessingConstants {

	// User Related Constants
	public static final String INVALIED_USER = "Order rejected because of invalid user";
	public static final String USER_PATH = "src/main/resources/user.json";

	// Product Related Constants
	public static final String INVALID_PRODUCT = "Order Rejected due to some Products not Found";
	public static final String PRODUCT_UNAVAILABLE = "Order rejected because of product unavailability";
	public static final String PRODUCT_PATH = "src/main/resources/product.json";

	// User-Order Related Constants
	public static final String INVALID_ORDER = "Order is Invalied or Not Exist";
	public static final String ORDER_PATH = "src/main/resources/userorder.json";

	// User Payment Related Constants
	public static final String INVALID_PAYMENT = "Order is Rejected due to Invalid Payment Details";
	public static final String PAYMENT_FAILED = "Order rejected because of insufficient balance";
	public static final String PAYMENT_PATH = "src/main/resources/payment.json";

	// Order Process Related Constants
	public static final String SUCCESS_ORDER = "Order is Placed Successfully";

}
