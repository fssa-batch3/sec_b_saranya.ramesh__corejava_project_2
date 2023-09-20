package in.fssa.missnature.service;

import in.fssa.missnature.dao.UserDAO;
import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.exception.ServiceException;
import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.User;
import in.fssa.missnature.validator.UserValidator;

public class UserService {
	
/**
 * 
 * @param newUser
 * @throws Exception
 */
	public void createUser(User newUser) throws ServiceException {
		
		UserValidator userValidator = new UserValidator();
		UserDAO userDAO = new UserDAO();
		try {
			userValidator.validate(newUser); 
			userDAO.create(newUser);
		}
		catch(ValidationException | PersistanceException e) {
			throw new ServiceException(e.getMessage()); 
		}
	}
	
/**
 * 
 * @param id
 * @throws Exception
 */
	public void deleteUser(String email)throws ServiceException{
	
		UserValidator userValidator = new UserValidator();
		UserDAO userDAO = new UserDAO();
		
		try {
			userValidator.validateEmail(email);	
			userDAO.delete(email);
		}
		catch(PersistanceException | ValidationException e){
		throw new ServiceException(e.getMessage());
		}
}
	
	/**
	 * @param email
	 * @param newName
	 * @param newPassword
	 * @throws ServiceException
	 */
	public void updateUser(User user)throws ServiceException{
		UserValidator userValidator = new UserValidator();
		UserDAO userDAO = new UserDAO();
		try {
			userValidator.validateName(user.getName());
			userValidator.validateEmail(user.getEmail());
			userValidator.validateAddress(user.getAddress());
			userValidator.validateCity(user.getCity());
			userValidator.validateState(user.getState());
			userValidator.validatePincode(user.getPincode());
			userDAO.updateUser(user);
		}
		catch(ValidationException |PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
	}
 
	/**
	 * 
	 * @param id
	 * @param newName
	 * @throws Exception
	 */
	public void updateName (int id, String newName)throws ServiceException{
		
		UserValidator userValidator = new UserValidator();
		UserDAO userDAO = new UserDAO();
		try {
		userValidator.validateUser(id);
		userValidator.validateName(newName);
		userDAO.updateName(id, newName);
		}
		catch(ValidationException |PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
/**
 * 	
 * @param id
 * @param newPassword
 * @throws Exception
 */
	
	public void updatePassword (int id, String newPassword)throws ServiceException{
		
		UserValidator userValidator = new UserValidator();
		UserDAO userDAO = new UserDAO();
		try {
		userValidator.validateUser(id);
		userValidator.validatePassword(newPassword);
		userDAO.updatePassword(id, newPassword);
	}
		catch(PersistanceException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public User findUserByEmail(String email)throws ServiceException, ValidationException{
		
		UserValidator userValidator = new UserValidator();
		UserDAO userDAO = new UserDAO();
		User user;
		try {
			userValidator.validateEmail(email);
			user = userDAO.findUserByEmail(email);	
		}
		catch(PersistanceException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
		return user;
	}
}

