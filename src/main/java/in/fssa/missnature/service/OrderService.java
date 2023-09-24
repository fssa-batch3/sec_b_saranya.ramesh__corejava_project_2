package in.fssa.missnature.service;

import java.util.Set;

import in.fssa.missnature.dao.OrdersDAO;
import in.fssa.missnature.dao.ProductDAO;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ServiceException;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Orders;
import in.fssa.missnature.model.Product;
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

	public Set<Orders> listOrdersById(int userId)throws ServiceException{
		
		OrdersDAO orderDAO = new OrdersDAO();
		Set<Orders> allOrderById;
		try {
			allOrderById = orderDAO.listOrderById(userId);
		}
		catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
		return allOrderById;
	}
	
	public Set<Orders> listOrders()throws ServiceException{
		
		OrdersDAO orderDAO = new OrdersDAO();
		Set<Orders> listOrders;
		try {
			listOrders = orderDAO.listOrders();
		}
		catch(PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
		return listOrders;
	}
	
	public void cancelOrder(int id)throws ServiceException{
		
		OrdersDAO orderDAO = new OrdersDAO();
		try {
			orderDAO.cancelOrder(id);
		}
		catch(PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}

