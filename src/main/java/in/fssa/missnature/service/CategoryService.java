package in.fssa.missnature.service;

import in.fssa.missnature.model.Categories;
import in.fssa.missnature.validator.CategoryValidator;
import in.fssa.missnature.dao.*;

public class CategoryService {

	public void createCategory (Categories newcategory) throws Exception{
		
		CategoryValidator.validateCategory(newcategory);
		
		CategoryDAO categoryDAO = new CategoryDAO();
		
		categoryDAO.create(newcategory);
	}
	
	public void updateCategoryName(int id, String newCategoryName) throws Exception{

		CategoryValidator.validateId(id);
		CategoryValidator.validateName(newCategoryName);
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.updateName(id, newCategoryName);
		
	}
}
