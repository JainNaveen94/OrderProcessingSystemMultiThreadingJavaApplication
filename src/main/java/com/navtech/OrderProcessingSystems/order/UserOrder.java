package com.navtech.OrderProcessingSystems.order;

import java.util.List;

import com.navtech.OrderProcessingSystems.product.Product;

public class UserOrder {

	private int orderId;
	private int userId;
	private List<Product> productList;
	private double totalAmount;

	/* Default Constuctor */

	public UserOrder() {
		// TODO Auto-generated constructor stub
	}

	/* Parameterized Constructor */

	public UserOrder(int orderId, int userId, List<Product> productList, double totalAmount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productList = productList;
		this.totalAmount = totalAmount;
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

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
