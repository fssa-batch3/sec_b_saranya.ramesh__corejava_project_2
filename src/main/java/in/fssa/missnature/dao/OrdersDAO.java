package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.logger.Logger;
import in.fssa.missnature.model.Orders;
import in.fssa.missnature.util.ConnectionUtil;

public class OrdersDAO {

	public void create(Orders order)throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "INSERT INTO orders (userId, productId, address, price, productName, quantity) VALUES (?,?,?,?,?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getProductId());
			ps.setString(3, order.getAddress());
			ps.setInt(4, order.getPrice());
			ps.setString(5, order.getProductName());
			ps.setInt(6, order.getQuantity());
			ps.executeUpdate();
			Logger.info("Order created Successfully");
			
		}
		catch(SQLException e) {
			Logger.info(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
}
