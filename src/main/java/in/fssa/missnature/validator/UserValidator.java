package in.fssa.missnature.validator;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
import in.fssa.missnature.util.*;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.User;
import in.fssa.missnature.util.StringUtil;

public class UserValidator {
	
	private static final String NAME_PATTERN = "^[A-Za-z][A-Za-z\\s]*$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+([a-zA-Z0-9_+\\-\\. ]*[a-zA-Z0-9]+)?@[a-zA-Z0-9]+([a-zA-Z0-9\\-\\.]*[a-zA-Z0-9])?\\.[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";

	public  void validate(User user) throws ValidationException,IllegalArgumentException {
		
		if (user == null) {
			throw new ValidationException("Invalid User object");
		}

        validateName(user.getName());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword()); 
        validateMobileNumber(user.getMobile_number());

    }

	
	public  void validateUser(int id)throws ValidationException{
		
		if(id < 0) {
			throw new ValidationException("Invalid user id");
		}
		
		 Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     
		try {
			String query = "SELECT * FROM users WHERE is_active=1 AND id = ?";
			con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
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
	
    
    public  void validateMobileNumber(long mobileNumber) throws ValidationException{
        
        String phno = String.valueOf(mobileNumber);
        
        if(phno.length()<10 && phno.length()>10) { 
            throw new ValidationException("Invalid phone number");
        }
        
        if(mobileNumber <= 6000000000l || mobileNumber >= 9999999999l) {
            throw new ValidationException("Invalid phone number");
        } 
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        try {
            
            String query = "SELECT * FROM users WHERE is_active=1 AND mobile_number=?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setLong(1, mobileNumber);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                throw new ValidationException("This user is already exist");
            }
        
        } catch (SQLException e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }

    }
    
    public  void validateName(String name) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(name, "Name");
        
        if (!Pattern.matches(NAME_PATTERN, name)) {
            throw new ValidationException("Name should match the pattern");
        }
    
    }
    
    public  void validateEmail(String email) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(email, "Email");
        
        if (!Pattern.matches(EMAIL_PATTERN, email)) {
            throw new ValidationException("Email does not match the pattern");
        }
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        try {
            
            String query = "SELECT * FROM users WHERE is_active=1 AND email=?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                throw new ValidationException("This user is already exist");
            }
        
        } catch (SQLException e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        
        } finally {
            
            ConnectionUtil.close(con, ps, rs);   
        }
    }
    
    public  void validatePassword(String password) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(password, "Password");
        
        if(password.length() <8) {
            throw new ValidationException("Password must contain atleast 8 characters");
        }
        
        if (!Pattern.matches(PASSWORD_PATTERN, password)) {
            throw new ValidationException("Password does not match the pattern");
        }
    }
    
	}

