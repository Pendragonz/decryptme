package decryptme;

import java.util.Random;

public class CipherGenerator {

	public static Random random = new Random();
	public static int SHIFT_MIN = 1;
	public static int SHIFT_MAX = 25;
	
	public static String shift(String plaintext) {
		int len = plaintext.length();
		int shift = random.nextInt(SHIFT_MAX - SHIFT_MIN) + SHIFT_MIN;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < len; i++) {
			char c = (char)(plaintext.charAt(i) + shift);
			if(c > 'z') {
				sb.append((char)(plaintext.charAt(i)  - (26 - shift)));
			} else {
				sb.append(c);
			}
		}
		
		
		return sb.toString();
	}

}
