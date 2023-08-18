package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import in.fssa.missnature.interfacesfile.UserInterface;
import in.fssa.missnature.model.User;
import in.fssa.missnature.util.ConnectionUtil;

public class UserDAO implements UserInterface{

	@Override
	public void create(User newuser) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "INSERT INTO users (name,email,password,mobile_number)values(?,?,?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newuser.getName());
			ps.setString(2, newuser.getEmail());
			ps.setString(3, newuser.getPassword());
			ps.setLong(4, newuser.getMobile_number());
			
			ps.executeUpdate();
			
			System.out.println("User created Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	
	@Override
	public void updatePassword(int id, String newPassword) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE users set password = ? WHERE id = ? AND is_active = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Password updated successfully");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);	
		}
		
	}
	
	@Override
	public void delete(int userId) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "Update users set is_active = ? WHERE id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setBoolean(1, false);
			ps.setInt(2, userId);
			ps.executeUpdate();
			
			System.out.println("User deleted Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		
	}

	@Override
	public void updateName(int id, String newName) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE users set name = ? WHERE id = ? AND is_active = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newName);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Name updated successfully");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);	
		}
		
	}
	
}
