package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.interfacesfile.UserInterface;
import in.fssa.missnature.model.User;
import in.fssa.missnature.util.ConnectionUtil;

/**
 * Below the code for Write the DAO Methods
 * @author SaranyaRamesh
 *
 */
public class UserDAO implements UserInterface{

	
	/**
	 * Below the code for creating the new user
	 * @author SaranyaRamesh
	 * @param newuser - this parameter refer the all user details 
	 */
	@Override
	public void create(User newuser)throws PersistanceException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "INSERT INTO users (name,email,password,mobileNumber) VALUES (?,?,?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newuser.getName());
			ps.setString(2, newuser.getEmail());
			ps.setString(3, newuser.getPassword());
			ps.setLong(4, newuser.getMobileNumber());
			
			ps.executeUpdate();
			
			System.out.println("User created Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	
	/**
	 * Below the code for update the specific user password
	 * @author SaranyaRamesh
	 * @param id, newPassword - id refers to the user id & newPassword refers to the password given by the user
	 *  
	 */
	@Override
	public void updatePassword(int id, String newPassword)throws PersistanceException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE users SET password = ? WHERE id = ? AND isActive = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Password updated successfully");
			}
		} catch (SQLException e) {
			throw new PersistanceException(e.getMessage());	
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		
	}
	
	/**
	 * Below the code for delete a particular user
	 * @author SaranyaRamesh
	 * @param userId - this parameter refer to a unique existing userId
	 */
	
	@Override
	public void delete(int userId) throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "Update users SET isActive = 0 WHERE id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ps.executeUpdate();
			
			System.out.println("User deleted Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		
	}

	/**
	 * Below the code for update user name
	 * @author SaranyaRamesh
	 * @param id, newName - id refers to the user id & newName refers to the updated name given by the user
	 */
	
	@Override
	public void updateName(int id, String newName)throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE users SET name = ? WHERE id = ? AND isActive = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newName);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Name updated successfully");
			}
		} catch (SQLException e) {
			throw new PersistanceException(e.getMessage());	
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		
	}
	
	public void checkEmailExist(String userEmail) throws PersistanceException{
		
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        try {
            
            String query = "SELECT name, email FROM users WHERE isActive=1 AND email=?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, userEmail);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                throw new PersistanceException("This user is already exist");
            }
        
        } catch (SQLException e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new PersistanceException(e.getMessage());
        
        } finally {
            
            ConnectionUtil.close(con, ps, rs);   
        }
	}
	
	public void checkMobileNumberExist (long mobileNumber)throws PersistanceException{
		
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        try {
            
            String query = "SELECT name FROM users WHERE isActive=1 AND mobileNumber=?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setLong(1, mobileNumber);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                throw new PersistanceException("This user is already exist");
            }
        
        } catch (SQLException e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new PersistanceException(e.getMessage());
        
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }
	}
	
}
