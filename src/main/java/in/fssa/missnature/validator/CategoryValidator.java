package in.fssa.missnature.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.logger.Logger;
import in.fssa.missnature.model.Categories;
import in.fssa.missnature.util.ConnectionUtil;

public class CategoryValidator {

	/**
	 * 
	 * @param category
	 * @throws ValidationException
	 */
	public static void validateCategory(Categories category) throws ValidationException{
		
		if (category == null) {
			throw new ValidationException("Invalid category input");
		}
		if(category.getId() < 0) {
			throw new ValidationException("Invalid category id");
		}

		//Business validation
		
		 Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
		try {
			String query = "SELECT name FROM categories WHERE name = ?";
			con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, category.getName());
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	throw new ValidationException("Category name already exist");
            }
            
		} catch (SQLException e) {
            
            e.printStackTrace();
            Logger.info(e.getMessage());
            throw new ValidationException(e.getMessage());
        
        } finally {
            ConnectionUtil.close(con, ps);
        }

		validateName(category.getName());
	}
	
	/**
	 * 
	 * @param Categoryname
	 * @throws ValidationException
	 */
	public static void validateName(String categoryName) throws ValidationException{

		if(categoryName == null || "".equals(categoryName.trim())) {
			throw new ValidationException("Name cannot be null or empty");
		}
		
		String regexp = "^[A-Za-z][A-Za-z\\s]*$";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(categoryName);
		
		if(!matcher.matches()) {
			throw new ValidationException("Name should contains only alphabets");
		}
	}
	
	public static void validateId(int categoryId) throws ValidationException{
		
		if(categoryId < 0) {
			throw new ValidationException("Invalid Id");
		}
		
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		try {
			String query = "SELECT name FROM categories WHERE id = ?";
			con = ConnectionUtil.getConnection();
           ps = con.prepareStatement(query);
           ps.setInt(1, categoryId);
           rs = ps.executeQuery();
           
           if(!rs.next()) {
           	throw new ValidationException("Category id doesn't exist");
           }
           
		} catch (SQLException e) {
           
           e.printStackTrace();
           Logger.info(e.getMessage());
           throw new ValidationException(e.getMessage());
       
       } finally {
           ConnectionUtil.close(con, ps);
       }
	}
}
