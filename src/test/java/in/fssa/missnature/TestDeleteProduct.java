package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.Product;
import in.fssa.missnature.service.ProductService;

public class TestDeleteProduct {

	@Test
	 void testDeleteProduct() {
		
		ProductService productService = new ProductService();

		Product newProduct = new Product();
		newProduct.setId(4);
		assertDoesNotThrow(() ->{
			productService.deleteProduct(newProduct.getId());
		});
	}
	
	@Test
	 void testDeleteProductwithInvalidId() {
		
		ProductService productService = new ProductService();

		Product newProduct = new Product();
		newProduct.setId(0);
		assertDoesNotThrow(() ->{
			productService.deleteProduct(newProduct.getId());
		});
	}
}
