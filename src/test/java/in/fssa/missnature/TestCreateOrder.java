package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.Orders;
import in.fssa.missnature.service.OrderService;

public class TestCreateOrder {

	@Test
	 void testCreateOrderWithValidInput() {
		
		OrderService orderService = new OrderService();
		Orders order = new Orders();
		order.setAddress("12/24, ranga nagar, peungalathur, chennai");
		order.setProductId(1);
		order.setUserId(1);
		assertDoesNotThrow(() ->{
			orderService.createOrder(order);
		});
	}
}
