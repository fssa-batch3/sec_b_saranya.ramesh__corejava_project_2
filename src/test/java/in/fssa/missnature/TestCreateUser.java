package in.fssa.missnature;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import in.fssa.missnature.model.User;
import in.fssa.missnature.service.UserService;
import in.fssa.missnature.exception.ValidationException;

class TestCreateUser {

	@Test
	 void testCreateUserWithValidInput() {
		
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("subi@gmail.com");
		newUser.setName("subi");
		newUser.setPassword("Subi@123");
		newUser.setMobile_number(7586126773l);
		assertDoesNotThrow(() ->{
			userService.create(newUser);
		});
	}
	
	@Test    
	 void testCreateUserWithInvalidInput(){
		
			UserService userService = new UserService();
			Exception exception = assertThrows(ValidationException.class, () ->{
				userService.create(null);
			});
		String expectedMessage = "Invalid User object";
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
		newUser.setMobile_number(987654321);
		newUser.toString();
			
		Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
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
		newUser.setMobile_number(987654321);
		newUser.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
	});
	String expectedMessage = "Email cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	@Test
	void testCreateUserWithInvalidEmail() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail("sarangmail.com");
		newUser.setName("Saranya");
		newUser.setPassword("1234567456");
		newUser.setMobile_number(987654321);
		newUser.toString();
			
		Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
	});
	String expectedMessage = "Email does not match the pattern";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	
	@Test
	 void testCreateUserWithNameNull() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail("sara@gmail.com");
		newUser.setName(null);
		newUser.setPassword("1234567456");
		newUser.setMobile_number(987654321);
		newUser.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
	});
	String expectedMessage = "Name cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	@Test
	 void testCreateUserWithNameEmpty() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail("sara@gmail.com");
		newUser.setName("");
		newUser.setPassword("1234567456");
		newUser.setMobile_number(987654321);
		newUser.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
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
		newUser.setEmail("suji@gmail.com");
		newUser.setPassword("1234567456");
		newUser.setMobile_number(987654321);
		newUser.toString();
			
		Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
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
		newUser.setEmail("Saran@gmail.com");
		newUser.setName("Saranya");
		newUser.setPassword(null);
		newUser.setMobile_number(987654321);
		newUser.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
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
		newUser.setEmail("Saran@gmail.com");
		newUser.setName("Saranya");
		newUser.setPassword("");
		newUser.setMobile_number(987654321);
		newUser.toString();
			
			Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
	});
	String expectedMessage = "Password cannot be null or empty";
	String actualMessage = exception.getMessage();
	assertTrue(expectedMessage.equals(actualMessage));
}
	@Test
	 void testCreateUserWithInvalidPassword() {
		
		UserService userService = new UserService();
		
		User newUser = new User();
		newUser.setEmail("siva@gmail.com");
		newUser.setName("Saranya");
		newUser.setPassword("saranyabwD");
		newUser.setMobile_number(987654321);
		newUser.toString();
			
		Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
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
		newUser.setEmail("ujitha@gmail.com");
		newUser.setName("raji");
		newUser.setPassword("Rajeshwari@123");
		newUser.setMobile_number(0000000000l);
		newUser.toString();
			
		Exception exception = assertThrows(ValidationException.class, () ->{
		userService.create(newUser);
	});
	String expectedMessage = "Invalid phone number";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));
}
}