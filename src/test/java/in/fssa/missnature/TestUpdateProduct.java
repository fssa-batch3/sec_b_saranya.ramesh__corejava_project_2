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
	
	@Test
	 void testUpdateProduct() {
		
		ProductService productService = new ProductService();
		Product updateProduct = new Product();
		updateProduct.setId(2);
		updateProduct.setName("Neem Shampoo");
		updateProduct.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		updateProduct.setIngredients("Clean and Pure neem leaves, essential oil, etc....");
		updateProduct.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		updateProduct.setCategoryId(2);
		updateProduct.setWeight(250);
		updateProduct.setQuantityUnit(Product.QuantityUnit.ML);
		updateProduct.setHowToUse("Take required amount of neem shampoo, mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		updateProduct.setShelfLife("3months");
		updateProduct.setPrice(150);
		assertDoesNotThrow(() ->{
			productService.updateProduct(updateProduct);
		});
	}
}
