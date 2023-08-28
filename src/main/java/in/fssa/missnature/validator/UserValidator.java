package in.fssa.missnature.validator;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import in.fssa.missnature.util.*;
import in.fssa.missnature.dao.UserDAO;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.User;
import in.fssa.missnature.util.StringUtil;

public class UserValidator {
	
	private static final String NAME_PATTERN = "^[A-Za-z][A-Za-z\\s]*$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+([a-zA-Z0-9_+\\-\\. ]*[a-zA-Z0-9]+)?@[a-zA-Z0-9]+([a-zA-Z0-9\\-\\.]*[a-zA-Z0-9])?\\.[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";

    /**
     * 
     * @param user
     * @throws ValidationException
     * @throws PersistanceException 
     */
	public  void validate(User user) throws ValidationException, PersistanceException {
		
		if (user == null) {
			throw new ValidationException("User object cannot be null");
		}

        validateName(user.getName());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword()); 
        validateMobileNumber(user.getMobileNumber());

    }

	/**
	 * 
	 * @param id
	 * @throws ValidationException
	 */
	public  void validateUser(int UserId)throws ValidationException{
		
		if(UserId < 0) {
			throw new ValidationException("Invalid user id");
		}
		
		 Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     
		try {
			String query = "SELECT name FROM users WHERE isActive = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, UserId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	System.out.println("user exists");
            }else {
            	throw new ValidationException("user doesn't exist");
            }		
		} catch (SQLException e) {
			
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        
        } finally {
            ConnectionUtil.close(con, ps);
        }

	}
	
    /**
     * 
     * @param mobileNumber
     * @throws ValidationException
     * @throws PersistanceException 
     */
    public  void validateMobileNumber(long mobileNumber) throws ValidationException, PersistanceException{
        
        String phno = String.valueOf(mobileNumber);
        
        if(phno.length()<10 && phno.length()>10) { 
            throw new ValidationException("Invalid phone number");
        }
        
        if(mobileNumber <= 6000000000l || mobileNumber >= 9999999999l) {
            throw new ValidationException("Invalid phone number");
        } 
        UserDAO userDAO = new UserDAO();
        userDAO.checkMobileNumberExist(mobileNumber);
        
    }
    
    public  void validateName(String userName) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(userName, "Name");
        
        if (!Pattern.matches(NAME_PATTERN, userName)) {
            throw new ValidationException("Name should contains only alphabets");
        }
    
    }
    /**
     * 
     * @param email
     * @throws ValidationException
     * @throws PersistanceException 
     */
    
    public void validateEmail(String userEmail) throws ValidationException, PersistanceException {
        
        StringUtil.rejectIfInvalidString(userEmail, "Email");
        
        if (!Pattern.matches(EMAIL_PATTERN, userEmail)) {
            throw new ValidationException("Email does not match the pattern");
        }
        
        UserDAO userDAO = new UserDAO();
        userDAO.checkEmailExist(userEmail);
        
    }
    /**
     * 
     * @param password
     * @throws ValidationException
     */
    public  void validatePassword(String userPassword) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(userPassword, "Password");
        
        if(userPassword.length() <8) {
            throw new ValidationException("Password must contain atleast 8 characters");
        }
        
        if (!Pattern.matches(PASSWORD_PATTERN, userPassword)) {
            throw new ValidationException("Password does not match the pattern");
        }
    }
    
	}