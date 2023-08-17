package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.Category;
import in.fssa.missnature.service.CategoryService;

public class TestUpdateCategory {

	@Test
	public void testUpdateCategoryName() {
		
		CategoryService categoryService = new CategoryService();

		Category updateCategory = new Category();
		updateCategory.setId(2);
		updateCategory.setName("haircare");
		assertDoesNotThrow(() ->{
			categoryService.updateCategoryName(updateCategory.getId(),updateCategory.getName());
		});
	}
}
