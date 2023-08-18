package in.fssa.missnature.service;

import in.fssa.missnature.dao.UserDAO;
import in.fssa.missnature.model.User;
import in.fssa.missnature.validator.UserValidator;

public class UserService {
	
/**
 * 
 * @param newUser
 * @throws Exception
 */
	public void create(User newUser) throws Exception {
		
		UserValidator userValidator = new UserValidator();
	
			userValidator.validate(newUser);
			
			UserDAO userDao = new UserDAO();
					
			userDao.create(newUser);
	}
/**
 * 
 * @param id
 * @throws Exception
 */
	public void delete(int id)throws Exception{
	
		UserValidator userValidator = new UserValidator();
	
			userValidator.validateUser(id);
			
			UserDAO userDao1 = new UserDAO();
			
			userDao1.delete(id);
}
	/**
	 * 
	 * @param id
	 * @param newName
	 * @throws Exception
	 */
	public void updateName (int id, String newName)throws Exception{
		
		UserValidator userValidator = new UserValidator();
		
		userValidator.validateUser(id);
		userValidator.validateName(newName);
		
		UserDAO userDao1 = new UserDAO();
		
		userDao1.updateName(id, newName);
		
	}
/**
 * 	
 * @param id
 * @param newPassword
 * @throws Exception
 */
	
	public void updatePassword (int id, String newPassword)throws Exception{
		
		UserValidator userValidator = new UserValidator();
		
		userValidator.validateUser(id);
		userValidator.validatePassword(newPassword);
		
		UserDAO userDao1 = new UserDAO();
		userDao1.updatePassword(id, newPassword);
	}

}

