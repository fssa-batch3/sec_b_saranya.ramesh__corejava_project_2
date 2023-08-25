package in.fssa.missnature.service;

import java.util.Set;

import in.fssa.missnature.dao.*;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.validator.ProductValidator;

public class ProductService {
	
/**
 * 
 * @return
 * @throws Exception
 */
	public Set<Product> listAllProduct()throws Exception{
		
		ProductDAO productDAO = new ProductDAO();
		Set<Product> allProducts = productDAO.listAllProducts();
		
		return allProducts;
	}
	/**
	 * 
	 * @param category_id
	 * @return
	 * @throws Exception
	 */
	
	public Set<Product> findProductDetailByCategoryId(int categoryId) throws Exception {
	    
		ProductValidator validator = new ProductValidator();
	    validator.validateCategoryId(categoryId);
	    
	    ProductDAO productDAO = new ProductDAO();
	    Set<Product> products = productDAO.listallProductsByCategoryId(categoryId);
	    
	    return products;
	}
	/**
	 * 
	 * @param product_id
	 * @return
	 * @throws Exception
	 */
	public Product FindProductDetailsByProductId(int productId)throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProductId(productId);
		
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.findProductDetailsByProductId(productId);
		
		return product;
		
	}
/**
 * 
 * @param id
 * @param price
 * @throws Exception
 */
	public void updateProductPrice(int id, int price)throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProductId(id);
		validator.validatePrice(price);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.updatePrice(id, price);
		
	}
	/**
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void updateProduct(Product product) throws Exception{
		
		ProductValidator validator = new ProductValidator();
		
		validator.validateProductId(product.getId());
		validator.validateName(product.getName());
		validator.validateCategoryId(product.getCategoryId());
		validator.validateDescription(product.getDescription());
		validator.validateWeight(product.getWeight());
		validator.validateIngredients(product.getIngredients());
		validator.validateBenefits(product.getBenefits());
		validator.validateHowToUse(product.getHowToUse());
		validator.validateShelfLife(product.getShelfLife());
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.updateProduct(product);
									
	}
	/**
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void createProduct(Product product)throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProduct(product);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.create(product);
		
	}
	/**
	 * 
	 * @param productId
	 * @throws Exception
	 */
	public void deleteProduct(int productId) throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProductId(productId);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.deleteProduct(productId);
		
	}

}
