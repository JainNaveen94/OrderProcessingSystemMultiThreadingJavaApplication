package com.navtech.OrderProcessingSystems.product;

public class Product {

	private int prodId;
	private String prodName;
	private String prodDesc;
	private int prodQuantity;
	private double prodPricePerUnit;

	/* Default Constructor */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/* Parameterized Constructor */

	public Product(int prodId, String prodName, String prodDesc, int prodQuantity, double prodPricePerUnit) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodQuantity = prodQuantity;
		this.prodPricePerUnit = prodPricePerUnit;
	}

	/* Getter-Setter */

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public double getProdPricePerUnit() {
		return prodPricePerUnit;
	}

	public void setProdPricePerUnit(double prodPricePerUnit) {
		this.prodPricePerUnit = prodPricePerUnit;
	}

}
