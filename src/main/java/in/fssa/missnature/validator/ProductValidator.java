package in.fssa.missnature.validator;

import java.util.regex.Pattern;
import in.fssa.missnature.dao.ProductDAO;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.util.StringUtil;

public class ProductValidator {

	private static final String NAME_PATTERN = "^[A-Za-z][A-Za-z\\s]*$";
	
	/**  
	 * 
	 * @param product
	 * @throws ValidationException
	 * @throws PersistanceException 
	 */
	
	public void validateProduct(Product product) throws ValidationException, PersistanceException{
		
		if(product == null) {
			throw new ValidationException("Invalid Product input");
		}
		 
		validateProductId1(product.getId());
		validateName(product.getName());
		validateNameAlreadyExist(product.getName());
		validateDescription(product.getDescription());
		validateIngredients(product.getIngredients());
		validateBenefits(product.getBenefits());
		validateHowToUse(product.getHowToUse());
		validateShelfLife(product.getShelfLife());
		validateWeight(product.getWeight());
		validatePrice(product.getPrice());
		validateCategoryId(product.getCategoryId());
		validateImage(product.getImage());
	}
	
	/**
	 * 
	 * @param name
	 * @throws ValidationException
	 * @throws PersistanceException 
	 */
	
	public  void validateName(String productName) throws ValidationException, PersistanceException {
        
        StringUtil.rejectIfInvalidString(productName, "Name");
        
        if (!Pattern.matches(NAME_PATTERN, productName)) {
            throw new ValidationException("Name does not match the pattern");
        }
    }
	/**
	 * 
	 * @param uerName
	 * @throws ValidationException
	 * @throws PersistanceException
	 */
	public void validateNameAlreadyExist(String uerName)throws ValidationException, PersistanceException{
		
		ProductDAO productDAO = new ProductDAO();
        productDAO.checkProductNameExist(uerName);
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
	 * @param image
	 * @throws ValidationException
	 */
	public void validateImage(String image)throws ValidationException{
		
		StringUtil.rejectIfInvalidString(image, "image");
		
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
	 * @param productId
	 * @throws ValidationException
	 * @throws PersistanceException 
	 */
	public void validateProductId(int productId)throws ValidationException, PersistanceException{
		
		if(productId <= 0) {
			throw new ValidationException("Id cannot be negative or zero");
		} 
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.checkProductIdExist(productId);
		
	}
	
	/**
	 * 
	 * @param categoryId
	 * @throws ValidationException
	 * @throws PersistanceException 
	 */
	public void validateCategoryId(int categoryId)throws ValidationException, PersistanceException{
		
		 if (categoryId <= 0) {
		        throw new ValidationException("Category ID cannot be negative or zero");
		    }
		 ProductDAO productDAO = new ProductDAO();
		 productDAO.checkCategoryIdExist(categoryId);
	}
}