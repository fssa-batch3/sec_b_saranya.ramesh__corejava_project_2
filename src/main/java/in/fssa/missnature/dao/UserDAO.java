package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.interfacesfile.UserInterface;
import in.fssa.missnature.logger.Logger;
import in.fssa.missnature.model.Product;
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

			Logger.info("User created Successfully");
			
		}catch(SQLException e) {
			Logger.info(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	
	@Override
	public void updateUser(User user) throws PersistanceException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "UPDATE users SET name = ?, city = ?, state = ?, pincode = ?, address = ? WHERE email = ? AND isActive = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
		
			ps.setString(1, user.getName());
			ps.setString(2, user.getCity());
			ps.setString(3, user.getState());
			ps.setString(4, user.getPincode());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getEmail());
			int rowsAffected = ps.executeUpdate();
				if(rowsAffected > 0) {
					Logger.info("User updated successfully");
				}
			} catch (SQLException e) {
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
				Logger.info("Password updated successfully");
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
	public void delete(String email) throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "Update users SET isActive = 0 WHERE email = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.executeUpdate();
			
			Logger.info("User deleted Successfully");
			
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
				Logger.info("Name updated successfully");
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
            Logger.info(e.getMessage());
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
                throw new PersistanceException("This mobileNumber is already exist");
            }
        
        } catch (SQLException e) {
            
            e.printStackTrace();
            Logger.info(e.getMessage());
            throw new PersistanceException(e.getMessage());
        
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }
	}
	
	/**
	 *
	 * @param emailId
	 * @param password
	 * @return
	 * @throws PersistanceException
	 * @throws SQLException
	 */
	
	public boolean userLogin(String emailId, String password) throws PersistanceException, SQLException {
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        if (emailExists(emailId, connection)) {
	            String selectQuery = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ? AND isActive = 1";
	            try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
	                psmt.setString(1, emailId);
	                psmt.setString(2, password);

	                try (ResultSet rs = psmt.executeQuery()) {
	                    if (rs.next()) {
	                        int count = rs.getInt(1);
	                        if (count > 0) {
	                            return true;
	                        } else {
	                            throw new PersistanceException("User not found");
	                        }
	                    }
	                }
	            }
	        } else {
	            throw new PersistanceException("Invalid Email Id");
	        }
	    }
	    return false;
	}

	 
	/**
	 * 
	 * @param email
	 * @param connection
	 * @return
	 * @throws PersistanceException
	 */
	 
	private boolean emailExists(String email, Connection connection) throws PersistanceException {
        String selectQuery = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
            psmt.setString(1, email);
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new PersistanceException("Error while checking email existence: " + e.getMessage());
        }
        return false;
    }
	
	@Override
	public User findUserByEmail(String email) throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			String query = "SELECT id, name, email, mobileNumber, state, city, pincode, address FROM users WHERE email = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
		
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setMobileNumber(rs.getLong("mobileNumber"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setPincode(rs.getString("pincode"));
				user.setAddress(rs.getString("address"));
				
			}
		} catch(SQLException e) {
			Logger.info(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return user;
		}

	@Override
	public int findUserIdByEmail(String email) throws PersistanceException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userId;
		try {
			String query = "SELECT id FROM users WHERE email= ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			userId = rs.getInt("id");
			
		}catch(SQLException e) {
			Logger.info(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		return userId;
	}
}
