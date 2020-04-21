package com.navtech.OrderProcessingSystems.processorder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;
import com.navtech.OrderProcessingSystems.exception.custom.PaymentFailedException;
import com.navtech.OrderProcessingSystems.order.UserOrder;
import com.navtech.OrderProcessingSystems.order.UserOrderService;
import com.navtech.OrderProcessingSystems.payment.UserPayment;
import com.navtech.OrderProcessingSystems.payment.UserPaymentService;
import com.navtech.OrderProcessingSystems.product.ProductService;
import com.navtech.OrderProcessingSystems.user.User;
import com.navtech.OrderProcessingSystems.user.UserService;

public class OrderService {

	// Instances Of Services related to Order Processing
	UserService userService = new UserService();
	UserOrderService orderService = new UserOrderService();
	UserPaymentService paymentService = new UserPaymentService();
	ProductService productService = new ProductService();

	// Process the Order Through Completable Future Concept
	@SuppressWarnings("unused")
	public void processOrder(ThreadPoolExecutor executor) {
		for (int i = 1; i < 20; i++) {
			final int orderId = i;
			CompletableFuture.supplyAsync(() -> {
				sleep(500);
				return orderService.fetchOrder(orderId);
			}, executor).exceptionally((ex) -> {
				System.out.println(Thread.currentThread() + " : Order Having OrderId " + orderId + " => " + ex.getMessage());
				return null;
			}).thenApply(order -> {
				if (order != null) {
					sleep(500);
					User user = userService.verfiedUser(order.getUserId());
				}
				return order;
			}).exceptionally((ex) -> {
				System.out.println(Thread.currentThread() + " : Order Having OrderId " + orderId + " => " + ex.getMessage());
				return null;
			}).thenApply(order -> {
				if (order != null) {
					sleep(500);
					boolean productAvalability = productService
							.verifyProductsQuantityAndAvailablity(order.getProductList());
				}
				return order;
			}).exceptionally((ex) -> {
				System.out.println(Thread.currentThread() + " : Order Having OrderId " + orderId + " => " + ex.getMessage());
				return null;
			}).thenAccept(order -> {
				if (order != null) {
					sleep(500);
					UserPayment payment = paymentService.fetechUserPayment(order.getUserId());
					if (payment != null && order.getTotalAmount() < payment.getAmount()) {
						finilizeOrder(order, payment);
					} else {
						throw new PaymentFailedException(OrderProcessingConstants.PAYMENT_FAILED);
					}
				}
			}).exceptionally((ex) -> {
				System.out.println(Thread.currentThread() + " : Order Having OrderId " + orderId + " => " + ex.getMessage());
				return null;
			});
		}
		executor.shutdown();
	}

	// just to sleep thread for some times
	public boolean sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException exception) {
			System.out.println(Thread.currentThread() + " : " + "time Out for Execution of Task");
		}
		return true;
	}

	// Finilize the Order if All the Validation is passesd
	public void finilizeOrder(UserOrder order, UserPayment payment) {
		if (paymentService.updatePaymentBalance(order.getUserId(), (payment.getAmount() - order.getTotalAmount()))
				&& productService.updateProductsQuantityAndAvailability(order.getProductList())) {
			System.out.println(Thread.currentThread() + " : Order Having OrderId " + order.getOrderId() + " => " + OrderProcessingConstants.SUCCESS_ORDER);
		} else {
			System.out.println(Thread.currentThread() + " : Order Having OrderId " + order.getOrderId() + " => " + OrderProcessingConstants.SERVER_ISSUE);
		}
	}

}
