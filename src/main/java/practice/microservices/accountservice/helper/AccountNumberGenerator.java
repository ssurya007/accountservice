package practice.microservices.accountservice.helper;

import java.util.Random;

public class AccountNumberGenerator {
	
	public static int generateAccountNumber() throws Exception {
		Random generator = new Random();
		generator.setSeed(System.currentTimeMillis());
		  
		int num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
		num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
			throw new Exception("Unable to generate PIN at this time..");
		}
		}
		return num;
	}
}
