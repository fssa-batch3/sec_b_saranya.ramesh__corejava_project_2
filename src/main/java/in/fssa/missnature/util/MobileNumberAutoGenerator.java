package in.fssa.missnature.util;

import java.util.Random;

public class MobileNumberAutoGenerator {

	public static long generate() {
		
		Random ran = new Random();
		StringBuilder a = new StringBuilder();
		
		a.append(6+ran.nextInt(4));
		int length = 9;
		for(int i=1; i<= length; i++) {
			a.append(ran.nextInt(9));
		}
		
		long number = Long.parseLong(a.toString());
		
		return number;
	}
}
