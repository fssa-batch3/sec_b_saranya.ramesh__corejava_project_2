package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.Category;
import in.fssa.missnature.service.CategoryService;

public class TestDeleteCategory {

	@Test
	public void testDeleteCategroy() {
		
		CategoryService categoryService = new CategoryService();

		Category newCategory = new Category();
		newCategory.setId(3);
		assertDoesNotThrow(() ->{
			categoryService.delete(newCategory.getId());
		});
	}
}
