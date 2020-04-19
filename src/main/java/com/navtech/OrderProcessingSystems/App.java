package com.navtech.OrderProcessingSystems;

import com.navtech.OrderProcessingSystems.constants.OrderProcessingConstants;
import com.navtech.OrderProcessingSystems.exception.custom.InvalidOrderException;
import com.navtech.OrderProcessingSystems.exception.custom.InvalidUserException;
import com.navtech.OrderProcessingSystems.exception.custom.PaymentFailedException;
import com.navtech.OrderProcessingSystems.exception.custom.PaymentNotFoundException;
import com.navtech.OrderProcessingSystems.exception.custom.ProductAvailablityExecption;
import com.navtech.OrderProcessingSystems.exception.custom.ProductNotFoundException;
import com.navtech.OrderProcessingSystems.order.UserOrder;
import com.navtech.OrderProcessingSystems.order.UserOrderService;
import com.navtech.OrderProcessingSystems.payment.UserPayment;
import com.navtech.OrderProcessingSystems.payment.UserPaymentService;
import com.navtech.OrderProcessingSystems.product.ProductService;
import com.navtech.OrderProcessingSystems.user.User;
import com.navtech.OrderProcessingSystems.user.UserService;

public class App {
	public static void main(String[] args) {

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

	}
}
