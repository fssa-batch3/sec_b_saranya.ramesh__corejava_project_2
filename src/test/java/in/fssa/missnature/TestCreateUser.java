package in.fssa.missnature;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.MissNatureValidatorErrors;
import in.fssa.missnature.model.User;
import in.fssa.missnature.service.UserService;
import in.fssa.missnature.exception.ValidationException;

public class TestCreateUser {

	@Test
	public void testCreateUserWithValidInput() {
		
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setEmail("viji@gmail.com");
		newUser.setName("viji");
		newUser.setPassword("Viji@123");
		newUser.setMobile_number(6586456743l);
		assertDoesNotThrow(() ->{
			userService.create(newUser);
		});
	}
	
	@Test    
	 void testCreateUserWithInvalidInput(){
		try {
			UserService userService = new UserService();
			userService.create(null);
		}
		catch(ValidationException ex ) {
			Assertions.assertEquals(MissNatureValidatorErrors.USER_NAME, ex.getMessage());
		} 
		catch(Exception ex) {
			Assertions.assertEquals(MissNatureValidatorErrors.USER_NAME,ex.getMessage());
		}
	
//		String expectedMessage = "Invalid User input";
//		String actualMessage = exception.getMessage();
//		assertTrue(expectedMessage.equals(actualMessage));
//		System.out.println(actualMessage);
	}
	@Test
	public void testCreateUserWithEmailNull() {
		
		
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
	public void testCreateUserWithEmailEmpty() {
		
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
	public void testCreateUserWithInvalidEmail() {
		
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
	public void testCreateUserWithNameNull() {
		
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
	public void testCreateUserWithNameEmpty() {
		
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
	public void testCreateUserWithInValidName() {
		
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
	String expectedMessage = "Name does not match the pattern";
	String actualMessage = exception.getMessage();
	System.out.println(actualMessage);
	assertTrue(expectedMessage.equals(actualMessage));	
}
	
	@Test
	public void testCreateUserWithPasswordNull() {
		
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
	public void testCreateUserWithPasswordEmpty() {
		
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
	public void testCreateUserWithInvalidPassword() {
		
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
	public void testCreateUserWithInvalidMobileNumber() {
		
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