package in.fssa.missnature.service;

import in.fssa.missnature.model.Category;
import in.fssa.missnature.validator.CategoryValidator;
import in.fssa.missnature.dao.*;

public class CategoryService {

	public void create (Category newcategory) throws Exception{
		
		CategoryValidator.validateCategory(newcategory);
		
		CategoryDAO categoryDao = new CategoryDAO();
		
		categoryDao.create(newcategory);
	}
	
	public void updateCategoryName(int id, String newCategoryName)throws Exception{
		
		CategoryValidator.validateId(id);
		CategoryValidator.validateName(newCategoryName);
		CategoryDAO categoryDao = new CategoryDAO();
		categoryDao.updateName(id, newCategoryName);
		
	}
}
