package in.fssa.missnature.service;

import java.util.Set;

import in.fssa.missnature.dao.*;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ServiceException;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.validator.ProductValidator;

public class ProductService {
	
/**
 * 
 * @return
 * @throws Exception
 */
	public Set<Product> listAllProduct()throws ServiceException{
		
		ProductDAO productDAO = new ProductDAO();
		Set<Product> allProducts;
		try {
			allProducts = productDAO.listAllProducts();
		} catch (PersistanceException e) {
			throw new ServiceException("Error while listing the product" + e.getMessage());
		}
		return allProducts;
	}
	/**
	 * 
	 * @param skinType
	 * @return
	 * @throws Exception
	 */
	public Set<Product> listAllProductsBySkinType(String skinType)throws ServiceException{
		
		ProductDAO productDAO = new ProductDAO();
		Set<Product> allProdBySkinType;
		try {
			allProdBySkinType = productDAO.listProductBySkinType(skinType);
		} catch (PersistanceException e) {
			throw new ServiceException("Error while listing product by skin type" + e.getMessage());
		}
		
		return allProdBySkinType;
	}
	/**
	 * 
	 * @param productType
	 * @return
	 * @throws Exception
	 */
	public Set<Product> listAllProductByProductType(String productType)throws ServiceException{
		
		ProductDAO productDAO = new ProductDAO();
		Set<Product> allProdByProdType;
		try {
			allProdByProdType = productDAO.listProductByProductType(productType);
		}
		catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return allProdByProdType;
	}
	/**
	 * 
	 * @param category_id
	 * @return
	 * @throws Exception
	 */
	
	public Set<Product> findProductDetailByCategoryId(int categoryId) throws ServiceException {
	    
		ProductValidator validator = new ProductValidator();
		Set<Product> products;
		try {
	    validator.validateCategoryId(categoryId);
	    ProductDAO productDAO = new ProductDAO();
	    products = productDAO.listallProductsByCategoryId(categoryId);
		}
		catch(PersistanceException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	    return products;
	}
	
	/**
	 * 
	 * @param product_id
	 * @return
	 * @throws Exception
	 */
	public Product findProductDetailsByProductId(int productId)throws ServiceException{
		
		ProductValidator validator = new ProductValidator();
		Product product;
		try {
		
		validator.validateProductId(productId);
		ProductDAO productDAO = new ProductDAO();
		product = productDAO.findProductDetailsByProductId(productId);
		}
		catch(PersistanceException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
		return product;
		 
	}
/**
 * 
 * @param id
 * @param price
 * @throws Exception
 */
	public void updateProductPrice(int id, int price)throws ServiceException{
		
		ProductValidator validator = new ProductValidator();
		ProductDAO productDAO = new ProductDAO();
		try {
		validator.validateProductId(id);
		validator.validatePrice(price);
		productDAO.updatePrice(id, price);
		}
		catch(ValidationException | PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void updateProduct(Product product) throws ServiceException{
		
		ProductValidator validator = new ProductValidator();
		ProductDAO productDAO = new ProductDAO();
		try {
		validator.validateProductId(product.getId());
		validator.validateName(product.getName());
		validator.validateCategoryId(product.getCategoryId());
		validator.validateDescription(product.getDescription());
		validator.validateWeight(product.getWeight());
		validator.validateIngredients(product.getIngredients());
		validator.validateBenefits(product.getBenefits());
		validator.validateHowToUse(product.getHowToUse());
		validator.validateShelfLife(product.getShelfLife());
		validator.validatePrice(product.getPrice());
		validator.validateImage(product.getImage());
		
		productDAO.updateProduct(product);
		}
		catch(PersistanceException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void createProduct(Product product)throws ServiceException{
		
		ProductValidator validator = new ProductValidator();
		ProductDAO productDAO = new ProductDAO();
		
		try {
		validator.validateProduct(product);
		productDAO.create(product);
		}
		 catch(PersistanceException | ValidationException e) {
			 throw new ServiceException(e.getMessage());
		 }
		
	}
	/**
	 * 
	 * @param productId
	 * @throws Exception
	 */
	public void deleteProduct(int productId) throws ServiceException{
		
		ProductValidator validator = new ProductValidator();
		try {
		validator.validateProductId(productId);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.deleteProduct(productId);
		}
		
		catch(PersistanceException |ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}
