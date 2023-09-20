package in.fssa.missnature.validator;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import in.fssa.missnature.util.*;
import in.fssa.missnature.dao.UserDAO;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.logger.Logger;
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
        checkEmailAlreadyExist(user.getEmail());
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
            	Logger.info("user exists");
            }else {
            	throw new ValidationException("user doesn't exist");
            }		
		} catch (SQLException e) {
			
            e.printStackTrace();
            Logger.info(e.getMessage());
            throw new ValidationException(e.getMessage());
        
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
    /**
     * @param userName
     * @throws ValidationException
     */
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
     */
    
    public void validateEmail(String userEmail) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(userEmail, "Email");
        
        if (!Pattern.matches(EMAIL_PATTERN, userEmail)) {
            throw new ValidationException("Email does not match the pattern");
        }
               
    }
    
    /**
     * @param userEmail
     * @throws ValidationException
     * @throws PersistanceException
     */
    public void checkEmailAlreadyExist(String userEmail)throws ValidationException, PersistanceException{
    	
    	UserDAO userDAO = new UserDAO();
        userDAO.checkEmailExist(userEmail);

    }
    /**
     * @param password
     * @throws ValidationException
     */
    public void validatePassword(String userPassword) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(userPassword, "Password");
        
        if(userPassword.length() <8) {
            throw new ValidationException("Password must contain atleast 8 characters");
        }
        
        if (!Pattern.matches(PASSWORD_PATTERN, userPassword)) {
            throw new ValidationException("Password does not match the pattern");
        }
    }
    
    // below the code to validate address null or empty string
    
    public void validateAddress(String userAddress)throws ValidationException{
    	
    	StringUtil.rejectIfInvalidString(userAddress, "userAddress");	
    }
    
    /**
     * below the code to validate pincode
     * @param userPincode
     * @throws ValidationException
     */
    public void validatePincode(String userPincode) throws ValidationException{
    	
    	String pinCodePattern = "^[1-9][0-9]{5}$";
    	
    	Pattern pattern = Pattern.compile(pinCodePattern);
        Matcher matcher = pattern.matcher(userPincode);
        
        if(!matcher.matches()) {
        	throw new ValidationException("pincode does not match the pattern");
        }
    }
    
    /**
     * below the code to validate city name
     * @param userCity
     * @throws ValidationException
     */
    public void validateCity(String userCity)throws ValidationException{
    	
    	StringUtil.rejectIfInvalidString(userCity, "userCity");
    	
    	 String cityPattern = "^[a-zA-Z\\s\\-'’]+$";
    	    int minLength = 2;
    	    int maxLength = 50;
    	    if(!userCity.matches(cityPattern) && userCity.length() >= minLength && userCity.length() <= maxLength) {
    	    	throw new ValidationException("city name does not match the pattern");
    	    }
    }
    
    public void validateState(String state) throws ValidationException{
    	
    	String statePattern = "^[A-Za-z\\s.'-]+$";
    	if(!state.matches(statePattern)) {
    		throw new ValidationException("Invalid state name");
    	}
    }
}