package in.fssa.missnature.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.util.ConnectionUtil;
import in.fssa.missnature.util.StringUtil;

public class ProductValidator {

	private static final String NAME_PATTERN = "^[A-Za-z][A-Za-z\\s]*$";
	
	/**
	 * 
	 * @param product
	 * @throws ValidationException
	 */
	
	public void validateProduct(Product product) throws ValidationException{
		
		if(product == null) {
			throw new ValidationException("Invalid Product input");
		}
		// business validation
		 Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     
		try {
			String query = "SELECT * FROM products WHERE name = ?";
			con = ConnectionUtil.getConnection();
         ps = con.prepareStatement(query);
         ps.setString(1, product.getName());
         rs = ps.executeQuery();
         
         if(rs.next()) {
       	  throw new ValidationException("product already exists");		
         }
		}catch (SQLException e) {
         e.printStackTrace();
         System.out.println(e.getMessage());
         throw new RuntimeException(e);
     
     } finally {
         ConnectionUtil.close(con, ps);
     }
		validateProductId1(product.getId());
		validateName(product.getName());
		validateDescription(product.getDescription());
		validateIngredients(product.getIngredients());
		validateBenefits(product.getBenefits());
		validateHowToUse(product.getHow_to_use());
		validateShelfLife(product.getShelf_life());
		validateWeight(product.getProduct_weight());
		validatePrice(product.getPrice());
		validateCategoryId(product.getCategory_id());
		
	}
	
	/**
	 * 
	 * @param name
	 * @throws ValidationException
	 */
	
	public  void validateName(String name) throws ValidationException {
        
        StringUtil.rejectIfInvalidString(name, "Name");
        
        if (!Pattern.matches(NAME_PATTERN, name)) {
            throw new ValidationException("Name does not match the pattern");
        }
    
    }
	
	/**
	 * 
	 * @param description
	 * @throws ValidationException
	 */
	public void validateDescription(String description)throws ValidationException{
		
		StringUtil.rejectIfInvalidString(description, "description");
	}
	/**
	 * 
	 * @param ingredients
	 * @throws ValidationException
	 */
	public void validateIngredients(String ingredients)throws ValidationException{
		
		StringUtil.rejectIfInvalidString(ingredients, "Ingredients");
	}
	/**
	 * 
	 * @param benefits
	 * @throws ValidationException
	 */
	public void validateBenefits(String benefits)throws ValidationException{
		
		StringUtil.rejectIfInvalidString(benefits, "Benefits");
	}
	/**
	 * 
	 * @param howToUse
	 * @throws ValidationException
	 */
	public void validateHowToUse(String howToUse)throws ValidationException{
		
		StringUtil.rejectIfInvalidString(howToUse, "HowToUse");
	}
	/**
	 * 
	 * @param shelfLife
	 * @throws ValidationException
	 */
	public void validateShelfLife(String shelfLife)throws ValidationException{
		
		StringUtil.rejectIfInvalidString(shelfLife, "ShelfLife");
	}
	/**
	 * 
	 * @param weight
	 * @throws ValidationException
	 */
	public void validateWeight(int weight)throws ValidationException{
		
		if(weight <= 0) {
			throw new ValidationException("Weight cannot be zero or negative");
		}
	}
	/**
	 * 
	 * @param price
	 * @throws ValidationException
	 */
	public void validatePrice(int price)throws ValidationException{
		
		if(price < 0) {
			throw new ValidationException("Price cannot be negative or zero");
		}
	}
	/**
	 * 
	 * @param productId
	 * @throws ValidationException
	 */
	public void validateProductId1(int productId)throws ValidationException{
		if(productId < 0) {
			throw new ValidationException("Id cannot be negative or zero");
		}
	}
	/**
	 * 
	 * @param productId
	 * @throws ValidationException
	 */
	public void validateProductId(int productId)throws ValidationException{
		
		if(productId <= 0) {
			
			throw new ValidationException("Id cannot be negative or zero");
		}
		
		 Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     
		try {
			String query = "SELECT * FROM products WHERE id = ?";
			con = ConnectionUtil.getConnection();
           ps = con.prepareStatement(query);
           ps.setInt(1, productId);
           rs = ps.executeQuery();
           
           if(rs.next()) {
           	System.out.println("product exists");
           }else {
           	throw new ValidationException("product doesn't exist");
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
	 * @param categoryId
	 * @throws ValidationException
	 */
	public void validateCategoryId(int categoryId)throws ValidationException{
		
		 if (categoryId <= 0) {
		        throw new ValidationException("Category ID cannot be negative or zero");
		    }
		 Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     
		try {
			String query = "SELECT * FROM category WHERE id = ?";
			con = ConnectionUtil.getConnection();
           ps = con.prepareStatement(query);
           ps.setInt(1, categoryId);
           rs = ps.executeQuery();
           
           if(rs.next()) {
           	System.out.println("category exists");
           }else {
           	throw new ValidationException("category doesn't exist");
           }		
		} catch (SQLException e) {
			
           e.printStackTrace();
           System.out.println(e.getMessage());
           throw new RuntimeException(e);
       
       } finally {
           ConnectionUtil.close(con, ps);
       }
	}
}
