package in.fssa.missnature.util;

import in.fssa.missnature.exception.ValidationException;

public class StringUtil {

public static void rejectIfInvalidString(String input, String inputName) throws ValidationException {
		
		if(input == null || "".equals(input.trim())) {
			throw new ValidationException(inputName.concat(" cannot be null or empty"));
		}

	}
}
