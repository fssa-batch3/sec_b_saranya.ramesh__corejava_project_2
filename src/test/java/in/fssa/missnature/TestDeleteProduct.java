package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.Product;
import in.fssa.missnature.service.ProductService;

class TestDeleteProduct {

	@Test
	 void testDeleteProduct() {
		
		ProductService productService = new ProductService();

		Product newProduct = new Product();
		newProduct.setId(3);
		assertDoesNotThrow(() ->{
			productService.deleteProduct(newProduct.getId());
		});
	}
}
