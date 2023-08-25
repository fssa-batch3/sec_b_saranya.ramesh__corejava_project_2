package in.fssa.missnature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.User;
import in.fssa.missnature.service.UserService;

class TestDeleteUser {

	@Test
	 void testDeleteUser() {
		
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(3);
		assertDoesNotThrow(() ->{
			userService.deleteUser(newUser.getId());
		});
	}
}
