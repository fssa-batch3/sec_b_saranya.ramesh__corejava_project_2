package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.User;
import in.fssa.missnature.service.UserService;

 class TestUpdateUser {

	@Test
	 void testUpdateUserName() {
		
		UserService userService = new UserService();

		User updateUser = new User();
		updateUser.setId(2);
		updateUser.setName("sound");
		assertDoesNotThrow(() ->{
			userService.updateName(updateUser.getId(),updateUser.getName());
		});
	}
		  							
	@Test
	 void testUpdateUserPassword() {
		
		UserService userService = new UserService();

		User updateUser = new User();
		updateUser.setId(2);
		updateUser.setPassword("Soundarya@123");
		assertDoesNotThrow(() ->{
			userService.updatePassword(updateUser.getId(), updateUser.getPassword());
		});
	}
	
	@Test
	void testUpdateUser() {
		
		UserService userService = new UserService();
		User updateUser = new User();
		updateUser.setName("saran");
		updateUser.setEmail("sujitha@gmail.com");
		updateUser.setMobileNumber(98765456789l);
		updateUser.setCity("chenai");
		updateUser.setAddress("4/451, shanmuga sundharam street,  ranga nagar extension, old perungalathur, chennai - 63.");
		updateUser.setPincode("600063");
		updateUser.setState("Tamilnadu");
		
		assertDoesNotThrow(() ->{
			userService.updateUser(updateUser);
		});
	}
}
