package in.fssa.missnature.service;

import in.fssa.missnature.dao.OrdersDAO;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ServiceException;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Orders;
import in.fssa.missnature.validator.OrderValidator;


public class OrderService {

public void createOrder(Orders order)throws ServiceException{
		
		
		OrderValidator validator = new OrderValidator();
		OrdersDAO orderDAO = new OrdersDAO();
		
		try {
		validator.validateAddress(order.getAddress());
		validator.validateProductName(order.getProductName());
		validator.validateProductPrice(order.getPrice());
		validator.validateQuantity(order.getQuantity());
		
		orderDAO.create(order);
		}
		 catch(PersistanceException | ValidationException e) {
			 throw new ServiceException(e.getMessage());
		 }
		
	}
	}

