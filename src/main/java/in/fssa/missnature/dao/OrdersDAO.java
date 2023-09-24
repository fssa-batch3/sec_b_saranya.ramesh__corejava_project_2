package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.logger.Logger;
import in.fssa.missnature.model.Orders;
import in.fssa.missnature.util.ConnectionUtil;

public class OrdersDAO {

	public void create(Orders order)throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "INSERT INTO orders (userId, productId, address, price, productName, quantity, userName, productWeight, quantityUnit, productImage) VALUES (?,?,?,?,?,?,?,?,?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getProductId());
			ps.setString(3, order.getAddress());
			ps.setInt(4, order.getPrice());
			ps.setString(5, order.getProductName());
			ps.setInt(6, order.getQuantity());
			ps.setString(7, order.getUserName());
			ps.setInt(8, order.getProductWeight());
			ps.setString(9, order.getQuantityUnit().toString());
			ps.setString(10, order.getProductImage());
			ps.executeUpdate();
			
			
		}
		catch(SQLException e) {
			Logger.info(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		
	}
	
	public Set<Orders> listOrderById(int userId) throws PersistanceException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Set<Orders> listOrderById = new HashSet<>();

        try {
            String query = "SELECT * FROM orders WHERE userId = ?";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders();
                orders.setId(rs.getInt("id"));
                orders.setAddress(rs.getString("address"));
                orders.setProductImage(rs.getString("productImage"));
                orders.setUserName(rs.getString("userName"));
                orders.setProductName(rs.getString("productName"));
                orders.setProductWeight(rs.getInt("productWeight"));
                orders.setQuantityUnit(Orders.QuantityUnit.valueOf(rs.getString("quantityUnit")));
                orders.setPrice(rs.getInt("price"));
                orders.setQuantity(rs.getInt("quantity"));
                orders.setActive(rs.getBoolean("isActive"));
                //below the code for formatting
                LocalDateTime dateTime = rs.getTimestamp("date").toLocalDateTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
                String formattedDateTime = dateTime.format(formatter);
                
                orders.setDate(formattedDateTime);

                listOrderById.add(orders);
            }
        } catch (SQLException e) {
            Logger.info(e.getMessage());
            throw new PersistanceException(e.getMessage());
            
        } finally {
            ConnectionUtil.close(conn, ps);
        }
        return listOrderById;
    }
	
	public Set<Orders> listOrders()throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Set<Orders> orderList = new HashSet<>(); 
		
		try {
			String query = "SELECT * FROM orders";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Orders orders = new Orders();
				orders.setId(rs.getInt("id"));
				orders.setAddress(rs.getString("address"));
				orders.setProductImage(rs.getString("productImage"));
				orders.setUserName(rs.getString("userName"));
				orders.setProductName(rs.getString("productName"));
				orders.setProductWeight(rs.getInt("productWeight"));
				orders.setQuantityUnit(Orders.QuantityUnit.valueOf(rs.getString("quantityUnit")));
				orders.setPrice(rs.getInt("price"));
				orders.setQuantity(rs.getInt("quantity"));
				
				orderList.add(orders);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			Logger.info(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		return orderList;
	}
	
	
	public void cancelOrder(int id)throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE orders SET isActive = 0 WHERE id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			Logger.info("Order canceled successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	
}