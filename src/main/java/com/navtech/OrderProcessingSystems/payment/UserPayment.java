package com.navtech.OrderProcessingSystems.payment;

public class UserPayment {

	private int userId;
	private double amount;

	/* Default Constructor */
	public UserPayment() {
		// TODO Auto-generated constructor stub
	}

	/* Parameterized Constructor */
	public UserPayment(int userId, double amount) {
		super();
		this.userId = userId;
		this.amount = amount;
	}

	/* Getter-Setter */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
