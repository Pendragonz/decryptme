package decryptme;

public class CipherGenerator {

	public static int SHIFT_AMOUNT = 3;
	
	public static String shift(String plaintext) {
		int len = plaintext.length();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < len; i++) {
			char c = (char)(plaintext.charAt(i) + SHIFT_AMOUNT);
			if(c > 'z') {
				sb.append((char)(plaintext.charAt(i)  - (26-SHIFT_AMOUNT)));
			} else {
				sb.append(c);
			}
		}
		
		
		return sb.toString();
	}

}
