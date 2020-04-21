package com.navtech.OrderProcessingSystems.product;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;
import com.navtech.OrderProcessingSystems.exception.custom.ProductAvailablityExecption;
import com.navtech.OrderProcessingSystems.exception.custom.ProductNotFoundException;

public class ProductService {

	// Creating the Instance of Product DAO
	ProductDAO productDAO = ProductDAO.getProductDAOInstance();

	// Default Constructor
	public ProductService() {
		// Initilizing the Product Collection
		productDAO.initiateProductHashMap();
	}

	// Verify the Products Quantity
	public boolean verifyProductsQuantityAndAvailablity(List<Product> products) {
		Product dbProduct;
		for (Product product : products) {
			dbProduct = productDAO.getProducts().get(product.getProdId());
			if (dbProduct == null) {
				throw new ProductNotFoundException(OrderProcessingConstants.INVALID_PRODUCT);
			} else if (product.getProdQuantity() > dbProduct.getProdQuantity()) {
				throw new ProductAvailablityExecption(OrderProcessingConstants.PRODUCT_UNAVAILABLE);
			}
		}

		return true;
	}

	// Update the Product Quantity
	public synchronized boolean updateProductsQuantityAndAvailability(List<Product> products) {

		// Feteching the HashMap of Products
		ConcurrentHashMap<Integer, Product> dbProducts = productDAO.getProducts();

		// Creating Instance of Product
		Product dbProduct;
		for (Product product : products) {
			// Get the Specific Product
			dbProduct = dbProducts.get(product.getProdId());

			// System.out.println( Thread.currentThread() + " : " +
			// dbProduct.getProdQuantity());

			// Update the Product Quantity
			dbProduct.setProdQuantity(dbProduct.getProdQuantity() - product.getProdQuantity());

			// System.out.println( Thread.currentThread() + " : " +
			// dbProduct.getProdQuantity());

			// Updation Done here
			dbProducts.put(product.getProdId(), dbProduct);
		}
		return true;
	}

}
