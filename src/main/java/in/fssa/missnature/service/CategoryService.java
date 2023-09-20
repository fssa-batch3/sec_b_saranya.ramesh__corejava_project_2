package in.fssa.missnature.service;

import in.fssa.missnature.model.Categories;
import in.fssa.missnature.validator.CategoryValidator;
import in.fssa.missnature.dao.*;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ServiceException;
import in.fssa.missnature.exception.ValidationException;

public class CategoryService {

	public void createCategory (Categories newcategory) throws ServiceException{
		
		try {
			CategoryValidator.validateCategory(newcategory);
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.create(newcategory);
		}
		catch(PersistanceException | ValidationException e) {
			throw new ServiceException("Error while creating catey" + e.getMessage());
		}
	}
	 
	public void updateCategoryName(int id, String newCategoryName) throws ServiceException{

		try {
		
		CategoryValidator.validateId(id);
		CategoryValidator.validateName(newCategoryName);
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.updateName(id, newCategoryName);
		}
		
		catch(PersistanceException | ValidationException e ) {
			throw new ServiceException("Error while update the catgy name" + e.getMessage());
		}
	}
}
