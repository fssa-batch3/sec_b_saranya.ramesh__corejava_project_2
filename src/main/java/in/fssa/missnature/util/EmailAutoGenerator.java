package in.fssa.missnature.util;

import java.util.Random;

public class EmailAutoGenerator {

	public static String generateRandomName() {
	    String[] names = {"john", "emma", "david", "sarah", "jessica", "michael"};
	    Random rand = new Random();
	    
	    String randomName = names[rand.nextInt(names.length)];
	    return randomName;
	}

	public static String generateEmail() {
	    String domain = "gmail.com"; // Using a fixed domain like "gmail.com"
	    Random rand = new Random();
	    
	    int randomNumber = 1000 + rand.nextInt(9000); // Generating a 4-digit random number
	    String randomName = generateRandomName();
	    
	    String email = randomName + randomNumber + "@" + domain;
	    return email;
	}
}
















