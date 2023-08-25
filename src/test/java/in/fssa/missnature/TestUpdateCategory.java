package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.Categories;
import in.fssa.missnature.service.CategoryService;

class TestUpdateCategory {

	@Test
	 void testUpdateCategoryName() {
		
		CategoryService categoryService = new CategoryService();

		Categories updateCategory = new Categories();
		updateCategory.setId(2);
		updateCategory.setName("haircare");
		assertDoesNotThrow(() ->{
			categoryService.updateCategoryName(updateCategory.getId(),updateCategory.getName());
		});
	}
}
