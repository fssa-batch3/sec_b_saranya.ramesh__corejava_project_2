package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.service.ProductService;

 class TestUpdateProduct {

	@Test
	 void testUpdateProductPrice() {
		
		ProductService productService = new ProductService();
		Product updateProduct = new Product();
		updateProduct.setId(1);
		updateProduct.setPrice(140);
		assertDoesNotThrow(() ->{
			productService.updateProductPrice(updateProduct.getId(), updateProduct.getPrice());
		});
	}
	

	
}
