package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.User;
import in.fssa.missnature.service.UserService;

public class TestDeleteUser {

	@Test
	public void testDeleteUserWithValidInput() {
		
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(1);
		assertDoesNotThrow(() ->{
			userService.delete(newUser.getId());
		});
	}
	
	
}
