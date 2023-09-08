package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.logger.Logger;
import in.fssa.missnature.model.Categories;
import in.fssa.missnature.service.CategoryService;



class TestCreateCategory {

	@Test
	 void testCreateCategoryWithValidInput() {
		
		CategoryService categoryService = new CategoryService();

		Categories newCategory = new Categories();
		newCategory.setName("skin care combo");
		assertDoesNotThrow(() ->{
			categoryService.createCategory(newCategory);
		});
	}
	@Test    
	 void testCreateCategoryWithInvalidInput() {
		CategoryService categoryService = new CategoryService();
		Exception exception = assertThrows(ValidationException.class, () ->{
			categoryService.createCategory(null);
		});
		String expectedMessage = "Invalid category input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
		Logger.info(actualMessage);
	}
	  
	@Test
	 void testCreateCategoryWithNameNull() {
		
		CategoryService categoryService = new CategoryService();
		
		Categories newCategory = new Categories();
		
		newCategory.setName(null);
		
		newCategory.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				categoryService.createCategory(newCategory);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	 void testCreateCategoryWithNameEmpty() {
		
		CategoryService categoryService = new CategoryService();
		
		Categories newCategory = new Categories();
		
		newCategory.setName(" ");
		
		newCategory.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
				categoryService.createCategory(newCategory);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	Logger.info(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}

	@Test
	 void testCreateCategoryWithInvalidName() {
		
		CategoryService categoryService = new CategoryService();
		
		Categories newCategory = new Categories();
		
		newCategory.setName("1234");
		
		newCategory.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
				categoryService.createCategory(newCategory);
	});
	String expectedMessage = "Name should contains only alphabets";
	String actualMessage = exception.getMessage();
	Logger.info(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
}
