package com.navtech.OrderProcessingSystems;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.navtech.OrderProcessingSystems.processorder.OrderService;
//import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;
//import com.navtech.OrderProcessingSystems.exception.custom.InvalidOrderException;
//import com.navtech.OrderProcessingSystems.exception.custom.InvalidUserException;
//import com.navtech.OrderProcessingSystems.exception.custom.PaymentFailedException;
//import com.navtech.OrderProcessingSystems.exception.custom.PaymentNotFoundException;
//import com.navtech.OrderProcessingSystems.exception.custom.ProductAvailablityExecption;
//import com.navtech.OrderProcessingSystems.exception.custom.ProductNotFoundException;
//import com.navtech.OrderProcessingSystems.order.UserOrder;
//import com.navtech.OrderProcessingSystems.order.UserOrderService;
//import com.navtech.OrderProcessingSystems.payment.UserPayment;
//import com.navtech.OrderProcessingSystems.payment.UserPaymentService;
//import com.navtech.OrderProcessingSystems.product.ProductService;
//import com.navtech.OrderProcessingSystems.user.User;
//import com.navtech.OrderProcessingSystems.user.UserService;

public class App {
	public static void main(String[] args) {
		
		/********************************************************************************/
		
		// Just to check the Services using Single Flow
		/*
		UserOrderService orderService = new UserOrderService();
		UserService userService = new UserService();
		UserPaymentService paymentService = new UserPaymentService();
		ProductService productService = new ProductService();
		try {
			UserOrder order = orderService.fetchOrder(9);
			if (order != null) {
				System.out.println("Order Exist Having Total Amount :: " + order.getTotalAmount());
				User user = userService.verfiedUser(order.getUserId());
				if (user != null) {
					System.out.println("User Exist Having Name :: " + user.getName());
					boolean productAvalibility = productService
							.verifyProductsQuantityAndAvailablity(order.getProductList());
					if (productAvalibility) {
						System.out.println("Products are Available");
						UserPayment payment = paymentService.fetechUserPayment(user.getId());
						if (payment != null) {
							System.out.println("Balance Available :: " + payment.getAmount());
							if (payment.getAmount() < order.getTotalAmount()) {
								throw new PaymentFailedException(OrderProcessingConstants.PAYMENT_FAILED);
							} else {

								if (paymentService.updatePaymentBalance(order.getUserId(),
										(payment.getAmount() - order.getTotalAmount()))
										|| productService
												.updateProductsQuantityAndAvailability(order.getProductList())) {
									System.out.println(OrderProcessingConstants.SUCCESS_ORDER);
								}
								System.out.println("Updated Balance :: "
										+ (float) paymentService.fetechUserPayment(user.getId()).getAmount());
							}
						}
					}
				}
			}
		} catch (InvalidOrderException exception) {
			System.out.println(exception.getMessage());
		} catch (InvalidUserException exception) {
			System.out.println(exception.getMessage());
		} catch (ProductAvailablityExecption exception) {
			System.out.println(exception.getMessage());
		} catch (ProductNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (PaymentFailedException exception) {
			System.out.println(exception.getMessage());
		} catch (PaymentNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
		*/
	/*************************************************************************************/
		
		// Use this when you want to Create the ThreadPoolExecutor using its Contructor
		/*
		// Creating Blocking Queue
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);

		// Creating Thread Pool having size min=2 and max=4 and timeout is 3 Seconds and
		// custom Blocking Queue
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, blockingQueue);
		*/
		
		// Use this when use want to create the ThreadPoolExecutor using Executors Interface
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

		// Instance of the Order Service
		OrderService process = new OrderService();
		
		// Call To Process the List of Orders
		process.processOrder(executor);

	}
}
