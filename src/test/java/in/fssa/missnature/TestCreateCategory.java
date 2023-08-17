package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Category;
import in.fssa.missnature.model.User;
import in.fssa.missnature.service.CategoryService;
import in.fssa.missnature.service.UserService;


public class TestCreateCategory {

	@Test
	public void testCreateCategoryWithValidInput() {
		
		CategoryService categoryService = new CategoryService();

		Category newCategory = new Category();
		newCategory.setName("saran");
		assertDoesNotThrow(() ->{
			categoryService.create(newCategory);
		});
	}
	
	@Test    
	public void testCreateCategoryWithInvalidInput() {
		CategoryService categoryService = new CategoryService();
		Exception exception = assertThrows(ValidationException.class, () ->{
			categoryService.create(null);
		});
		String expectedMessage = "Invalid category input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
		System.out.println(actualMessage);
	}
	
	@Test
	public void testCreateUserWithNameNull() {
		
		CategoryService categoryService = new CategoryService();
		
		Category newCategory = new Category();
		
		newCategory.setName(null);
		
		newCategory.toString();

			Exception exception = assertThrows(ValidationException.class, () ->{
				categoryService.create(newCategory);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	public void testCreateUserWithNameEmpty() {
		
		CategoryService categoryService = new CategoryService();
		
		Category newCategory = new Category();
		
		newCategory.setName(" ");
		
		newCategory.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
				categoryService.create(newCategory);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}

	@Test
	public void testCreateUserWithInvalidName() {
		
		CategoryService categoryService = new CategoryService();
		
		Category newCategory = new Category();
		
		newCategory.setName("1234");
		
		newCategory.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
				categoryService.create(newCategory);
	});
	String expectedMessage = "Name doesn't match the pattern";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
}
