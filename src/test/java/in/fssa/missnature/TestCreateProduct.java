package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.service.ProductService;

class TestCreateProduct {

	@Test
	 void testCreateProductWithValidInput() {
		
		ProductService productService = new ProductService();
		Product product = new Product();
		product.setName("Body butter");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("Pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://iili.io/J9anywQ.md.webp");
		product.setSkinType(Product.SkinType.OTHERS);
		product.setProductType(Product.ProductType.OTHERS);
		assertDoesNotThrow(() ->{
			productService.createProduct(product);
		});
	}
	  
	@Test    
	 void testCreateProductWithInvalidInput() {
		
		ProductService productService = new ProductService();
		Exception exception = assertThrows(ValidationException.class, () ->{
			productService.createProduct(null);
		});
		String expectedMessage = "Invalid Product input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
		System.out.println(actualMessage);
	}
	
	@Test
	void testCreateProductWithNameNull() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		
		product.setName(null);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithNameEmpty() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		
		product.setName("");
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithInvalidName() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		
		product.setName("shampoo123");
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "Name does not match the pattern";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithDescriptionNull() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("aloe Shampoo");
		product.setCategoryId(2);
		product.setDescription(null);
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		product.toString(); 

		Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "description cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithDescriptionEmpty() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("hibiscus Shampoo");
		product.setCategoryId(2);
		product.setDescription("");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "description cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithIngredientsEmpty() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("moringa Shampoo");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "Ingredients cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithBenefitsNull() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("aloe Shampoo");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits(null);
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "Benefits cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithBenefitsEmpty() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("methi Shampoo");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "Benefits cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithHowToUseEmpty() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("antidandruff Shampoo");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("");
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "HowToUse cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}

	@Test
	void testCreateProductWithHowToUseNull() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("eggwhite Shampoo");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse(null);
		product.setShelfLife("3months");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "HowToUse cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithShelfLifeNull() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("cooling Shampoo");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife(null);
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "ShelfLife cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithShelfLifeEmpty() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("protien Shampoo");
		product.setCategoryId(2);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(100);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("");
		product.setPrice(300);
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);
		
		product.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "ShelfLife cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateProductWithInvalidWeight() {
		
		ProductService productService = new ProductService();
		
		Product product = new Product();
		product.setName("dove moist");
		product.setCategoryId(4);
		product.setDescription("Formulated with pure Ayurvedic herbs, this Neem Shampoo is known for its excellent antifungal & antibacterial properties and is suitable for all hair types");
		product.setBenefits("It improves root strength, reduce scalp dryness, prevent hair fall");
		product.setIngredients("pure and clean neem leaves, essential oil, etc....");
		product.setWeight(-1);
		product.setQuantityUnit(Product.QuantityUnit.ML);
		product.setHowToUse("Take required amount of neem shampoo. Mix with warm water massage on yoy scalp for 2 to 3 minutes then rinse it off. Use twice a week");
		product.setShelfLife("3 months");
		product.setPrice(300);
		product.toString();
		product.setImage("https://missnatura.in/wp-content/uploads/2022/04/SAFFRON-GEL.jpg");
		product.setSkinType(Product.SkinType.OILY);
		product.setProductType(Product.ProductType.CREAMS);

			Exception exception = assertThrows(ValidationException.class, () ->{
				productService.createProduct(product);
	});
	String expectedMessage = "Weight cannot be zero or negative";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
}
