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
		updateProduct.setId(3);
		updateProduct.setName("Coco butter");
		updateProduct.setDescription("Body butter is a deeply hydrating skin moisturizer. It is typically a thick cream made of cocoa butter, shea butter, and mango butter. Some butters are also infused with essential oils for an added indulgence for your skin.");
		updateProduct.setIngredients("cocoa butter, shea butter, and mango butter.");
		updateProduct.setBenefits("It replenishes the natural moisture of the skin and locks it in.");
		updateProduct.setCategoryId(3);
		updateProduct.setWeight(150);
		updateProduct.setQuantityUnit(Product.QuantityUnit.G);
		updateProduct.setHowToUse("Take adequate amout of miss nature butter and massage for 2 mins all over your body.");
		updateProduct.setShelfLife("3months");
		updateProduct.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoTNjWM73Y4w0A4a5XNWV9tZVU1Qq52kTV9w&usqp=CAU");
		updateProduct.setSkinType(Product.SkinType.OTHERS);
		updateProduct.setProductType(Product.ProductType.OTHERS);
		updateProduct.setPrice(150);
		updateProduct.setActive(true);
		assertDoesNotThrow(() ->{
			productService.updateProduct(updateProduct);
		});
	}
}
