package in.fssa.missnature;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import in.fssa.missnature.model.User;
import in.fssa.missnature.service.UserService;
import in.fssa.missnature.util.EmailAutoGenerator;
import in.fssa.missnature.util.MobileNumberAutoGenerator;
import in.fssa.missnature.exception.ServiceException;
import in.fssa.missnature.exception.ValidationException;

class TestCreateUser {

	@Test
	 void testCreateUserWithValidInput() {
		
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setName("sarah");
		newUser.setPassword("Sarah@123");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		assertDoesNotThrow(() ->{
			userService.createUser(newUser);
		});
	}
	
	@Test    
	 void testCreateUserWithInvalidInput(){
		
			UserService userService = new UserService();
			Exception exception = assertThrows(ServiceException.class, () ->{
				userService.createUser(null);
			});
		String expectedMessage = "User object cannot be null";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
		System.out.println(actualMessage);
	}
	@Test
	 void testCreateUserWithEmailNull() {
		
		
		UserService userService = new UserService();
	
		User newUser = new User();
		newUser.setEmail(null);
		newUser.setName("Saranya");
		newUser.setPassword("1234567456");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
		Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Email cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	@Test
	 void testCreateUserWithEmailEmpty() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail(" ");
		newUser.setName("Saranya");
		newUser.setPassword("1234567456");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
			Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Email cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	void testCreateUserWithInvalidEmail() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail("bhghv@hbvh");
		newUser.setName("Saranya");
		newUser.setPassword("1234567456");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
		Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Email does not match the pattern";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	 void testCreateUserWithNameNull() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setName(null);
		newUser.setPassword("1234567456");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
			Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	@Test
	 void testCreateUserWithNameEmpty() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setName("");
		newUser.setPassword("1234567456");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
			Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	@Test
	 void testCreateUserWithInValidName() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setName("@@@@");
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setPassword("1234567456");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
		Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Name should contains only alphabets";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));	
}
	
	@Test
	 void testCreateUserWithPasswordNull() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setName("Saranya");
		newUser.setPassword(null);
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
			Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Password cannot be null or empty";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	 void testCreateUserWithPasswordEmpty() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setName("Saranya");
		newUser.setPassword("");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
			Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Password cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	@Test
	 void testCreateUserWithInvalidPassword() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setName("Saranya");
		newUser.setPassword("saranyabwD");
		newUser.setMobileNumber(MobileNumberAutoGenerator.generate());
		newUser.toString();
			
		Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});			
	String expectedMessage = "Password does not match the pattern";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
} 
	@Test
	 void testCreateUserWithInvalidMobileNumber() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail(EmailAutoGenerator.generateEmail());
		newUser.setName("raji");
		newUser.setPassword("Rajeshwari@123");
		newUser.setMobileNumber(0000000000l);
		newUser.toString();
		
		Exception exception = assertThrows(ServiceException.class, () ->{
		userService.createUser(newUser);
	});
	String expectedMessage = "Invalid phone number";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
}