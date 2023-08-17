package in.fssa.missnature.service;

import java.util.Set;

import in.fssa.missnature.dao.*;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.validator.ProductValidator;

public class ProductService {

	public Set<Product> listAllProduct()throws Exception{
		
		ProductDAO product = new ProductDAO();
		Set<Product> allProducts = product.listAllProducts();
		
		return allProducts;
	}
	
	public Set<Product> findProductDetailByCategoryId(int category_id) throws Exception {
	    ProductValidator validator = new ProductValidator();
	    validator.validateCategoryId(category_id);

	    ProductDAO productDAO = new ProductDAO();
	    Set<Product> products = productDAO.listallProductsByCategoryId(category_id);
	    
	    return products;
	}
	
	public Product FindProductDetailsByProductId(int product_id)throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProductId(product_id);
		
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.findProductDetailsByProductId(product_id);
		
		return product;
		
	}
	
	public void updateProductPrice(int id, int price)throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProductId(id);
		validator.validatePrice(price);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.updatePrice(id, price);
		
	}
	
	public void createProduct(Product product)throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProduct(product);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.create(product);
		
	}
	
	public void deleteProduct(int productId) throws Exception{
		
		ProductValidator validator = new ProductValidator();
		validator.validateProductId(productId);
		
		ProductDAO productDAO = new ProductDAO();
		productDAO.deleteProduct(productId);
		
	}

}
