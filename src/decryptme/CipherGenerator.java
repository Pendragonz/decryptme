package decryptme;

import java.util.Random;

public class CipherGenerator {

	public static Random random = new Random();
	public static int SHIFT_MIN = 1;
	public static int SHIFT_MAX = 25;
	
	public static String shift(String plaintext) {
		int shift = random.nextInt(SHIFT_MAX - SHIFT_MIN) + SHIFT_MIN;
		
		return shift(plaintext, shift);
	}
	
	public static String[] shift(String[] plaintext) {
		String[] cipher = new String[plaintext.length];
		int shift = random.nextInt(SHIFT_MAX - SHIFT_MIN) + SHIFT_MIN;
		
		for(int i = 0; i < plaintext.length; i++ ) {
			cipher[i] = shift(plaintext[i], shift);
		}
		
		return cipher;
	}
	
	
	public static String shift(String plaintext, int shift) {
		StringBuilder sb = new StringBuilder();
		int len = plaintext.length();
		
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
