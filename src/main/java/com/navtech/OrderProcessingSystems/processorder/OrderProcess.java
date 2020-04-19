package com.navtech.OrderProcessingSystems.processorder;

import java.util.List;

import com.navtech.OrderProcessingSystems.product.Product;

public class OrderProcess {

	private int orderId;
	private int userId;
	private double orderAmount;
	private String deliveryAddress;
	private String contantNumber;
	private boolean payStatus;
	private boolean orderStatus;
	private List<Product> products;

	/* Default Constructor */

	public OrderProcess() {
		// TODO Auto-generated constructor stub
	}

	/* Parameterized Constructor */

	public OrderProcess(int orderId, int userId, double orderAmount, String deliveryAddress, String contantNumber,
			boolean payStatus, boolean orderStatus, List<Product> products) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderAmount = orderAmount;
		this.deliveryAddress = deliveryAddress;
		this.contantNumber = contantNumber;
		this.payStatus = payStatus;
		this.orderStatus = orderStatus;
		this.products = products;
	}
	

	/* Getter-Setter */

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getContantNumber() {
		return contantNumber;
	}

	public void setContantNumber(String contantNumber) {
		this.contantNumber = contantNumber;
	}

	public boolean isPayStatus() {
		return payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
