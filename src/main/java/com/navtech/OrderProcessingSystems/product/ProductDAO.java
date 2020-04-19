package com.navtech.OrderProcessingSystems.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;

public class ProductDAO {

	// Collection To Manage Products
	private ConcurrentHashMap<Integer, Product> products;

	// Single Private Instance of ProductDAO
	private static ProductDAO productDao;

	// Private Constructor so that no new Instance is created
	private ProductDAO() {
		this.products = new ConcurrentHashMap<Integer, Product>();
	}

	// Get the Single Instance of Product DAO
	public static ProductDAO getProductDAOInstance() {
		if (productDao == null) {
			productDao = new ProductDAO();
		}
		return productDao;
	}

	// Used to Initilize the User Order Collection from json File
	public void initiateProductHashMap() {
		productDao.setProducts(productDao.listToHashMap(productDao.getProductList()));
	}

	// Used to Read the JSON File of Product
	private List<Product> getProductList() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
		};
		try {
			return mapper.readValue(new File(OrderProcessingConstants.PRODUCT_PATH), typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Product>();
	}

	// Used to Convert the List of Products to ConcurrentHashMap of Products
	private ConcurrentHashMap<Integer, Product> listToHashMap(List<Product> productList) {
		ConcurrentHashMap<Integer, Product> products = new ConcurrentHashMap<Integer, Product>();
		// Converting List to HashMap Here
		for (Product product : productList) {
			products.put(product.getProdId(), product);
		}
		return products;
	}

	
	// Getter-Setter
	public ConcurrentHashMap<Integer, Product> getProducts() {
		return productDao.products;
	}

	private void setProducts(ConcurrentHashMap<Integer, Product> products) {
		productDao.products = products;
	}
	
	

}
